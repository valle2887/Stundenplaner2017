package daten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


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
     * @param scan .
     * @return name, passwort .
     * @throws FileNotFoundException .
     */
    public static boolean vergleichPasswort(Scanner scan,
        String benutzerName, String passwort)
        throws FileNotFoundException {

        String loginName = benutzerName;
        String loginPW = passwort;
        String userName = scan.next();
        String userPW = scan.next();
        
        if (userName.equals(loginName)) {
            scan.close();
            return userPW.equals(loginPW);
        } else {
            return false;
        }
    }
    /**
     * Speichern von Benutzerdaten.
     * @param benutzerName .
     * @param passwort .
     * @param studiengang .
     * @param punkte .
     * @param punkte.
     * @throws IOException .
     */
    
    // String Passwort zu Char[] passwort geändert
    public static void speichernVonBenutzerdaten(String benutzerName, 
        char[] passwort, String studiengang, String punkte) throws IOException {

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
        schreiben.write("Marker: \t\t" + pruefungArray[9]);
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
     * Lese die Benutzerdaten aus die Datei (txt) aus.
     * @param benutzerName vom benutzer der eingelogt ist .
     * @return  gibt ArrayList mit den informationen vom benutzer .
     * @throws IOException  wenn kein zugriff auf die datei .
     */
    public static Benutzer loadBenutzer(String benutzerName) 
        throws IOException {
        //Erstelle benutzerdaten ArrayList 
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
        //benutzerdaten werden in die ArrayListe eingefuegt. 
        String username = benutzerdaten.get(0);
        String passwort = benutzerdaten.get(1);
        String semester = benutzerdaten.get(2);
        String ects = benutzerdaten.get(3);
        String studiengang = benutzerdaten.get(4);
        
        Benutzer benutzer = new Benutzer(username, passwort, semester, ects
            , studiengang);
        // schliesse den reader sonst gibt es ein leak.
        read.close();
        // gebe benutzer informationen zurueck.
        return benutzer; 
    }
    // Anfang  lesen von Aufgabe Daten ++++++++++++++++  
    /**
     * lese die Daten von Aufgabe.
     * @param benutzerName .
     * @return aufgabenDaten .
     * @throws IOException .
     */
    public static ArrayList<String> leseAufgabe(String benutzerName) throws 
    IOException {
        ArrayList<String> aufgabenDaten = new ArrayList<String>();
        // inhalt vom datei txt
        String inhalt;
        
        File dieDatei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(dieDatei));
        
        while ((inhalt = read.readLine()) != null) {
            // wonach er suchen soll. 
            String stichwort = "Aufgabe";
            // bedingung falls stichwort gleich inhalt.
            if (inhalt.equals(stichwort)) {
                //speichernAufgabenArray hat ein Array der groesse 8    
                for (int daten = 0; daten < 8; daten++) {
                    inhalt = read.readLine();
                    aufgabenDaten.add(inhalt);
                } 
            }
        }
        read.close();
        return aufgabenDaten;
    }
    // Anfang  lesen von Pruefung Daten ++++++++++++++++  
    /**
     * lese die Daten von Pruefung.
     * @param benutzerName .
     * @return pruefungenDaten .
     * @throws IOException .
     */

    public static ArrayList<String> lesePruefung(String benutzerName) throws 
    IOException {
        ArrayList<String> pruefungenDaten = new ArrayList<String>();
        // inhalt vom datei txt
        String inhalt;
        
        File dieDatei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(dieDatei));
        
        while ((inhalt = read.readLine()) != null) {
            // wonach er suchen soll. 
            String stichwort = "Prüfung";
            // bedingung falls stichwort gleich inhalt.
            if (inhalt.equals(stichwort)) {
                //speichernPruefungenArray hat ein Array der groesse 10   
                for (int daten = 0; daten < 10; daten++) {
                    inhalt = read.readLine();
                    pruefungenDaten.add(inhalt);
                }  
            }
        }
        read.close();
        return pruefungenDaten;
    }
    // Anfang  lesen von Veranstaltung Daten ++++++++++++++++  
    /**
     * lese die Daten von Veranstaltung.
     * @param benutzerName .
     * @return veranstaltungenDaten .
     * @throws IOException .
     */

    public static ArrayList<String> leseVeranstaltung(String benutzerName) 
        throws IOException {
        ArrayList<String> veranstaltungenDaten = new ArrayList<String>();
        // inhalt vom datei txt
        String inhalt;
        
        File dieDatei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(dieDatei));
        
        while ((inhalt = read.readLine()) != null) {
            // wonach er suchen soll. 
            String stichwort = "Veranstaltung";
            // bedingung falls stichwort gleich inhalt.
            if (inhalt.equals(stichwort)) {
                //speichernVeranstaltungenArray hat ein Array der groesse 12   
                for (int daten = 0; daten < 12; daten++) {
                    inhalt = read.readLine();
                    veranstaltungenDaten.add(inhalt);
                }  
            }
        }
        read.close();
        return veranstaltungenDaten;
    }
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
