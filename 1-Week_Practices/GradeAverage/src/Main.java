
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {

     public static void main(String[] args) {
        // ders tanımalamaları
        int matematik,fizik,kimya,turkce,tarih,muzik;
        Scanner scanner = new Scanner(System.in);
        
        // tanımlanan ders değer girişleri (kullanıcıdan)
        System.out.println("Matematik notunuz: ");
        matematik = scanner.nextInt();
        
        System.out.println("Fizik notunuz: ");
        fizik = scanner.nextInt();
        
        System.out.println("Kimya notunuz: ");
        kimya = scanner.nextInt();
        
        System.out.println("Turkce notunuz: ");
        turkce = scanner.nextInt();
        
        System.out.println("Tarih notunuz: ");
        tarih = scanner.nextInt();
        
        System.out.println("Muzik notunuz: ");
        muzik = scanner.nextInt();
        
        // kosula gore cıktıya dokecek olan mesaj tanımı
        String sonuc = "";
        
        // toplam ve ortalama formulu
        int total = (matematik + fizik + kimya + tarih + tarih + muzik);
        double ortalama = total/6;
        
        // verilen degerleri formulde isleyerek cıkarılan sonuc
        sonuc = ortalama >= 60 ? "Sinifi gectiniz.." : "Sinif tekrari..";
        System.out.println(sonuc);
        
    }
    
}