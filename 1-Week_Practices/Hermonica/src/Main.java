
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // We need to take two different numbers to adapt the formula
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Enter Value: ");
        n = input.nextInt();
        
        double sum = 0;
        
        // HM= 2/ (1/value1 + 1/value2)
        for(int i = 1; i<=n ;i++){
            sum += (1.0/i);
        }

        System.out.println("Result: "+ sum);

    }
    
}
