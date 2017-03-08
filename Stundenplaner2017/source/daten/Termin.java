package daten;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Termin, von welcher die Klassen Aufgabe, Pruefung und
 * Veranstaltung erben. Zeigt die Bezeichnung, einen Kommentar, die Dauer, die
 * Art und die Wiederholbarkeit eines Termins an.
 * 
 * @author Christian Lindenberg
 */
public class Termin {
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
     * Das Datum, an dem der Termin stattfindet.
     */
    private String datum;
    /**
     * Die Uhrzeit, an der der Termin stattfindet.
     */
    private String uhrzeit;
    /**
     * Eine Liste, welche die Markierungen fuer einen Termin enthaelt.
     */
    private List<Markierung> markierung = new ArrayList<Markierung>();

    /**
     * Getter fuer die Markierung des Termins.
     * @return markierung
     */
    public List<Markierung> getMarkierung() {
        return markierung;
    }

    /**
     * Setter fuer die Markierung des Termins.
     * @param markierung
     * Die Markierung des Termins wird gesetzt.
     */
    public void setMarkierung(List<Markierung> markierung) {
        this.markierung = markierung;
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
     * @param wiederholen
     *            Setzt die Wiederholbarkeit eines Termins.
     */
    public void setWiederholbarkeitTermin(
        Wiederholbarkeit wiederholen) {
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
     * @return datum
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Setter fuer das Datum.
     * @param datum 
     * Setzt das Datum fuer den Termin.
     */
    public void setDatum(String datum) {
        this.datum = datum;
    }

    /**
     * Getter fuer die Uhrzeit.
     * @return uhrzeit
     */
    public String getUhrzeit() {
        return uhrzeit;
    }

    /**
     * Setter fuer die Uhrzeit.
     * @param uhrzeit
     * Setzt die Uhrzeit fuer den Termin.
     */
    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }
    
    /**
     * Eine Aufzaehlung von den Markierungen, welche die Termine haben
     * koennen.
     */
    public enum Markierung {
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
       Nicht_gewaehlt(""),
       Universitaet("Universitaet"),
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
    
    public String[] terminArray() {
        
        String[] termArray = new String[5];
        
        termArray[0] = bezeichnung;
        termArray[1] = kommentar;
        termArray[2] = dauer + "";
        termArray[3] = datum;
        termArray[4] = uhrzeit + "";
        termArray[5] = wiederholbarkeitTermin + "";
        
        return termArray;
    }

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
