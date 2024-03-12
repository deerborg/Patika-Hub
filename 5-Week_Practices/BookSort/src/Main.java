import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void bracket(){
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        TreeSet<Book> book = new TreeSet<>();

        book.add(new Book("VELİ","KİTAP A",2000,321));
        book.add(new Book("ALİ","KİTAP B",2002,444));
        book.add(new Book("AHMET","KİTAP C",2020,241));
        book.add(new Book("MEHMET","KİTAP D",2010,623));
        book.add(new Book("NECİP","KİTAP E",2009,948));

        // Kitap adına göre alfabetik sıra
        for(Book i : book.reversed()){
            System.out.println(i.getName() + " " + i.getPage() + " " + i.getAuthor() + " " + i.getYear());
        }

       bracket(); // çıktı için ayraç

        // Anonim metot ile yeni sınıf tanımlama (A 'dan Z' ye sıralama)
        TreeSet<Book> book2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage() - o2.getPage();
            }
        });

        book2.add(new Book("VELİ","KİTAP A",2000,321));
        book2.add(new Book("ALİ","KİTAP B",2002,444));
        book2.add(new Book("AHMET","KİTAP C",2020,241));
        book2.add(new Book("MEHMET","KİTAP D",2010,623));
        book2.add(new Book("NECİP","KİTAP E",2009,948));

        // Sayfa sayısına göre sıralama (Çoktan - Aza)
        for(Book i : book2.reversed()){
            System.out.println(i.getName() + " " + i.getPage() + " " + i.getAuthor() + " " + i.getYear());
        }




    }
}
