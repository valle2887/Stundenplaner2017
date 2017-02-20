package daten;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, welche den Benutzer zeigt, seinen Name, sein Passwort, Semester,
 * ECTs, Studiengang, und die personalierte Terminliste.
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

    // muss der Konstruktor leer sein?

    public Benutzer() {

    }

    /**
     * Getter fuer den Usernamen.
     * 
     * @return username Ist der einzugebende Name fuer den Login.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter fuer den Usernamen.
     * 
     * benutzername. Fuer den Login benstaetigt.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter fuer das Passwort.
     * 
     * @return passwort Ist das Passwort, welches vom User festgelegt wurde.
     */
    public String getPasswort() {
        return passwort;
    }

    /**
     * Setter fuer das Passwort.
     * 
     * @param passwort
     *            Fuer den Login bestaetigt.
     */
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    /**
     * Getter fuer die Semesteranzahl des Users.
     * 
     * @return semester
     * 
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Setter fuer Semesteranzahl.
     * 
     * @param semester
     *            Semesteranzahl des Users.
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Getter fuer ECTS.
     * 
     * @return ects Die Credits des Users.
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Setter fuer ECTS.
     * 
     * @param ects
     *            Setzt die ECTS.
     */
    public void setEcts(int ects) {
        this.ects = ects;
    }

    /**
     * Getter fuer Studiengang.
     * 
     * @return Studiengang Der Studiengang des Users
     */
    public String getStudiengang() {
        return studiengang;
    }

    /**
     * Setter fuer Studiengang.
     * 
     * @param studiengang
     *            Setzt die Studiengang.
     */
    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }

    /**
     * Getter fuer ArrayList der Termine.
     * 
     * @return ArrayList der Termine
     *
     */

    public ArrayList<Termin> getTerminliste() {
        return terminListe;
    }

    /**
     * Setter fuer die Terminliste.
     * 
     * @param terminliste
     *            Liste mit den Terminen.
     */
    public void setTerminliste(ArrayList<Termin> terminliste) {
        this.terminListe = terminliste;
    }

    /**
     * @return
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
     * @return Veranstaltung.
     */
    public Pruefung getPruefungFuerVeranstaltung(Veranstaltung veranst) {
        Pruefung gefPruefung = new Pruefung();
        for (Termin termin : terminListe) {
            if (termin instanceof Pruefung && ((Pruefung) termin).getzVeranstaltung() != null
                && ((Pruefung) termin).getzVeranstaltung().equals(veranst)) {
                gefPruefung = (Pruefung) termin;
            } else {
                gefPruefung = null;
            }
        }
        return gefPruefung;
    }

}
