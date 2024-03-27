package core;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database status = null;
    private static final String URL = "jdbc:sql://localhost:yourport/yourbase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private Connection connection = null;

    private Database(){
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("connected");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection getStatus(){
        if(status == null){
            status = new Database();
        }
        return status.getConnection();
    }
}
