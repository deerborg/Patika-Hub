import java.util.Comparator;
import java.util.Scanner;

public class Book implements Comparable<Book>{

    private String author;
    private String name;
    private int year;
    private int page;

    public Book(String author, String name, int year, int page) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.page = page;
    }

    @Override
    public int compareTo(Book o) {
        return o.getName().compareTo(getName());
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


}
