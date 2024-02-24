import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int baseValue,lowValue,count = 1;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Taban deger giriniz: ");
        baseValue = scanner.nextInt();
        
        System.out.println("Ust deger giriniz: ");
        lowValue = scanner.nextInt();
        
        
        
        for(int loop = 0; loop < lowValue; loop++){
            count *= baseValue; 
        }
        System.out.println(count);
    }         
}
       

