package daten;

import java.util.ArrayList;

import gui.KalenderGui;

/**
 * Die Klasse AktuelleSitzung managed alle Termine des eingeloggten Benutzers,
 * d.h. die Termine vom Kalender. Es werden fuer die Variablen-Typen Aufgabe,
 * Pruefung und Veranstaltung Listen erstellt. Es werden die Variablen-Typen
 * Benutzer, Aufgabe, Pruefung, Veranstaltung und KalenderGUI.
 * 
 * @author Valerian Tjunnikov.
 */
public class AktuelleSitzung {
    /**
     * der benutzer von Variablentyp Benutzer.
     */
    private static Benutzer aktuellerBenutzer;

    /**
     * Die ArrayList, die die aufgaben enthaehlt.
     */
    private ArrayList<Aufgabe> aufgaben;

    /**
     * Die ArrayList, die die pruefungen enthaelt.
     */
    private ArrayList<Pruefung> pruefungen;

    /**
     * Die ArrayList, die die veranstaltungen enthaelt.
     */
    private ArrayList<Veranstaltung> veranstaltungen;
    /**
     * die aufgabe vom Variablentyp Aufgabe.
     */
    private Aufgabe aufgabe;

    /**
     * die pruefung vom Variablentyp Pruefung.
     */
    private Pruefung pruefung;

    /**
     * die veranstaltung vom Variablentyp Veranstaltung.
     */
    private Veranstaltung veranstaltung;

    /**
     * klasse kalender muss noch erstellt werden.
     */
    // private Kalender GUI kalendergui;
    private KalenderGui kalenderGui;

    /**
     * die aktuelleSitzung vom Variablentyp AktuelleSitzung wird hier auf static
     * gesetzt (dient als Allgemeingueltigkeit fuer das ganze Projekt) und auf
     * null.
     */
    private static AktuelleSitzung aktuelleSitzung = null;

    /**
     * Der Konstruktor von der Klasse AktuelleSitzung.
     */
    public AktuelleSitzung() {
        aufgaben = new ArrayList<Aufgabe>();
        veranstaltungen = new ArrayList<Veranstaltung>();
        pruefungen = new ArrayList<Pruefung>();
    }

    /**
     * Der Getter von Benutzer benutzer.
     * 
     * @return benutzer
     */
    public static Benutzer getBenutzer() {
        return aktuellerBenutzer;
    }

    /**
     * Der Getter von ArrayList Aufgaben.
     * 
     * @return aufgaben
     */
    public ArrayList<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    /**
     * Der Getter von ArrayList Pruefungen.
     * 
     * @return pruefungen
     */
    public ArrayList<Pruefung> getPruefungen() {
        return pruefungen;
    }

    /**
     * Der Getter von ArrayList Veranstaltungen.
     * 
     * @return veranstaltungen
     */
    public ArrayList<Veranstaltung> getVeranstaltungen() {
        return veranstaltungen;
    }

    /**
     * Der Getter von Aufgabe aufgabe.
     * 
     * @return aufgabe
     */
    public Aufgabe getAufgabe() {
        return aufgabe;
    }

    /**
     * Der Getter von Pruefung pruefung.
     * 
     * @return pruefung
     */
    public Pruefung getPruefung() {
        return pruefung;
    }

    /**
     * Der Getter von Veranstaltung veranstaltungen.
     * 
     * @return veranstaltung
     */
    public Veranstaltung getVeranstaltung() {
        return veranstaltung;
    }

    /**
     * Wenn noch keine AktuelleSitzung vom eingeloggten Benutzer besteht, bzw.
     * gleich null ist, soll eine neue aktuelleSitzung erstellt werden. Als
     * Rueckgabewert erhaelt man aktuelleSitzung.
     * 
     * @return aktuelleSitzung
     */
    public static AktuelleSitzung getAktuelleSitzung() {
        if (aktuelleSitzung == null) {
            aktuelleSitzung = new AktuelleSitzung();
        }
        return aktuelleSitzung;
    }

    /**
     * Der Setter von Benutzer benutzer.
     * 
     * @param benutzer
     *            Die Benutzer vom Typ Benutzer
     */
    public static void setBenutzer(Benutzer benutzer) {
        aktuellerBenutzer = benutzer;
    }

    /**
     * Der Setter von ArrayList aufgabe.
     * 
     * @param aufgaben
     *            Die Aufgaben vom Typ Arraylist
     */
    public void setAufgaben(ArrayList<Aufgabe> aufgaben) {
        this.aufgaben = aufgaben;
    }

    /**
     * Der Setter von ArrayList pruefung.
     * 
     * @param pruefungen
     *            Die Pruefung vom Typ Arraylist
     */
    public void setPruefungen(ArrayList<Pruefung> pruefungen) {
        this.pruefungen = pruefungen;
    }

    /**
     * Der Setter von ArrayList veranstaltungen.
     * 
     * @param veranstaltungen
     *            Die Veranstaltung vom Typ Arraylist
     */
    public void setVeranstaltungen(ArrayList<Veranstaltung> veranstaltungen) {
        this.veranstaltungen = veranstaltungen;
    }

    /**
     * Der Setter von Aufgabe aufgabe.
     * 
     * @param aufgabe
     *            Die Aufgabe vom Typ Aufgabe
     */
    public void setAufgabe(Aufgabe aufgabe) {
        this.aufgabe = aufgabe;
    }

    /**
     * Der Setter von Pruefung pruefung.
     * 
     * @param pruefung
     *            Die Pruefung vom Typ Pruefung
     */
    public void setPruefung(Pruefung pruefung) {
        this.pruefung = pruefung;
    }

    /**
     * Der Setter von Veranstaltung veranstaltung.
     * 
     * @param veranstaltung
     *            Die Veranstaltung vom Typ Veranstaltung
     */
    public void setVeranstaltung(Veranstaltung veranstaltung) {
        this.veranstaltung = veranstaltung;
    }

    /**
     * Mit dieser Methode wird es ermoeglicht, dass man Aufgaben hinzufuegen
     * kann. Es wird nach jedem hinzufuegen ein Update durchgefuehrt.
     * 
     * @param aufgabe
     *            Die Aufgabe vom Typ Aufgabe.
     */
    public void aufgHinzu(Aufgabe aufgabe) {
        this.aufgaben.add(aufgabe);
        // kalender muss aktualisiert werden!
    }

    /**
     * Mit dieser Methode wird es ermoeglicht, dass man Pruefungen hinzufuegen
     * kann. Es wird nach jedem hinzufuegen ein Update durchgefuehrt.
     * 
     * @param pruefung
     *            Die Pruefung vom Typ Pruefung.
     */
    public void pruefHinzu(Pruefung pruefung) {
        this.pruefungen.add(pruefung);
        // kalender muss aktualisiert werden!
    }

    /**
     * Mit dieser Methode wird es ermoeglicht, dass man Veranstaltungen
     * hinzufuegen kann. Es wird nach jedem hinzufuegen ein Update
     * durchgefuehrt.
     * 
     * @param veranstaltung
     *            Die Veranstaltung vom Typ Veranstaltung.
     */
    public void veranHinzu(Veranstaltung veranstaltung) {
        this.veranstaltungen.add(veranstaltung);
        // kalender muss aktualisiert werden!
    }

    /**
     * noch nicht fertig!
     */
    public void loadAufgaben() {

    }

    /**
     * noch nicht fertig!
     */
    public void loadVeranstaltungen() {

    }

    /**
     * noch nicht fertig!
     */
    public void loadPruefungen() {

    }

    /**
     * Der Setter von AktuelleSitzung aktuelleSitzung.
     * 
     * @param aktuelleSitzung
     *            Die AktuelleSitzung vom Typ AktuelleSitzung
     */
    public void setAktuelleSitzung(AktuelleSitzung aktuelleSitzung) {
        AktuelleSitzung.aktuelleSitzung = aktuelleSitzung;
    }

}
