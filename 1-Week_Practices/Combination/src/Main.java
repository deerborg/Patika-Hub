import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       System.out.println("n degerini giriniz :");
       int oneFacValue = scanner.nextInt();
       System.out.println("r degerini giriniz: ");
       int twoFacValue = scanner.nextInt();
       int calculationForN = 1,calculationForR = 1,facResultForN,facResultForR,combinasion;
       
       
       for(int loopForN = 1; loopForN < oneFacValue; loopForN++){
           calculationForN*=loopForN;
       }
       for(int loopForR = 1; loopForR < twoFacValue; loopForR++){
           calculationForR*=loopForR;
       }
        
        
        facResultForN = calculationForN * oneFacValue;
        facResultForR = calculationForR * twoFacValue;
        combinasion = facResultForN / (facResultForR * (oneFacValue - twoFacValue));
        System.out.println(combinasion);
    }         
}
       

