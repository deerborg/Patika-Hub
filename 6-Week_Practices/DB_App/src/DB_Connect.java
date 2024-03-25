import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class DB_Connect {

    private final String URL = "jdbc:mysql://localhost/employees";
    private final String USERNAME = "user_name"; // enter user_name for sql
    private final String PASSWORD = "password"; // enter password for sql
    private String query;
    private Connection connection;
    private Statement statement;
    private ResultSet data;

    public DB_Connect(String query) {
        this.query = query;
    }

    // Connect to database method
    public void connectDB(){
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connection.createStatement();

            System.out.println("CONNECTION SUCCSESS");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Print database for console
    public void printQuery(){
        try {
            data = statement.executeQuery(query);
            int id = 0;
            String name = "";
            String position ="";
            int salary = 0;
            while (data.next()){
                id = data.getInt("id");
                name = data.getString("name");
                position = data.getString("position");
                salary = data.getInt("salary");

                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Position : " + position);
                System.out.println("Salary : " + salary);
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Writes the queries made for the database to the txt files
    public void writeDB(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/employees_save.txt",true))){

            data = statement.executeQuery(query);

            int id = 0;
            String name = "";
            String position ="";
            int salary = 0;

            while (data.next()){
                id = data.getInt("id");
                name = data.getString("name");
                position = data.getString("position");
                salary = data.getInt("salary");

                writer.write("ID: "+ id +"\n");
                writer.write("NAME: " + name +"\n");
                writer.write("POSITION: "+position +"\n");
                writer.write("SALARY: "+salary +"\n");
            }
            System.out.println("WRITER PROCESS SUCCSESS");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // It is a method of reading the written file via the console.
    public void readDB(){
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/employees_save.txt")))){

            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
