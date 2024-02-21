/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        int elementValue, valueStack, firstValue=0, secondValue=1;
        System.out.println("Fibonacci Calculator");

        // User input
        System.out.print("Enter element value: ");
        elementValue = value.nextInt();

        // Calculate fibonacci numbers
        for(int fbCal=0; fbCal<=elementValue;fbCal++){
            System.out.print(firstValue + " ");
            valueStack = firstValue + secondValue;
            firstValue = secondValue;
            secondValue = valueStack;
        }
    }
}