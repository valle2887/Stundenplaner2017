package daten;

import java.util.Calendar;
import java.util.Date;

/** 
 * Klasse Datum.
 * @author Christian Lindenberg
 */
public class Datum {

    /**
     * Methode, welche das aktuelle Datum widergibt.
     * @return datum
     */
    public static Date aktuellesDatum() {
        Calendar kalender = Calendar.getInstance();
        Date datum = kalender.getTime();

        return datum;
        
    }
    /**
     * Methode, welche den aktuellen Tag im Monat angibt.
     * @return tag.
     */
    public static int aktuellerTag() {
        Calendar kalender = Calendar.getInstance();
        int tag = kalender.get(Calendar.DAY_OF_MONTH);
        return tag;
    }
    /**
     * Methode, um dem aktuellen Wochentag zu benennen.
     * @return TagName.
     */
    public static String aktuellerWochenTag() {
        Calendar kalender = Calendar.getInstance();
        int kalenderTag = kalender.get(Calendar.DAY_OF_WEEK);
        String tagName = null;
        
        switch (kalenderTag) {
        case 1:
            tagName = "Sonntag";
            break;
        case 2:
            tagName = "Montag";
            break;
        case 3:
            tagName = "Dienstag";
            break;
        case 4:
            tagName = "Mittwoch";
            break;
        case 5:
            tagName = "Donnerstag";
            break;
        case 6:
            tagName = "Freitag";
            break;
        case 7:
            tagName = "Samstag";
            break;
        default:
            break;
        }
        
        return tagName;
    }
    /**
     * Methode, welche die Monate benennt.
     * @return monatName.
     */
    private static String aktuellerMonat() {
        Calendar kalender = Calendar.getInstance();
        int kalenderMonat = kalender.get(Calendar.MONTH);
        String monatName = null;
        
        switch (kalenderMonat) {
        case 1:
            monatName = "Januar";
            break;
        case 2: 
            monatName = "Februar";
            break;
        case 3:
            monatName = "Maerz";
            break;
        case 4: 
            monatName = "April";
            break;
        case 5:
            monatName = "Mai";
            break;
        case 6:
            monatName = "Juni";
            break;
        case 7:
            monatName = "Juli";
            break;
        case 8:
            monatName = "August";
            break;
        case 9:
            monatName = "September";
            break;
        case 10:
            monatName = "Oktober";
            break;
        case 11:
            monatName = "November";
            break;
        case 12:
            monatName = "Dezember";
            break;
        default:
            break;
        }
        return monatName;
    }
    /**
     * Methode, welche das Jahr wiedergibt.
     * @return kalenderJahr
     */
    public static String aktuellesJahr() {
        Calendar kalender = Calendar.getInstance();
        int kalenderJahr = kalender.get(Calendar.YEAR);
        return kalenderJahr + "";
    }
    /**
     * Gibt die aktuelle Stunde wieder.
     * @return kalenderStd
     */
    public static int aktuelleStunde() {
        Calendar kalender = Calendar.getInstance();
        int kalenderStd = kalender.get(Calendar.HOUR);
        return kalenderStd;
    }
    /**
     * Gibt die aktuelle Minute wieder.
     * @return kalenderMin
     */
    public static int aktuelleMinute() {
        Calendar kalender = Calendar.getInstance();
        int kalenderMin = kalender.get(Calendar.MINUTE);
        return kalenderMin;
    }
    /**
     * Gibt die aktuelle Uhrzeit wieder, welche sich aus std und min 
     * zusammensetzt.
     * @return uhrzeit
     */
    public static String aktuelleUhrzeit() {
        int std = aktuelleStunde();
        int min = aktuelleMinute();
        
        String uhrzeit = std + ":" + min;
        return uhrzeit;
    }
}
