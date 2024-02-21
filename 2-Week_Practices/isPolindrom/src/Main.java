
import java.util.Scanner;
/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
public class Main {
    
    static boolean isPolindrom(int value){
        int number = value, reNumber = 0, lastNumber;
        
        // The number must not be less than 0
        while(number != 0){
        // It divides the number by 10 and adds the remainder, and finally divides the value of the number by 10 and makes it smaller, and the cycle continues.    
            lastNumber = number % 10;
            reNumber = (reNumber * 10) + lastNumber;
            number /= 10;
        } 
        // If the number is equal to the reconstructed value, it is a polyndromic number
        if(value == reNumber){
            System.out.println("is a polindrom");
            return true;
        }else{
            System.out.println("Not a polindrom");
            System.out.println("Your number reverse: " + reNumber);
            return false;
        }  
    }
    public static void main(String[] args) {
        // Try the method here
        isPolindrom(9999);
    }
 
}
