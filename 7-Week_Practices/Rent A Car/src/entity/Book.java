package entity;

import java.time.LocalDate;

public class Book {
    private int book_id;
    private int book_car_id;
    private Car car;
    private String book_name;
    private String book_idno;
    private String book_mpno;
    private String book_mail;
    private LocalDate book_strt_date;
    private LocalDate book_fnsh_date;
    private int book_prc;
    private String book_note;
    private String book_case;

    public Book() {
    }

    public Book(int book_id, int book_car_id, Car car, String book_name, String book_idno, String book_mpno, String book_mail, LocalDate book_strt_date, LocalDate book_fnsh_date, int book_prc, String book_note, String book_case) {
        this.book_id = book_id;
        this.book_car_id = book_car_id;
        this.car = car;
        this.book_name = book_name;
        this.book_idno = book_idno;
        this.book_mpno = book_mpno;
        this.book_mail = book_mail;
        this.book_strt_date = book_strt_date;
        this.book_fnsh_date = book_fnsh_date;
        this.book_prc = book_prc;
        this.book_note = book_note;
        this.book_case = book_case;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_car_id() {
        return book_car_id;
    }

    public void setBook_car_id(int book_car_id) {
        this.book_car_id = book_car_id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_idno() {
        return book_idno;
    }

    public void setBook_idno(String book_idno) {
        this.book_idno = book_idno;
    }

    public String getBook_mpno() {
        return book_mpno;
    }

    public void setBook_mpno(String book_mpno) {
        this.book_mpno = book_mpno;
    }

    public String getBook_mail() {
        return book_mail;
    }

    public void setBook_mail(String book_mail) {
        this.book_mail = book_mail;
    }

    public LocalDate getBook_strt_date() {
        return book_strt_date;
    }

    public void setBook_strt_date(LocalDate book_strt_date) {
        this.book_strt_date = book_strt_date;
    }

    public LocalDate getBook_fnsh_date() {
        return book_fnsh_date;
    }

    public void setBook_fnsh_date(LocalDate book_fnsh_date) {
        this.book_fnsh_date = book_fnsh_date;
    }

    public int getBook_prc() {
        return book_prc;
    }

    public void setBook_prc(int book_prc) {
        this.book_prc = book_prc;
    }

    public String getBook_note() {
        return book_note;
    }

    public void setBook_note(String book_note) {
        this.book_note = book_note;
    }

    public String getBook_case() {
        return book_case;
    }

    public void setBook_case(String book_case) {
        this.book_case = book_case;
    }
}
