package daten;
/**
 * Die Klasse Termin, von welcher die Klassen Aufgabe, Pruefung und
 * Veranstaltung erben. Zeigt die Bezeichnung, einen Kommentar, die Dauer,
 * die Art und die Wiederholbarkeit eines Termins an.
 *@author Christian Lindenberg
 */
public class Termin {
    
    private String bezeichnung;
    
    private String kommentar;
    
    private int dauer;
    
    
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public enum Typ {
        Studium, Privat;
    }
    
    public enum Wiederholbarkeit {
        Einmalig, Woechentlich;
    }
}
