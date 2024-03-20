/**
 * @author Furkan Aydemir - deerborg
 * @since  2024
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Kullanıcıdan toplanacak rakamların istendiği blok
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/dosya.txt"))){

            Scanner value = new Scanner(System.in);
            int uservalue;
            System.out.println("If u want exit press -1");

            // -1 olma durumuna kadar dosyaya integer eleman ekleme bloğu
            while (true){
                try {
                    uservalue = value.nextInt();
                    if(uservalue == -1){
                        System.out.println("SUCCESS!");
                        break;
                    }
                    writer.write(String.valueOf(uservalue) + "\n");

                }catch (InputMismatchException e){
                    System.out.println("ENTER A INTEGER VALUE");
                    value.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("ERROR but IDONTKNOW");
        }

        // Dosya okuma ve toplam sonuç verme bloğu
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/dosya.txt")))){

            int totalValue = 0;
            // Alınan değerlerin Integer değere çevrilip toplandığı blok
            while (scanner.hasNextLine()){
                String userValueChar = scanner.nextLine();
                totalValue += Integer.parseInt(userValueChar);
            }
            System.out.println("Total : " + totalValue);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
