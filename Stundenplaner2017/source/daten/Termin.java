package daten;
/**
 * Die Klasse Termin, von welcher die Klassen Aufgabe, Pruefung und
 * Veranstaltung erben. Zeigt die Bezeichnung, einen Kommentar, die Dauer,
 * die Art und die Wiederholbarkeit eines Termins an.
 *@author Christian Lindenberg
 */
public class Termin {
    /** 
     * Die Bezeichnung fuer den Termin.
     */
    private String bezeichnung;
    /** Kommentar fuer den Termin.
     */
    private String kommentar;
    /**
     * Die Dauer des Termins.
     */
    private int dauer;
    
    /**
     * Getter fuer die Bezeichnung.
     * @return bezeichnung
     * Gibt die Bezeichnung des Termins aus
     */
    
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Setter fuer die Bezeichnung.
     * @param bezeichnung
     * Setzt die Bezeichnung des Termins.
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    /**
     * Getter fuer den Kommentar.
     * @return kommentar
     * Gibt den Kommentar des Termins aus.
     */
    public String getKommentar() {
        return kommentar;
    }
    /**
     * Setter fuer den Kommentar.
     * @param kommentar
     * Setzt den Kommentar des Termins.
     */
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
    /**
     * Getter fuer die Dauer des Termins.
     * @return dauer;
     * Gibt aus, wie lange der Termin dauert.
     */
    public int getDauer() {
        return dauer;
    }
    /**
     * Setter fuer die Dauer.
     * @param dauer
     * Setzt die Dauer des Termins.
     */
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }
    /**
     * Aufzaehlung der Typen von Terminen, sprich ob der Termin zum Studium 
     * gehoert oder ein privater ist.
     * @ Studium, Privat
     */
    public enum Typ {
        Studium, Privat;
    }
    
    /**
     * Aufzaehlung ueber die Wiederholbarkeit des Termins, sprich ob der Termin
     * einmalig ist, oder woechentlich auftritt.
     */
    
    public enum Wiederholbarkeit {
        Einmalig, Woechentlich;
    }
}
