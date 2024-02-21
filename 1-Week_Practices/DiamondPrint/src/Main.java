/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {

     public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        System.out.println("Enter value :");
        int belly = value.nextInt();

        for (int count = 0; count <= belly; count++) {
            for (int countTwo = 0; countTwo < (belly - count); countTwo++) {
                System.out.print(" ");
            }
            for (int countTr = 1; countTr <= (2 * count + 1); countTr++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        for (int i = belly; i > 0; i--) {
            for (int countTwo = belly+1; countTwo > i; countTwo--) {
                System.out.print(" ");
            }
            for (int countTo= 0; countTo < (i * 2 - 1); countTo++) {
                System.out.print("*");
            }
            System.out.println();
        }

}
}
