import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Array length: ");
        int length = scanner.nextInt();
        int get = 1;
        System.out.print("Values: ");
        int[] list = new int[length];
        
        for(int i = 0; i < list.length ; i++){
            System.out.print(get+" - Value: ");
            list[i] = scanner.nextInt();
            get++;
        }
        Arrays.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }   
}

