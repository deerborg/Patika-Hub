
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        // User first value

        System.out.println("Enter the first value: ");
        int firstValue = userInput.nextInt();
        
        // User second value
        System.out.println("Enter the second value: ");
        int secondValue = userInput.nextInt();

        // User third value
        System.out.println("Enter the third value: ");
        int thirdValue = userInput.nextInt();
        
        // Result operations
        int mathStack = firstValue + secondValue * thirdValue - secondValue;
        System.out.println("Result: " + mathStack);
    }

}