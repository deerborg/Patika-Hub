package dao;

import core.Database;
import entity.Car;
import entity.Model;

import java.sql.*;
import java.util.ArrayList;

public class CarDao {
    private Connection connection;
    private Statement statement;
    private ResultSet data;
    private PreparedStatement preparedStatement;
    private Model model = null;
    private ModelDao modelDao = null;
    private Car car;
    private BrandDao brandDao;

    public CarDao() {
        connection = Database.connector();
        modelDao = new ModelDao();
        brandDao = new BrandDao();
    }

    public ArrayList<Car> findByAll(){

        ArrayList<Car> list = new ArrayList<>();
        String query = "select * from public.car order by car_id asc";
        try {
            statement = connection.createStatement();
            data = statement.executeQuery(query);
            while (data.next()){
                list.add(match(data));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Car> getCarId(int id){
        return selectByQuery("select * from public.car where car_model_id =" + id);
    }

    public Car match(ResultSet data) throws SQLException {
        car = new Car();
        car.setCar_id(data.getInt("car_id"));
        car.setCar_model_id(data.getInt("car_model_id"));
        car.setCar_plate(data.getString("car_plate"));
        car.setCar_color(Car.Color.valueOf(data.getString("car_color")));
        car.setCar_km(data.getInt("car_km"));
        car.setModel(modelDao.getById(car.getCar_model_id()));
        return car;
    }
    public boolean save(Car car){
        String query = "insert into public.car (car_model_id,car_color,car_km,car_plate) values (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,car.getCar_model_id());
            preparedStatement.setString(2,car.getCar_color().toString());
            preparedStatement.setInt(3,car.getCar_km());
            preparedStatement.setString(4,car.getCar_plate());

            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Car getById(int id){

        Car obj = null;
        String query = "select * from public.car where car_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            data = preparedStatement.executeQuery();
            if(data.next()){
                obj = match(data);
            }
            return obj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Car car){
        String query = "update public.car set car_model_id = ? , car_color = ? , car_km = ?, car_plate = ? where car_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,car.getCar_model_id());
            preparedStatement.setString(2,car.getCar_color().toString());
            preparedStatement.setInt(3,car.getCar_km());
            preparedStatement.setString(4,car.getCar_plate());
            preparedStatement.setInt(5,car.getCar_id());
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id){
        String query = "delete from public.car where car_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Car> selectByQuery(String query){
        ArrayList<Car> cars = new ArrayList<>();
        try {
            data = connection.createStatement().executeQuery(query);
            while (data.next()){
                cars.add(match(data));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }
}
