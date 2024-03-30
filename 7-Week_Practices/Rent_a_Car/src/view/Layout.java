package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public  class Layout extends JFrame {
    public Layout(){
    }
    public void pageArt(int width,int height,String title){
        setVisible(true);
        setSize(width,height);
        setTitle(title);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().width) / 2;

        setLocation(x,y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTable(DefaultTableModel model, JTable table, Object[] column, ArrayList<Object[]> rows){
        model = (DefaultTableModel) table.getModel(); // Tablonun içeriği
        model.setColumnIdentifiers(column); // Tablonun başlıkları
        table.getTableHeader().setReorderingAllowed(false); // Tablo başlıkları boyutunu değiştirme engelleme

        model.setRowCount(0); // Tablo içeriğini sıfırlama

        if(rows == null){
            rows = new ArrayList<>(); // Datadaki veri varsa
        }

        for(Object[] i : rows){ // DAtadaki verileri ekleme
            model.addRow(i);
        }
    }
    // Seçilen rowu getirir
    public int getSelectedRow(JTable table, int column){
        int selectId = (int) table.getValueAt(table.getSelectedRow(),column); // id seçimi
        return selectId;
    }

    // Mouse seçim işlemleri
    public void tableMouseSelect(JTable table){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectrow = table.rowAtPoint(e.getPoint()); // seçilen kordinatı int degere atadik, gelen deger sütun degeridir. 0 dan baslar. ilk sutun degeri 0 dır
                table.setRowSelectionInterval(selectrow,selectrow); // kordinat aralıgını secilen atadigimiz int degeri ile int degeri arasinda verdik.
            }
        });
    }
}
