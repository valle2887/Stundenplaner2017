package daten;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import gui.NeuenTerminHinzu;

// TODO: Auto-generated Javadoc
/**
 * Ein Kalender speichert alle Termine eines Benutzers ab.
 * 
 * @author Valerian Tjunnikov
 */
public class Kalender {

    /**
     * ArrayListe der Termine.
     */
    private ArrayList<Aufgabe> termine;

    /**
     * Instantiates a new kalender.
     */
    public Kalender() {

        termine = new ArrayList<Aufgabe>();
    }
    // Kollisionstest

    /**
     * Termin hinzufuegen.
     *
     * @param termin
     *            the termin
     * @return true, if successful
     */
    public boolean terminHinzufuegen(Aufgabe termin) {

        boolean kollision = false;

        ArrayList<String> list = DatenVerwaltung.leseAufgabe(Benutzer.getUserName());
        // TODO Kollisionstest?!
        for (String termin2 : list) {

            if (termin2.getBezeichnung().equals(termin.getBezeichnung()) && 
                (termin2.getDatum())equals(termin.getDatum()))) {
                kollision = true;
                
                new NeuenTerminHinzu();
            }else {
                JOptionPane.showMessageDialog(null,
                    "Es gibt eine Kollision");
            }
        }
        if (!kollision) {
            this.termine.add(termin);
        }

        return !kollision;
    }

}
