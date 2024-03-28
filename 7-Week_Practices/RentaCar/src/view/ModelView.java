package view;

import bussines.ModelManager;
import entity.Model;

import javax.swing.*;

public class ModelView extends Desigin{
    private JPanel container;
    private JLabel lbl_header;
    private JComboBox cmb_brand;
    private JTextField fld_model_name;
    private JTextField fld_year;
    private JComboBox cmb_type;
    private JComboBox cmb_fuel;
    private JComboBox cmb_gear;
    private JButton btn_save;
    private Model model;
    private ModelManager modelManager;

    public ModelView(Model model) {
        this.modelManager = new ModelManager();
        this.model = model;
        add(container);
        guiArt(300,500,"Model Page");

    }
}
