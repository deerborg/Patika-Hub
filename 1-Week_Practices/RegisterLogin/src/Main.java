import java.util.Scanner;

/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */

public class Main {
    
    /* Information */
    /* 1- Sizden isim, id no şifre ve güvenlik sorusu cevabı bilgisi ister. Verilen bilgileri kaydeder. İsim bilgisi sadece hitap amaçlı kullanır.
       2- Tekrar giriş yapmanız için sizi yönlendirir. 37. satır. Id no ve şifre bilgisi.
       3- Bilgileri doğru girerseniz sizi menü işlemlerine yönlendirir. 68. satır, hatalı girişlerde tekrar giriş yapmanınızı ister.
       4- Program amacı üzerine olan menü işlemleri 3. seçenektir. 
       5- Şifreyi değiştirmek için sizden başta aldığı güvenlik sorusu yanıtını bekler, hatalı girişte programı sonlandırır. Doğru yanıttlarda ise yeni şifre giridisi ister.
       6- 4. seçenek programı sonlandırır, 1 ve 2 ise koşullar sağlandığı sürece basit işlemler yapmanızı sağlar (Bakiye ekle çıkar).
       7- Program https://github.com/deerborg/OOP-BankAccount/blob/master/src/Account.java üzerinden yazdığım metodun sadece login ve menü işlemleri kısmıdır. 
            
            Furkan Aydemir, 2024p
    */
    
    
    
    public static void main(String[] args) {
        String fullName,securityQuestion;
        long password,IdNo;
          
        Scanner fullNameScanner = new Scanner(System.in);
        System.out.println("Welcome the XXX Bank. \n Please create an account, enter ur name and surname");
        fullName = fullNameScanner.nextLine();
        
        Scanner IdScanner = new Scanner(System.in);
        System.out.println("Enter ur ID no");
        IdNo = IdScanner.nextLong();
         
        Scanner passwordScanner = new Scanner(System.in);
        System.out.println("Please create an password");
        password = passwordScanner.nextInt();
        
        Scanner securityQuestionScanner = new Scanner(System.in);
        System.out.println("This is a security question. Please enter your favorite color information. For example, black.");
        securityQuestion = securityQuestionScanner.nextLine();
        
        System.out.println("---------Please Wait----------");
        System.out.println("Account information has been successfully saved. I'm directing you to the login page.");
        System.out.println("---------Please Wait----------");
        
        // Login panel
        while(true){
            
            // It compares the IdNo and password information received from the user with the entered value.
            System.out.println("Welcome to XXX Bank. Please enter your ID and password.");
            Scanner checkId = new Scanner(System.in);
            double checkIdNo = checkId.nextDouble();
            if(checkIdNo != IdNo){
                System.out.println("!!!********************!!!");
                System.out.println("ID number is wrong, try again.");
                System.out.println("!!!********************!!!");
                continue;
            }if (checkIdNo == IdNo){
                System.out.println("Hello," + fullName + " enter your password.");
            }
            Scanner checkPass = new Scanner(System.in);
            int checkPassNo = checkPass.nextInt();
            if(checkPassNo != password){
                System.out.println("!!!********************!!!");
                System.out.println("Incorrect password, try again.");
                System.out.println("!!!********************!!!");
                continue;
            }
            if(checkPassNo == password){
                System.out.println("Welcome " + fullName + " I direct you to the transaction menu.");
                System.out.println("---------Please Wait----------");
                
            } // End login
            
            
            
            // Selection menu
            while(true){
            int selector = 0, balance = 0;
            System.out.println("Please select the option you want to perform. For example, 2 .");
            System.out.println("--------------------------------------");
            System.out.println("1 - Deposit \n 2 - Withdraw \n 3 - Change password \n 4 - Exit");
            Scanner selecScanner = new Scanner(System.in);
            selector = selecScanner.nextInt();
            
            // It provides routing between transactions according to the transaction received from the user.
                if(selector == 1){
                    Scanner balanceScanner = new Scanner(System.in);
                    System.out.println("Enter the amount you want to deposit.");
                    double newBalance = balanceScanner.nextDouble();
                    balance += newBalance;
                    System.out.println("The deposit was successful, thank you. Your balance: " + "\n"+balance);
                    System.out.println("---------Please Wait----------");
                    System.out.println("You are directed to the menu....");
                    System.out.println("--------------------------------------");
                    if(newBalance <= 0){
                        System.out.println("!!!********************!!!");
                        System.out.println("Please enter a valid amount.");
                        System.out.println("!!!********************!!!");
                        continue;
                } 
            }
                else if(selector == 2){
                    
                    // Makes changes to the initially created balance variable.
                    if(balance == 0){
                        System.out.println("!!!********************!!!");
                        System.out.println("You cannot perform this transaction because you do not have any amount in your account.");
                        System.out.println("!!!********************!!!");
                        System.out.println("You are directed to the menu....");
                        System.out.println("---------Please Wait----------");
                        continue;
                    }
                    System.out.println("Enter the amount you want to withdraw. Total balance: " +"\n"+ balance);
                    Scanner reBalanceScanner = new Scanner(System.in);
                    double removeBalance = reBalanceScanner.nextDouble();
                    if(removeBalance > balance){
                        System.out.println("There is not enough balance in your account. Your total balance: " + balance);
                        continue;
                    }
                    balance -= removeBalance;
                    System.out.println("The withdraw was successful, thank you. Your balance: " +"\n"+ balance);
                    System.out.println("---------Please Wait----------");
                    System.out.println("You are directed to the menu....");
                    System.out.println("--------------------------------------");
                    
                }
                else if (selector == 3){
                    
                    // It compares with the securityQuestion variable received from the user during registration.
                    System.out.println("Please enter your security question answer: ");
                    Scanner secScanner = new Scanner(System.in);
                    String checkSecurty = secScanner.nextLine();
                    if(checkSecurty.equals(securityQuestion)){
                        System.out.println("Please enter your new password.");
                        Scanner newPassScanner = new Scanner(System.in);
                        password = newPassScanner.nextInt();
                        System.out.println("Your password has been changed.");
                        System.out.println("---------Please Wait----------");
                        System.out.println("--------------------------------------");
                    }
                    else{
                        System.out.println("The answer is incorrect, try again.");
                        System.out.println("The session is closed for security reasons.");
                        break;
                    }
                }
                    
                    else if(selector == 4){
                    System.out.println("Exiting safely. Thank you for choosing us.");
                    System.out.println("--------------------------------------");
                    break;// End program.
                }
        }break;
    }
        }
    }
