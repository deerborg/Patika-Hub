package view;

import bussines.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel w_top;
    private JPanel w_bottom;
    private JTextField fld_username;
    private JPasswordField fld_pass;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private UserManager userManager;


    public LoginView(){
        userManager = new UserManager();
        add(container);
        pageArt(500,500,"Login Page");

        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_pass)){
                Helper.msg("fill");
            }else {
               User login = userManager.findByLogin(fld_username.getText(),fld_pass.getText());
               if(login == null){
                   Helper.msg("Not found");
               }else {
                   Helper.msg("Succsess");
                   AdminView a  = new AdminView(login);
                   dispose();
               }
            }
        });
    }
}
