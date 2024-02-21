/**
 * @author Furkan Aydemir, deerborg
 * @since  2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        // Birth year information received from the user
        Scanner userInput = new Scanner(System.in);
        int bornYear, zodiac;
        System.out.print("Enter your birth year: ");
        bornYear = userInput.nextInt();
        // Formula
        zodiac = bornYear % 12;

        // Outputs according to the information given
        switch (zodiac){
            case 0:
                System.out.print("Your zodiac is Monkey");
                break;
            case 1:
                System.out.print("Your zodiac is Roaster");
                break;
            case 2:
                System.out.print("Your zodiac is Dog");
                break;
            case 3:
                System.out.print("Your zodiac is Pig");
                break;
            case 4:
                System.out.print("Your zodiac is Rat");
                break;
            case 5:
                System.out.print("Your zodiac is Ox");
                break;
            case 6:
                System.out.print("Your zodiac is Tiger");
                break;
            case 7:
                System.out.print("Your zodiac is Rabbit");
                break;
            case 8:
                System.out.print("Your zodiac is Dragon");
                break;
            case 9:
                System.out.print("Your zodiac is Snake");
                break;
            case 10:
                System.out.print("Your zodiac is Horse");
                break;
            case 11:
                System.out.print("Your zodiac is Sheep");
                break;
        }
    }
}