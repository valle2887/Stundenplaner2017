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
     * @param zaehler wird uebergeben
     * @return monatName.
     */
    private static String aktuellerMonat(int zaehler) {
        Calendar kalender = Calendar.getInstance();
        kalender.setWeekDate(Calendar.YEAR, Calendar.WEEK_OF_YEAR + zaehler, 2);
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
    /**
     * Methode, welche ueberprueft, ob sich 2 Termine ueberschneiden.
     * @param datumTermin1 ist das Datum, an dem der als erstes zu 
     * ueberpruefende Termin stattfindet.
     * @param datumTermin2 ist das Datum, an dem der als zweites
     * zu ueberpruefende Termin stattfindet.
     * @param dauerTermin1 ist die Dauer, welche der als erstes zu
     * überpruefende Termin hat.
     * @param dauerTermin2 ist die Dauer, welche der als zweites zu
     * ueberpruefende Termin hat.
     * @return ueberschneidung
     */
    public static boolean terminUeberschneidung(Date datumTermin1,
        Date datumTermin2, int dauerTermin1, int dauerTermin2) {
        Calendar kalenderTermin1 = Calendar.getInstance();
        kalenderTermin1.setTime(datumTermin1);
        kalenderTermin1.add(Calendar.MINUTE, dauerTermin1);
        Date endeTermin1 = kalenderTermin1.getTime();
        
        Calendar kalenderTermin2 = Calendar.getInstance();
        kalenderTermin2.setTime(datumTermin2);
        kalenderTermin2.add(Calendar.MINUTE, dauerTermin2);
        Date endeTermin2 = kalenderTermin2.getTime();
        
        boolean ueberschneidung = false;
        
        if (datumTermin1.before(datumTermin2)
            && endeTermin2.before(endeTermin1)) {
            ueberschneidung = true;
        }
        if (datumTermin2.before(datumTermin1)
            && endeTermin1.before(endeTermin2)) {
            ueberschneidung = true;
        }
        
        return ueberschneidung;
        
        
    }
    /**
     * Gibt an ob sich zwei Daten im selben Zeitfenster befinden.
     * 
     * @param datum1 Datum des ersten Termins
     * @param datum2 Datum des zweiten Termins
     * @param dauer1 Dauer des ersten Termins
     * @param dauer2 Dauer des zweiten Termins
     * 
     * @return true wenn beide im Intervall liegen
     */
    public static boolean liegtImZeitintervall(Date datum1, Date datum2,
        int dauer1, int dauer2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(datum1);
        cal1.add(Calendar.MINUTE, dauer1);
        Date ende1 = cal1.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(datum2);
        cal2.add(Calendar.MINUTE, dauer2);
        Date ende2 = cal2.getTime();

        boolean liegtImIntervall = false;

        if (datum1.before(datum2)) {
            if (datum2.before(ende1)) {
                liegtImIntervall = true;
            } else {
                liegtImIntervall = false;
            }

        } else if (datum2.before(datum1)) {
            if (datum1.before(ende2)) {
                liegtImIntervall = true;
            } else {
                liegtImIntervall = false;
            }
        } else {
            liegtImIntervall = true;
        }

        return liegtImIntervall;
    }
}
