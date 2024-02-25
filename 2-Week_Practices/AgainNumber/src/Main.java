import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       int ekle = 1;
       int say = 0;
       int tekrar = 0;
       Scanner scanner = new Scanner(System.in);
       System.out.print("Dizi boyutunu girin: ");
       int diziBoyutu = scanner.nextInt();
       int[] dizi = new int[diziBoyutu];

       // dizi olusturma
       for(int i = 0 ; i < dizi.length ; i++){
           System.out.print(ekle + ". elemani giriniz: ");
           dizi[i] = scanner.nextInt();
           ekle++;
       }
       // dizi ciktisi
        System.out.print("Olusturulan yeni dizi =====> ");
        
       for(int i = 0; i < dizi.length; i++){
           System.out.print(dizi[i] + " ");
       }
       // tekrari sayan dongu
       for(int i = 0 ; i < dizi.length; i++){
           for(int j = 0; j < dizi.length; j++){
               if(dizi[i] == dizi[j]){
                   say++;
                   break;
               }
               else{
                   say = 0;
                   say++;
                   break;
               }
           }
           System.out.println("");
           
           System.out.println(dizi[i] + " sayisi " + say +" kere tekrar etti");
       }
    }
}             
        
    
            