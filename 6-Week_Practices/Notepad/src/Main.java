import java.io.*;
import java.util.Scanner;
class Notes {

    // Not girdi metodu
    public  void takeNote(){
        Scanner notes = new Scanner(System.in);

        // Kullanıcı Q olma durumuna kadar notları dosyaya kaydetme
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/dosya.txt",true))){
            System.out.println("ENTER NOTE" + "If u want quit press q");
            while (true){
                String userNote = notes.nextLine().toUpperCase() + "\n";
                if(userNote.equals("Q" + "\n")){
                    System.out.println("Note save");
                    break;
                }
                writer.write(userNote);
            }
        } catch (IOException e) {
            System.out.println("dosya.txt is open");
        }
    }
    // Not çıktı metodu
    public  void readNote(){

        // Notların Çıktısı
        try(Scanner reader = new Scanner(new BufferedReader(new FileReader("src/dosya.txt")))){
            System.out.println("Your notes: ");
            while (reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("dosya.txt is open");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Notes notes = new Notes();
        notes.takeNote();
        notes.readNote();

    }
}
