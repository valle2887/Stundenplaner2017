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
 * Klasse, die fuer die Daten der Nutzerverwaltung verantworklich ist.
 * @author Christian Lindenberg
 */

public class UserVerwaltung {
    
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
    // String Passwort zu Char[] passwort ge‰ndert
    public static void speichernVonBenutzerdaten(String benutzerName, 
        char[] passwort, String studiengang, String punkte) throws IOException {

        FileWriter schreiben = new FileWriter(benutzerName + ".txt", true);

        schreiben.write(benutzerName);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(passwort);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(studiengang);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(punkte);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }
    // Ende fuer speichernVonBenutzerdaten++++++++++++++++++++++++++++
    /**
     * Benutzer Bearbeiten.
     *@param benutzerName .
     *@param daten . 
     *@throws IOException .
     */
    public static void bearbeitenBenutzer(String benutzerName, String[] daten)
        throws IOException {

        ArrayList<String> benutzerDaten = new ArrayList<String>();

        String inhaltVonDatei;
        int arrayGroesse;

        String passwort = daten[0];
        String studiengang = daten[1];
        String ects = daten[2];

        File datei = new File(benutzerName + ".txt");

        BufferedReader read = new BufferedReader(new FileReader(datei));

        while ((inhaltVonDatei = read.readLine()) != null) {
            benutzerDaten.add(inhaltVonDatei);
        }

        benutzerDaten.set(1, passwort);
        benutzerDaten.set(2, studiengang);
        benutzerDaten.set(3, ects);

        arrayGroesse = benutzerDaten.size();

        // true damit der Text angehängt wird, false(oder ohne)
        // wird die Datei komplett überschrieben
        FileWriter write = new FileWriter(benutzerName + ".txt", false);

        for (int a = 0; a < arrayGroesse; a++) {
            write.write(benutzerDaten.get(a));
            write.append(System.getProperty("line.separator"));
        }

        read.close();
        write.close();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
        
        File datei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));
        
        // hier werden die daten gelesen und dann in eine ArrayList geschrieben
        // 4 steht fuer benutzername
        String inhaltVonDatei;
        for (int daten = 0; daten < 4; daten++) {
            inhaltVonDatei = read.readLine();
            benutzerdaten.add(inhaltVonDatei);
        }
        //benutzerdaten werden in die ArrayListe eingefuegt. 
        String username = benutzerdaten.get(0);
        String passwort = benutzerdaten.get(1);
        String ects = benutzerdaten.get(2);
        String studiengang = benutzerdaten.get(3);
        
        Benutzer benutzer = new Benutzer(username, passwort, ects
            , studiengang);
        // schliesse den reader sonst gibt es ein leak.
        read.close();
        // gebe benutzer informationen zurueck.
        return benutzer; 
    }
}
