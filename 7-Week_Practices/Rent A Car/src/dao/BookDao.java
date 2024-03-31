package dao;

import core.Database;
import entity.Book;
import entity.Car;
import entity.Model;

import java.sql.*;
import java.util.ArrayList;

public class BookDao {
    private Connection connection;
    private Statement statement;
    private ResultSet data;
    private PreparedStatement preparedStatement;
    private Model model = null;
    private ModelDao modelDao = null;
    private Car car;
    private BrandDao brandDao;
    private Book book;
    private CarDao carDao;

    public BookDao() {
        connection = Database.connector();
        modelDao = new ModelDao();
        brandDao = new BrandDao();
        carDao = new CarDao();
    }

    public ArrayList<Book> findByAll(){

        ArrayList<Book> list = new ArrayList<>();
        String query = "select * from public.book order by book_id asc";
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

    public ArrayList<Book> getCarId(int id){
        return selectByQuery("select * from public.book where book_car_id =" + id);
    }

    public Book match(ResultSet data) throws SQLException {
        book = new Book();
        book.setBook_id(data.getInt("book_id"));
        book.setBook_case(data.getString("book_case"));
        book.setBook_car_id(data.getInt("book_car_id"));
        book.setBook_name(data.getString("book_name"));
        book.setBook_strt_date(data.getDate("book_strt_date").toLocalDate());
        book.setBook_strt_date(data.getDate("book_fnsh_date").toLocalDate());
        book.setCar(carDao.getById(data.getInt("book_car_id")));
        book.setBook_idno(data.getString("book_idno"));
        book.setBook_note(data.getString("book_mpno"));
        book.setBook_mail(data.getString("book_mail"));
        book.setBook_note(data.getString("book_note"));
        book.setBook_prc(data.getInt("book_prc"));
        return book;
    }
    public boolean save(Book book){
        String query = "insert into public.book (book_car_id,book_name,book_idno,book_mpno,book_mail,book_strt_date,book_fnsh_date,book_prc,book_note,book_case) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,book.getBook_car_id());
            preparedStatement.setString(2,book.getBook_name());
            preparedStatement.setString(3,book.getBook_idno());
            preparedStatement.setString(4,book.getBook_mpno());
            preparedStatement.setString(5,book.getBook_mail());
            preparedStatement.setDate(6,Date.valueOf(book.getBook_strt_date()));
            preparedStatement.setDate(7,Date.valueOf(book.getBook_fnsh_date()));
            preparedStatement.setInt(8,book.getBook_prc());
            preparedStatement.setString(9,book.getBook_case());
            preparedStatement.setString(10,book.getBook_note());

            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book getById(int id){

        Book obj = null;
        String query = "select * from public.book where book_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            data = preparedStatement.executeQuery();
            if(data.next()){
                obj = match(data);
            }
            return obj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Book book){
        String query = "update public.book set book_car_id = ? , ";
        try {
            preparedStatement = connection.prepareStatement(query);

            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id){
        String query = "delete from public.book where book_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() != -1; // sonuc -1 dönerse islem gerceklesmemistir
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Book> selectByQuery(String query){
        ArrayList<Book> books = new ArrayList<>();
        try {
            data = connection.createStatement().executeQuery(query);
            while (data.next()){
                books.add(match(data));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
