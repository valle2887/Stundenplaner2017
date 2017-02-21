package daten;
/**
 * Die Klasse für die Pruefung, erbt von der Klasse Termin und zeigt die
 * Pruefungsdauer und die zur Pruefung gehoerende Veranstaltung.
 * @author Christian Lindenberg
 */
public class Pruefung extends Termin {
/**
 * Pruefungsdauer in Minuten.
 */
    private int pruefungsdauer;
/**
 * Die Veranstaltung, die zu einer Pruefung gehoert.
 */ 
    private Veranstaltung zugehoerendeVeranstaltung;
    
    /**
     * Getter fuer die Pruefungsdauer.
     * @return pruefungsdauer
     * Gibt die Pruefungsdauer in Minuten zurueck.
     */
    public int getPruefungsdauer() {
        return pruefungsdauer;
    }

    /**
     * Setter fuer die Pruefungsdauer.
     * @param pruefungsdauer
     * Setzt die Pruefungsdauer.
     */
    public void setPruefungsdauer(int pruefungsdauer) {
        this.pruefungsdauer = pruefungsdauer;
    }

    /**
     * Getter fuer die Veranstaltung.
     * @return zugehoerendeVeranstaltung
     * Gibt die Veranstaltung, zu der die Pruefung gehoert zurueck.
     */

    public Veranstaltung getZugehoerendeVeranstaltung() {
        return zugehoerendeVeranstaltung;
    }

    /**
     * Setter fuer die zughoerende Veranstaltung.
     * @param zugehoerendeVeranstaltung
     * Setzt die zur Pruefung zugehoerende Veranstaltung.
     */
    public void setZugehoerendeVeranstaltung(
        Veranstaltung zugehoerendeVeranstaltung) {
        this.zugehoerendeVeranstaltung = zugehoerendeVeranstaltung;
    }



}