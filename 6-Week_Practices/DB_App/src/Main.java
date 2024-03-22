public class Main {
    public static void main(String[] args) {

        DB_Connect con = new DB_Connect("SELECT * FROM worker");
        con.connectDB();
        con.printQuery();
        con.writeDB();
        // con.readDB(); // Dosyayı okumak için metodu yorumdan çıkarabilirsiniz
    }
}
