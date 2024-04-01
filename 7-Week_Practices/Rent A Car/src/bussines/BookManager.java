package bussines;

import dao.BookDao;
import dao.CarDao;
import dao.ModelDao;
import entity.Book;
import entity.Car;
import entity.Model;

import javax.swing.*;
import java.util.ArrayList;

public class BookManager {
    private BookDao bookDao;

    public BookManager() {
        bookDao = new BookDao();
    }

    public boolean save(Book book){
        return bookDao.save(book);
    }
    public ArrayList<Object[]> getForTable(int size, ArrayList<Book> list) {
        ArrayList<Object[]> bookList = new ArrayList<>();
        for (Book obj : list) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getBook_id();
            rowObject[i++] = obj.getBook_car_id();
            rowObject[i++] = obj.getBook_name();
            rowObject[i++] = obj.getBook_idno();
            rowObject[i++] = obj.getBook_mpno();
            rowObject[i++] = obj.getBook_mail();
            rowObject[i++] = obj.getBook_strt_date();
            rowObject[i++] = obj.getBook_fnsh_date();
            rowObject[i++] = obj.getBook_prc();
            rowObject[i++] = obj.getBook_note();
            rowObject[i++] = obj.getBook_case();
            bookList.add(rowObject);
        }
        return bookList;
    }
    public ArrayList<Book> findByAll() {
        return bookDao.findByAll();
    }
}
