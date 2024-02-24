import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int userValue;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter value: ");
        userValue = scanner.nextInt();
        
        int min = 0;
        int max = 0;
        
        int[] listValue = {5,15,45,100,67,124,250};
        Arrays.sort(listValue);
        
        for (int i : listValue) {
            if(i < userValue){
                min = i;
            }
            else if(i > userValue){
                max = i;
                break;
            }  
        }
        if(userValue > max){
            System.out.println("Enter a larger value from the list.");
            System.out.println("Only the nearest smallest number will be given.: " + min);
        }
        else{
            System.out.println("smaller :  " + min);
            System.out.println("bigger: : " + max);
        }
    }
}
