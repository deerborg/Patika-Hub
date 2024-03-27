package view;

import bussines.BrandManager;
import entity.Brand;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminView extends Desigin{

    private JPanel container;
    private JPanel top_con;
    private JLabel lbl_username;
    private JTabbedPane brand_pane;
    private JPanel tab_brand;
    private JTable table_brand;
    private JButton btn_exit;
    private JScrollPane scroll_brand;
    private User user;
    private DefaultTableModel model;
    private BrandManager brandManager;
    private JPopupMenu brandMenu;

    public AdminView(User user) {
        brandManager = new BrandManager();
        guiArt(500,500,"Manager Page");
        this.user = user;
        if(user == null){
            dispose();
        }
        add(container);
        lbl_username.setText(lbl_username.getText()+" "+user.getUser_name());
        brandMenu = new JPopupMenu();
        model = (DefaultTableModel) table_brand.getModel();
        table_brand.setModel(model);
        table_brand.getTableHeader().setReorderingAllowed(false);
        //table_brand.setEnabled(false); // Popmenu hatasi sebebiyle devre disi




        // Verileri tabloya ekleme
        ArrayList<Brand> list = brandManager.findAll();
        Object[] column = {"ID","Brand Name"};
        model.setColumnIdentifiers(column);
        for(Brand i : list){
            Object[] data = {i.getBrand_id(),i.getBrand_name()};
            model.addRow(data);
        }

        table_brand.setComponentPopupMenu(brandMenu);
        // eventler
        table_brand.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = table_brand.rowAtPoint(e.getPoint());
                table_brand.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        brandMenu.add("New").addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

             }
         });
        brandMenu.add("Update");
        brandMenu.add("Deleted");

        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }



}
