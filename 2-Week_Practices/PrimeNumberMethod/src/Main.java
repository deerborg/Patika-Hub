/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 * @code .isPrimeNumber() : Verilen değerin koşullar içerisinde kontrol edip çıktı sağlar
 */
import java.util.Scanner;
public class Main {
    
    private int isPrimeNumber;
    
    public void isPrimeNumber(){
       // Asal kontrolü sağlamak istediğiniz değeri sizden ister
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the number you are curious about: ");
       int value = scanner.nextInt();
       int count = 0; 
       // Asal koşullarını kontrol eder
       for(int i = 2; i < value ; i++){
           if(value == 2){
               System.out.println("is a prime");
               break;
           }else if (value % i == 0){
               count++;  
           }
       }
       // Çıktı
       if(count == 0){
             System.out.println("is a prime");
         }else{
             System.out.println("is a not prime");}
   }
    
    
    
    public static void main(String[] args) {
        Main testMain = new Main();
        
        testMain.isPrimeNumber();
    }
}

