package daten;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Klasse, mit der sich die einzelnen Zellen im Table manipulieren lassen.
 * 
 * @author Christian Lindenberg
 */
public class CellRenderer extends DefaultTableCellRenderer {

    /**
     * SerialID.
     */
    private static final long serialVersionUID = 2573882632121593201L;

    /**
     * Ein neues Icon, was die Markierung nette TUtoren ausdruecken soll.
     */
    private ImageIcon imgNetteTutoren;

    /**
     * Ein neues Icon, was die Markierung Termin erfolgreich erledigt
     * ausdruecken soll.
     */
    private ImageIcon imgTerminErfolgreich;

    /**
     * Ein Icon, was die Markierung Termin erledigt ausdruecken soll.
     */

    private ImageIcon imgTerminErledigt;

    /**
     * Ein Icon, was die Markierung hohe Prioritaet ausdruecken soll.
     */
    private ImageIcon imgTerminHohePrio;

    /**
     * Ein Icon, was die Markierung schwieriger Termin ausdruecken soll.
     */
    private ImageIcon imgTerminSchwierig;

    /**
     * Methode, welche die Icons den entsprechenden Bildern zuweist.
     */
    private void ladenIcons() {

        imgNetteTutoren = new ImageIcon(
            CellRenderer.class.getResource("/Bilder/netteTutoren.png"));
        imgTerminErfolgreich = new ImageIcon(
            CellRenderer.class.getResource("/Bilder/TerminErfolgreich.png"));
        imgTerminErledigt = new ImageIcon(
            CellRenderer.class.getResource("/Bilder/TerminErledigt.png"));
        imgTerminHohePrio = new ImageIcon(
            CellRenderer.class.getResource("/Bilder/TerminHohePrio"));
        imgTerminSchwierig = new ImageIcon(
            CellRenderer.class.getResource("/Bilder/TerminSchwierig.png"));
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);
    
    
        if (value instanceof Aufgabe) {
            Aufgabe aufgabe = (Aufgabe) value;
            setBackground(Color.CYAN);
        } else if (value instanceof Pruefung) {
            Pruefung pruefung = (Pruefung) value;
            setBackground(Color.YELLOW);
        } else if (value instanceof Veranstaltung) {
            Veranstaltung veranstaltung = (Veranstaltung) value;
            setBackground(Color.ORANGE);
        }
        return this;
    }

}


