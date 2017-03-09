package daten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Klasse Datenverwaltung. Diese ist dafuer da um die Eingaben in eine Datei
 * zuschreiben
 * 
 * @author Rakan Al-Swayyed
 */
public class DatenVerwaltung {
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
     * Speichern von Pr¸fung in Datei.
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

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
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
        // inhaltVonDatei vom datei txt
        String inhaltVonDatei;
        
        File datei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));
        
        while ((inhaltVonDatei = read.readLine()) != null) {
            // wonach er suchen soll. 
            String stichwort = "Aufgabe";
            // bedingung falls stichwort gleich inhaltVonDatei.
            if (inhaltVonDatei.equals(stichwort)) {
                //speichernAufgabenArray hat ein Array der groesse 8    
                for (int daten = 0; daten < 8; daten++) {
                    inhaltVonDatei = read.readLine();
                    aufgabenDaten.add(inhaltVonDatei);
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
        // inhaltVonDatei vom datei txt
        String inhaltVonDatei;
        
        File datei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));
        
        while ((inhaltVonDatei = read.readLine()) != null) {
            // wonach er suchen soll. 
            String stichwort = "Pr¸fung";
            // bedingung falls stichwort gleich inhaltVonDatei.
            if (inhaltVonDatei.equals(stichwort)) {
                //speichernPruefungenArray hat ein Array der groesse 10   
                for (int daten = 0; daten < 10; daten++) {
                    inhaltVonDatei = read.readLine();
                    pruefungenDaten.add(inhaltVonDatei);
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
        // inhaltVonDatei vom datei txt
        String inhaltVonDatei;
        
        File datei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));
        
        while ((inhaltVonDatei = read.readLine()) != null) {
            // wonach er suchen soll. 
            String stichwort = "Veranstaltung";
            // bedingung falls stichwort gleich inhaltVonDatei.
            if (inhaltVonDatei.equals(stichwort)) {
                //speichernVeranstaltungenArray hat ein Array der groesse 12   
                for (int daten = 0; daten < 12; daten++) {
                    inhaltVonDatei = read.readLine();
                    veranstaltungenDaten.add(inhaltVonDatei);
                }  
            }
        }
        read.close();
        return veranstaltungenDaten;
    }
    /**
     * Termin loeschen ob Aufgabe, Pruefung, Veranstaltung.
     * @param benutzerName.
     * @throws IOException .
     * @return geloescht .
     */
    public static boolean aufgabeLoeschen(String benutzerName)
        throws IOException {

        // Erstellt die ArrayList diese wird später mit den Daten gefüllt
        ArrayList<String> benutzerDaten = new ArrayList<String>();

        // Hier muss die Eingabe aus der GUI eingefügt werden
        String typ = "Aufgabe";

        String inhaltVonDatei;
        int index = 0;
        int arrayGroesse;

        // Hier muss der Name des ausgewählten Termins aus der GUI hin
        String name = "Test";

        boolean geloescht = false;

        // Zum Auslesen der Textdatei mit den Benutzerdaten
        File datei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));

        while ((inhaltVonDatei = read.readLine()) != null) {
            benutzerDaten.add(inhaltVonDatei);
        }
        // Größe der ArrayList
        arrayGroesse = benutzerDaten.size();

        // Nummer des gesuchten Begriffs
        index = benutzerDaten.indexOf(name);

        // Wenn der Begriff in der Nummer steht dann wird switch ausgeführt
        if (index > 0 && benutzerDaten.get(index).equals(name)) {

            switch (typ) {
            case "Aufgabe":

                System.out.println("Aufgabe kann gelöscht werden");

                FileWriter speichern =
                    new FileWriter(benutzerName + ".txt", false);
                // Damit auch das Wort Aufgabe + Leerzeile gelöscht wird
                index = index - 2;
                // Es werden 10 Stellen entfernt
                arrayGroesse = arrayGroesse - 10;
                // for-Schleife die die Daten löscht
                for (int i = 0; i <= 8; i++) {
                    benutzerDaten.remove(index);
                }
                // for-Schleife die die ArrayList speichert
                for (int a = 0; a <= arrayGroesse; a++) {
                    speichern.write(benutzerDaten.get(a));
                    speichern.append(System.getProperty("line.separator"));
                }
                geloescht = true;
                speichern.close();
                read.close();
                break;

            case "Prüfung":

                FileWriter speichern1 =
                    new FileWriter(benutzerName + ".txt", false);
                // Damit auch das Wort Prüfung + Leerzeile gelöscht wird
                index = index - 2;
                // Es werden 13 Stellen entfernt
                arrayGroesse = arrayGroesse - 13;
                // for-Schleife die Daten löscht
                for (int i = 0; i <= 12; i++) {
                    benutzerDaten.remove(index);
                }
                // for-Schleife die die ArrayList wieder abspeichert
                for (int a = 0; a <= arrayGroesse; a++) {
                    speichern1.write(benutzerDaten.get(a));
                    speichern1.append(System.getProperty("line.separator"));
                }
                geloescht = true;
                System.out.println("Prüfung gelöscht");
                speichern1.close();
                read.close();
                break;
            case "Veranstaltung":

                FileWriter speichern2 =
                    new FileWriter(benutzerName + ".txt", false);
                // Damit das Wort Veranstaltung + Leerzeile gelöscht wird
                index = index - 2;
                // Es werden 14 Stellen entfernt
                arrayGroesse = arrayGroesse - 14;
                // for-Schleife die die Daten löscht
                for (int i = 0; i <= 13; i++) {
                    benutzerDaten.remove(index);
                }
                // for-Schleife die die ArrayList wieder abspeichert
                for (int a = 0; a <= arrayGroesse; a++) {
                    speichern2.write(benutzerDaten.get(a));
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
    /**
     * 
     */
    public void aufgabeCase() {
        
    }
    /**
     * 
     */
    public void pruefungCase() {
        
    }
    /**
     * 
     */
    public void veranstaltungCase() {
        
    }
    // Der Vorschlag von Dome
    /**
     * @return true.
     * @param termin
     *            es wird ein termin ¸bergeben.
     */
    // public boolean terminLoeschen(Termin termin) {
    // boolean geloescht = false;
    // while (this.termine.remove(termin)) {
    // geloescht = true;
    // }
    // return geloescht;
    // }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * Termin Bearbeiten .
     * @param benutzerName .
     * @param eingabe .
     * @throws IOException .
     */
    public static void termineBearbeiten(String benutzerName, String[] eingabe)
        throws IOException {

        String bezeichnung = eingabe[1];
        String datum = eingabe[2];
        String uhrzeit = eingabe[3];
        String dauer = eingabe[4];
        String kommentar = eingabe[5];
        String wiederholung = eingabe[6];
        String typ = eingabe[7];

        String art = eingabe[0];

        // ArrayList mit den Daten aus der Datei des Benutzers
        ArrayList<String> terminDaten = new ArrayList<String>();

        // inhaltVonDatei der Zeile aus der Textdatei
        String inhaltVonDatei;

        //Name des Termins der bearbeitet werden soll
        String terName = eingabe[1];

        // Zeilennumer
        int index = 0;

        int arrayGroesse;

        // Zum Auslesen der Textdatei mit den Benutzerdaten
        File datei = new File(benutzerName + ".txt");
        BufferedReader read = new BufferedReader(new FileReader(datei));

        // Erstellt ArrayList mit den Daten aus der Textdatei
        while ((inhaltVonDatei = read.readLine()) != null) {
            terminDaten.add(inhaltVonDatei);
        }

        arrayGroesse = terminDaten.size();
        index = terminDaten.indexOf(terName);

        FileWriter speichern = new FileWriter(benutzerName + ".txt", false);

        switch (art) {

        case "Aufgabe":

            terminDaten.set(index, bezeichnung);
            index++;
            terminDaten.set(index, datum);
            index++;
            terminDaten.set(index, uhrzeit);
            index++;
            terminDaten.set(index, dauer);
            index++;
            terminDaten.set(index, kommentar);
            index++;
            terminDaten.set(index, wiederholung);
            index++;
            terminDaten.set(index, typ);

            for (int a = 0; a <= arrayGroesse; a++) {
                speichern.write(terminDaten.get(a));
                speichern.append(System.getProperty("line.separator"));
            }
            speichern.close();
            read.close();
            break;
        case "Prüfung":

            String veranstaltung = eingabe[8];
            String campus = eingabe[9];
            String raum = eingabe[10];

            terminDaten.set(index, bezeichnung);
            index++;
            terminDaten.set(index, datum);
            index++;
            terminDaten.set(index, uhrzeit);
            index++;
            terminDaten.set(index, dauer);
            index++;
            terminDaten.set(index, kommentar);
            index++;
            terminDaten.set(index, wiederholung);
            index++;
            terminDaten.set(index, typ);
            index++;
            terminDaten.set(index, veranstaltung);
            index++;
            terminDaten.set(index, campus);
            index++;
            terminDaten.set(index, raum);

            for (int a = 0; a <= arrayGroesse; a++) {
                speichern.write(terminDaten.get(a));
                speichern.append(System.getProperty("line.separator"));
            }
            speichern.close();
            read.close();
            break;
        case "Veranstaltung":

            String raumNummer = eingabe[8];
            String gebaeude = eingabe[9];
            String dozent = eingabe[10];
            String ects = eingabe[11];

            terminDaten.set(index, bezeichnung);
            index++;
            terminDaten.set(index, datum);
            index++;
            terminDaten.set(index, uhrzeit);
            index++;
            terminDaten.set(index, dauer);
            index++;
            terminDaten.set(index, kommentar);
            index++;
            terminDaten.set(index, wiederholung);
            index++;
            terminDaten.set(index, typ);
            index++;
            terminDaten.set(index, raumNummer);
            index++;
            terminDaten.set(index, gebaeude);
            index++;
            terminDaten.set(index, dozent);
            index++;
            terminDaten.set(index, ects);

            for (int a = 0; a <= arrayGroesse; a++) {
                speichern.write(terminDaten.get(a));
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
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * Export in Excel
     */

    /**
     * Speichern in XLS Foramt
     */

    /**
     * Speichern von Pr¸fung in XLS
     */

    /**
     * Speichern von Aufgaben in XLS
     */

    /**
     * Import
     */
}
