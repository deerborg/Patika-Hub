package view;

import bussines.BrandManager;
import entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends Desigin{
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_save;
    private Brand brand;
    private BrandManager brandManager;

    public BrandView(Brand brand) {
        brandManager = new BrandManager();
        add(container);
        guiArt(300,200,"APP");
        this.brand = brand;

        if(brand != null){
            fld_brand_name.setText(brand.getBrand_name());
        }

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(fld_brand_name.getText().equals("")){
                   JOptionPane.showMessageDialog(null,"Not null");
               }else {
                   boolean resutl;
                   if(brand == null){ // eğer daha oluşturulmamışsa
                       resutl = brandManager.save(new Brand(fld_brand_name.getText()));
                       dispose();
                   }else{
                       brand.setBrand_name(fld_brand_name.getText());
                       resutl = brandManager.update(brand);
                   }
                   if(resutl){
                       JOptionPane.showMessageDialog(null,"Save It");
                       dispose();
                   }else{
                       JOptionPane.showMessageDialog(null,"Error");
                   }
               }
            }
        });
    }
}
