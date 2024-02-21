
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Year value received from the user
        int yearValue;
        System.out.print("Please enter year: ");
        yearValue = input.nextInt();

        // If the year is divisible or not divisible by 4
        if (yearValue % 4 == 0) {
            if (yearValue % 100 == 0) {
                if (yearValue % 400 == 0) {
                    System.out.print(yearValue + " is a leapyear");
                } else {
                    System.out.print(yearValue + " is a not leapyear");
                }
            } else {
                System.out.print(yearValue + " is a leapyear");
            }
        } else {
            System.out.print(yearValue + " is not a leapyear");
        }
    }

}