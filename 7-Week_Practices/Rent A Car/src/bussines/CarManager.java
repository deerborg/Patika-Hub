package bussines;

import dao.CarDao;
import dao.ModelDao;
import entity.Car;
import entity.Model;

import javax.swing.*;
import java.util.ArrayList;

public class CarManager {
    private CarDao carDao;
    public CarManager() {
        carDao = new CarDao();
    }

    public ArrayList<Car> findByAll(){
        return carDao.findByAll();
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Car> list){
        ArrayList<Object[]> carList = new ArrayList<>();
        for(Car obj : list){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getCar_id();
            rowObject[i++] = obj.getModel().getBrand().getBrand_name();
            rowObject[i++] = obj.getModel().getModel_name();
            rowObject[i++] = obj.getCar_plate();
            rowObject[i++] = obj.getCar_color();
            rowObject[i++] = obj.getCar_km();
            rowObject[i++] = obj.getModel().getModel_year();
            rowObject[i++] = obj.getModel().getType();
            rowObject[i++] = obj.getModel().getFuel();
            rowObject[i++] = obj.getModel().getGear();
            carList.add(rowObject);
        }
        return carList;
    }

    public boolean save(Car car){
        return carDao.save(car);
    }
    public Car getById(int id){
        return carDao.getById(id);
    }
    public boolean update(Car car){
        if(getById(car.getCar_id()) == null){
            JOptionPane.showMessageDialog(null,"Not Found");
        }
        return carDao.update(car);
    }
    public boolean deleted (int car_id) {
        if (getById(car_id) == null) {
            JOptionPane.showMessageDialog(null, "Not Found");
            return false;
        }
        return carDao.delete(car_id);
    }
    public ArrayList<Car> getByBrandId(int id){
        return carDao.getCarId(id);
    }
    /*


    public ArrayList<Car> filterTable(int id,String color,int km,String plate){
        ArrayList<String> whereList = new ArrayList<>();
        String select = "select * from public.car";

        if(id != 0){
            whereList.add("car_model_id = " + id);
        }
        if(color != null){
            whereList.add("model_fuel = '" + color + "'");
        }
        if(km != 0){
            whereList.add("model_gear = " + km );
        }
        if(plate != null){
            whereList.add("model_type = '" + plate + "'");
        }
        String whereStr = String.join(" and ",whereList);
        String query = select;
        if(whereStr.length() > 0){
            query += " where " + whereStr;
        }
        return carDao.selectByQuery(query);
    }

     */
}
