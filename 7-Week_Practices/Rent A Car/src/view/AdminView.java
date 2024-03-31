package view;

import bussines.BrandManager;
import bussines.CarManager;
import bussines.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Car;
import entity.Model;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
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
    private User user;
    private DefaultTableModel brand_model;
    private BrandManager brandManager;
    private JPopupMenu brandPopMenu;
    private ModelManager modelManager;
    private JPopupMenu modelPopMenu;
    private Object[] columsName;
    private CarManager carManager;
    private JPopupMenu carPopMenu;

    public AdminView(User user) {
        brandManager = new BrandManager();
        modelManager = new ModelManager();
        carManager = new CarManager();
        this.user = user;
        add(container);
        pageArt(1000, 500, "Admin Page");

        if (user == null) {
            Helper.msg("Accsess blocked");
            dispose();
        }

        // Başlangıc label
        lbl_loginUser.setText(lbl_loginUser.getText() + " " + user.getUser_name());

        brandTableLoadRefresh(); // tablo oluşturma ve yenileme metodu
        popMenusBrand();

        modelTableLoadRefreshList(null);
        popMenusModels();
        carTableLoadRefresh();
        modelsFilter();
        popMenusCar();


        // Exit butonu
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmd_fuel_search.setSelectedItem(null); // Default olarak içi boş şekilde gelir
                cmd_gear_search.setSelectedItem(null);
                cmd_type_search.setSelectedItem(null);
                brandNameFilter();
            }
        });
    }


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


    // tablo oluşturma ve yenileme metodu
    public void brandTableLoadRefresh() {
        // Tablo oluşturma  veri ekleme işlemleri ve tablo işlemleri
        Object[] columns = {"ID", "Name"};
        ArrayList<Object[]> brandsList = brandManager.getForTable(columns.length);
        createTable(brand_model, table_brand, columns, brandsList);
    }

    public void carTableLoadRefresh(){
        Object[] columns = {"ID", "Brand","Model","Plate","Color","KM","Year","Type","Fuel","Gear"};
        ArrayList<Object[]> carList = carManager.getForTable(columns.length,carManager.findByAll());
        createTable(brand_model, table_car, columns, carList);
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



}
