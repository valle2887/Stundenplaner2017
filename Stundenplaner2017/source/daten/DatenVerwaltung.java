package daten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Klasse Datenverwaltung. Diese ist dafür da um die Eingaben in eine Datei
 * zuschreiben
 * 
 * @author Rakan Al-Swayyed
 */
public class DatenVerwaltung {
    // Anfang fuer speichernVonBenutzerdaten++++++++++++++++++++++++++++    
    /**
     * Passwort vergleichen.
     * @param benutzerName .
     * @param passwort .
     * @return name, passwort .
     * @throws FileNotFoundException .
     */
    public boolean vergleichPasswort(String benutzerName, String passwort)
        throws FileNotFoundException {

        return false;
    }
    /**
     * Speichern von Benutzerdaten.
     * @param benutzerName .
     * @param passwort .
     * @param studiengang .
     * @param punkte .
     * @param punkte.
     * @throws IOException .
     * 
     */
    public static void speichernVonBenutzerdaten(String benutzerName, 
        String passwort, String studiengang, String punkte) throws IOException {

        FileWriter schreiben = new FileWriter(benutzerName + ".txt", true);

        schreiben.write("Username: \t\t" + benutzerName);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Passwort: \t\t" + passwort);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Studiengang: \t\t" + studiengang);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("ECTS: \t\t" + punkte);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }
    // Ende fuer speichernVonBenutzerdaten++++++++++++++++++++++++++++
    
    // Anfang fuer speichernAufagbeArray++++++++++++++++++++++++++++    
    /**
     * Speichern von Terminen in Datei des Eingelogten Benutzers.
     *@param aufgabeArray .
     *@param benutzerName . 
     *@throws IOException .
     */
    public void speichernAufagbeArray(String[] aufgabeArray, 
        String benutzerName) throws IOException {

        FileWriter schreiben = new FileWriter(benutzerName + ".txt", true);

        schreiben.write("Aufgabe");
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Bezeichnung: \t\t" + aufgabeArray[0]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Datum: \t\t" + aufgabeArray[1]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Uhrzeit: \t\t" + aufgabeArray[2]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dauer: \t\t" + aufgabeArray[3]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Notiz: \t\t" + aufgabeArray[4]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Wiederholungen: \t\t" + aufgabeArray[5]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Kategorie: \t\t" + aufgabeArray[6]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Marker: \t\t" + aufgabeArray[7]);
        schreiben.append(System.getProperty("line.separator"));

        schreiben.close();
    }
    // Ende fuer speichernAufagbeArray++++++++++++++++++++++++++++
    
    // Anfang fuer speichernVeranstungsArray++++++++++++++++++++++++++++    
    /**
     * Speichern von Veranstaltung in Datei.
     * @param veranstaltungArray .
     * @param benutzerName .
     * @throws IOException .
     */
    public void speichernVeranstungenArray(String[] veranstaltungArray
        , String benutzerName) throws IOException {

        FileWriter schreiben = new FileWriter(benutzerName + ".txt", true);

        schreiben.write("Veranstaltung");
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Bezeichnung \t\t" + veranstaltungArray[0]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Datum: \t\t" + veranstaltungArray[1]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Uhrzeit: \t\t" + veranstaltungArray[2]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dauer: \t\t" + veranstaltungArray[3]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Notiz: \t\t" + veranstaltungArray[4]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Wiederholungen: \t\t" + veranstaltungArray[5]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Kategorie: \t\t" + veranstaltungArray[6]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Campus: \t\t" + veranstaltungArray[7]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Raumnummer: \t\t" + veranstaltungArray[8]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dozent: \t\t" + veranstaltungArray[9]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("ECTS: \t\t" + veranstaltungArray[10]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Marker: \t\t" + veranstaltungArray[11]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }
    // Ende fuer speichernVeranstungsArray++++++++++++++++++++++++++++    

    /**
     * Speichern von Prüfung in Datei.
     * @param pruefungArray .
     * @param benutzerName .
     * @throws IOException .
     */
    public void speichernPruefungenArray(String[] pruefungArray
        , String benutzerName) throws IOException {

        FileWriter schreiben = new FileWriter(benutzerName + ".txt", true);

        schreiben.write("Pruefung");
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Bezeichnung \t\t" + pruefungArray[0]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Datum: \t\t" + pruefungArray[1]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Uhrzeit: \t\t" + pruefungArray[2]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dauer: \t\t" + pruefungArray[3]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Notiz: \t\t" + pruefungArray[4]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Wiederholungen: \t\t" + pruefungArray[5]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Kategorie: \t\t" + pruefungArray[6]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Campus: \t\t" + pruefungArray[7]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Raumnummer: \t\t" + pruefungArray[8]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Marker: \t\t" + pruefungArray[11]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }

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
     * Lese die Benutzerdaten.
     * @param benutzerName .
     * @return  .
     * @throws IOException .
     */
    public static Benutzer loadBenutzer(String benutzerName) 
        throws IOException {
        ArrayList<String> benutzerdaten = new ArrayList<String>();
        

        
        File dieDatei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(dieDatei));
        
        // hier werden die daten gelesen und dann in eine ArrayList geschrieben
        // 4 steht fuer benutzername
        String inhalt;
        for (int daten = 0; daten < 4; daten++) {
            inhalt = read.readLine();
            benutzerdaten.add(inhalt);
        }
        Benutzer benutzer = new Benutzer(name, passwort, studiengang, gesamtPunkteECTS);
        
        read.close();
        
        return benutzer;
        
    }
    /**
     * lese die Daten von Aufgabe
     */
    

    /**
     * lese due Daten von Prüfung
     */

    /**
     * lese die Daten von Veranstaltung
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
