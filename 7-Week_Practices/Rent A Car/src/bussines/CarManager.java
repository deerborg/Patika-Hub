package bussines;

import dao.BookDao;
import dao.CarDao;
import dao.ModelDao;
import entity.Book;
import entity.Car;
import entity.Model;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarManager {
    private CarDao carDao;
    private BookDao bookDao;

    public CarManager() {
        carDao = new CarDao();
        bookDao = new BookDao();
    }

    public ArrayList<Car> findByAll() {
        return carDao.findByAll();
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Car> list) {
        ArrayList<Object[]> carList = new ArrayList<>();
        for (Car obj : list) {
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

    public boolean save(Car car) {
        return carDao.save(car);
    }

    public Car getById(int id) {
        return carDao.getById(id);
    }

    public boolean update(Car car) {
        if (getById(car.getCar_id()) == null) {
            JOptionPane.showMessageDialog(null, "Not Found");
        }
        return carDao.update(car);
    }

    public boolean deleted(int car_id) {
        if (getById(car_id) == null) {
            JOptionPane.showMessageDialog(null, "Not Found");
            return false;
        }
        return carDao.delete(car_id);
    }

    public ArrayList<Car> getByBrandId(int id) {
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

    public ArrayList<Car> searchBooking(String strt, String fnsh, Model.Type type, Model.Gear gear, Model.Fuel fuel) {
        String query = "select * from public.car as c left join public.model as m";

        ArrayList<String> where = new ArrayList<>();
        ArrayList<String> joinWhere = new ArrayList<>();
        ArrayList<String> bookOrWhere = new ArrayList<>();

        joinWhere.add("c.car_model_id = m.model_id");

        strt =  LocalDate.parse(strt, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        fnsh =  LocalDate.parse(fnsh, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();



        if (fuel != null) where.add("m.model_fuel = '" + fuel.toString() + "'");

        if (type != null) where.add("m.model_type = '" + type.toString() + "'");

        if (gear != null) where.add("m.model_gear = '" + gear.toString() + "'");

        String whereStr = String.join(" and ", where);
        String joinStr = String.join(" and ", joinWhere);

        if (joinStr.length() > 0) {
            query += " on " + joinStr;
        }
        if (whereStr.length() > 0) {
            query += " where " + whereStr;
        }

        ArrayList<Car> findCarList = carDao.selectByQuery(query);


        bookOrWhere.add("('" + strt + "' between book_strt_date and book_fnsh_date)");
        bookOrWhere.add("('" + fnsh + "' between book_strt_date and book_fnsh_date)");
        bookOrWhere.add("(book_strt_date between '"+ strt +"' and '"+ fnsh +"')");
        bookOrWhere.add("(book_fnsh_date between '"+ strt +"' and '"+ fnsh +"')");

        String bookOrWhereStr = String.join(" or ", bookOrWhere);
        String bookQuery = "select * from public.book where " + bookOrWhereStr;

        ArrayList<Book> bookList = bookDao.selectByQuery(bookQuery);

        ArrayList<Integer> busyCarId =  new ArrayList<>();

        for(Book book : bookList){
            busyCarId.add(book.getBook_car_id());
        }

        findCarList.removeIf(car -> busyCarId.contains(car.getCar_id())); // meşgul olan araç varsa, meşgul olan aracı listeden sil


        System.out.println(query);
        return findCarList;
    }
}
