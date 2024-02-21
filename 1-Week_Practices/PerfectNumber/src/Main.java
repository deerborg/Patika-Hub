import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    public static void main(String[] args) {
        int sayi, sum = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number :");
        sayi = input.nextInt();
        for (int i = 1; i < sayi; i++) {
            if (sayi % i == 0)
                sum += i;
        }
        if (sum == sayi)
            System.out.print(sayi + " its a perfect number.");
        else
            System.out.print(sayi + " its a not perfect number.");
    }
}