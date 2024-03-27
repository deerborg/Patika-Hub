package doa;

import core.Database;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDoa {
    private final Connection connection;
    public UserDoa() {
        connection = Database.getStatus();
    }

    public  User findByLogin(String username,String password){
       User user = null;

       String query = "select * from public.user where user_name = ? and user_pass = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet data = preparedStatement.executeQuery();

             if(data.next()){
                user = new User();
                user.setUser_id(data.getInt("user_id"));
                user.setUser_name(data.getString("user_name"));
                user.setUser_pass(data.getString("user_pass"));
                user.setUser_role(data.getString("user_role"));

            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<User> findAll(){
        ArrayList<User> dataList = new ArrayList<>();

        String query = "select * from public.user";

        try {
            Statement statement = connection.createStatement();

            ResultSet data = statement.executeQuery(query);
            while (data.next()){

                int id = (data.getInt("user_id"));
                String name = (data.getString("useR_name"));
                String pass = (data.getString("user_pass"));
                String perm = (data.getString("user_role"));

                dataList.add(new User(id,name,pass,perm));
            }
            return dataList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
