import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       System.out.println("Faktoriyelini alacaginiz sayiyi giriniz :");
       int facValue = scanner.nextInt();
       int calculation = 1;
       for(int loop = 1 ; loop < facValue ; loop ++){
           calculation = loop * calculation;
       }
        System.out.println(facValue*calculation);
    }         
}
       
// 1-  loop 1 için döngü 1x1 = 1 = calc
// 2 - loop 2 için döngü 2x1 = 2 = calc
// 3 - loop 3 için döngü 3x2 = 6 = calc
// 4 - loop 4 için döngü 4x6 = 24 = calc
// 5 - loop 5 için döngü 5x24 = 120 = calc

//....... facValue değerine kadar bu devam eder. 
// En sonunda çıkacak değer aslında, girilen değerin bir eksiğinin faktöriyeli olacaktır
