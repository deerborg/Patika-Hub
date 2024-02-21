
/**
 *
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        
        int userValue, total = 0,number = 0;
        double avarage;
        
        System.out.println("Enter number: ");
        userValue = value.nextInt();
        
        for(int i = 0; i <= userValue; i++){
            if(i % 3 == 0 && i % 4 == 0){
                total += i;
                number++;
            }
        }
            avarage = total / number;
            System.out.println(avarage);
    }
}
