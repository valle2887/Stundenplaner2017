package daten;

import java.util.Calendar;
import java.util.Date;

/**
 * Die Klasse Termin, von welcher die Klassen Aufgabe, Pruefung und
 * Veranstaltung erben. Zeigt die Bezeichnung, einen Kommentar, die Dauer, die
 * Art und die Wiederholbarkeit eines Termins an.
 * 
 * @author Rakan Al-Swayyed
 */
public class Aufgabe {
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
    private static int dauer;

    /**
     * Das Datum, an dem der Termin stattfindet.
     */
    private String datum;

    /**
     * Die Uhrzeit, an der der Termin stattfindet.
     */
    private String uhrzeit;

    /**
     * 
     */
    private boolean konflikt;

    /**
     * 
     */
    private boolean mehrereTermine;

    /**
     * Eine Liste, welche die Markierungen fuer einen Termin enthaelt.
     */
    private Object markierung;

    /**
     * Datum fuer die Deadline der Aufgabe.
     */
    private String deadline;

    /**
     * Setter fuer die Deadline der Aufgabe.
     * 
     * @param deadline
     *            Setzt die deadline einer Aufgabe.
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * Getter fuer die Deadline der Aufgabe.
     * 
     * @return deadline gibt die Deadline der Aufgabe aus.
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * Getter fuer die Markierung des Termins.
     * 
     * @return markierung
     */
    public Object getMarkierung() {
        return markierung;
    }

    /**
     * Setter fuer die Markierung des Termins.
     * 
     * @param marker
     *            Die Markierung des Termins wird gesetzt.
     */
    public void setMarkierung(Object marker) {
        this.markierung = marker;
    }

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
    public static int getDauer() {
        return dauer;
    }

    /**
     * Setter fuer die Dauer.
     * 
     * @param i
     *            Setzt Dauer des Termins.
     */
    public void setDauer(int i) {
        Aufgabe.dauer = i;
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
     * @param wiederholen
     *            Setzt die Wiederholbarkeit eines Termins.
     */
    public void setWiederholbarkeitTermin(Wiederholbarkeit wiederholen) {
        this.wiederholbarkeitTermin = wiederholen;
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
     * Getter fuer das Datum.
     * 
     * @return datum
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Setter fuer das Datum.
     * 
     * @param datum
     *            Setzt das Datum fuer den Termin.
     */
    public void setDatum(String datum) {
        this.datum = datum;
    }

    /**
     * Getter fuer die Uhrzeit.
     * 
     * @return uhrzeit
     */
    public String getUhrzeit() {
        return uhrzeit;
    }

    /**
     * Setter fuer die Uhrzeit.
     * 
     * @param uhrzeit
     *            Setzt die Uhrzeit fuer den Termin.
     */
    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
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

    /**
     * Die Wiederholbarkeit eines Termins.
     */
    private Wiederholbarkeit wiederholbarkeitTermin;

    /**
     * Der Typ eines Termins.
     */
    private Typ terminTyp;

    /**
     * @return konflikt
     */
    public boolean isKonflikt() {
        return konflikt;
    }

    /**
     * @param konflikt
     *            wird ein konflikt übergeben.
     */
    public void setKonflikt(boolean konflikt) {
        this.konflikt = konflikt;
    }

    /**
     * @return mehereTermine
     */
    public boolean isMehrereTermine() {
        return mehrereTermine;
    }

    /**
     * @param mehrereTermine
     *            es wirden mehrere Temine übergeben.
     */
    public void setMehrereTermine(boolean mehrereTermine) {
        this.mehrereTermine = mehrereTermine;
    }

    /**
     * @return Umwandlung des datums in string
     */
    public Date stringZuDatum() {
        Calendar cal = Calendar.getInstance();

        String[] tagMonatJahr = datum.split(":");
        String[] zeit = uhrzeit.split(":");
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(tagMonatJahr[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(tagMonatJahr[1]) - 1);
        cal.set(Calendar.YEAR, Integer.parseInt(tagMonatJahr[2]));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(zeit[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(zeit[1]));

        return cal.getTime();
    }

    /**
     * Methode die die Daten einer Aufgabe in ein Array schreibt.
     * 
     * @return Array das die Daten der Aufgabe enthält
     **/
    public String[] terminarray() {

        String[] thisArray = new String[9];

        thisArray[0] = bezeichnung;
        thisArray[1] = datum;
        thisArray[2] = uhrzeit;
        thisArray[3] = dauer + "";
        thisArray[4] = kommentar;
        thisArray[5] = wiederholbarkeitTermin + "";
        thisArray[6] = terminTyp + "";
        thisArray[7] = markierung + "";
        thisArray[8] = deadline + "";

        return thisArray;
    }

    /**
     * Die Methode macht aus einem übergebenen String-Objekt (der Position)
     * einen String mit dem Inhalt.
     * 
     * @return Bezeichnung des Termins
     */
    public String toString() {

        return getBezeichnung();
    }

}
