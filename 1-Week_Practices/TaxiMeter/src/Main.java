import java.util.Scanner;
public class Main {
    
     public static void main(String[] args) {
        // Variables for taxi price programming
        double km, taxiPrice, taxiMeterPrice = 10.0, kmPer = 2.20;

        // User distance information
        Scanner input = new Scanner(System.in);
        System.out.print("Enter KM: ");
        km = input.nextDouble();

        // Calculating taxi price
        taxiPrice = taxiMeterPrice +( km*kmPer);

        // Printing taxi price
        System.out.print(taxiPrice < 20 ? "Taxi price is: 20.0": "Taxi price is: " + taxiPrice + " $ ");
    }
}
