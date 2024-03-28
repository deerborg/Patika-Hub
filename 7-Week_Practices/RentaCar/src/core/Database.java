package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database status = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/rentacar";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1511";

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
