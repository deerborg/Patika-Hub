/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3, balance = 1500, select, price;
        while (right > 0) {
            System.out.print("Kullanıcı Adınız : ");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            if (userName.equals(userName) && password.equals(password)) {
                System.out.println("Welcome to XXX Bank ATM");
                do {
                    System.out.println("1-Withdraw\n" +
                            "2-Deposit\n" +
                            "3-Balance\n" +
                            "4-Exit");
                    System.out.print("Please choice the menu : ");
                    select = input.nextInt();
                    switch (select) {
                        case 1:
                            System.out.print("Value : ");
                            price = input.nextInt();
                            balance += price;
                            break;
                        case 2:
                            System.out.print("Value : ");
                            price = input.nextInt();
                                if (price > balance) {
                                    System.out.println("Insufficient funds");
                                } else {
                                    balance -= price;
                                }
                            break;
                        case 3:
                            System.out.println("Balance : " + balance);
                        break;
                    }
                } while (select != 4);
                System.out.println("See u again.");
                break;
            } else {
                right--;
                System.out.println("Incorrect entry");
                if (right == 0) {
                    System.out.println("Your account has been blocked for security reasons");
                } else {
                    System.out.println("right to try again : " + right);
                }
            }
        }
    }
}
