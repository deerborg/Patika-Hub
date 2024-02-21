/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
     public static void main(String[] args) {
         
         // Gets temperature value
        double temperature; 
        Scanner value = new Scanner(System.in);
        System.out.print("Hello, what is the temperature? ");
        temperature = value.nextDouble();

        // It controls the temperature and makes suggestions with comments.
        if(temperature>25) {
            System.out.println("We can go swimming");
        } 
        else if ( temperature>=15){
            System.out.println("I'm hungry, let's go on a picnic!");
        } 
        else if (temperature>=5) {
            System.out.println("Kalpaçino 4 has been released, I can't believe it.");
        } 
        else {
            System.out.println("Shall we slide down the hill with a bag?");
        }
    }
}
