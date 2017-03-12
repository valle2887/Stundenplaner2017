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

    public Kalender() {
        termine = new ArrayList<Termin>();
    }

    public boolean kollidiertTermin(Termin termine) {
        boolean kollision = false;
        for(Termin t : termine) {
            if () {
                
            }
        }
                   
      return kollision;
    }

    public void terminHinzufuegen(Termin termin) {
        termine.add(termin);
    }

    public void terminLoeschen(Termin termin) {
        termine.remove(termin);
    }

    public void setTermine(ArrayList<Termin> termine) {
        this.termine = termine;
    }

}
