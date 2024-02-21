
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Variables
        int ebob=1,ekok,count=1,valueFs,valueSc;
        
        // Two values ​​are taken from the user
        System.out.print("Enter value 1: ");
        valueFs = input.nextInt();
      
        System.out.print("Enter value 2: ");
        valueSc = input.nextInt();
        
        while (true){
            if (valueFs % count == 0 && valueSc % count == 0){
                ebob=count;
            }
            if(count == valueFs || count == valueSc){
                break;
            }
            count++;
        }
        ekok=(valueFs*valueSc) / ebob;
        System.out.println("Ebob: "+ebob);
        System.out.println("Ekok: "+ekok);
    }
}