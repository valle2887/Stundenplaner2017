package daten;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasse Datenverwaltung. Diese ist dafür da um die Eingaben in eine Datei
 * zuschreiben
 * 
 * @author Valerian Tjunnikov
 */
public class DatenVerwaltung {

    /**
     * Passwort vergleichen.
     */
    
    public boolean vergleichPasswort(String name, String passwort,
        ) throws FileNotFoundException

    /**
     * Speichern von Benutzerdaten
     */
    public void speichernVonBenutzerdaten(String name, String passwort,
        String studiengang, int punkte) throws IOException {
        FileWriter schreiben = new FileWriter(name + ".txt", true);

        schreiben.write(name);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(passwort);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(studiengang);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(punkte);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }

    /**
     * Speichern von Terminen in Datei
     */

    /**
     * Speichern von Veranstaltung in Datei
     */

    /**
     * Speichern von Prüfung in Datei
     */

    /**
     * Löschen der gesamten Daten des Benutzers
     */

    /**
     * Benutzer Bearbeiten
     */

    /**
     * Auslesen der Gesamten Datei
     */

    /**
     * Lesen der Benutzerdaten
     */

    /**
     * Auslesen der Daten von Aufgabe
     */

    /**
     * Auslesen der Daten von Prüfung
     */

    /**
     * Auslesen der Daten von Veranstaltung
     */

    /**
     * Termin löschen
     */
    // Der Vorschlag von Dome
    /**
     * @return true.
     * @param termin
     *            es wird ein termin übergeben.
     */
    // public boolean terminLoeschen(Termin termin) {
    // boolean geloescht = false;
    // while (this.termine.remove(termin)) {
    // geloescht = true;
    // }
    // return geloescht;
    // }

    /**
     * Termin Bearbeiten
     */

    /**
     * Export in Excel
     */

    /**
     * Speichern in XLS Foramt
     */

    /**
     * Speichern von Prüfung in XLS
     */

    /**
     * Speichern von Aufgaben in XLS
     */

    /**
     * Import
     */
}
