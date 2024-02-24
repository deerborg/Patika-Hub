import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int[] list={45,2,123,5,-1,-58,4,0};
        Arrays.sort(list);
        System.out.print("Number:");
        int bigger=0,smaller=0;
        int nm = scan.nextInt();

        for (int i:list) {
            if(i<nm){
                bigger=i;
            }
            else if(i>nm){
                smaller=i;
                break;
            }

        }
        System.out.println("Smaller : "+ bigger);
        System.out.println(Arrays.toString(list));
        System.out.println("Bigger : "+ smaller);
    
    }   
}
