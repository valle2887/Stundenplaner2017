package daten;

public class Pruefung extends Termin {

    private int pruefungsdauer;
    
    private Veranstaltung zugehoerendeVeranstaltung;
    
    
    public int getPruefungsdauer() {
        return pruefungsdauer;
    }


    public void setPruefungsdauer(int pruefungsdauer) {
        this.pruefungsdauer = pruefungsdauer;
    }


    public Veranstaltung getZugehoerendeVeranstaltung() {
        return zugehoerendeVeranstaltung;
    }


    public void setZugehoerendeVeranstaltung(
        Veranstaltung zugehoerendeVeranstaltung) {
        this.zugehoerendeVeranstaltung = zugehoerendeVeranstaltung;
    }



}
