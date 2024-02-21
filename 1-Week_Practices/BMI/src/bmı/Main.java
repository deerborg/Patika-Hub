
package BMI;
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // User height and weight information inputs
        System.out.println("Please enter your height (m): ");
        double userHeight = input.nextDouble();

        System.out.println("Please enter your weight (kg): ");
        double userWeight = input.nextDouble();

        // Calculating Body Index
        double bmi = userWeight/(userHeight*userHeight);
        System.out.println("Your Body Mass Index is: "+ bmi);
        }
}