package daten;

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
