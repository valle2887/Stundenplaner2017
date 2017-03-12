package daten;

/**
 * Die Klasse für die Pruefung, erbt von der Klasse Termin und zeigt die
 * Pruefungsdauer und die zur Pruefung gehoerende Veranstaltung.
 * 
 * @author Rakan Al-Swayyed
 */
public class Pruefung extends Termin {

    /**
     * 
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
    private String zugehoerendeVeranstaltung;

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
    public void setZugehoerendeVeranstaltung(String zugehoerendeVeranstaltung) {
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
     * Setter fuer gebaeude. s
     * 
     * @param gebaeude
     *            .
     */
    public void setGebaeude(String gebaeude) {
        this.gebaeude = gebaeude;
    }

    /**
     * @return pruefungsdauer
     * 
     * @param pruefungsdauer
     * 
     *            es wird eine dauer uebergaben
     */
    public String getPruefungsdauer(int pruefungsdauer) {
        return Integer.toString(pruefungsdauer);
    }

    /**
     * @param pruefungsdauer
     * 
     *            es wird eine dauer uebergeben
     */
    public void setPruefungsdauer(int pruefungsdauer) {
        this.pruefungsdauer = pruefungsdauer;
    }

}
