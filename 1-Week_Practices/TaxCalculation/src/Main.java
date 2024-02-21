
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double fiyat,kdvOranı,kdvTutarı,genelToplam;
        
        // kullanicidan alinan fiyat bilgisi
        System.out.println("Fiyat bilgisi giriniz: ");
        fiyat = scanner.nextDouble();
        
        // alinan degerin 1000'den az veya cok olma durumundaki kosullar
        if(fiyat <= 1000){
            kdvOranı = 0.18;
            kdvTutarı = fiyat * kdvOranı;
            genelToplam = fiyat + kdvTutarı;
            
            System.out.println("DEKONT");
            System.out.println("----------------------");
            System.out.println("KDV siz tutar: " + fiyat );
            System.out.println("KDV oranı: " +"% "+(kdvOranı*100));
            System.out.println("KDV tutar: " + kdvTutarı);
            System.out.println("Genel toplam: " + genelToplam);
        }
        else {
            kdvOranı = 0.08;
            kdvTutarı = fiyat * kdvOranı;
            genelToplam = fiyat + kdvTutarı;
            
            System.out.println("DEKONT");
            System.out.println("----------------------");
            System.out.println("KDV siz tutar: " + fiyat );
            System.out.println("KDV oranı: " +"% "+ (kdvOranı*100));
            System.out.println("KDV tutar: " + kdvTutarı);
            System.out.println("Genel toplam: " + genelToplam);
        }
        
    }
}