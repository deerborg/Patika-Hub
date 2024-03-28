package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
        setResizable(true);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;

        setLocation(x,y);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public int getTableSelectedRow(JTable table,int index){
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(),index).toString());
    }
    public void tableSelectedRow(JTable table){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(selectedRow,selectedRow);
                table.setEnabled(true);
            }
        });
    }
}
