package view;

import bussines.BrandManager;
import bussines.ModelManager;
import entity.Brand;
import entity.Model;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminView extends Desigin{

    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_username;
    private JTabbedPane pnl_brand;
    private JPanel tab_brand;
    private JTable table_brand;
    private JButton btn_exit;
    private JScrollPane scroll_brand;
    private JPanel pnl_model;
    private JScrollPane scroll_model;
    private JTable table_model;
    private User user;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private BrandManager brandManager;
    private JPopupMenu brandMenu;
    private JPopupMenu modelMenu;
    private ModelManager modelManager;

    public AdminView(User user) {
        brandManager = new BrandManager();
        modelManager = new ModelManager();

        // Görüntü ayarları
        guiArt(1000,500,"Manager Page");
        this.user = user;
        if(user == null){
            dispose();
        }
        add(container);
        lbl_username.setText(lbl_username.getText()+" "+user.getUser_name());

        // Tablo işlemleri
        loadBrandRefresh();
        loadBrandCompenent();
        loadModelRefresh();

        loadModelCompanent();


        // Exit butonu
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Model tablosu güncelleme silme ve ekleme
    private void loadModelCompanent() {

        tableSelectedRow(table_model); // mouse event metodu
        modelMenu = new JPopupMenu();
        table_model.setComponentPopupMenu(modelMenu);

        modelMenu.add("New").addActionListener(e -> {
            ModelView modelView = new ModelView(null);
        });
        modelMenu.add("Update").addActionListener(e -> {

        });
        modelMenu.add("Deleted").addActionListener(e -> {

        });
    }

    // Brand tablosu güncelleme silme ve ekleme
    public void loadBrandCompenent(){
        tableSelectedRow(table_brand);
        brandMenu = new JPopupMenu();
        table_brand.setComponentPopupMenu(brandMenu);
        brandMenu.add("New").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrandView brandView = new BrandView(null);
                brandView.addWindowListener(new WindowAdapter() { // sayfa açıldığında tekrardan tabloları günceller
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadBrandRefresh();
                    }
                });
            }
        });
        brandMenu.add("Update").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectId = getTableSelectedRow(table_brand,0);
                BrandView brandView = new BrandView(brandManager.getById(selectId));

                brandView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadBrandRefresh();
                    }
                });

            }
        });
        brandMenu.add("Deleted").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(JOptionPane.showConfirmDialog(null,"Sure") == 0){
                    int selectId = getTableSelectedRow(table_brand,0);
                    if(brandManager.deleted(selectId)){
                        JOptionPane.showMessageDialog(null,"Delete Succsess");
                        loadBrandRefresh();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Canceled");
                }
            }
        });
    }
    // Brand tablosu yenileme
    public void loadBrandRefresh(){
        model = (DefaultTableModel) table_brand.getModel();
        table_brand.setModel(model);
        table_brand.getTableHeader().setReorderingAllowed(false);
        table_brand.setEnabled(false);
        table_brand.setEditingRow(0);
        // Verileri tabloya ekleme
        ArrayList<Brand> list = brandManager.findAll();
        Object[] column = {"ID","Brand Name"};
        model.setColumnIdentifiers(column);

        DefaultTableModel clearModel = (DefaultTableModel) table_brand.getModel();
        clearModel.setRowCount(0); // her çalıştığında tablonun içini boşaltır


        for(Brand i : list){
            Object[] data = {i.getBrand_id(),i.getBrand_name()};
            model.addRow(data);
        }

    }

    // Model tablosu yenileme
    public void loadModelRefresh(){
        model2 = (DefaultTableModel) table_model.getModel();
        table_model.setModel(model2);
        table_model.getTableHeader().setReorderingAllowed(false);
        table_model.setEnabled(false);
        table_model.setEditingRow(0);
        // Verileri tabloya ekleme
        ArrayList<Model> list = modelManager.findAll();
        Object[] column = {"Model ID","Model Brand","Model Name","Model Type","Model Year","Fuel Type","Gear Type"};
        model2.setColumnIdentifiers(column);

        DefaultTableModel clearModel = (DefaultTableModel) table_model.getModel();
        clearModel.setRowCount(0); // her çalıştığında tablonun içini boşaltır

        for(Model i : list){
            Object[] data = {i.getBrand_id(),i.getBrand().getBrand_name(),i.getName(),i.getType(),i.getYear(),i.getFuel(),i.getGear()};
            model2.addRow(data);
        }
    }

}
