package bussines;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;

public class UserManager {
    private UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }

    public ArrayList<User> findByAll(){
        return userDao.findByAll();
    }
    public User findByLogin(String username,String password){
        return userDao.findByLogin(username,password);
    }

}
