import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        String[][] list = new String[7][4];
        for (int i = 0; i < list.length;i++) {
            for (int j = 0; j < list[i].length; j++) {
                if(i==0 || i == 3){
                    list[i][j] = " * ";
                }
                else if( j == 0 || j == 3){
                    list[i][j] = " * ";
                }
                else if(i == 6){
                    list[i][j] = " * ";
                }
                else{
                    list[i][j] = "   ";
                } 
            }
        }
        for (String[] row : list) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
