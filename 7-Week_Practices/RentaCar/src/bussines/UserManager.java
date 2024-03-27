package bussines;

import doa.UserDoa;
import entity.User;

import java.util.ArrayList;

public class UserManager {
    private final UserDoa userDoa;

    public UserManager() {
        this.userDoa =new UserDoa();
    }

    public User findByLogin(String username,String password){
        return userDoa.findByLogin(username,password);
    }
    public ArrayList<User> findAll(){
        return userDoa.findAll();
    }
}
