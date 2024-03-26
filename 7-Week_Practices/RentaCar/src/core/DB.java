package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private Connection connection = null;
    private static DB instance = null;
    private final String DB_URL = "jdbc:postgresql://localhost/rentacar";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "1511";


    private DB(){
        try {
             this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("connection succsess");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection getInstance()  {
        try {
            if(instance == null || instance.getConnection().isClosed()){
                instance = new DB();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return instance.getConnection();
    }

    public static void main(String[] args) {
        getInstance();
    }
}
