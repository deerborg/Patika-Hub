package view;

import bussines.BookManager;
import bussines.BrandManager;
import bussines.CarManager;
import bussines.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_loginUser;
    private JPanel pnl_top;
    private JTabbedPane pnl_brand;
    private JButton btn_exit;
    private JTable table_brand;
    private JTable table_model;
    private JComboBox cmd_brand_search;
    private JComboBox cmd_type_search;
    private JComboBox cmd_fuel_search;
    private JComboBox cmd_gear_search;
    private JLabel lbl_gear;
    private JButton btn_search;
    private JButton btn_clear;
    private JTable table_car;
    private JFormattedTextField fld_start_date;
    private JFormattedTextField fld_fnsh_date;
    private JComboBox cmd_gear_type;
    private JComboBox cmd_fuel_type;
    private JComboBox cmd_car_type;
    private JTable table_book;
    private JButton btn_find;
    private JButton btn_book_clear;
    private JTable table_book_list;
    private User user;
    private DefaultTableModel brand_model;
    private BrandManager brandManager;
    private JPopupMenu brandPopMenu;
    private ModelManager modelManager;
    private JPopupMenu modelPopMenu;
    private Object[] columsName;
    private CarManager carManager;
    private JPopupMenu carPopMenu;
    private BookManager bookManager;
    private Book book;
    private JPopupMenu bookPopMenu;
    private Object[] carBookColum;

    public AdminView(User user) {
        bookManager = new BookManager();
        brandManager = new BrandManager();
        modelManager = new ModelManager();
        carManager = new CarManager();
        this.user = user;
        add(container);
        pageArt(1200, 700, "Admin Page");

        if (user == null) { // Kullanıcı giriş bilgileri bulunamadığında
            Helper.msg("Accsess blocked");
            dispose();
        }

        // Başlangıc label
        lbl_loginUser.setText(lbl_loginUser.getText() + " " + user.getUser_name());

        // Markalar
        brandTableLoadRefresh(); // tablo oluşturma ve yenileme metodu
        popMenusBrand();

        // Modeller
        modelTableLoadRefreshList(null);
        popMenusModels();
        modelsFilter();

        // Araçlar
        carTableLoadRefresh();
        popMenusCar();

        // Müşteriler
        bookTableLoadRefresh(null);
        popMenusBook();
        booksFilter();

        bookListTableRefresh();


        // Exit butonu
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    //---------------------------------METOTLAR-------------------------------------------

    public void modelsFilter() {
        cmd_fuel_search.setModel(new DefaultComboBoxModel(Model.Fuel.values()));
        cmd_fuel_search.setSelectedItem(null); // Default olarak içi boş şekilde gelir
        cmd_gear_search.setModel(new DefaultComboBoxModel(Model.Gear.values()));
        cmd_gear_search.setSelectedItem(null);
        cmd_type_search.setModel(new DefaultComboBoxModel(Model.Type.values()));
        cmd_type_search.setSelectedItem(null);
        brandNameFilter();
    }

    private void brandNameFilter() {
        cmd_brand_search.removeAllItems();
        for (Brand brand : brandManager.findByAll()) {
            cmd_brand_search.addItem(new ComboItem(brand.getBrand_id(), brand.getBrand_name()));
        }
        cmd_brand_search.setSelectedItem(null);
    }

    public void bookListTableRefresh(){
        Object[] columns = {"Book ID", "Car ID","Name","ID No","Phone","Mail","Start Date","Finish Date","Price","Note","Case"};
        ArrayList<Object[]> bookList = bookManager.getForTable(columns.length,bookManager.findByAll());
        createTable(brand_model, table_book_list, columns, bookList);
    }

    // tablo oluşturma ve yenileme metodu
    public void brandTableLoadRefresh() {
        // Tablo oluşturma  veri ekleme işlemleri ve tablo işlemleri
        Object[] columns = {"ID", "Name"};
        ArrayList<Object[]> brandsList = brandManager.getForTable(columns.length);
        createTable(brand_model, table_brand, columns, brandsList);

        // Clear butonu
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmd_fuel_search.setSelectedItem(null); // Default olarak içi boş şekilde gelir
                cmd_gear_search.setSelectedItem(null);
                cmd_type_search.setSelectedItem(null);
                brandNameFilter();
            }
        });
        // Find buyonu
        btn_find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> carList = carManager.searchBooking(fld_start_date.getText(),fld_fnsh_date.getText(),
                        (Model.Type) cmd_car_type.getSelectedItem(),
                        (Model.Gear) cmd_gear_type.getSelectedItem(),
                        (Model.Fuel) cmd_fuel_type.getSelectedItem());
                ArrayList<Object[]> carBookRow = carManager.getForTable(carBookColum.length,carList);
                bookTableLoadRefresh(carBookRow);
            }
        });

        // Clear butonu Books
        btn_book_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmd_car_type.setSelectedItem(null);
                cmd_fuel_type.setSelectedItem(null);
                cmd_gear_type.setSelectedItem(null);
                fld_fnsh_date.setText("");
                fld_start_date.setText("");
                bookTableLoadRefresh(null);
            }
        });
    }

    public void carTableLoadRefresh(){
        Object[] columns = {"ID", "Brand","Model","Plate","Color","KM","Year","Type","Fuel","Gear"};
        ArrayList<Object[]> carList = carManager.getForTable(columns.length,carManager.findByAll());
        createTable(brand_model, table_car, columns, carList);
    }

    public void bookTableLoadRefresh(ArrayList<Object[]> carList){
        carBookColum = new Object[]{"ID", "Car","Name","Number","Mail","Start Date","Finish Date","Price","Note","Case"};
        createTable(brand_model, table_book, columsName, carList);
    }


    // tablo oluşturma ve yenileme metodu
    public void modelTableLoadRefresh() {
        // Tablo oluşturma  veri ekleme işlemleri ve tablo işlemleri
        Object[] columns = {"ID", "Brand Name", "Name", "Type", "Year", "Fuel", "Gear"};
        ArrayList<Object[]> modelList = modelManager.getForTable(columns.length,modelManager.findByAll());
        createTable(brand_model, table_model, columns, modelList);
    }

    // tablo oluşturma ve yenileme metodu
    public void modelTableLoadRefreshList(ArrayList<Object[]> modelList) {
        // Tablo oluşturma  veri ekleme işlemleri ve tablo işlemleri
        columsName = new Object[]{"ID", "Brand Name", "Name", "Type", "Year", "Fuel", "Gear"};
        if (modelList == null) {
            modelList = modelManager.getForTable(columsName.length,modelManager.findByAll());
        }
        //modelList = modelManager.getForTable(columsName.length,modelManager.findByAll());
        createTable(brand_model, table_model, columsName, modelList);
    }

    // Brand için pop menü
    public void popMenusBrand() {
        // Brand Tablosu için pop menüler
        this.brandPopMenu = new JPopupMenu();

        // Mouse seçim işlemleri
        tableMouseSelect(table_brand);


        brandPopMenu.add("New").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrandSaveView brandView = new BrandSaveView(null);
                // Save sayfası kapandığı zaman tabloyu yeniler
                brandView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                        modelsFilter();

                    }
                });
            }
        });
        brandPopMenu.add("Update").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectId = (int) table_brand.getValueAt(table_brand.getSelectedRow(),0); // id seçimi
                BrandSaveView brandSaveView = new BrandSaveView(brandManager.getById(getSelectedRow(table_brand, 0)));

                // Save sayfası kapandığı zaman tabloyu yeniler
                brandSaveView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                        modelTableLoadRefreshList(null);
                        modelsFilter();
                    }
                });
            }
        });

        brandPopMenu.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectId = (int) table_brand.getValueAt(table_brand.getSelectedRow(),0); // id seçimi
                if (JOptionPane.showConfirmDialog(null, "Deleted a Brand", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    brandManager.delete(getSelectedRow(table_brand, 0));
                    Helper.msg("Delete succsess");
                    brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                    modelTableLoadRefreshList(null);
                    modelsFilter();
                } else {
                    Helper.msg("Canceled");
                }
            }
        });

        table_brand.setComponentPopupMenu(brandPopMenu);
    }

    // Brand için pop menü
    public void popMenusModels() {

        // Brand Tablosu için pop menüler
        this.modelPopMenu = new JPopupMenu();

        // Mouse seçim işlemleri
        tableMouseSelect(table_model);

        modelPopMenu.add("New").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModelSaveView modelSaveView = new ModelSaveView(new Model());
                modelSaveView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        modelTableLoadRefresh();
                    }
                });
            }
        });

        modelPopMenu.add("Update").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModelSaveView modelSaveView = new ModelSaveView(modelManager.getById(getSelectedRow(table_model, 0)));
                modelSaveView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        modelTableLoadRefresh();
                    }
                });
            }
        });

        modelPopMenu.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deleted a Model", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    modelManager.deleted(getSelectedRow(table_model, 0));
                    Helper.msg("Delete succsess");
                    modelTableLoadRefresh(); // Tabloyu yeniden oluşturur
                } else {
                    Helper.msg("Canceled");
                }
            }
        });

        // Filtreleme işlemleri
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComboItem selectItem = (ComboItem) cmd_brand_search.getSelectedItem();
                int brandID = 0;
                if(selectItem != null){
                    brandID = selectItem.getKey();
                }
                ArrayList<Model> modelListTableSearch =
                        modelManager.filterTable(brandID,
                                (Model.Fuel) cmd_fuel_search.getSelectedItem(),
                                (Model.Gear) cmd_gear_search.getSelectedItem(),
                                (Model.Type) cmd_type_search.getSelectedItem()
                        );
                ArrayList<Object[]> modelListObject = modelManager.getForTable(columsName.length,modelListTableSearch);
                modelTableLoadRefreshList(modelListObject);
            }
        });

        table_model.setComponentPopupMenu(modelPopMenu);
    }
    public void popMenusCar() {
        // Brand Tablosu için pop menüler
        this.carPopMenu = new JPopupMenu();

        // Mouse seçim işlemleri
        tableMouseSelect(table_car);

        carPopMenu.add("New").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarView carView = new CarView(new Car());
                // Save sayfası kapandığı zaman tabloyu yeniler
                carView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                        modelsFilter();
                        carTableLoadRefresh();

                    }
                });
            }
        });
        carPopMenu.add("Update").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectId = (int) table_brand.getValueAt(table_brand.getSelectedRow(),0); // id seçimi
                CarView carView = new CarView(carManager.getById(getSelectedRow(table_car, 0)));

                // Save sayfası kapandığı zaman tabloyu yeniler
                carView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                        modelTableLoadRefreshList(null);
                        modelsFilter();
                        carTableLoadRefresh();
                    }
                });
            }
        });
        carPopMenu.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectId = (int) table_brand.getValueAt(table_brand.getSelectedRow(),0); // id seçimi
                if (JOptionPane.showConfirmDialog(null, "Deleted a Brand", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    carManager.deleted(getSelectedRow(table_car, 0));
                    Helper.msg("Delete succsess");
                    brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                    modelTableLoadRefreshList(null);
                    modelsFilter();
                    carTableLoadRefresh();
                } else {
                    Helper.msg("Canceled");
                }
            }
        });
        table_car.setComponentPopupMenu(carPopMenu);
    }

    public void popMenusBook(){
        bookPopMenu = new JPopupMenu();
        bookPopMenu.add("Rezervation").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectId = getSelectedRow(table_book,0);
                BookView bookView = new BookView(carManager.getById(selectId),fld_start_date.getText(),fld_fnsh_date.getText());
                bookView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        bookTableLoadRefresh(null);
                        booksFilter();
                    }
                });
            }
        });
        table_book.setComponentPopupMenu(bookPopMenu);
    }
    public void booksFilter(){
        cmd_car_type.setModel(new DefaultComboBoxModel(Model.Type.values()));
        cmd_car_type.setSelectedItem(null);
        cmd_fuel_type.setModel(new DefaultComboBoxModel(Model.Fuel.values()));
        cmd_fuel_type.setSelectedItem(null);
        cmd_gear_type.setModel(new DefaultComboBoxModel(Model.Gear.values()));
        cmd_gear_type.setSelectedItem(null);
    }

    // Tarih formatı "##/##/####"
    private void createUIComponents() {
        try {
            fld_start_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
            fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
            fld_start_date.setText("10/10/2023");
            fld_fnsh_date.setText("16/10/2023");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



}
