
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double r,a,alan,pi,cevre,secAlan;
        pi = 3.14;
        
        // Radius and center angle measurement values ​​are received from the user
        System.out.println("Yari capi giriniz: ");
        r = scanner.nextDouble();
        System.out.println("Merkez acisi olcusunu giriniz: ");
        a = scanner.nextDouble();
        
        // The received values ​​are adapted to the formula to reach the desired values ​​in the output
        alan = pi * r * r;
        cevre = 2 * pi * r;
        secAlan = (pi * (r*r) * a) / 360;
        
        System.out.println("Dairenin cevresi: " + cevre);
        System.out.println("Dairenin alani : " + alan);
        System.out.println("Daire diliminin alani: " + secAlan); 
    }
 
}