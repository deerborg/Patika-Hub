/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 * @code .bracket() : Ayraç
 *       .coinFlip() : %50 olasılık ile başlayacak ismi belirler
 *       .fighterInformation() : Constructor içinde belirlenen bilgileri çıktı olarak verir
 *       .fight() : Rastgele hasarlar ile maçı başlatır
 */
import java.util.Random;
import java.util.Scanner;
public class Match {
    
    private int fighterOneHit; 
    private int fighterTwoHit;
    private String fighterOneName;
    private String fighterTwoName;
    private int fighterOneHealth; 
    private int fighterTwoHealth;
    private int firstPunch;
    
    // Constructor
    public Match(String fighterOneName, String fighterTwoName){
        Random random = new Random();
        this.fighterOneName = fighterOneName;
        this.fighterTwoName = fighterTwoName;
        this.fighterOneHealth = random.nextInt(100,151);
        this.fighterTwoHealth = random.nextInt(100,151);
    }
    
    // Karışıklığı engellemek amaçlı ayraç
    public void bracket(){
        System.out.println("--------------------------------------");
    }
    // İlk başlayacak ismi random belirler (%50 olasılık)
    public void coinFlip(){
        Random random = new Random();
        while(true){
            System.out.println("Coin toss....");
            this.firstPunch = random.nextInt(1,3);
            
            if(firstPunch == 1){
                System.out.println("Coin flip result: HEADSSS!!");
                System.out.println("First Puuuncchh " + fighterOneName);
                break;
            }
            else if(firstPunch == 2){
                System.out.println("Coin flip: TAILSSS!!!");
                System.out.println("First Puuuncch " + fighterTwoName);
                break;
            }
            else{
                System.out.println("Came a upright");
                continue;
            }
        }  
    }
    // Constructor belirlenen bilgileri verir
    public void fighterInformation(){
        bracket();
        
        System.out.println("FIRST FIGHTER");
        System.out.println("Name: " + fighterOneName);
        System.out.println("Durability: " + fighterOneHealth);
        bracket();
        
        System.out.println("SECOND FIGHTER");
        System.out.println("Name: " + fighterTwoName);
        System.out.println("Durabilty: " + fighterTwoHealth);
        bracket();
    }
    // Random hasarlar ile fight başlatır, sonuç koşullara göre sağlanır
    public void fight(){
        Random random = new Random();
        System.out.println("Welcome to the MATCH!!");
        bracket();
        System.out.println("We ask first for 'TAILL or HEAADSS!!' ");
        System.out.println("Now say! What your choice!!!");
        coinFlip();
        bracket();
        
        while (true) {            
            if(firstPunch == 1){
                System.out.println(fighterOneName + " attacked!! woooww");
                // Maçı başlatan döngü
                bracket();
                fighterOneHit = random.nextInt(30,40);
                fighterTwoHealth -= fighterOneHit;
                System.out.println("So hard punch " + fighterOneName + " Damage: " + fighterOneHit + "  Health " + fighterTwoHealth);
                bracket();
                
                fighterTwoHit = random.nextInt(30,40);
                fighterOneHealth -= fighterTwoHit;
                System.out.println("Very good " + fighterOneName + " Damage: " + fighterTwoHit + " Health " + fighterOneHealth);
                bracket();
                
                if(fighterOneHealth > 0 || fighterTwoHealth > 0){
                    continue;
                }
                // Sağlık koşullarına göre kazanan belirleme
                else if(fighterOneHealth > fighterTwoHealth){
                    System.out.println("NEW CHAMPIIONN " + fighterOneName);
                    bracket();
                    break;
                }
                else if(fighterOneHealth < fighterTwoHealth){
                    System.out.println("NEW CHAMPIIONN " + fighterTwoName);
                    bracket();
                    break;
                }
                else if(fighterTwoHealth == fighterOneHealth){
                    System.out.println("Boring match! SCORLESS!!");
                    bracket();
                    break;
                }
                else{
                    continue;
                }
            }
            if(firstPunch == 2){
                System.out.println(fighterOneName + " attacked!! woooww");
                // Maçı başlatan döngü
                bracket();
                
                fighterOneHit = random.nextInt(30,40);
                fighterTwoHealth -= fighterOneHit;
                System.out.println("So hard punch " + fighterOneName + " Damage: " + fighterOneHit + "  Health " + fighterTwoHealth);
                bracket();
                
                fighterTwoHit = random.nextInt(30,40);
                fighterOneHealth -= fighterTwoHit;
                System.out.println("Very good " + fighterOneName + " Damage: " + fighterTwoHit + " Health " + fighterOneHealth);
                bracket();
                
                if(fighterOneHealth > 0 || fighterTwoHealth > 0){
                    continue;
                }
                // Sağlık koşullarına göre kazanan belirleme
                else if(fighterOneHealth > fighterTwoHealth){
                    System.out.println("NEW CHAMPIIONN " + fighterOneName);
                    bracket();
                    break;
                }
                else if(fighterOneHealth < fighterTwoHealth){
                    System.out.println("NEW CHAMPIIONN " + fighterTwoName);
                    bracket();
                    break;
                }
                else if(fighterTwoHealth == fighterOneHealth){
                    System.out.println("Boring match! SCORLESS!!");
                    bracket();
                    break;
                }
                else{
                    continue;
                }
            }
        }
        
    }
    
 
}

