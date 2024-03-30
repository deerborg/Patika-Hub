package dao;

import bussines.ModelManager;
import core.Database;
import entity.Brand;
import entity.Model;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class BrandDao {
   private Connection connection;

   private Statement statement;
   private ResultSet data;
   private PreparedStatement preparedStatement;
   private Brand brand = null;

    public BrandDao() {
        this.connection = Database.connector();
    }

    public ArrayList<Brand> findByAll(){

        ArrayList<Brand> list = new ArrayList<>();
        String query = "select * from public.brand order by brand_id asc";
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

    public Brand match(ResultSet data) throws SQLException {

        brand = new Brand();

        brand.setBrand_id(data.getInt("brand_id"));
        brand.setBrand_name(data.getString("brand_name"));


        return brand;
    }
    public boolean save(Brand brand){
        String query = "insert into public.brand (brand_name) values (?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,brand.getBrand_name());
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Brand getById(int id){

        Brand brand = null;
        String query = "select * from public.brand where brand_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            data = preparedStatement.executeQuery();
            if(data.next()){
                brand = match(data);
            }
            return brand;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Brand brand){
        String query = "update public.brand set brand_name = ?  where brand_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,brand.getBrand_name());
            preparedStatement.setInt(2,brand.getBrand_id());
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id){
        String query = "delete from public.brand where brand_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Brand> selectByQuery(String query){
        ArrayList<Brand> brands = new ArrayList<>();
        try {
            data = connection.createStatement().executeQuery(query);
            while (data.next()){
                brands.add(match(data));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brands;
    }


}
