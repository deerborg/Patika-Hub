/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 * @code .bracket() : Ayraç
 *       .coinFlip() : %50 olasılık ile başlayacak ismi belirler
 *       .fighterInformation() : Constructor içinde belirlenen bilgileri çıktı olarak verir
 *       .fight() : Rastgele hasarlar ile maçı başlatır
 */
import java.util.Random;
public class Main {
    public static void main(String[] args) {
       Match match = new Match("Furkan", "Eren");
       
       // Kullanılabilir metotlar
       match.fighterInformation();
       match.coinFlip();
       match.fight();
        
    }
}
