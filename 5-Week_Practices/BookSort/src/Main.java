import java.util.Comparator;
import java.util.TreeSet;
public class Main {

        public static void main(String[] args) {
            TreeSet<Sorter> books = new TreeSet<>();

            Sorter book1 = new Sorter("Book 1",747,"Author 1","2024.01.01");
            Sorter book2 = new Sorter("Book 2",901,"Author 2","2023-01-01");
            Sorter book3 = new Sorter("Book 3",167,"Author 3","2022-01-01");
            Sorter book4 = new Sorter("Book 4",314,"Author 4","2021-01-01");

            books.add(book1);
            books.add(book2);
            books.add(book3);
            books.add(book4);

            for(Sorter book: books){
                System.out.println("Book Name: " + book.getName() +
                        "\nPage Number: " + book.getPageNumber() +
                        "\nAuthor Name: " + book.getAuthor() +
                        "\nReleased Date: " + book.getDate() +
                        "\n***********************************");
            }

            System.out.println();

            TreeSet<Sorter> books2 = new TreeSet<>(new Comparator<Sorter>() {
                @Override
                public int compare(Sorter o1, Sorter o2) {
                    return o1.getPageNumber() - o2.getPageNumber();
                }
            });

            books2.add(book1);
            books2.add(book2);
            books2.add(book3);
            books2.add(book4);

            for(Sorter book: books2){
                System.out.println("Book Name: " + book.getName() +
                        "\nPage Number: " + book.getPageNumber() +
                        "\nAuthor Name: " + book.getAuthor() +
                        "\nReleased Date: " + book.getDate() +
                        "\n***********************************");
            }
        }
    }

