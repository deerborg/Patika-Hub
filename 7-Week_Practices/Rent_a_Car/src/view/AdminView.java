package view;

import bussines.BrandManager;
import bussines.ModelManager;
import core.Helper;
import entity.Brand;
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
    private User user;
    private DefaultTableModel brand_model;
    private BrandManager brandManager;
    private JPopupMenu brandPopMenu;
    private ModelManager modelManager;
    private JPopupMenu modelPopMenu;



    public AdminView(User user){
        brandManager = new BrandManager();
        modelManager = new ModelManager();
        this.user = user;
        add(container);
        pageArt(1000,500,"Admin Page");

        if(user == null){
            Helper.msg("Accsess blocked");
            dispose();
        }

        // Başlangıc label
        lbl_loginUser.setText(lbl_loginUser.getText() + " " + user.getUser_name());

        brandTableLoadRefresh(); // tablo oluşturma ve yenileme metodu
        popMenusBrand();

        modelTableLoadRefresh();
        popMenusModels();


        // Exit butonu
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }









    // tablo oluşturma ve yenileme metodu
    public void brandTableLoadRefresh(){
        // Tablo oluşturma  veri ekleme işlemleri ve tablo işlemleri
        Object[] columns = {"ID","Name"};
        ArrayList<Object[]> brandsList = brandManager.getForTable(columns.length);
        createTable(brand_model,table_brand,columns,brandsList);

        // Tablo oluşturma  veri ekleme işlemleri ve tablo işlemleri
        /*
        this.brand_model = (DefaultTableModel) table_brand.getModel();
        table_brand.getTableHeader().setReorderingAllowed(false); // tablo sütunlarının boyutu ile oynamayı kapatma
        //table_brand.setEnabled(false); // tablo içeriğini düzenlemeyi kapatma - false durumunda pop menüler çalışmıyor
        Object[] columns = {"ID","Name"};
        brand_model.setColumnIdentifiers(columns);
        ArrayList<Brand> brandsList = brandManager.findByAll();
        for(Brand i : brandsList){
            Object[] brands = {i.getBrand_id(),i.getBrand_name()};
            brand_model.addRow(brands);
        } // Tablo veri ekleme işlem sonu

         */
    }

    // tablo oluşturma ve yenileme metodu
    public void modelTableLoadRefresh(){
        // Tablo oluşturma  veri ekleme işlemleri ve tablo işlemleri
        Object[] columns = {"ID","Brand Name","Name","Type","Year","Fuel","Gear"};
        ArrayList<Object[]> modelList = modelManager.getForTable(columns.length);
        createTable(brand_model,table_model,columns,modelList);
    }

    // Brand için pop menü
    public void popMenusBrand(){
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
                    }
                });
            }
        });
        brandPopMenu.add("Update").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectId = (int) table_brand.getValueAt(table_brand.getSelectedRow(),0); // id seçimi
                BrandSaveView brandSaveView = new BrandSaveView(brandManager.getById(getSelectedRow(table_brand,0)));

                // Save sayfası kapandığı zaman tabloyu yeniler
                brandSaveView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                        modelTableLoadRefresh();
                    }
                });
            }
        });

        brandPopMenu.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int selectId = (int) table_brand.getValueAt(table_brand.getSelectedRow(),0); // id seçimi
                if(JOptionPane.showConfirmDialog(null,"Deleted a Brand","Confirm",JOptionPane.YES_NO_OPTION) == 0){
                    brandManager.delete(getSelectedRow(table_brand,0));
                    Helper.msg("Delete succsess");
                    brandTableLoadRefresh(); // Tabloyu yeniden oluşturur
                    modelTableLoadRefresh();
                }else {
                    Helper.msg("Canceled");
                }
            }
        });

        table_brand.setComponentPopupMenu(brandPopMenu);
    }


    // Brand için pop menü
    public void popMenusModels(){

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
                ModelSaveView modelSaveView = new ModelSaveView(modelManager.getById(getSelectedRow(table_model,0)));
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
                if(JOptionPane.showConfirmDialog(null,"Deleted a Model","Confirm",JOptionPane.YES_NO_OPTION) == 0){
                    modelManager.deleted(getSelectedRow(table_model,0));
                    Helper.msg("Delete succsess");
                    modelTableLoadRefresh(); // Tabloyu yeniden oluşturur
                }else {
                    Helper.msg("Canceled");
                }
            }
        });

        table_model.setComponentPopupMenu(modelPopMenu);

    }




}
