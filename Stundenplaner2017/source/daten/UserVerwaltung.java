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
 * 
 * @author Christian Lindenberg
 */

public class UserVerwaltung {

    /**
     * Passwort vergleichen.
     * 
     * @param benutzerName .
     * @param passwort .
     * @param scan .
     * @return name, passwort .
     * @throws FileNotFoundException .
     */

    public static boolean vergleichPasswort(Scanner scan, String benutzerName,
        String passwort) throws FileNotFoundException {

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
     * 
     * @param userName .
     * @param passwort .
     * @param studiengang .
     * @param ects .
     * @param punkte.
     * @throws IOException .
     */
    public static void speichernVonBenutzerdaten(String userName,
        char[] passwort, String studiengang, String ects) throws IOException {

        FileWriter schreiben = new FileWriter(userName + ".txt");

        schreiben.write(userName);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(passwort);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(studiengang);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write(ects);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }

    /**
     * Benutzer Bearbeiten.
     * 
     * @param userName .
     * @param daten .
     * @throws IOException .
     */
    public static void bearbeitenBenutzer(String userName, String[] daten)
        throws IOException {

        ArrayList<String> userDaten = new ArrayList<String>();

        String inhaltVonDatei;
        int arrayGroesse;

        String passwort = daten[0];
        String studiengang = daten[1];
        String ects = daten[2];

        File datei = new File(userName + ".txt");

        BufferedReader read = new BufferedReader(new FileReader(datei));

        while ((inhaltVonDatei = read.readLine()) != null) {
            userDaten.add(inhaltVonDatei);
        }

        userDaten.set(1, passwort);
        userDaten.set(2, studiengang);
        userDaten.set(3, ects);


        arrayGroesse = userDaten.size();
   

        FileWriter write = new FileWriter(userName + ".txt", false);
        for (int a = 0; a < arrayGroesse; a++) {
            write.write(userDaten.get(a));
            write.append(System.getProperty("line.separator"));
        }
        //speichernVonBenutzerdaten(userName, passwort.toCharArray(),
          //  studiengang, ects);
        read.close();
        write.close();
    }
    /**
     * Lese die Benutzerdaten aus der Datei aus.
     * @param userName vom aktuell eingeloggten Benutzer .
     * @return  ArrayList, welche die Informationen des Benutzers enthaelt .
     * @throws IOException  wenn kein zugriff auf die datei .
     * Lese die Benutzerdaten aus die Datei (txt) aus.
     * 
     */
    public static Benutzer loadBenutzer(String userName) throws IOException {
        // Erstelle benutzerdaten ArrayList
        ArrayList<String> benutzerdaten = new ArrayList<String>();

        File datei = new File(userName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));

        // hier werden die daten gelesen und dann in eine ArrayList geschrieben
        // 4 steht fuer benutzername
        String inhaltVonDatei;
        for (int daten = 0; daten < 4; daten++) {
            inhaltVonDatei = read.readLine();
            benutzerdaten.add(inhaltVonDatei);
        }
        // benutzerdaten werden in die ArrayListe eingefuegt.
        String username = benutzerdaten.get(0);
        String passwort = benutzerdaten.get(1);
        String studiengang = benutzerdaten.get(2);
        String ects = benutzerdaten.get(3);

        Benutzer benutzer = new Benutzer(username, passwort, ects, studiengang);
        // schliesse den reader sonst gibt es ein leak.
        read.close();
        // gebe benutzer informationen zurueck.
        return benutzer;
    }

    /**
     * Methode, um den momentan angemeldeten Benutzer zu loeschen.
     * 
     * @param userName wird uebergeben.
     * @return geloescht
     */
    public static boolean loeschenBenutzer(String userName) {
        File file = new File(userName + ".txt");
        boolean geloescht = file.delete();
        return geloescht;
    }
   
}
