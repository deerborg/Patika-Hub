import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        int[] list = {1,1,1,3,3,4,5,5,6,7,8,9,9,10,11,12,13,13,13,2,2,4,4,4,44,44,444,22,20,14,14};
        Arrays.sort(list);
        System.out.print("Tekar eden cift sayilar -----> ");
        for(int i = 0 ; i < list.length ; i++){
            for(int j = 0; j < list.length ; j++){
                if(list[i] == list[j] && i != j && list[i] % 2 == 0 && list[j] % 2 == 0){
                    System.out.print(list[i] + " ");
                    break;
                } 
            }
        }
    }       
}             