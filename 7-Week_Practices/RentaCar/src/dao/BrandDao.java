package dao;

import core.Database;
import entity.Brand;

import java.sql.*;
import java.util.ArrayList;

public class BrandDao {
    private Connection connection;

    public BrandDao() {
        this.connection = Database.getStatus();
    }
    
    public ArrayList<Brand> findAll(){

        ArrayList<Brand> dataList = new ArrayList<>();

        String query = "select * from public.brand order by brand_id asc";

        try {
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery(query);

            while (data.next()){
                int id = (data.getInt("brand_id"));
                String name = (data.getString("brand_name"));

                dataList.add(new Brand(id,name));
            }
            return dataList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean save (Brand brand){
        String query = "insert into public.brand (brand_name) values (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,brand.getBrand_name());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return true;
    }

    public Brand getById(int id){
        Brand brand = null;
        String query = "select * from public.brand where brand_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet data = preparedStatement.executeQuery();

            if(data.next()){
               brand = new Brand();
               brand.setBrand_id(data.getInt("brand_id"));
               brand.setBrand_name(data.getString("brand_name"));
            }
            return brand;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean update (Brand brand){
        String query = "update public.brand set brand_name = ? where brand_id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,brand.getBrand_name());
            preparedStatement.setInt(2,brand.getBrand_id());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleted (int id){
        String query = "delete from public.brand where brand_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }



}
