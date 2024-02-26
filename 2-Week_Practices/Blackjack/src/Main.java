/**
 * @author Furkan Aydemir, deerborg
 * @since  2024
 */ 



 /* 
 * 
 *                                                          BLACKJACK KURALLARI
 *          |------------------------------------------------------------------------------------------------------------------------------|    *
 *          |    * Toplam kart sayısı ilk turda 21 olduğu zaman 3 katını kazanırınız                                                       |    *
 *          |    * Eğer toplam kart 21 üstü olursa kaybedersiniz                                                                           |    * 
 *          |    * Eğer toplam kartınız kasanın toplam kartından küçükse kaybedersiniz                                                     |    *
 *          |    * Eğer toplam kartınız 21 küçük ve kasanın açtığından büyükse kazanırsınız 2 katını kazanırsınız                          |    *
 *          |    * Eğer kasa toplam kartı, ilk turda 21 olursa ve siz 21 değilseniz kasa kazanır                                           |    *   
 *          |    * Eğer kart çekmek isterseniz 21 den küçük olana kadar çekmenize imkan tanır                                              |    *
 *          |    * Eğer çekilen kartlar toplamı 21 geçerse kaybedersiniz                                                                   |    *  
 *          |    * Kasa en fazla toplam kartı 18 olana kadar çekebilir                                                                     |    *
 *          |    * Kartlar Random sınıfı üzerinden 1 ile 12 arasında rakamlardan rastgele olarak verilir.                                  |    *
 *          |    * Hem kasa hem kullanıcı eşit değerlerde kart toplamına sahipse beraberlik olur, iki tarafta bakiyesine ekleme yapmaz.    |    *
 *          |------------------------------------------------------------------------------------------------------------------------------|    *
 *          |                !! - Beraberlik durumu bu oyun için devredışı.                                                                |    *
 *          |                !! - Bakiye 0 ' dan küçük döngüsü devre dışı. Oyun bitince program sonlanır.                                  |    *
 *          |------------------------------------------------------------------------------------------------------------------------------|    *
 */

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("");
        Random blackJack = new Random();
        Scanner value = new Scanner(System.in);
        // döngü içinde kullanılacak değişkenler
        int balance,startBonus = 100, cardValue, cashierCardFs,cashierCardSc,userCardFs,userCardSc,playOrLeaveGame,totalCardUser,totalCardCashier,userMoreCard,cashierMoreCard,forceQuit = 0,userAddCard = 0,cashierCardAdd = 0;
        System.out.println("balance: ");
        balance = value.nextInt();
        // bonus bakiyeye +100 ekler ve öyle oyuna başlar
        int totalBalance = balance + startBonus;
        System.out.println("Hosgeldin bonusu: " + startBonus);
        // bakiye toplamı 0 altına düşmediği sürece oyun devam eder.
        while(totalBalance > 0){
            System.out.println("kartlar dagitiliyor: ");
            
            userCardFs = blackJack.nextInt(1,12);
            System.out.println("ilk kart: " + userCardFs);
            
            cashierCardFs  = blackJack.nextInt(1,12);
            System.out.println("Kasa ilk kart: " + cashierCardFs);

            cashierCardSc = blackJack.nextInt(1,12);
            System.out.println("Kasa ikinci karti kapali acti ");
            System.out.println("****** kasa karti kontrol ediyor******* kart: " + cashierCardSc);
            totalCardCashier = cashierCardFs + cashierCardSc;
            if(totalCardCashier == 21){
                System.out.println("KASA KAZANDI KAYBETTİNİZ..");
                System.out.println("Oyuna devam etmek icin 1");
                totalBalance -= balance;
                playOrLeaveGame = value.nextInt();
                 if(playOrLeaveGame == 2){
                    System.out.println("Exit");
                    break;
                }
                else if(playOrLeaveGame == 1){
                    System.out.println("Contin.");
                    continue;
                }
            }
            System.out.println("ikinci kart veriliyor");
            userCardSc = blackJack.nextInt(1,12);    
            System.out.println("ikinci kart: " + userCardSc);
            totalCardUser = userCardFs + userCardSc;
            if(totalCardUser == 21){
               System.out.println("BLACKJACK!!!");
               totalBalance = totalBalance*3;
               System.out.println("bakiye: " + totalBalance);
               
                System.out.println("Oyuna devam etmek icin 1");
                playOrLeaveGame = value.nextInt();
                if(playOrLeaveGame == 2){
                    System.out.println("Bakiye: " + totalBalance);
                    System.out.println("Exit");
                    break;
                }
                else if(playOrLeaveGame == 1){
                    
                    continue;
                }
            }
            else if(totalCardUser > 21){
                System.out.println("Toplam acilan kart: " + totalCardUser);
                System.out.println("KAYBETTİNİZ..");
                totalBalance -= balance;
                System.out.println("bakiye: " + totalBalance);
            }
            do {                
                System.out.println("Yeni kart eklemek istiyomusun 1-2");
                playOrLeaveGame = value.nextInt();
                if(playOrLeaveGame == 2){
                    do {                        
                        System.out.println("Kasa kart aciyo");
                        cashierMoreCard = blackJack.nextInt(1,12);
                        System.out.println("Kasa acilan kart " + cashierMoreCard);
                        cashierCardAdd+=cashierMoreCard;
                        totalCardCashier = cashierCardFs + cashierCardSc + cashierCardAdd;
                    } while (totalCardCashier <= 17);
                    if(totalCardCashier > 18){
                        if(totalCardCashier > 21){
                            
                            System.out.println("kasa acilan toplam kart: " + totalCardCashier);
                            System.out.println("kazandiniz toplam kart: " + totalCardUser);
                            System.out.println("bakiye: " + totalBalance);
                            totalBalance+=balance;
                            break;
                        }
                        else if(totalCardCashier > totalCardUser){
                            System.out.println("kasa kazandi kasa kart toplam: " + totalCardCashier);
                            totalBalance -= balance;
                            System.out.println("bakiye: " + totalBalance);
                            forceQuit = 1;
                            break;
                        }
                        else if(totalCardUser > totalCardCashier){
                            System.out.println("kazandin toplam" + totalCardUser);
                            totalBalance = totalBalance * 2;
                            System.out.println("bakiye: " + totalBalance);
                            forceQuit = 1;
                            break;
                        }
                    } 
                }
                System.out.println("kart cekiliyo");
                userMoreCard = blackJack.nextInt(1,12);
                userAddCard+=userMoreCard;
                System.out.println("Cekilen kart: " + userMoreCard);
                totalCardUser = userCardFs + userCardSc + userAddCard;
                System.out.println("Toplam cekilen kartlar: " + totalCardUser);
                if(totalCardUser > 21){
                    System.out.println("toplam skor : " + totalCardUser);
                    System.out.println("kaybettiniz");
                    totalBalance-=balance;
                    System.out.println("bakiye: " + totalBalance);
                    forceQuit = 1;
                }
            } while (forceQuit == 0);
            break;
        }
    }
}
