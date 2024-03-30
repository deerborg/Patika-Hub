package dao;

import core.Database;
import entity.Brand;
import entity.Model;

import java.sql.*;
import java.util.ArrayList;

public class ModelDao {
    private Connection connection;
    private Statement statement;
    private ResultSet data;
    private PreparedStatement preparedStatement;
    private Model model = null;
    private BrandDao brandDao = new BrandDao();

    public ModelDao() {
        connection = Database.connector();
    }

    public ArrayList<Model> findByAll(){

        ArrayList<Model> list = new ArrayList<>();
        String query = "select * from public.model order by model_id asc";
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

    public ArrayList<Model> getBrandId(int id){
        return selectByQuery("select * from public.model where model_brand_id =" + id);
    }


    public Model match(ResultSet data) throws SQLException {

        model = new Model();

        model.setModel_id(data.getInt("model_id"));
        model.setModel_name(data.getString("model_name"));
        model.setFuel(Model.Fuel.valueOf(data.getString("model_fuel")));
        model.setGear(Model.Gear.valueOf(data.getString("model_gear")));
        model.setType(Model.Type.valueOf(data.getString("model_type")));
        model.setModel_year(data.getString("model_year"));
        model.setBrand(brandDao.getById(data.getInt("model_brand_id")));
        model.setModel_brand_id(data.getInt("model_brand_id"));


        return model;
    }
    public boolean save(Model model){
        String query = "insert into public.model (model_brand_id,model_name,model_type,model_year,model_fuel,model_gear) values (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,model.getModel_brand_id());
            preparedStatement.setString(2,model.getModel_name());
            preparedStatement.setString(3,model.getType().toString());
            preparedStatement.setString(4,model.getModel_year());
            preparedStatement.setString(5,model.getFuel().toString());
            preparedStatement.setString(6,model.getGear().toString());
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Model getById(int id){

        Model model = null;
        String query = "select * from public.model where model_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            data = preparedStatement.executeQuery();
            if(data.next()){
                model = match(data);
            }
            return model;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Model model){
        String query = "update public.model set model_brand_id = ? , model_name = ? , model_type = ?, model_year = ?,model_fuel = ?,model_gear = ? where model_id = ? ";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,model.getModel_brand_id());
            preparedStatement.setString(2,model.getModel_name());
            preparedStatement.setString(3,model.getType().toString());
            preparedStatement.setString(4,model.getModel_year());
            preparedStatement.setString(5,model.getFuel().toString());
            preparedStatement.setString(6,model.getGear().toString());
            preparedStatement.setInt(7,model.getModel_id());
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id){
        String query = "delete from public.model where model_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Model> selectByQuery(String query){
        ArrayList<Model> models = new ArrayList<>();
        try {
            data = connection.createStatement().executeQuery(query);
            while (data.next()){
                models.add(match(data));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return models;
    }
}
