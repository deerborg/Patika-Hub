package bussines;

import dao.ModelDao;
import entity.Model;

import javax.swing.*;
import java.util.ArrayList;

public class ModelManager {
    private ModelDao modelDao;

    public ModelManager() {
        modelDao = new ModelDao();
    }

    public ArrayList<Model> findByAll(){
        return modelDao.findByAll();
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> modelList = new ArrayList<>();
        for(Model obj : findByAll()){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getModel_id();
            rowObject[i++] = obj.getBrand().getBrand_name();
            rowObject[i++] = obj.getModel_name();
            rowObject[i++] = obj.getType();
            rowObject[i++] = obj.getModel_year();
            rowObject[i++] = obj.getFuel();
            rowObject[i++] = obj.getGear();
            modelList.add(rowObject);
        }
        return modelList;
    }

    public boolean save(Model model){
        return modelDao.save(model);
    }
    public Model getById(int id){
        return modelDao.getById(id);
    }
    public boolean update(Model model){
        if(getById(model.getModel_id()) == null){
            JOptionPane.showMessageDialog(null,"Not Found");
        }
        return modelDao.update(model);
    }
    public boolean deleted (int model_id) {
        if (getById(model_id) == null) {
            JOptionPane.showMessageDialog(null, "Not Found");
            return false;
        }
        return modelDao.delete(model_id);
    }
    public ArrayList<Model> getByBrandId(int id){
        return modelDao.getBrandId(id);
    }
}
