package view;

import bussines.BrandManager;
import core.Helper;
import entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandSaveView extends Layout{
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_branName;
    private JTextField fld_brandname;
    private JButton btn_save;
    private JButton btn_cancel;
    private BrandManager brandManager;
    private Brand brand;

    public BrandSaveView(Brand brand) {
        if(brand != null){
            fld_brandname.setText(brand.getBrand_name());
        }
        this.brand = brand;
        brandManager = new BrandManager();
        add(container);
        pageArt(400,500,"Brand Edit");

        // Cancel butonu
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Kaydetme butonu ve kayıt işlemleri
        btn_save.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_brandname)){ // Boş ise
                Helper.msg("Not Null");
            }else{
                boolean isSuccsess;

                if(brand == null){
                    isSuccsess = brandManager.save(new Brand(fld_brandname.getText()));
                }else {
                    brand.setBrand_name(fld_brandname.getText());
                    isSuccsess = brandManager.update(brand);
                }
                if(isSuccsess){
                    Helper.msg("Saved");
                    dispose();
                }else{
                    Helper.msg("Error");
                }
            }
        });
//        btn_delete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(Helper.isFieldEmpty(fld_brandname)){
//                    Helper.msg("Not Null");
//                }else{
//                    brand.setBrand_name(fld_brandname.getText());
//                    brandManager.delete(brand);
//                    dispose();
//                }
//            }
//        });
    }
}
