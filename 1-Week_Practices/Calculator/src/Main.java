/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        Scanner value = new Scanner(System.in);

        // the variables.
        double number1, number2;
        int userSelect;

        // Getting value from user
        System.out.println("Welcome to the calculator.");
        System.out.println("__________________________");
        System.out.println("Instructions; "  );
        System.out.println("__________________________");
        System.out.println("Enter first number. ");
        number1 = value.nextInt();
        System.out.println("Enter second number. ");
        number2 = value.nextInt();
        
        // Action menu
        System.out.println("To Sum: select 1");
        System.out.println("To Extract: select 2");
        System.out.println("To Divide: select 3");
        System.out.println("To Multiplation: select 4");
        userSelect = value.nextInt();

        // Actions to be applied according to the value received
        switch (userSelect){
            case 1:
                System.out.println("Result " + (number1 + number2));
                break;
            case 2:
                System.out.println("Result " + (number1 - number2));
                break;
            case 3:
                if (number2 != 0 && number1 != 0){
                    System.out.println("Result " + (number1 / number2));
                }else if ( number1 != 0 && number2 == 0){
                    System.out.println("wrong choice");
                }else {
                    System.out.println("wrong choice");
                }break;
            case 4:
                System.out.println("Result " + (number1 * number2));
                break;
            default:
                System.out.println("Invalid entry.");
                break;
        }// End program
    }
}