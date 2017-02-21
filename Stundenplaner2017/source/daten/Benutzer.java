package daten;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, welche den Benutzer zeigt, seinen Name, sein Passwort, Semester,
 * ECTs, Studiengang, und die personalierte Terminliste
 */
public class Benutzer {
    /**
     * Name des users
     */
    private String username;
    /** 
     * Passwort des users
     */
    private String passwort;
    /**
     * Semesteranzahl des users
     */
    private int semester;
    /**
     * Credits des users
     */
    private int ects;
    /**
     * Studiengang des users
     */
    private String studiengang;
    /**
     * ArrayList um die Termine des users festzuhalten
     */
    private ArrayList<Termin> terminListe = new ArrayList<Termin>();
    
    /**
     * Klassenkonstruktor
     */
    public Benutzer() {
        
    }
    /** 
     * Getter für den Usernamen
     * @return username 
     * Ist der einzugebende Name für den Login.
    */
    public String getUsername() {
        return username;
    }
    /** Setter für den Usernamen
     * 
     * @param benutzername 
     * Für den Login benötigt.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /** Getter für das Passwort
     * 
     * @return passwort 
     * Ist das Passwort, welches vom User festgelegt wurde.
     */
    public String getPasswort() {
        return passwort;
    }
    /** 
     * Setter für das Passwort
     * @param passwort 
     * Für den Login benötigt.
     */
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    /**
     * Getter für die Semesteranzahl des Users
     * @return semester
     * 
     */
    public int getSemester() {
        return semester;
    }
    /** Setter für Semesteranzahl
     * 
     * @param semester
     * Semesteranzahl des Users.
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }
    /** Getter für ECTS
     * 
     * @return ects
     * Die Credits des Users.
     */
    public int getEcts() {
        return ects;
    }
    public void setEcts(int ects) {
        this.ects = ects;
    }
    public String getStudiengang() {
        return studiengang;
    }
    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }
    public ArrayList<Termin> getTerminliste() {
        return terminListe;
    }
    /**
     * Setter für die Terminliste
     * @param terminliste
     * Liste mit den Terminen.
     */
    public void setTerminliste(ArrayList<Termin> terminliste) {
        this.terminListe = terminliste;
    }
    
    
    public List<Veranstaltung> getVeranstaltungen() {
        List<Veranstaltung> veranstaltungen = new ArrayList<Veranstaltung>();
        for (Termin termin : terminListe) {
            if (termin instanceof Veranstaltung) {
                veranstaltungen.add((Veranstaltung) termin);
            }
        }
        return veranstaltungen;
    }
    
    public Pruefung getPruefungFuerVeranstaltung(Veranstaltung veranst) {
        Pruefung pruefungFuerVer = new Pruefung(); 
        for (Termin termin : terminListe) {
            if (termin instanceof Pruefung
                && ((Pruefung) termin).getZugehoerendeVeranstaltung() 
                != null
                && ((Pruefung) termin).getZugehoerendeVeranstaltung().
                equals(veranst)) {
                pruefungFuerVer = (Pruefung) termin;
            } else {
                pruefungFuerVer = null;
            }
        }
        return pruefungFuerVer;
    }
    
    
    
}
 