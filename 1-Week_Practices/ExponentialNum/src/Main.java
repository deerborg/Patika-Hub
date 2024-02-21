
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int n, r,sum=1;
        
        System.out.print("Number : ");
        n = input.nextInt();
        
        System.out.print("Expen : ");
        r = input.nextInt();
        
        for(int i=0;i<r;i++) {
            sum*=n;
        }
        System.out.println(n + " ^ " + r + " = " +sum);
    }
}
