/**
 *
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int cift,total = 0, number = 0;

        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("Enter the value: ");
            cift = scanner.nextInt();
            if(cift % 2 != 0){
                System.out.println("You must enter an even number!");
                continue;
            }
            for(int i = 0 ; i <= cift ; i++){
                if(i % 4 == 0){
                    System.out.println(i);
                    total+=i;
                }
            }
            System.out.println(total);
            break;
        }
    }
}
