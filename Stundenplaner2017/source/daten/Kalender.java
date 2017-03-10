package daten;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Ein Kalender speichert alle Termine eines Benutzers ab.
 * 
 * @author Valerian Tjunnikov
 */
public class Kalender {
    /**
     * ArrayListe der Termine.
     */
    private ArrayList<Termin> termine;

    // ------------------------------------------------------------

    /**
     * Legt einen neuen leeren Kalender an.
     */
    public Kalender() {
        termine = new ArrayList<Termin>();
    }

    /**
     * Legt einen neuen Kalender an und fuegt die uebergebenen Termine ein.
     * 
     * @param termine
     *            - Termine, die eingetragen werden sollen
     */
    public Kalender(Termin... termine) {
        // Rufe Standardkonstruktor auf und erstelle leere Liste fuer Termine
        this();
        // Laufe ueber alle Termine, die uebergeben wurden
        for (Termin t : termine) {
            this.termine.add(t);
        }
    }

    /**
     * @param kalenderDatei
     *            es wird ein kalenderDatei übergeben
     */
    public Kalender(File kalenderDatei) {
        // TODO Termine aus Datei laden
    }

    // ------------------------------------------------------------

    /**
     * @return true.
     * @param termin
     *            es wird ein termin übergeben.
     */
    public boolean terminHinzufuegen(Termin termin) {

        boolean kollision = false;

        // TODO Kollisionstest?!

        for (Termin termin2 : termine) {
            if (termin2.getBezeichnung().equals(termin.getBezeichnung())) {
                kollision = true;
            }
        }
        if (!kollision) {
            this.termine.add(termin);
        }

        return !kollision;

    }

    /**
     * @return true.
     * @param termin
     *            es wird ein termin übergeben.
     */
    public boolean terminLoeschen(Termin termin) {
        boolean geloescht = false;
        while (this.termine.remove(termin)) {
            geloescht = true;
        }
        return geloescht;
    }

    // ------------------------------------------------------------

    /**
     * @return toString.
     */
    public String toString() {
        String s = "";
        for (Termin t : this.termine) {
            s += t.toString() + "\n";
        }
        return s;
    }
}
