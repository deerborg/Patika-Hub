package core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    // Tema secimi
    public static void setTheme(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if(info.getName().equals("Nimbus")){
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
    }

    // Fielderin bos olma durumları, bos ise true doner
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }
    // Mesaj kutusu
    public static void msg(String str){

        String msg;
        String title = switch (str) {
            case "fill" -> {
                msg = "Field not null";
                yield "Error";
            }
            case "done" -> {
                msg = "Saved";
                yield "Information";
            }
            default -> {
                msg = str;
                yield "Information";
            }
        };

        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }


}
