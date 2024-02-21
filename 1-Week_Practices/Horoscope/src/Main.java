/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner value = new Scanner(System.in);
        String hobbies,status,fullName;
        int month,day,year;
        System.out.println("Enter your name: ");
        fullName = value.nextLine();

        while(true){
            System.out.println("I was wondering about your zodiac sign, can you write in which year you were born? For example, 1990.");
            year = value.nextInt();
            if(year <= 1900){
                System.out.println("You're really old, were there horoscopes back then? I don't know, I couldn't calculate it.");
                System.out.println("I have to ask you again.");
                continue;
            }break;
        }
        while(true){
            System.out.println("Yes, I save it. Can you write the month you were born now? For example 11.");
            month = value.nextInt();
            if(month > 13 || month <= 0){
                System.out.println("Like the Mayan calendar? You're taking me too seriously. I'm a stupid creator(for the program). The values ​​I need are between 1 and 12. January February March...");
                System.out.println("I have to ask you again.");
                continue;
            }break;
        }
        while(true){
            System.out.println("Hmm, we're getting closer. Can you write the day you were born? For example 21.");
            day = value.nextInt();
            if(day > 30 || day <= 0){
                System.out.println("We were so close. They said that the new operation in CS2 would come on February 33. I was confused at the time.");
                System.out.println("I have to ask you again.");
                continue;
            }break;
        }
        
        System.out.println("I think I know your zodiac sign. I will use this when creating your personal card.");
        System.out.println("There should be information density in this card. Can you write what your hobbies are?");
        Scanner hobbiesValue = new Scanner(System.in);
        hobbies = hobbiesValue.nextLine();
        System.out.println("I'm creating your card... I'm working on it... I think I'm succeeding!");

        String horoscope;
       // Horoscope calculation
       if(month == 3 && day >= 21 || month == 4 && day <= 20){
           horoscope = "Aries";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 4 && day >= 21 || month == 5 && day <= 20){
          horoscope = "Taurus";
          System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 5 && day >= 21 || month == 6 && day <= 20){
           horoscope = "Gemini";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 6 && day >= 21 || month == 7 && day <= 20){ 
           horoscope = "Cancer";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 7 && day >= 21 || month == 8 && day <= 20){ 
           horoscope = "Leo";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 8 && day >= 21 || month == 9 && day <= 20){
           horoscope = "Virgo";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
           
       }
       if(month == 9 && day >= 21 || month == 10 && day <= 20){
           horoscope = "Libra";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 10 && day >= 21 || month == 11 && day <= 20){
           horoscope = "Scorpio";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 11 && day >= 21 || month == 12 && day <= 20){
           horoscope = "Sagittarius";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
           
       }
       if(month == 12 && day >= 21 || month == 1 && day <= 20){
           horoscope = "Capricorn";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 1 && day >= 21 || month == 2 && day <= 20){
           horoscope = "Aquarius";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       if(month == 2 && day >= 21 || month == 3 && day <= 20){
           horoscope = "Pisces";
           System.out.println("----------------------------");
           System.out.println("Your Horoscope: " + horoscope);
           System.out.println("----------------------------");
       }
       // Card printout
        System.out.println("__________________________________________");
        System.out.println("Name and Surname: " + fullName);
        System.out.println("Your Birthday: " + day + "/" + month + "/" + year);
        System.out.println("Your Hobbies: " + hobbies);
       
    }
}
