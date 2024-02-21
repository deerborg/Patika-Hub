
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {
        Scanner userValue = new Scanner(System.in);

        System.out.println("Cashier program");
        System.out.println("------------------------------------------");
        
        //  Product prices
        double pearPrice = 2.14;
        double applePrice = 3.67;
        double tomatoesPrice = 1.11;
        double bananaPrice = 0.95;
        double auberginePrice = 5.00;
        double totalPrice = 0;
        
        System.out.println("------------------------------------------");
        System.out.println("Price list: ");
        
        // Price List
        System.out.println("Pear Price: " + pearPrice);
        System.out.println("Apple Price " + applePrice);
        System.out.println("Tomatoes Price:  " + tomatoesPrice);
        System.out.println("Banana Price " + bananaPrice);
        System.out.println("aubergine Price " + auberginePrice);
        System.out.println("-----------------------------------------");
        
        System.out.println("Kilos of tomatoes: ");
        // Price-weight calculations
        int tomatoesValue = userValue.nextInt();
        totalPrice += tomatoesValue*tomatoesPrice;

        System.out.println("Kilos of apple: ");
        int appleValue = userValue.nextInt();
        totalPrice += appleValue*applePrice;

        System.out.println("Kilos of pear: ");
        int pearValue = userValue.nextInt();
        totalPrice += pearValue*pearPrice;

        System.out.println("Kilos of banana: ");
        int bananaValue = userValue.nextInt();
        totalPrice += bananaValue*bananaPrice;

        System.out.println("Kilos of aubergine");
        int aubergineValue = userValue.nextInt();
        totalPrice += aubergineValue*auberginePrice;
        
        System.out.println("-----------------------------------------");
        System.out.println("Total price : " + totalPrice);
        System.out.println("-----------------------------------------");
    }
}