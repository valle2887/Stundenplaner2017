package daten;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
    private Benutzer benutzer;

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
    public Benutzer getBenutzer() {
        return benutzer;
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
    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
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
        try {
            ArrayList<String> aufgaben =
                DatenVerwaltung.leseAufgabe(Benutzer.getUsername());
            for (int i = 0; i < aufgaben.size(); i = i + 7) {
                Aufgabe aufgabe = new Aufgabe();
                aufgabe.setBezeichnung(aufgaben.get(i + 0));
                aufgabe.setDatum(aufgaben.get(i + 1));
                aufgabe.setUhrzeit(aufgaben.get(i + 2));
                aufgabe.setDauer(Integer.parseInt(aufgaben.get(i + 3)));
                aufgabe.setKommentar(aufgaben.get(i + 4));
                // aufgabe.setWiederholung(Integer.parseInt(aufgaben.get(i +
                // 5)));
                // aufgabe.setTyp(aufgaben.get(i + 6));
                this.aufgaben.add(aufgabe);

            }

        } catch (IOException exc) {

            exc.printStackTrace();
        }

    }

    /**
     * noch nicht fertig!
     */
    public void loadVeranstaltungen() {
        try {
            ArrayList<String> veranstaltungen =
                DatenVerwaltung.leseVeranstaltung(Benutzer.getUsername());
            for (int i = 0; i < veranstaltungen.size(); i = i + 11) {
                Veranstaltung veranstaltung = new Veranstaltung();
                veranstaltung.setBezeichnung(veranstaltungen.get(i + 0));
                veranstaltung.setDatum(veranstaltungen.get(i + 1));
                veranstaltung.setUhrzeit(veranstaltungen.get(i + 2));
                veranstaltung
                    .setDauer(Integer.parseInt(veranstaltungen.get(i + 3)));
                veranstaltung.setKommentar(veranstaltungen.get(i + 4));
                // veranstaltung.setWiederholung(
                // Integer.parseInt(veranstaltungen.get(i + 5)));
                // veranstaltung.setTyp(veranstaltungen.get(i + 6));
                // veranstaltung.setRaumNummer(veranstaltungen.get(i + 7));
                veranstaltung.setGebaeude(veranstaltungen.get(i + 8));
                veranstaltung.setDozent(veranstaltungen.get(i + 9));
                // veranstaltung.setEcts(veranstaltungen.get(i + 10));
                this.veranstaltungen.add(veranstaltung);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    /**
     * noch nicht fertig!
     */
    public void loadPruefungen() {

        try {
            ArrayList<String> pruefungen =
                DatenVerwaltung.lesePruefung(Benutzer.getUsername());
            for (int i = 0; i < pruefungen.size(); i = i + 10) {
                Pruefung pruefung = new Pruefung();
                pruefung.setBezeichnung(pruefungen.get(i + 0));
                pruefung.setDatum(pruefungen.get(i + 1));
                pruefung.setUhrzeit(pruefungen.get(i + 2));
                pruefung.setDauer(Integer.parseInt(pruefungen.get(i + 3)));
                pruefung.setKommentar(pruefungen.get(i + 4));
                // pruefung
                // .setWiederholung(Integer.parseInt(pruefungen.get(i + 5)));
                // pruefung.setTyp(pruefungen.get(i + 6));
                // pruefung.setVeranstaltung(pruefungen.get(i + 7));
                // pruefung.setCampus(pruefungen.get(i + 8));
                // pruefung.setRaum(pruefungen.get(i + 9));
                this.pruefungen.add(pruefung);
            }
        } catch (Exception exc) {

            exc.printStackTrace();
        }
    }

    /**
     * @param anfang
     *            .
     * @return wochenAufgaben.
     */
//    public ArrayList<Aufgabe> wochenAufgaben(Date anfang) {
//        ArrayList<Aufgabe> wochenAufgaben = new ArrayList<Aufgabe>();
//        for (int i = 0; i < aufgaben.size(); i++) {
//            if (Datum.liegtImZeitintervall(start,
//                aufgaben.get(i).stringZuDatum(), 60 * 24 * 7,
//                aufgaben.get(i).getDauer())) {
//                wochenAufgaben.add(aufgaben.get(i));
//            }
//        }
//        return wochenAufgaben;
//    }

    /**
     * @return wochenPruefung
     */
//    public ArrayList<Pruefung> wochenPruefung(Date start) {
//        ArrayList<Pruefung> wochenPruefung = new ArrayList<Pruefung>();
//        for (int i = 0; i < pruefungen.size(); i++) {
//            if (Datum.liegtImZeitintervall(start,
//                pruefungen.get(i).stringZuDatum(), 60 * 24 * 7,
//                pruefungen.get(i).getDauer())) {
//                wochenPruefung.add(pruefungen.get(i));
//            }
//        }
//        return wochenPruefung;
//    }
//
//    /**
//     * @return wochenVeranstaltung
//     */
//    public ArrayList<Veranstaltung> wochenVeranstaltung(Date start) {
//
//        ArrayList<Veranstaltung> wochenVeranstaltung =
//            new ArrayList<Veranstaltung>();
//        for (int i = 0; i < veranstaltungen.size(); i++) {
//            if (Datum.liegtImZeitintervall(start,
//                veranstaltungen.get(i).stringZuDatum(), 60 * 24 * 7,
//                veranstaltungen.get(i).getDauer())) {
//                wochenVeranstaltung.add(veranstaltungen.get(i));
//            }
//        }
//        return wochenVeranstaltung;

    /**
     * Der Setter von AktuelleSitzung aktuelleSitzung.
     * 
     * @param aktuelleSitzung
     *            Die AktuelleSitzung vom Typ AktuelleSitzung
     */
    public static void setAktuelleSitzung(AktuelleSitzung aktuelleSitzung) {
        AktuelleSitzung.aktuelleSitzung = aktuelleSitzung;
    }

}
