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

    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> list){
        ArrayList<Object[]> modelList = new ArrayList<>();
        for(Model obj : list){
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
    public ArrayList<Model> filterTable(int id,Model.Fuel fuel,Model.Gear gear ,Model.Type type){
        ArrayList<String> whereList = new ArrayList<>();
        String select = "select * from public.model";

        if(id != 0){
            whereList.add("model_brand_id = " + id);
        }
        if(fuel != null){
            whereList.add("model_fuel = '" + fuel.toString() + "'");
        }
        if(gear != null){
            whereList.add("model_gear = '" + gear.toString() + "'");
        }
        if(type != null){
            whereList.add("model_type = '" + type.toString() + "'");
        }
        String whereStr = String.join(" and ",whereList);
        String query = select;
        if(whereStr.length() > 0){
            query += " where " + whereStr;
        }
        return modelDao.selectByQuery(query);


    }
}
