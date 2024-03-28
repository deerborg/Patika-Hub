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

    public ArrayList<Model> findAll(){
        return modelDao.findAll();
    }

    public ArrayList<Object[]> getForTable(int size,ArrayList<Model> models){
        ArrayList<Object[]> modelList = new ArrayList<>();
        for(Model obj : models){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getBrand().getBrand_name();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getType();
            rowObject[i++] = obj.getYear();
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
        if(getById(model.getId()) == null){
            JOptionPane.showMessageDialog(null,"Not Found");
        }
        return modelDao.update(model);
    }
    public boolean deleted (int model_id) {
        if (getById(model_id) == null) {
            JOptionPane.showMessageDialog(null, "Not Found");
            return false;
        }
        return modelDao.deleted(model_id);
    }
}
