package daten;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CellRenderer extends DefaultTableCellRenderer {

    private ImageIcon imgNetteTutoren;
    
    private ImageIcon imgTerminErfolgreich;
    
    private ImageIcon imgTerminErledigt;
    
    private ImageIcon imgTerminHohePrio;
    
    private ImageIcon imgTerminSchwierig;
    
    
    private void ladenBilder() {
        imgNetteTutoren = new ImageIcon(CellRenderer.class.getResource(
            "/Bilder/netteTutoren.png"));
        imgTerminErfolgreich = new ImageIcon(CellRenderer.class.getResource(
            "/Bilder/TerminErfolgreich.png"));
        imgTerminErledigt = new ImageIcon(CellRenderer.class.getResource(
            "/Bilder/TerminErledigt.png"));
        imgTerminHohePrio = new ImageIcon(CellRenderer.class.getResource(
            "/Bilder/TerminHohePrio"));
        imgTerminSchwierig = new ImageIcon(CellRenderer.class.getResource(
            "/Bilder/TerminSchwierig.png"));
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, 
        Object value, boolean isSelected, boolean hasFocus, int row, int col) {
     
        super.getTableCellRendererComponent(table, value, isSelected,
            hasFocus, row, col);
        if (value instanceof Aufgabe) {
            Aufgabe aufgabe = (Aufgabe) value;
            setBackground(Color.BLUE);
        }
        
        if (value instanceof Pruefung) {
            Pruefung pruefung = (Pruefung) value;
            setBackground(Color.YELLOW);
        }
        
        if (value instanceof Veranstaltung) {
            Veranstaltung veranstaltung = (Veranstaltung) value;
            setBackground(Color.ORANGE);
        }
        
        
        return this;
    }

}
