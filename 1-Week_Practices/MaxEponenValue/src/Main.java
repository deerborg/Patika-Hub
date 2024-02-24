import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Max deger giriniz: ");
        int a = s.nextInt();
        System.out.println("Taban ifade giriniz");
        int c = s.nextInt();
        
        for(int i = 1; i < a; i*=c){
            System.out.println(i);
        } 
    }         
}

/* 
Problem bu konuda, kullanıcının verdiği değeri taban olarak alıp, tabanın kuvvetleri Max değere en yakın
değerine gelene kadar döndürecektir.

Girilen değeri 100 olarak alalım.
For içinde olan koşul, i değeri 100' den küçük olacaktır.
Taban değerini 4 alalım
For içinde koşul sağlanmazsa i = i * 4 olarak artıralım

Döngü
1- i = 1    (i nin değeri 1, ilk önce 1 değerini yansıtacak)
2- i = 4    (i değeri Max değerden küçük, o yüzden taban değer olan 4 ile çarpılacak, 1 x 4 = 4
3- i = 16   (4 x 4 = 16, bir önceki döngü i 4 değerine dönmüştü ve kaydetti. Tekrardan 4 ile çarpıldı yeni sonuç i için 16.
4- i = 64   (16 x 4 = 64, değer 100 yaklaştı ama hala 100 den küçük, tekrar loopa girip 4 ile çarptığı takdirde sonuç 256 olacak ve for tamamlanmış olacak. 
            ! - sonuç 64 çıkar, 5. kez loopa girmez ve bu yüzden en son yazdığı değer olan 64 değerini çıktı olarak verir.
*/

