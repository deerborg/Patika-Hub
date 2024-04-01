package view;

import bussines.BookManager;
import bussines.BrandManager;
import bussines.CarManager;
import core.Helper;
import dao.BookDao;
import entity.Book;
import entity.Brand;
import entity.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookView extends Layout{
    private JPanel container;
    private JTextField fld_book_name;
    private JLabel fld_car;
    private JTextField fld_book_id_no;
    private JTextField fld_book_mpno;
    private JTextField fld_book_mail;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JTextField fld_price;
    private JTextPane pnl_book_note;
    private JButton btn_save;
    private JButton btn_cancel;
    private Book book;
    private BookDao bookDao;
    private BookManager bookManager;
    private CarManager carManager;
    private BrandManager brandManager;
    private Car car;
    private Brand brand;


    public BookView(Car carSelect, String strtDate,String fnshDate) {
        brandManager = new BrandManager();
        bookDao = new BookDao();
        bookManager = new BookManager();
        carManager = new CarManager();
        this.car = carSelect;

        add(container);
        pageArt(500,700,"Rezervation");

        fld_car.setText(fld_car.getText() + " / " + car.getCar_plate() + " / " + car.getModel().getModel_name() + " / " + car.getModel().getBrand().getBrand_name());
        // Cancel butonu
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        fld_strt_date.setText(strtDate);
        fld_fnsh_date.setText(fnshDate);

        // Save butonu
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Boş olmama durumu
                if(Helper.isFieldEmpty(fld_book_id_no) &&
                        Helper.isFieldEmpty(fld_book_mail) &&
                        Helper.isFieldEmpty(fld_book_mpno) &&
                        Helper.isFieldEmpty(fld_book_name) &&
                        Helper.isFieldEmpty(fld_price) &&
                        Helper.isFieldEmpty(fld_fnsh_date) &&
                        Helper.isFieldEmpty(fld_strt_date))
                {
                    Helper.msg("Not Null");
                }else {
                    Book book = new Book();
                    book.setBook_case("Done");
                    book.setBook_car_id(car.getCar_id());
                    book.setBook_mpno(fld_book_mpno.getText());
                    book.setBook_prc(Integer.parseInt(fld_price.getText()));
                    book.setBook_mail(fld_book_mail.getText());
                    book.setBook_idno(fld_book_id_no.getText());
                    book.setBook_name(fld_book_name.getText());
                    book.setBook_strt_date(LocalDate.parse(strtDate, DateTimeFormatter.ofPattern("dd/MM/yyy")));
                    book.setBook_fnsh_date(LocalDate.parse(fnshDate, DateTimeFormatter.ofPattern("dd/MM/yyy")));
                    book.setBook_note(pnl_book_note.getText());

                    if(bookManager.save(book)){
                        Helper.msg("Succsess");
                        dispose();
                    }else{
                        Helper.msg("Error");
                        dispose();
                    }

                }
            }
        });
    }
}
