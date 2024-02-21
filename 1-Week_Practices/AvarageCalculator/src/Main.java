/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
         // Defined course names
        double matematik,fizik, turkce, tarih, muzik, ortalama;
        int counter = 5; 
        Scanner value = new Scanner(System.in);

        // Value entries
        System.out.print("Matematik notunu giriniz: ");
        matematik = value.nextDouble();
        if(matematik<=0 || matematik>100){
            System.out.println("Gecersiz deger");
            matematik = 0;
            counter-=1;
        }
        System.out.print("Fizik notu giriniz: ");
        fizik = value.nextDouble();
        if(fizik<=0 || fizik>100){
            System.out.println("Gecersiz deger");
            fizik = 0;
            counter-=1;
        }
        System.out.print("Turkce notunu giriniz ");
        turkce = value.nextDouble();
        if(turkce<=0 || turkce>100){
            System.out.println("Gecersiz deger");
            turkce = 0;
            counter-=1;
        }
        System.out.print("Tarih notunu giriniz: ");
        tarih = value.nextDouble();
        if(tarih<=0 || tarih>100){
            System.out.println("Gecersiz deger");
            tarih = 0;
            counter-=1;
        }
        System.out.print("Muzik notunu giriniz: ");
        muzik = value.nextDouble();
        if(muzik<=0 || muzik>100){
           System.out.println("Gecersiz deger");
            muzik = 0;
            counter-=1;
        }
        // Formulas
        if(counter<=0) {
            ortalama = (matematik + fizik + turkce + tarih + muzik);
        }else{
            ortalama = (matematik + fizik + turkce + tarih + muzik) / counter;
        }
        // Conditional outputs
        if(ortalama >= 55){
            System.out.println("Sinifi gectiniz..");
            System.out.println("Ortalama: "+ ortalama);
        }else{
            System.out.println("Sinif tekrari..");
            System.out.println("Ortalamaniz:  "+ ortalama);
        }
    }
}
