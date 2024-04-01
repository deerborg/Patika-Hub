package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection connection = null;
    private static Database connector = null;
    private final String Database_URL = "jdbc:postgresql://localhost:5432/###";
    private final String Database_USERNAME = "####";
    private final String Database_PASSWORD = "###";

    private Database() {
        try {
            connection = DriverManager.getConnection(Database_URL,Database_USERNAME,Database_PASSWORD);
            System.out.println("connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        return connection;
    }

    public static Connection connector(){
        try {
            if(connector == null || connector.getConnection().isClosed()){
                connector = new Database();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connector.getConnection();
    }
}
