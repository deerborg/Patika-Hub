package dao;

import core.Database;
import entity.Model;

import java.sql.*;
import java.util.ArrayList;

public class ModelDao {
    private Connection connection;
    private final BrandDao brandDao = new BrandDao();


    public ModelDao() {
        this.connection = Database.getStatus();
    }

    public ArrayList<Model> findAll(){

        return selectByQuery("select * from public.model order by model_id asc");
    }

    public boolean save (Model model){
        String query = "insert into public.model (model_brand_id,model_name,model_type,model_year,model_fuel,model_gear) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,model.getBrand_id());
            preparedStatement.setString(2,model.getName());
            preparedStatement.setString(3,model.getType().toString());
            preparedStatement.setString(4,model.getYear());
            preparedStatement.setString(5,model.getFuel().toString());
            preparedStatement.setString(6,model.getGear().toString());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Model getById(int id){
        Model model = null;
        String query = "select * from public.model where model_name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet data = preparedStatement.executeQuery();

            if(data.next()) model = this.mathc(data);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return model;
    }

    public boolean update (Model model){
        String query = "update public.model set model_brand_id = ? , model_name = ? , model_type = ?, model_year = ?,model_fuel = ?,model_gear = ? where model_id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,model.getBrand_id());
            preparedStatement.setString(2,model.getName());
            preparedStatement.setString(3,model.getType().toString());
            preparedStatement.setString(4,model.getYear());
            preparedStatement.setString(5,model.getFuel().toString());
            preparedStatement.setString(6,model.getGear().toString());
            preparedStatement.setInt(7,model.getId());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleted (int model_id){
        String query = "delete from public.model where model_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,model_id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Model mathc(ResultSet data) throws SQLException {
        Model model = new Model();
        model.setId(data.getInt("model_id"));
        model.setName(data.getString("model_name"));
        model.setFuel(Model.Fuel.valueOf(data.getString("model_fuel")));
        model.setGear(Model.Gear.valueOf(data.getString("model_gear")));
        model.setType(Model.Type.valueOf(data.getString("model_type")));
        model.setYear(data.getString("model_year"));
        model.setBrand(brandDao.getById(data.getInt("model_brand_id")));
        model.setBrand_id(data.getInt("model_brand_id"));
        return model;
    }

    public ArrayList<Model> selectByQuery(String query){
        ArrayList<Model> dataList = new ArrayList<>();
        try {
            ResultSet data = connection.createStatement().executeQuery(query);
            while (data.next()){
                dataList.add(mathc(data));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }

}
