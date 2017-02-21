package daten;

/**
 * Klasse um eine Veranstaltung zu erstellen, welche von Termin erbt.
 * @author Christian Lindenberg
 */
public class Veranstaltung extends Termin {

    private String raumnummer;
    
    private String gebaeude;
    
    private String dozent;
    
    private int ects;

    public String getRaumnummer() {
        return raumnummer;
    }

    public void setRaumnummer(String raumnummer) {
        this.raumnummer = raumnummer;
    }

    public String getGebaeude() {
        return gebaeude;
    }

    public void setGebaeude(String gebaeude) {
        this.gebaeude = gebaeude;
    }

    public String getDozent() {
        return dozent;
    }

    public void setDozent(String dozent) {
        this.dozent = dozent;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
}
