/**
 *
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    
   static int exponen(int expo, int base){
       if(base == 0){
           return 1;
       }
       int result;
       return result = expo * exponen(expo, base-1);
   }
    public static void main(String[] args) {
        System.out.println(exponen(5, 3));
    }
   
        
  }
    
    
    

