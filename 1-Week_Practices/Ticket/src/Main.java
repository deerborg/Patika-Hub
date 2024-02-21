/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Defined variables
        double km,kmPerPrice, totalPrice,discount;
        int age, aWay;
        
        Scanner userValue = new Scanner(System.in);
        kmPerPrice = 0.10;
        // Incorrect information check
        while(true){
            System.out.println("Please write the distance you will travel in km: ");
            km = userValue.nextDouble();
            if(km < 0){
                System.out.println("You entered an incorrect value.");
                System.out.println("Try again");
                continue;
            }break;
        }while(true){
            System.out.println("Please enter your age: ");
            age = userValue.nextInt();
            if(age <= 0){
                System.out.println("You entered an incorrect value.");
                System.out.println("Try again");
              continue;
            }break;
        }while(true){
            System.out.println("If your ticket is one-way (1). Enter round trip (2).");
            aWay = userValue.nextInt();
            if(aWay > 2 || aWay <= 0){
                System.out.println("You entered an incorrect value.");
                System.out.println("Try again");
                continue;
            }break;
        }
        // Applying discounts to received values
        if(age < 12 && aWay == 2){
            totalPrice = kmPerPrice*km;
            discount = (totalPrice - ((totalPrice * 0.5)) - (totalPrice * 0.2));
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km + " km");
            System.out.println("Total price: " + discount+ " $");
        }
        else if(age < 12 && aWay == 1){
            totalPrice = kmPerPrice*km;
            discount = totalPrice - (totalPrice * 0.5);
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km+ " km");
            System.out.println("Total price: " + discount+ " $");
        }
        else if(age >= 12 && age < 24  && aWay == 2){
            totalPrice = kmPerPrice*km;
            discount = (totalPrice - (totalPrice * 0.1)) - (totalPrice * 0.2);
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km+ " km");
            System.out.println("Total price:" + discount+ " $");
        }
        else if(age >= 12 && age < 24 && aWay == 1){
            totalPrice = kmPerPrice*km;
            discount = (totalPrice - (totalPrice * 0.1));
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km+ " km");
            System.out.println("Total price:" + discount+ " $");
        }
        else if(age > 65 && aWay == 2){
            totalPrice = kmPerPrice*km;
            discount = (totalPrice - (totalPrice * 0.3)) - (totalPrice * 0.2);
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km+ " km");
            System.out.println("Total price:" + discount+ " $");
        }
        else if(age > 65 && aWay == 1){
            totalPrice = kmPerPrice*km;
            discount = (totalPrice - (totalPrice * 0.3)) - (totalPrice * 0.2);
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km+ " km");
            System.out.println("Total price:" + discount+ " $");
        }
        else if(age > 24 && age < 65 && aWay == 2){
            totalPrice = kmPerPrice*km;
            discount = totalPrice - (totalPrice * 0.2);
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km+ " km");
            System.out.println("Total price:" + discount + " $");
        }
        else{
            totalPrice = kmPerPrice*km;
            System.out.println("Ticket");
            System.out.println("-------------------------------------");
            System.out.println("Distance: " + km + " km");
            System.out.println("Total price:" + totalPrice + " $");
        }
        // End program

    }
}
