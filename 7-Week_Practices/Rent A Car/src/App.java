import bussines.UserManager;
import core.Database;
import core.Helper;
import entity.User;
import view.AdminView;
import view.LoginView;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Helper.setTheme();
        Database.connector();
        //LoginView v = new LoginView();
        UserManager u = new UserManager();
        AdminView a = new AdminView(u.findByLogin("admin","1511"));
     }
}
