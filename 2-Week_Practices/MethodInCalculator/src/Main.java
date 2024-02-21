/**
 * @author Furkan Aydemir , deerborg
 * @since 2024
 * 
 * @code    .addition() : alınan değerleri toplar
            .subtraction() : alınan değerleri çıkarır
            .multiplication() : alınan değerleri çarpar
            .division() : koşulları sağlarsa alınan değerleri böler
            .mod() : alınan değerin kalanını verir
            .exponen() : alınan ilk değeri ana sayı, ikinci değeri üstsel ifade olarak alır ve işler
            .factoriel() : alınan tek değeri faktöriyel olarak çarpıp sonuç verir
            .areaAndPerimeter() : alınan değerleri formüle denkleyerek alan ve çevre sonucu verir
 */
import java.util.Scanner;
public class Main {
    
    private double firstValue;
    private double secondValue;
    private double result;
    
    // İki değer alınacağı zaman çağıralacak metot. Bu metodu diğer metotlar içinde çağırıp kullanmak için oluşturduk.
    public void takeNumber(){
        Scanner value = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        firstValue = value.nextDouble();
        System.out.println("Enter number 2: ");
        secondValue = value.nextDouble(); 
    }
    // Tek değer alınacağı zaman çağıralacak metot. Bu metot sadece faktöriyel hesap yaparken çağırılacak.
    public void oneValue(){
        Scanner value = new Scanner(System.in);
        System.out.println("Enter number: ");
        firstValue = value.nextDouble(); 
    }
    // Toplama işlemi için çağırılan metot
    public void addition(){
        takeNumber();
        result = firstValue + secondValue;
        System.out.println("Result: " + result); 
    }
    // Çıkarma işlemi için çağırılan metot
    public void subtraction(){
        takeNumber();
        result = firstValue - secondValue;
        System.out.println("Result: " + result);
    }
    // Çarpma işlemi için çağırılan metot
    public void multiplication(){
        takeNumber();
        result = firstValue * secondValue;
        System.out.println("Result: " + result);
    }
    // Bölme işlemi için çağırılan metot
    public void division(){
        while(true){
            takeNumber();
            if(firstValue == 0 || secondValue == 0){
                System.out.println("error");continue;
            }
            result = firstValue / secondValue;
            System.out.println("Result: " + result);
            break;
        }
    }
   // Kalan sonucu görmek için çağırılan metot
    public void mod(){
        takeNumber();
        result = firstValue % secondValue;
        System.out.println("Result: " + result);
    }
    // Üstlü ifade için çağırılan metot
    public void exponen(){
        int exop = 1;
        takeNumber();
        while(true){
            for(int i = 0; i < secondValue; i++){
                exop*=firstValue;
                result = exop;
            }System.out.println("Result: " + exop);
            break;
        }
    }
    // Faktöriyel için çağırılan metot. Bu blok içerisinde oneValue() metodunu da çağırdık.
    public void factoriel(){
        double fac, sub = 1;
        oneValue();
        if(firstValue < 0){
            firstValue = firstValue * -1;
        }
        for(int i = 1; i < firstValue; i++){
            fac = (firstValue - i);
            sub*= fac + 1;  
        }
        System.out.println("Result: " + sub);
    }
    // Alan ve çevre işlemi için çağırılan metot
    public void areaAndPerimeter(){
        while(true){
        takeNumber();
        if(firstValue <= 0 || secondValue <= 0){
           System.out.println("Length value cannot be less than 0");
           continue;
        }
        result = firstValue * secondValue;
        System.out.println("Area: " + result);
        System.out.println("------------------");
        result = firstValue*2 + secondValue*2;
        System.out.println("Perimeter: " + result);
        break;
        }
    }

    public static void main(String[] args) {
        Scanner touch = new Scanner(System.in);
        int select;
       // Metodu kullanabilmek için önce Main class'ını çağırıyoruz.
       Main testerMain = new Main();
       
       String menu = "1 - Addition\n2 - Extraction\n3 - Multiplication\n4 - Division\n5 - Exponen cal.\n6 - Factoriel\n7 - Mod\n8 - Area\n0 - Exit\n";

        while (true) {
            System.out.print(menu);
            System.out.print("Select choice:  ");
            select = touch.nextInt();

            if (select == 0) {
                System.out.println("Exit");
                break;
            }
            else if (select < 0 || select > 8) {
                System.out.println("Error");
            }
            else if (select == 6) {
                testerMain.factoriel();
            }
            else {
                switch (select) {
                    case 1:
                        testerMain.addition();
                        break;
                    case 2:
                        testerMain.subtraction();
                        break;
                    case 3:
                        testerMain.multiplication();
                        break;
                    case 4:
                        testerMain.division();
                        break;
                    case 5:
                        testerMain.exponen();
                        break;
                    case 7:
                        testerMain.mod();
                        break;
                    case 8:
                        testerMain.areaAndPerimeter();
                        break;
                }
            }
        }
       
        
    }
}
