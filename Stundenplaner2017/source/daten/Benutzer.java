package daten;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, welche den Benutzer zeigt, seinen Name, sein Passwort, Semester,
 * ECTs, Studiengang, und die personalierte Terminliste.
 * @author Christian Lindenberg
 */
public class Benutzer {
    /**
     * Name des users.
     */
    private String username;
    /** 
     * Passwort des users.
     */
    private String passwort;
    /**
     * Semesteranzahl des users.
     */
    private int semester;
    /**
     * Credits des users.
     */
    private int ects;
    /**
     * Studiengang des users.
     */
    private String studiengang;
    /**
     * ArrayList um die Termine des users festzuhalten.
     */
    private ArrayList<Termin> terminListe = new ArrayList<Termin>();
    
    /**
     * Klassenkonstruktor.
     */
    public Benutzer() {
        
    }
    /**
     * Getter fuer den Usernamen.
     * @return username 
     * Ist der einzugebende Name fuer den Login.
    */
    public String getUsername() {
        return username;
    }
    /** Setter fuer den Usernamen.
     * 
     * @param username 
     * Fuer den Login benötigt.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /** 
     * Getter für das Passwort.
     * @return passwort 
     * Ist das Passwort, welches vom User festgelegt wurde.
     */
    public String getPasswort() {
        return passwort;
    }
    /**
     * Setter fuer das Passwort.
     * @param passwort 
     * Fuer den Login benötigt.
     */
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    /**
     * Getter fuer die Semesteranzahl des Users.
     * @return semester
     * 
     */
    public int getSemester() {
        return semester;
    }
    /** Setter fuer Semesteranzahl.
     * 
     * @param semester
     * Semesteranzahl des Users.
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }
    /** 
     * Getter für ECTS.
     * @return ects
     * Die Credits des Users.
     */
    public int getEcts() {
        return ects;
    }
    
    /**
     * Setter fuer die ECTs.
     * @param ects
     * Die Credits des Users.
     */
    public void setEcts(int ects) {
        this.ects = ects;
    }
    /**
     * Getter fuer den Studiengang.
     * @return studiengang
     */
    public String getStudiengang() {
        return studiengang;
    }
    /**
     * Setter fuer den Studiengang.
     * @param studiengang
     * Der Studiengang des Users
     */
    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }
    /**
     * getter für die Terminliste.
     * @return terminListe
     * Die Terminliste fuer den Benutzer.
     */
    public ArrayList<Termin> getTerminliste() {
        return terminListe;
    }
    /**
     * Setter für die Terminliste.
     * @param terminliste
     * Liste mit den Terminen des Benutzers.
     */
    public void setTerminliste(ArrayList<Termin> terminliste) {
        this.terminListe = terminliste;
    }
    
    
    /**
     * Getter fuer die Liste der Veranstaltungen.
     * @return veranstaltungen
     * Geht zunaechst mit der For-Schleife saemtliche Termine in der Terminliste
     * durch, um dann einem Termin, der eine Veranstaltung ist, auch so 
     * deklarieren zu koennen.
     */
    public List<Veranstaltung> getVeranstaltungen() {
        List<Veranstaltung> veranstaltungen = new ArrayList<Veranstaltung>();
        for (Termin termin : terminListe) {
            if (termin instanceof Veranstaltung) {
                veranstaltungen.add((Veranstaltung) termin);
            }
        }
        return veranstaltungen;
    }
    /**
     * Durchsucht die Terminliste nach Pruefungen, die Veranstaltungen 
     * zugeordnet sind.
     * @param veranst wird uebergeben.
     * @return eine Pruefung die gefunden wurde oder null
     * Ueberprueft zunaechst saemtliche Termine in der Terminliste durch die
     * For-Schleife, ob der Termin eine Pruefung ist. Wenn dem so ist, wird
     * nach der zugehoerigen Veranstaltung gesucht.
     */
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
    /**
     * Gleiche Prozedur wie bei der Veranstaltung, es wird zunaechst eine
     * neue Liste fuer die Aufgaben erstellt und dann bei jedem Termin 
     * ueberprueft, ob der besagte Termin eine Aufgabe ist. Wenn dem so ist,
     * wird in die Liste der Aufgaben eine neue Aufgabe (der besagte Termin) 
     * hinzugefuegt.
     * @return aufgaben
     * werden zurueckgegeben.
     */
    public List<Aufgabe> getAufgaben() {
        List<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
        for (Termin termin : terminListe) {
            if (termin instanceof Aufgabe) {
                aufgaben.add((Aufgabe) termin);
            }
        }
        return aufgaben;
    }
    
    
    
}
 