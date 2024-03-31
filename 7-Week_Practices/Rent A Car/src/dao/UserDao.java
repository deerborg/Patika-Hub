package dao;

import core.Database;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

import static core.Database.connector;

public class UserDao {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet data;
    private Statement statement;
    private User user = null;

    public UserDao() {
        this.connection = connector();
    }

    public ArrayList<User> findByAll(){

        ArrayList<User> list = new ArrayList<>();
        String query = "select * from public.user";
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

    public User findByLogin(String username,String password){
        String query = "select * from public.user where user_name = ? and user_pass = ?";
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet data = preparedStatement.executeQuery();

            if(data.next()){
               user = match(data);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User match(ResultSet data) throws SQLException {

        User user = new User();

        user.setUser_id(data.getInt("user_id"));
        user.setUser_name(data.getString("user_name"));
        user.setUser_pass(data.getString("user_pass"));
        user.setUser_role(data.getString("user_role"));

        return user;
    }
}
