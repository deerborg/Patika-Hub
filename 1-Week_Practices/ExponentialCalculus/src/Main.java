import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        int n, i = 1, k = 1;

        System.out.print("Enter value : ");
        n = inp.nextInt();

        while (i <= n && k <= n) {
            i *= 4;
            k *= 5;
            if (i <= n && k <= n) {
                System.out.println(i);
                System.out.println(k);
            }
        }
    }
}