
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        System.out.print("value: ");
        int number = scanner.nextInt();
        double[] list = new double[number];
        for (int i = 0; i < list.length; i++) {
            list[i] = (double) 1 / (i + 1);
            sum += list[i];
        }
        double average = list.length / sum;
        System.out.println(average);
    }
}
