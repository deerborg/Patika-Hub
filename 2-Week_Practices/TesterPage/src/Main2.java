import java.util.Scanner;
import java.util.Arrays;
public class Main2 {
    public static void main(String[] args) {
        int[][] list = {
            {1,2,3},
            {4,5,6},
        };
        for(int i = 0 ; i < list[0].length ; i++){
            for(int j = 0 ; j < list.length; j++){
                System.out.print(list[j][i] + " ");
            }
            System.out.println();
        }
    }   
}

