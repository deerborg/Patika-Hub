import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {
        
        int kisaKenar,uzunKenar;
        double cevre,alan,u,hipotenus;
        
        // kullanicidan alinan boyut degerleri
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kisa kenari giriniz: ");
        kisaKenar = scanner.nextInt();
        System.out.println("Yukselik giriniz: ");
        uzunKenar = scanner.nextInt();
        hipotenus = Math.sqrt((kisaKenar*kisaKenar) + (uzunKenar*uzunKenar));
        
        // degerlere gore islenen formul 
        u = (kisaKenar+uzunKenar+hipotenus) / 2;
        cevre = 2*u;
        alan = (kisaKenar*uzunKenar/2);
        
        System.out.println("Hipotenüs: " + hipotenus);       
        System.out.println("cevre " + cevre);
        System.out.println("alan " + alan);
    }
}