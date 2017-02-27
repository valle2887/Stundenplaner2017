package daten;
/**
 * Klasse Aufgabe, welche von Termin erbt und eine Deadline fuer die Aufgaben
 * enthaelt.
 *@author Christian Lindenberg
 */
public class Aufgabe extends Termin {

    /**
     * Datum fuer die Deadline der Aufgabe.
     */
    private long deadline;
    
    /**
     * Setter fuer die Deadline der Aufgabe.
     * @param deadline
     * Setzt die deadline einer Aufgabe.
     */
    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }
    
    /**
     * Getter fuer die Deadline der Aufgabe.
     * @return deadline gibt die Deadline der Aufgabe aus.
     */
    public long getDeadline() {
        return deadline;
    }
}
