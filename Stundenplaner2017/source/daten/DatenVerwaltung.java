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
    // Benutzer Daten loeschen befindet sich in userbearbeitenGUI
    /**
     * Benutzer Aendern.
     * @param benutzerName .
     * @param bDatenGui .
     * @throws IOException .
     */
    public static void benutzerDatenAendern(String benutzerName, 
        String[] bDatenGui) throws IOException {
        
        ArrayList<String> benutzerDaten = new ArrayList<String>();
        
        String inhalt;
        int arrayGroesse;
        
        String passwort = bDatenGui[0];
        String studiengang = bDatenGui[1];
        String punkte = bDatenGui[2];
        
        File dieDatei = new File(benutzerName + ".txt");
        // throws IOException ist notwendig. 
        BufferedReader read = new BufferedReader(new FileReader(dieDatei));
        
        while ((inhalt = read.readLine()) != null) {
            benutzerDaten.add(inhalt);
        }
        // index 0 ist benutzername deshalb fangen wir ab 1 an.
        benutzerDaten.set(1, passwort);
        benutzerDaten.set(2, studiengang);
        benutzerDaten.set(3, punkte);
        
        arrayGroesse = benutzerDaten.size();
        //bei false wird die Datei ueberschrieben
        //bei true wird es drangehaengt die txt
        FileWriter write = new FileWriter(benutzerName + ".txt", false);
        // schleife um die Arrayliste zu durchlaufen
        for (int daten = 0; daten < arrayGroesse; daten++) {
            //schreibe daten wieder neu
            write.write(benutzerDaten.get(daten));
            write.append(System.getProperty("Line.separator"));
        }
        read.close();
        write.close();
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
                for (int daten = 0; daten < 7; daten++) {
                    inhalt = read.readLine();
                    aufgabenDaten.add(inhalt);
                } 
            }
        }
        read.close();
        return aufgabenDaten;
    }
    // Ende  lesen von Aufgabe Daten ++++++++++++++++  

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
    // Ende  lesen von Pruefung Daten ++++++++++++++++  

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
                for (int daten = 0; daten < 11; daten++) {
                    inhalt = read.readLine();
                    veranstaltungenDaten.add(inhalt);
                }  
            }
        }
        read.close();
        return veranstaltungenDaten;
    }

    // Ende lesen von Veranstaltung Daten ++++++++++++++++
    
    // Anfang fuer speichernAufagbeArray++++++++++++++++++++++++++++    
    /**
     * Speichern von Terminen in Datei des Eingelogten Benutzers.
     *@param aufgabeArray .
     *@param benutzerName . 
     *@throws IOException .
     */
    public static void speichernAufagbeArray(String[] aufgabeArray, 
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
        schreiben.write("Gebäude: \t\t" + veranstaltungArray[7]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Raumnummer: \t\t" + veranstaltungArray[8]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Dozent: \t\t" + veranstaltungArray[9]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("ECTS: \t\t" + veranstaltungArray[10]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }
    // Ende fuer speichernVeranstungsArray++++++++++++++++++++++++++++    
    
    // Anfang fuer speichernPruefungenArray++++++++++++++++++++++++++++    
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
        schreiben.write("zugehörige Veranstaltung: \t\t" + pruefungArray[7]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Campus: \t\t" + pruefungArray[8]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.write("Raumnummer: \t\t" + pruefungArray[9]);
        schreiben.append(System.getProperty("line.separator"));
        schreiben.append(System.getProperty("line.separator"));
        schreiben.close();
    }
    // Ende fuer speichernPruefungenArray++++++++++++++++++++++++++++  
    
    // Anfang fuer loesche Termine++++++++++++++++++++++++++++ 
    /**
     * Termine ob Aufgabe, Veranstaltung, Pruefung loeschen.
     * 
     * @param benutzerName
     *            .
     * @return geloescht .
     * @throws IOException
     *             .
     */
    public static boolean loescheTermin(String benutzerName)
        throws IOException {
        boolean geloescht = false;
        ArrayList<String> benutzerDaten = new ArrayList<String>();
        String terminTyp = "Termin";
        String inhalt;
        int daten = 0;
        int arrayGroesse;
        // typBezeichnung ob es
        String typBezeichnung = "TerminTest";

        File dieDatei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(dieDatei));

        while ((inhalt = read.readLine()) != null) {
            benutzerDaten.add(inhalt);
        }
        arrayGroesse = benutzerDaten.size();
        daten = benutzerDaten.indexOf(typBezeichnung);

        if (daten > 0 && benutzerDaten.get(daten).equals(typBezeichnung)) {

            switch (terminTyp) {

            case "Aufgabe":
                System.out.println("Aufgabe kann gelöscht werden");

                FileWriter speichern =
                    new FileWriter(benutzerName + ".txt", false);
                // -2 weil erste index ist beschriftung vom Typ ob Aufgabe oder 
                // Pruefung oder Veranstaltung sehe methode 
                // speichernAufagbeArray.
                daten = daten - 2;
                arrayGroesse = arrayGroesse - 10;
                for (int x = 0; x <= 8; x++) {
                    benutzerDaten.remove(daten);
                }
                for (int y = 0; y <= arrayGroesse; y++) {
                    speichern.write(benutzerDaten.get(y));
                    speichern.append(System.getProperty("line.separator"));
                }
                geloescht = true;
                speichern.close();
                read.close();
                break;
            case "Prüfung":

                FileWriter speichern1 = new FileWriter(benutzerName + ".txt"
                    , false);
                daten = daten - 2;
                arrayGroesse = arrayGroesse - 13;
                for (int x = 0; x <= 12; x++) {
                    benutzerDaten.remove(daten);
                }
                for (int y = 0; y <= arrayGroesse; y++) {
                    speichern1.write(benutzerDaten.get(y));
                    speichern1.append(System.getProperty("line.separator"));
                }
                geloescht = true;
                System.out.println("Prüfung gelöscht");
                speichern1.close();
                read.close();
                break;
            case "Veranstaltung":

                FileWriter speichern2 = new FileWriter(benutzerName + ".txt"
                    , false);
                daten = daten - 2;
                arrayGroesse = arrayGroesse - 14;
                for (int x = 0; x <= 13; x++) {
                    benutzerDaten.remove(daten);
                }
                for (int y = 0; y <= arrayGroesse; y++) {
                    speichern2.write(benutzerDaten.get(y));
                    speichern2.append(System.getProperty("line.separator"));
                }
                geloescht = true;
                speichern2.close();
                read.close();
                break;
            default:
                geloescht = false;
                break;
            }
        }
        return geloescht;
    } 
    // Ende fuer loesche Termine++++++++++++++++++++++++++++ 
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
     * Termin Bearbeiten .
     * @param benutzerName .
     * @param eingabe .
     * @throws IOException .
     */
    public static void terminBearbeiten(String benutzerName, String[] eingabe)
        throws IOException {

        String bezeichnung = eingabe[1];
        String datum = eingabe[2];
        String uhrzeit = eingabe[3];
        String dauer = eingabe[4];
        String notiz = eingabe[5];
        String wiederholung = eingabe[6];
        String kategorie = eingabe[7];
        
        String terminTyp = eingabe[0];

        ArrayList<String> terminDaten = new ArrayList<String>();

        String inhalt;

        //Name des Termins der bearbeitet werden soll
        String terminBezeichnung = eingabe[1];

        int datein = 0;

        int arrayGroesse;

        File datei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));

        while ((inhalt = read.readLine()) != null) {
            terminDaten.add(inhalt);
        }

        arrayGroesse = terminDaten.size();
        datein = terminDaten.indexOf(terminBezeichnung);

        FileWriter speichern = new FileWriter(benutzerName + ".txt", false);

        switch (terminTyp) {

        case "Aufgabe":

            terminDaten.set(datein, bezeichnung);
            datein++;
            terminDaten.set(datein, datum);
            datein++;
            terminDaten.set(datein, uhrzeit);
            datein++;
            terminDaten.set(datein, dauer);
            datein++;
            terminDaten.set(datein, notiz);
            datein++;
            terminDaten.set(datein, wiederholung);
            datein++;
            terminDaten.set(datein, kategorie);


            for (int x = 0; x <= arrayGroesse; x++) {
                speichern.write(terminDaten.get(x));
                speichern.append(System.getProperty("line.separator"));
            }
            speichern.close();
            read.close();
            break;
        case "Prüfung":
            String veranstaltung = eingabe[8];
            String campus = eingabe[9];
            String raum = eingabe[10];

            terminDaten.set(datein, bezeichnung);
            datein++;
            terminDaten.set(datein, datum);
            datein++;
            terminDaten.set(datein, uhrzeit);
            datein++;
            terminDaten.set(datein, dauer);
            datein++;
            terminDaten.set(datein, notiz);
            datein++;
            terminDaten.set(datein, wiederholung);
            datein++;
            terminDaten.set(datein, kategorie);
            datein++;
            terminDaten.set(datein, veranstaltung);
            datein++;
            terminDaten.set(datein, campus);
            datein++;
            terminDaten.set(datein, raum);
            

            for (int x = 0; x <= arrayGroesse; x++) {
                speichern.write(terminDaten.get(x));
                speichern.append(System.getProperty("line.separator"));
            }
            speichern.close();
            read.close();
            break;
        case "Veranstaltung":
            String gebaeude = eingabe[8];
            String raumNr = eingabe[9];
            String dozent = eingabe[10];
            String ects = eingabe[11];
            
            terminDaten.set(datein, bezeichnung);
            datein++;
            terminDaten.set(datein, datum);
            datein++;
            terminDaten.set(datein, uhrzeit);
            datein++;
            terminDaten.set(datein, dauer);
            datein++;
            terminDaten.set(datein, notiz);
            datein++;
            terminDaten.set(datein, wiederholung);
            datein++;
            terminDaten.set(datein, kategorie);
            datein++;
            terminDaten.set(datein, gebaeude);
            datein++;
            terminDaten.set(datein, raumNr);
            datein++;
            terminDaten.set(datein, dozent);
            datein++;
            terminDaten.set(datein, ects);
            

            for (int x = 0; x <= arrayGroesse; x++) {
                speichern.write(terminDaten.get(x));
                speichern.append(System.getProperty("line.separator"));
            }
            speichern.close();
            read.close();
            break;
        default:
            speichern.close();
            read.close();
            break;

        }
    }

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
