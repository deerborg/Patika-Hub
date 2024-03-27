package view;

import bussines.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginView extends Desigin{
    private JPanel main;
    private JPanel m_top;
    private JLabel lbl_title;
    private JLabel lbl_title2;
    private JPanel m_bottom;
    private JTextField fld_name;
    private JPasswordField fld_pass;
    private JButton btn_login;
    private UserManager userManager;

    public LoginView(){


        userManager = new UserManager();
        add(main);
        guiArt(500,500,"Rent a Car");
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(fld_name.getText().equals("") && fld_pass.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Not Null");
                }
                else if(fld_name.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Not Null User Name ");
                }
                else if(fld_pass.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Not Null Password");
                }else {
                    User admin = userManager.findByLogin(fld_name.getText(),fld_pass.getText());
                    if(admin == null){
                        JOptionPane.showMessageDialog(null,"Worng Information");
                    } else if (!admin.getUser_name().equals(fld_name.getText())) {
                        JOptionPane.showMessageDialog(null,"Wrong User Name");
                    }
                    else if (!admin.getUser_pass().equals(fld_pass.getText())) {
                        JOptionPane.showMessageDialog(null,"Wrong Password");
                    }
                    else {
                        AdminView view = new AdminView(admin);
                        dispose();
                        System.out.println("loggin succses");

                    }
                }
            }
        });
    }


}
