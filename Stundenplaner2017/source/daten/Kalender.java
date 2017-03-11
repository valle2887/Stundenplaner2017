package daten;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;

/**
 * Ein Kalender speichert alle Termine eines Benutzers ab.
 * 
 * @author Valerian Tjunnikov
 */
public class Kalender {
    /**
     * ArrayListe der Termine.
     */
    private ArrayList<Aufgabe> termine;

    // ------------------------------------------------------------
    public static void veranstaltungHinzufuegen(ArrayList<Aufgabe> aufgaben,
        ArrayList<Pruefung> pruefungen,
        ArrayList<Veranstaltung> veranstaltungen, int zaehler, JTable plan) {
        for (int i = 0; i < veranstaltungen.size(); i++) {
            Veranstaltung veranstaltung = veranstaltungen.get(i);
            boolean kollision = false;

            Calendar start = Calendar.getInstance();
            start.setWeekDate(start.get(Calendar.YEAR),
                start.get(Calendar.WEEK_OF_YEAR) + zaehler, 2);
            start.set(Calendar.HOUR_OF_DAY, 0);
            start.set(Calendar.MINUTE, 0);
            start.set(Calendar.SECOND, 0);
            start.set(Calendar.MILLISECOND, 0);

            Calendar cal = Calendar.getInstance();
            cal.setTime(veranstaltung.stringZuDatum());
            cal.add(Calendar.DAY_OF_YEAR, veranstaltung.getWiederholung());
            Date wiederholung = cal.getTime();

            for (int a = 0; a < aufgaben.size(); a++) {
                if (Datum.liegtImZeitintervall(veranstaltung.stringZuDatum(),
                    aufgaben.get(a).stringZuDatum(), veranstaltung.getDauer(),
                    aufgaben.get(a).getDauer())
                    || Datum.liegtImZeitintervall(wiederholung, aufgaben
                        .get(a).stringZuDatum(), veranstaltung.getDauer(),
                        aufgaben.get(a).getDauer())) {
                    kollision = true;
                    break;
                }
            }

            if (!kollision) {
                for (int p = 0; p < pruefungen.size(); p++) {
                    if (Datum.liegtImZeitintervall(veranstaltung
                        .stringZuDatum(), pruefungen.get(p).stringZuDatum(),
                        veranstaltung.getDauer(), pruefungen.get(p).getDauer())
                        || Datum.liegtImZeitintervall(wiederholung, pruefungen
                            .get(p).stringZuDatum(), veranstaltung.getDauer(),
                            pruefungen.get(p).getDauer())) {
                        kollision = true;
                        break;
                    }
                }
            }
            if (!kollision) {
                for (int v = 0; v < veranstaltungen.size(); v++) {
                    if (i != v) {
                        if (Datum.liegtImZeitintervall(veranstaltung
                            .stringZuDatum(), veranstaltungen.get(v)
                                .stringZuDatum(), veranstaltung.getDauer(),
                            veranstaltungen.get(v).getDauer())
                            || Datum.liegtImZeitintervall(wiederholung,
                                veranstaltungen.get(v).stringZuDatum(),
                                veranstaltung.getDauer(), veranstaltungen
                                    .get(v).getDauer())) {
                            kollision = true;
                            break;
                        }
                    }
                }
            }

            Date datum = veranstaltung.stringZuDatum();
            cal = Calendar.getInstance();
            cal.setTime(datum);
            int wochentag = cal.get(Calendar.DAY_OF_WEEK);
            if (wochentag == 1) {
                wochentag = 7;
            } else {
                wochentag--;
            }

            int zeit = cal.get(Calendar.HOUR_OF_DAY);
            zeit--;
            if (zeit < 0) {
                zeit = 23;
            }

            veranstaltung.setKonflikt(kollision);

            if (Datum.liegtImZeitintervall(start.getTime(),
                veranstaltung.stringZuDatum(), 60 * 24 * 7,
                veranstaltung.getDauer())) {

                if (plan.getValueAt(zeit, wochentag) == null) {
                    plan.setValueAt(veranstaltung, zeit, wochentag);
                } else {
                    plan.setValueAt("Mehrere Termine", zeit, wochentag);
                }

                veranstaltungDarstellen(veranstaltung,
                    veranstaltung.stringZuDatum(), plan);
            }

            if (veranstaltung.getWiederholung() > 0) {

                cal.setTime(wiederholung);
                wochentag = cal.get(Calendar.DAY_OF_WEEK);
                if (wochentag == 1) {
                    wochentag = 7;
                } else {
                    wochentag--;
                }

                zeit = cal.get(Calendar.HOUR_OF_DAY);
                zeit--;
                if (zeit < 0) {
                    zeit = 23;
                }

                if (Datum.liegtImZeitintervall(start.getTime(), wiederholung,
                    60 * 24 * 7, veranstaltung.getDauer())) {

                    if (plan.getValueAt(zeit, wochentag) == null) {
                        plan.setValueAt(veranstaltung, zeit, wochentag);
                    } else {
                        plan.setValueAt("Mehrere Termine", zeit, wochentag);
                    }
                    veranstaltungDarstellen(veranstaltung, wiederholung, plan);
                }
            }
            kollision = false;

        }
    }
}
