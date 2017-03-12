package daten;

/**
 * Die Klasse Termin, von welcher die Klassen Aufgabe, Pruefung und
 * Veranstaltung erben. Zeigt die Bezeichnung, einen Kommentar, die Dauer, die
 * Art und die Wiederholbarkeit eines Termins an.
 * 
 * @author Rakan Al-Swayyed
 */
public class Aufgabe extends Termin {

    /**
     * Datum fuer die Deadline der Aufgabe.
     */
    private String deadline;

    /**
     * Setter fuer die Deadline der Aufgabe.
     * 
     * @param deadline
     *            Setzt die deadline einer Aufgabe.
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * Getter fuer die Deadline der Aufgabe.
     * 
     * @return deadline gibt die Deadline der Aufgabe aus.
     */
    public String getDeadline() {
        return deadline;
    }
}