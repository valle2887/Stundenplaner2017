package daten;

import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import daten.Termin.Markierung;

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
    public Component getTableCellRendererComponent(final JTable table, 
        Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        if (value == null) {
            return new JLabel();
        }
     
        Termin termin = null;
        JLabel lblCell = null;
        if (termin != null) {
            String bez = termin.getBezeichnung();
            lblCell = new JLabel(bez);
        } else {
            lblCell = new JLabel((String) value);
        }
        JPanel panel = new JPanel();
        panel.add(lblCell);
        if (termin != null && termin.getMarkierung() != null) {
            for (Markierung marker : termin.getMarkierung()) {
                switch (marker) {
                case TERMIN_ERLEDIGT:
                    panel.add(new JLabel(imgTerminErledigt));
                    break;
                case TERMIN_ERFOLGREICH:
                    panel.add(new JLabel(imgTerminErfolgreich));
                    break;
                case HOHE_PRIORITAET:
                    panel.add(new JLabel(imgTerminHohePrio));
                    break;
                case NETTE_TUTOREN:
                    panel.add(new JLabel(imgNetteTutoren));
                    break;
                default:
                    break;
          
                }
            }
        }
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
