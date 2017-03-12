package daten;

/**
 * 
 */
public class Termin {
    /**
     * 
     */
    private String bezeichnung;

    /**
     * 
     */
    private static String datum;

    /**
     * 
     */
    private String uhrzeit;

    /**
     * 
     */
    private static int dauer;

    /**
     * 
     */
    private String kommentar;

    /**
     * 
     */
    private String info;

    /**
     * 
     */
    private int wiederholung;

    /**
     * 
     */
    private Typ terminTyp;

    /**
     * Eine Liste, welche die Markierungen fuer einen Termin enthaelt.
     */
    private Object markierung;

    /**
     * Die Wiederholbarkeit eines Termins.
     */
    private Wiederholbarkeit wiederholbarkeitTermin;

    /**
     * @return bezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * @param bezeichnung
     *            es wird eine bezeichnung uebergeben
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * @return datum
     */
    public static String getDatum() {
        return datum;
    }

    /**
     * @param datum
     *            es wird ein datum uebergeben
     */
    public void setDatum(String datum) {
        Termin.datum = datum;
    }

    /**
     * @return uhrzeit
     */
    public String getUhrzeit() {
        return uhrzeit;
    }

    /**
     * @param uhrzeit
     *            es wird eine uhrzeit ubergeben
     */
    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    /**
     * @return dauer
     */
    public static int getDauer() {
        return dauer;
    }

    /**
     * @param dauer
     *            es wird eine dauer uebergeben
     */
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    /**
     * @return kommentar
     */
    public String getKommentar() {
        return kommentar;
    }

    /**
     * @param notiz
     *            wird ein kommentar uebegeben
     */
    public void setKommentar(String notiz) {
        this.kommentar = notiz;
    }

    /**
     * @return info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     *            es wird eine info uebergeben
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return wiederholung
     */
    public int getWiederholung() {
        return wiederholung;
    }

    /**
     * @param wiederholung
     *            es wird eine wiederholung übergeben
     */
    public void setWiderholung(int wiederholung) {
        this.wiederholung = wiederholung;
    }

    /**
     * @return markierung Objekt Markierung.
     */
    public Object getMarkierung() {
        return markierung;
    }

    /**
     * @param markierung
     *            es wird eine markierung mit uebergeben
     */
    public void setMarkierung(Object markierung) {
        this.markierung = markierung;
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
     * @return wiederholbarkeitTermin
     */
    public Wiederholbarkeit getWiederholbarkeitTermin() {
        return wiederholbarkeitTermin;
    }

    /**
     * @param wiederholbarkeitTermin
     * 
     *            es wird ein wiederholbarkeitTermin uebergeben
     */
    public void setWiederholbarkeitTermin(
        Wiederholbarkeit wiederholbarkeitTermin) {
        this.wiederholbarkeitTermin = wiederholbarkeitTermin;
    }

    /**
     * Eine Aufzaehlung von den Markierungen, welche die Termine haben koennen.
     */
    public enum Markierung {
        /**
         * 
         */
        Not_Selected,
        /**
         * Markierung fuer einen erledigten Termin.
         */
        TERMIN_ERLEDIGT,
        /**
         * Markierung fuer einen erfolgreich erledigten Termin.
         */
        TERMIN_ERFOLGREICH,
        /**
         * Markierung fuer einen Termin mit hoher Prioritaet.
         */
        HOHE_PRIORITAET,
        /**
         * Markierung fuer nette Tutoren.
         */
        NETTE_TUTOREN,
        /**
         * Markierung fuer eine schwere Veranstaltung.
         */
        SCHWIERIG
    };

    /**
     * Aufzaehlung der Typen von Terminen, sprich ob der Termin zum Studium
     * gehoert oder ein privater ist.
     */
    public enum Typ {

        /**
         * Auswahlmoeglichkeiten des Types.
         */
        Not_Selected("Not Selected"),
        /**
         * Auswahlmoeglichkeiten Universitaet des Types.
         */
        Universitaet("Universitaet"),
        /**
         * Auswahlmoeglichkeiten Privat des Types.
         */
        Privat("Privat");

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
        Not_Selected("Not Selected"),
        /**
         * 
         */
        Einmalig("Einmalig"),
        /**
         * 
         */
        Woechentlich("Woechentlich");

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

}
