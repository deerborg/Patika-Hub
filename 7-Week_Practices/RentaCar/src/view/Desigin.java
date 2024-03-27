package view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Desigin extends JFrame {
    public Desigin(){


    }
    public void guiArt(int width,int height,String title){

        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if(Objects.equals(info.getName(), "Nimbus")){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        setTitle(title);
        setSize(width,height);
        setVisible(true);
        setResizable(false);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;

        setLocation(x,y);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
