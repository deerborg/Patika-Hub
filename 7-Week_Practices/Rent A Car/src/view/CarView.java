package view;

import bussines.BrandManager;
import bussines.CarManager;
import bussines.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Car;
import entity.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarView extends Layout{
    private JPanel container;
    private JComboBox cmb_model;
    private JComboBox cmb_color;
    private JTextField fld_km;
    private JTextField fld_plate;
    private JButton btn_save;
    private Car car = null;
    private CarManager carManager;
    private ModelManager modelManager;
    private BrandManager brandManager;

    public CarView(Car car) {
        this.car = car;
        brandManager = new BrandManager();
        carManager = new CarManager();
        modelManager = new ModelManager();
        add(container);
        pageArt(500,500,"Car Edit");

        cmb_color.setModel(new DefaultComboBoxModel(Car.Color.values()));
        for (Model model : modelManager.findByAll()){
           cmb_model.addItem(model.getComboItem());
        }

        if(car.getCar_id() != 0){ // Update işlemleri için metin kutusunu doldurur
            ComboItem selectItem = car.getModel().getComboItem();
            cmb_model.getModel().setSelectedItem(selectItem);
            cmb_color.getModel().setSelectedItem(selectItem);
            fld_plate.setText(car.getCar_plate());
            fld_km.setText(Integer.toString(car.getCar_km()));
        }


        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_km) && Helper.isFieldEmpty(fld_plate)){
                    Helper.msg("Not Null");
                }else{

                    boolean isSuccsess = false;
                    ComboItem selectModel = (ComboItem) cmb_model.getSelectedItem();
                    car.setCar_model_id(selectModel.getKey());
                    car.setCar_color((Car.Color) cmb_color.getSelectedItem());
                    car.setCar_plate(fld_plate.getText());
                    car.setCar_km(Integer.parseInt(fld_km.getText()));

                    if(car.getCar_id() != 0){ // id 0 dan farklıysa, model mevcut anlamına gelir, güncelleme bloğudur
                        isSuccsess = carManager.update(car);
                    }else { // değilse yeni model eklenecektir, save (ekleme) bloğudur
                        isSuccsess = carManager.save(car);
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




    }
}
