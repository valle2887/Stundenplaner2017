package daten;

import java.util.ArrayList;

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

        // TODO Kollisionstest?!
        for (Aufgabe termin2 : termine) {

            if (termin2.getBezeichnung().equals(termin.getBezeichnung())) {
                kollision = true;
            }
        }
        if (!kollision) {
            this.termine.add(termin);
        }

        return !kollision;
    }

}
