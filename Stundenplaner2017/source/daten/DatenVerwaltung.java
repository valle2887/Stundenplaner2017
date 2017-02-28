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

    public boolean vergleichPasswort(String name, String passwort)
        throws FileNotFoundException {

        return false;

    }

    /**
     * Speichern von Benutzerdaten.
     */
    public void speichernVonBenutzerdaten(String name, String passwort,
        String studiengang, int punkte) throws IOException {

        FileWriter schreiben = new FileWriter(name + ".txt", true);

        schreiben.write("Username: \t" + name);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Passwort: \t" + passwort);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Studiengang: \t" + studiengang);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("ECTS: \t" + punkte);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }

    /**
     * Speichern von Terminen in Datei des Eingelogten Benutzers.
     */
    public void speichernAufagbeArray(String[] termineArray, String name)
        throws IOException {

        FileWriter schreiben = new FileWriter(name + ".txt", true);

        schreiben.write("Aufgabe");
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Bezeichnung: \t" + termineArray[0]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Datum: \t" + termineArray[1]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Uhrzeit: \t" + termineArray[2]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dauer: \t" + termineArray[3]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Notiz: \t" + termineArray[4]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(termineArray[5]);
        // Bei Wiederholungen
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Typ: \t" + termineArray[6]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();

    }

    /**
     * Speichern von Veranstaltung in Datei.
     */
    public void speichernVeranstungsArray(String[] termineArray,
        String[] veranstaltungsArray, String name) throws IOException {

        FileWriter schreiben = new FileWriter(name + ".txt", true);

        schreiben.write("Veranstaltung");
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Bezeichnung \t" + termineArray[0]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Datum: \t" + termineArray[1]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Uhrzeit: \t" + termineArray[2]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dauer: \t" + termineArray[3]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Notiz: \t" + termineArray[4]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(termineArray[5]);
        // Bei Wiederholungen
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Typ: \t" + termineArray[6]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Raumnummer: \t" + veranstaltungsArray[0]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Gebaude: \t" + veranstaltungsArray[1]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dozent: \t" + veranstaltungsArray[2]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("ECTS: \t" + veranstaltungsArray[3]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }
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
