import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      System.out.print("Dizinin boyutu  : ");
        Scanner scanner = new Scanner(System.in);
        int diziBoyutu = scanner.nextInt();

        int[] dizi = new int[diziBoyutu];
        int[] dizi2 = new int[diziBoyutu];

        for (int i = 0; i < dizi.length; i++) {
            System.out.print((i + 1) + "- Elemani giriniz : ");
            dizi[i] = scanner.nextInt();
        }
        Arrays.sort(dizi);
        System.out.println("Dizi  : " + Arrays.toString(dizi));

        int tekrar = 0;
        for (int r : dizi) {
            int say = 0;
            for (int j = 0; j < dizi.length; j++) {
                if (r == dizi2[j]) {
                    say++;
                }
            }
            if (say == 0) {
                int say2 = 0;
                for (int i : dizi) {
                    if (r == i) {
                        say2++;
                    }
                }
                dizi2[tekrar] = r;
                tekrar++;
                System.out.println(r + " sayisindan " + say2 + " tane var ");
            }
        }
    }
}             
        
    
            