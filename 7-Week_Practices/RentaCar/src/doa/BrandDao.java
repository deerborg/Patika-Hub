package doa;

import core.Database;
import entity.Brand;
import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BrandDao {
    private Connection connection;

    public BrandDao() {
        this.connection = Database.getStatus();
    }

    public ArrayList<Brand> findAll(){

        ArrayList<Brand> dataList = new ArrayList<>();

        String query = "select * from public.brand";

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
}
