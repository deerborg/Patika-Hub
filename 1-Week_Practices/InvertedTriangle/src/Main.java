
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value for diamond :");
        int n = input.nextInt();
        // With a loop within a loop, it keeps the middle section wide to accommodate the entered value and form a diamond shape. Since the top and bottom sides need to be thin -- returns
        for (int i = n; i > 0; i--) {
            for (int j = n+1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < (i * 2 - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    } 
}
