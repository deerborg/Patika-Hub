package view;

import bussines.BrandManager;
import bussines.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class ModelSaveView extends Layout{
    private JPanel container;
    private JComboBox cmb_brand_name;
    private JComboBox cmb_type;
    private JComboBox cmb_gear;
    private JComboBox cmb_fuel;
    private JTextField fld_model_name;
    private JTextField fld_model_year;
    private JButton btn_save;
    private JButton btn_cancel;
    private JPanel w_bottom;
    private JPanel w_top;
    private ModelManager modelManager;
    private Model model;
    private BrandManager brandManager;
    private Brand brand;

    public ModelSaveView(Model model) {
        this.model = model;
        modelManager = new ModelManager();
        brandManager = new BrandManager();
        add(container);
        pageArt(500,600,"Models Save");

        if(model.getModel_id() != 0){ // Update işlemleri için metin kutusunu doldurur
            fld_model_name.setText(model.getModel_name());
            fld_model_year.setText(model.getModel_year());
            cmb_type.getModel().setSelectedItem(model.getType());
            cmb_fuel.getModel().setSelectedItem(model.getFuel());
            cmb_gear.getModel().setSelectedItem(model.getGear());
        }

        for (Brand brand : brandManager.findByAll()){
            cmb_brand_name.addItem(new ComboItem(brand.getBrand_id(), brand.getBrand_name()));
        }
        cmb_fuel.setModel(new DefaultComboBoxModel<Model.Fuel>(Model.Fuel.values()));
        cmb_type.setModel(new DefaultComboBoxModel<Model.Type>(Model.Type.values()));
        cmb_gear.setModel(new DefaultComboBoxModel<Model.Gear>(Model.Gear.values()));

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_model_name) && Helper.isFieldEmpty(fld_model_year)){
                    Helper.msg("Not Null");
                }else{

                    boolean isSuccsess = false;

                    model.setModel_name(fld_model_name.getText());
                    model.setModel_year(fld_model_year.getText());
                    ComboItem brandName = (ComboItem) cmb_brand_name.getSelectedItem();
                    model.setModel_brand_id(brandName.getKey());
                    model.setFuel((Model.Fuel) cmb_fuel.getSelectedItem());
                    model.setGear((Model.Gear) cmb_gear.getSelectedItem());
                    model.setType((Model.Type) cmb_type.getSelectedItem());

                    if(model.getModel_id() != 0){ // id 0 dan farklıysa, model mevcut anlamına gelir, güncelleme bloğudur
                        isSuccsess = modelManager.update(model);
                    }else { // değilse yeni model eklenecektir, save (ekleme) bloğudur
                        isSuccsess = modelManager.save(model);
                    }
                    if(isSuccsess){
                        Helper.msg("Saved new Model");
                        dispose();
                    }else {
                        Helper.msg("Error");
                    }

                }

            }
        });

        // Cancel butonu
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
