package daten;

import java.util.ArrayList;

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

    /**
     * konstruktor.
     */
    public Kalender() {
        termine = new ArrayList<Termin>();
    }

    // public boolean kollidiertTermin(Termin termine) {
    // boolean kollision = false;
    // for(Termin t : termine) {
    // if () {
    //
    // }
    // }
    //
    // return kollision;
    // }

    /**
     * @param termin
     *            die termine werden hinzugefügt
     */
    public void terminHinzufuegen(Termin termin) {
        termine.add(termin);
    }

    /**
     * @param termin
     *            termine soll gelöscht werden
     */
    public void terminLoeschen(Termin termin) {
        termine.remove(termin);
    }

    /**
     * @param termin
     *            es wird ein termin gesetzt
     */
    public void setTermine(ArrayList<Termin> termin) {
        this.termine = termin;
    }

}
