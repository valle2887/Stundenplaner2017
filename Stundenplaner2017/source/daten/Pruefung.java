package daten;

/**
 * Die Klasse für die Pruefung, erbt von der Klasse Termin und zeigt die
 * Pruefungsdauer und die zur Pruefung gehoerende Veranstaltung.
 * 
 * @author Rakan Al-Swayyed
 */
public class Pruefung extends Termin {
    /**
     * Pruefungsdauer in Minuten mit dem Datentyp Integer.
     */
    private int pruefungsdauer;

    /**
     * Der Raum, in der die Pruefung stattfindet mit dem Datentyp String.
     */
    private String raumnummer;

    /**
     * Das Gebaeude, in dem die Pruefung stattfindet mit dem Datentyp String.
     */
    private String gebaeude;

    /**
     * Die Veranstaltung, die zu einer Pruefung gehoert mit dem Datentyp String.
     */
    private Veranstaltung zugehoerendeVeranstaltung;

    /**
     * Konstruktor der Klasse Pruefung die von Termin erbt.
     **/
    public Pruefung() {

        super();
    }

    /**
     * Getter fuer die Pruefungsdauer.
     * 
     * @return pruefungsdauer Gibt die Pruefungsdauer in Minuten zurueck.
     */
    public int getPruefungsdauer() {
        return pruefungsdauer;
    }

    /**
     * Setter fuer die Pruefungsdauer.
     * 
     * @param pruefungsdauer
     *            Setzt die Pruefungsdauer.
     */
    public void setPruefungsdauer(int pruefungsdauer) {
        this.pruefungsdauer = pruefungsdauer;
    }

    /**
     * Getter fuer die Veranstaltung.
     * 
     * @return zugehoerendeVeranstaltung Gibt die Veranstaltung, zu der die
     *         Pruefung gehoert zurueck.
     */
    public String getZugehoerendeVeranstaltung() {
        return zugehoerendeVeranstaltung;
    }

    /**
     * Setter fuer die zughoerende Veranstaltung.
     * 
     * @param zugehoerendeVeranstaltung
     *            Setzt die zur Pruefung zugehoerende Veranstaltung.
     */
    public void setZugehoerendeVeranstaltung(
        Veranstaltung zugehoerendeVeranstaltung) {
        this.zugehoerendeVeranstaltung = zugehoerendeVeranstaltung;
    }

    /**
     * Getter fuer raumnummer.
     * 
     * @return raumnummer.
     */
    public String getRaumnummer() {
        return raumnummer;
    }

    /**
     * Setter fuer raumnummer.
     * 
     * @param raumnummer
     *            .
     */
    public void setRaumnummer(String raumnummer) {
        this.raumnummer = raumnummer;
    }

    /**
     * Getter fuer gebauede.
     * 
     * @return gebauede
     */
    public String getGebaeude() {
        return gebaeude;
    }

    /**
     * Setter fuer gebaeude.
     * 
     * @param gebaeude
     *            .
     */
    public void setGebaeude(String gebaeude) {
        this.gebaeude = gebaeude;
    }

    /**
     * Zusatzdaten einer Prüfung in ein Array schreiben.
     * 
     * @return Das Array mit den Zusatzdaten für die Prüfung
     **/
    public String[] pruefungArray() {

        String[] arrayPruef = new String[3];
        // zugehoerendeVeranstaltung nochmal verknüpfen
        arrayPruef[0] = zugehoerendeVeranstaltung;
        arrayPruef[1] = gebaeude;
        arrayPruef[2] = raumnummer;

        return arrayPruef;
    }

}
