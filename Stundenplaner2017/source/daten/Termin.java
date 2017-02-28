package daten;

/**
 * Die Klasse Termin, von welcher die Klassen Aufgabe, Pruefung und
 * Veranstaltung erben. Zeigt die Bezeichnung, einen Kommentar, die Dauer, die
 * Art und die Wiederholbarkeit eines Termins an.
 * 
 * @author Christian Lindenberg
 */
public abstract class Termin {
    /**
     * Die Bezeichnung fuer den Termin.
     */
    private String bezeichnung;

    /**
     * Kommentar fuer den Termin.
     */
    private String kommentar;

    /**
     * Die Dauer des Termins.
     */
    private int dauer;

    /**
     * Getter fuer die Bezeichnung.
     * 
     * @return bezeichnung Gibt die Bezeichnung des Termins aus
     */

    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Setter fuer die Bezeichnung.
     * 
     * @param bezeichnung
     *            Setzt die Bezeichnung des Termins.
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * Getter fuer den Kommentar.
     * 
     * @return kommentar Gibt den Kommentar des Termins aus.
     */
    public String getKommentar() {
        return kommentar;
    }

    /**
     * Setter fuer den Kommentar.
     * 
     * @param kommentar
     *            Setzt den Kommentar des Termins.
     */
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    /**
     * Getter fuer die Dauer des Termins.
     * 
     * @return dauer; Gibt aus, wie lange der Termin dauert.
     */
    public int getDauer() {
        return dauer;
    }

    /**
     * Setter fuer die Dauer.
     * 
     * @param dauer
     *            Setzt die Dauer des Termins.
     */
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    /**
     * Getter fuer die Wiederholbarkeit eines Termins.
     * 
     * @return wiederholbarkeitTermin Liefert die Wiederholbarkeit eines Termins
     *         zurueck.
     */
    public Wiederholbarkeit getWiederholbarkeitTermin() {
        return wiederholbarkeitTermin;
    }

    /**
     * Setter fuer die Wiederholbarkeit eines Termins.
     * 
     * @param wiederholbarkeitTermin
     *            Setzt die Wiederholbarkeit eines Termins.
     */
    public void setWiederholbarkeitTermin(
        Wiederholbarkeit wiederholbarkeitTermin) {
        this.wiederholbarkeitTermin = wiederholbarkeitTermin;
    }

    /**
     * Getter fuer den Typ eines Termins.
     * 
     * @return terminTyp Gibt den Typen eines Termines aus.
     */
    public Typ getTerminTyp() {
        return terminTyp;
    }

    /**
     * Setter fuer den Typ eines Termins.
     * 
     * @param terminTyp
     *            Setzt den Typ eines Termins.
     */
    public void setTerminTyp(Typ terminTyp) {
        this.terminTyp = terminTyp;
    }

    /**
     * Aufzaehlung der Typen von Terminen, sprich ob der Termin zum Studium
     * gehoert oder ein privater ist.
     */
    public enum Typ {

        /**
         * Auswahlmoeglichkeiten des Types.
         */
        Universitaet("Universitaet"), Privat("Privat");

        /**
         * Der Name des Termines.
         */

        private final String name;

        /**
         * Methode um den Typ eines Termines festzulegen.
         * 
         * @param name
         *            des Termines wird uebergeben.
         */
        private Typ(String name) {
            this.name = name;
        }

        /**
         * Getter um den Namen eines Termines zurueckzuliefern.
         * 
         * @return name
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Aufzaehlung ueber die Wiederholbarkeit des Termins, sprich ob der Termin
     * einmalig ist, oder woechentlich auftritt.
     */

    public enum Wiederholbarkeit {
        /**
         * Wiederholbarkeit, ob der Termin einmalig oder Woechentlich
         * stattfindet.
         */
        Einmalig("Einmalig"), Woechentlich("Woechentlich");
        /**
         * Name des Termines.
         */
        private final String name;

        /**
         * Methode, um die Wiederholbarkeit eines Termines festzulegen.
         * 
         * @param name
         *            des Termins wird uebergeben
         */
        private Wiederholbarkeit(String name) {
            this.name = name;
        }

        /**
         * Getter um den Namen eines Termines zurueckzuliefern.
         * 
         * @return name
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Die Wiederholbarkeit eines Termins.
     */
    private Wiederholbarkeit wiederholbarkeitTermin;

    /**
     * Der Typ eines Termins.
     */
    private Typ terminTyp;

    /**
     * Bitte erstmal nchit beachten das haben wir mit dome gemacht!
     * 
     * @param obj
     *            es wird ein objekt übergeben
     * @return es wird true oder false übergeben
     */

    /**
     * public boolean equals(Object obj) { if (obj == null) { return false; } if
     * (!(obj instanceof Termin)) { return false; } return id == ((Termin)
     * obj).id; }
     */
}
