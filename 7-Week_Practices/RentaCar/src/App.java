import bussines.BrandManager;
import bussines.UserManager;
import core.Database;
import core.Helper;
import view.AdminView;
import view.BrandView;
import view.LoginView;

public class App {

    public static void main(String[] args) {
        Database.getStatus();
        //LoginView l = new LoginView();
        UserManager user  = new UserManager();

        AdminView a = new AdminView(user.findByLogin("admin","1511"));

    }
}
