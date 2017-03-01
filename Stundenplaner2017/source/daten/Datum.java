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
    
    
}
