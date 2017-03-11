package daten;

/**
 * Klasse um eine Veranstaltung zu erstellen, welche von Termin erbt.
 * 
 * @author Rakan Al-Swayyed
 */
public class Veranstaltung extends Termin {
    /**
     * Die Raumnummer, in dem die Veranstaltung stattfindet, ist ein String, da
     * es auch eine Kombination von Buchstaben und Zahlen sein kann, bsp H2.
     */
    private String raumnummer;

    /**
     * Das Gebaeude, in dem die Veranstaltung stattfindet.
     */
    private String gebaeude;

    /**
     * Der Dozent, welcher die Veranstaltung haelt.
     */
    private String dozent;

    /**
     * Die Creditzahl, welche die Veranstaltung gibt.
     */
    private String ects;

    /**
     * Getter fuer die Raumnummer.
     * 
     * @return raumnummer Gibt die Raumnummer der Veranstaltung aus.
     */
    public String getRaumnummer() {
        return raumnummer;
    }

    /**
     * Setter fuer die Raumnummer.
     * 
     * @param raumnummer
     *            Setzt die Raumnummer der Veranstaltung.
     */
    public void setRaumnummer(String raumnummer) {
        this.raumnummer = raumnummer;
    }

    /**
     * Getter fuer das Gebaude.
     * 
     * @return gebaeude Gibt das Gebaeude aus, in dem die Veranstaltung
     *         stattfindet.
     */
    public String getGebaeude() {
        return gebaeude;
    }

    /**
     * Setter fuer das Gebaeude.
     * 
     * @param gebaeude
     *            Setzt das Gebaeude, in dem die Veranstaltung stattfindet.
     */
    public void setGebaeude(String gebaeude) {
        this.gebaeude = gebaeude;
    }

    /**
     * Getter fuer den Dozenten.
     * 
     * @return dozent Gibt den Dozenten aus, der die Veranstaltung haelt.
     */
    public String getDozent() {
        return dozent;
    }

    /**
     * Setter fuer den Dozenten.
     * 
     * @param dozent
     *            Setzt den Dozenten, der die Veranstaltung haelt.
     */
    public void setDozent(String dozent) {
        this.dozent = dozent;
    }

    /**
     * Getter fuer die ECTS der Veranstaltung.
     * 
     * @return ects Gibt die Anzahl der Credits aus, welche die Veranstaltung
     *         gibt.
     */
    public String getEcts() {
        return ects;
    }

    /**
     * Setter fuer die ECTS der Veranstaltung.
     * 
     * @param ects
     *            Setzt die Anzahl der Credits, welche die Veranstaltung gibt.
     */
    public void setEcts(String ects) {
        this.ects = ects;
    }

    /**
     * Konstruktor der Klasse Veranstaltung die von Aufgabe erbt.
     **/
    public Veranstaltung() {

        super();

    }

    /**
     * Methode die ein Array mit den Zusatzdaten für Veranstaltungen beschreibt.
     * 
     * @return Das Array mit den Zusatzdaten für Veranstaltungen
     **/
    public String[] veranstaltungsArray() {

        String[] arrayVeranst = new String[4];

        arrayVeranst[0] = raumnummer;
        arrayVeranst[1] = gebaeude;
        arrayVeranst[2] = dozent;
        arrayVeranst[3] = ects;

        return arrayVeranst;
    }
}
