/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Defined variables
        
        int ValueFirst, ValueSecond, ValueTriple;
        // User values
        System.out.print("First Value: ");
        ValueFirst = input.nextInt();
        System.out.print("Secon Value: ");
        ValueSecond = input.nextInt();
        System.out.print("Tripple Value: ");
        ValueTriple = input.nextInt();
        
        // Printing given values ​​with conditions
        if (ValueFirst > ValueSecond && ValueFirst > ValueTriple) {
            if (ValueSecond > ValueTriple)
                System.out.print(ValueFirst + " > " + ValueSecond + " > " + ValueTriple);
            else
                System.out.print(ValueFirst + " > " + ValueTriple + " > " + ValueSecond);
        }

        if (ValueSecond > ValueFirst && ValueSecond > ValueTriple) {
            if (ValueFirst > ValueTriple)
                System.out.print(ValueSecond + " > " + ValueFirst + " > " + ValueTriple);
            else
                System.out.print(ValueSecond + " > " + ValueTriple + " > " + ValueFirst);
        }

        if (ValueTriple > ValueSecond && ValueTriple > ValueFirst) {
            if (ValueFirst > ValueSecond)
                System.out.print(ValueTriple + " > " + ValueFirst + " > " + ValueSecond);
            else
                System.out.print(ValueTriple + " > " + ValueFirst + " > " + ValueSecond);
        }

    }
}