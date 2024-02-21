/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /* 
            Kullanıcıdan (sizden) iki farklı değer alıp bunları tip dönüşümünde kullanıcaz. 
            Tam sayı userIntValue (satır 20)
            Ondalıklı veya küsüratlı sayı userDoubleValue (satır 21)
        
        */
        int userIntValue;
        double userDoubleValue;
        /* 
            Alacağımız değerleri tip dönüşümünde kullanabilmek için iki farklı değişken oluşturduk.
            valueTypeToDouble : double (ondalıklı) değeri tam sayı değere dönüştürmek için
            valueTypeToInteger: integer (tam sayı) değeri ondalıklı değere dönüştürmek için
            Dönüştürme işlemleri Satır 42 ve Satır 47
        */
        int valueTypeToDouble;
        double valueTypeToInteger;
        
        Scanner userValue = new Scanner(System.in);
        System.out.println("Buraya tam sayi girisi yapin: ");
        userIntValue = userValue.nextInt();
        System.out.println("----------------------------------------");
        System.out.println("Buraya ondalikli sayi girisi yapin: ");
        userDoubleValue = userValue.nextDouble();
        
        System.out.println("----------------------------------------");
        System.out.println("Ilk girdiginiz tam sayi degerini double bir degiskene ceviriyorum...");
        valueTypeToInteger = userIntValue; 
        System.out.println("Cevrilen islem " + valueTypeToInteger);
        
        System.out.println("----------------------------------------");
        System.out.println("Girdiginiz ondalikli sayi degerini tam sayi (int) bir degiskene ceviriyorum");
        valueTypeToDouble = (int)userDoubleValue;
        System.out.println("Cevrilen islem: " + (int)userDoubleValue);
        
    }
}
