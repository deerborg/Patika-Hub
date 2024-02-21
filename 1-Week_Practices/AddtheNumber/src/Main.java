/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        int value,total = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter value: ");
        value = scanner.nextInt();
        
        while(value > 0){
            total = (value%10) + total;
            value /= 10; 
        }
        System.out.println("Total: " + total);
    }
}
