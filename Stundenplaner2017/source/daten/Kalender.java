package daten;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;

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
                aufgaben.get(a);
                aufgaben.get(a);
                if (Datum.liegtImZeitintervall(veranstaltung.stringZuDatum(),
                    aufgaben.get(a).stringZuDatum(), Aufgabe.getDauer(),
                    Aufgabe.getDauer())
                    || Datum.liegtImZeitintervall(wiederholung,
                        aufgaben.get(a).stringZuDatum(), Aufgabe.getDauer(),
                        Aufgabe.getDauer())) {
                    kollision = true;
                    break;
                }
            }

            if (!kollision) {
                for (int p = 0; p < pruefungen.size(); p++) {
                    pruefungen.get(p);
                    pruefungen.get(p);
                    if (Datum.liegtImZeitintervall(
                        veranstaltung.stringZuDatum(),
                        pruefungen.get(p).stringZuDatum(), Aufgabe.getDauer(),
                        Aufgabe.getDauer())
                        || Datum.liegtImZeitintervall(wiederholung,
                            pruefungen.get(p).stringZuDatum(),
                            Aufgabe.getDauer(), Aufgabe.getDauer())) {
                        kollision = true;
                        break;
                    }
                }
            }
            if (!kollision) {
                for (int v = 0; v < veranstaltungen.size(); v++) {
                    if (i != v) {
                        veranstaltungen.get(v);
                        veranstaltungen.get(v);
                        if (Datum.liegtImZeitintervall(
                            veranstaltung.stringZuDatum(),
                            veranstaltungen.get(v).stringZuDatum(),
                            Aufgabe.getDauer(), Aufgabe.getDauer())
                            || Datum.liegtImZeitintervall(wiederholung,
                                veranstaltungen.get(v).stringZuDatum(),
                                Aufgabe.getDauer(), Aufgabe.getDauer())) {
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
                Aufgabe.getDauer())) {

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
                    60 * 24 * 7, Aufgabe.getDauer())) {

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

    /**
     * 
     */
    private static void veranstaltungDarstellen(Veranstaltung veranstaltung,
        Date datum, JTable plan) {
        Calendar cal = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.setTime(datum);

        int stunden = Aufgabe.getDauer() / 60 - 1;

        for (int i = 0; i < stunden; i++) {

            cal.add(Calendar.HOUR_OF_DAY, 1);
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
            if (plan.getValueAt(zeit, wochentag) == null) {
                plan.setValueAt(veranstaltung, zeit, wochentag);
            } else {
                plan.setValueAt("Mehrere Termine", zeit, wochentag);
            }
        }

    }

    /**
     * 
     */
    private static void pruefungDarstellen(Pruefung pruefung, Date datum,
        JTable plan) {
        Calendar cal = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.setTime(datum);

        int stunden = Aufgabe.getDauer() / 60 - 1;

        for (int i = 0; i < stunden; i++) {

            cal.add(Calendar.HOUR_OF_DAY, 1);
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

            if (plan.getValueAt(zeit, wochentag) == null) {
                plan.setValueAt(pruefung, zeit, wochentag);
            } else {
                plan.setValueAt("Mehrere Termine", zeit, wochentag);
            }
        }

    }

    /**
     * 
     */
    public static void speicherTermine() {
        AktuelleSitzung aktuelleSitzung = AktuelleSitzung.getAktuelleSitzung();
        Benutzer benutzer = AktuelleSitzung.getBenutzer();

        try {
            UserVerwaltung.loeschenBenutzer(Benutzer.getUserName());
            DatenVerwaltung.speicherBenutzerdaten(Benutzer.getUserName(),
                Benutzer.getPasswort(), Benutzer.getStudiengang(),
                Benutzer.getECTS());
            ArrayList<Aufgabe> pruefungn = AktuelleSitzung.getAufgabe();
            for (int i = 0; i < pruefungn.size(); i++) {
                Aufgabe pruefung = pruefungn.get(i);
                String[] sAufgabe = new String[7];
                sAufgabe[0] = pruefung.getBezeichnung();
                sAufgabe[1] = pruefung.getDatum();
                sAufgabe[2] = pruefung.getUhrzeit();
                sAufgabe[3] = Aufgabe.getDauer() + "";
                sAufgabe[4] = pruefung.getKommentar();
                sAufgabe[5] = pruefung.getWiederholung() + "";
                sAufgabe[6] = pruefung.getTerminTyp();

                // ...

                DatenVerwaltung.speichernAufagbeArray(sAufgabe,
                    Benutzer.getUserName());
            }

            ArrayList<Pruefung> pruefungen = AktuelleSitzung.getPruefungen();
            for (int i = 0; i < pruefungen.size(); i++) {
                Pruefung pruefung = pruefungen.get(i);
                String[] terminArray = new String[7];
                terminArray[0] = pruefung.getBezeichnung();
                terminArray[1] = pruefung.getDatum();
                terminArray[2] = pruefung.getUhrzeit();
                terminArray[3] = Aufgabe.getDauer() + "";
                terminArray[4] = pruefung.getKommentar();
                terminArray[5] = pruefung.getWiederholung() + "";
                terminArray[6] = pruefung.getTerminTyp();
                // ...
                String[] pruefungArray = new String[3];
                pruefungArray[0] = pruefung.getZugehoerendeVeranstaltung();
                pruefungArray[2] = pruefung.getRaumnummer();

                DatenVerwaltung.speichernPruefungenArray(terminArray,
                    pruefungArray, Benutzer.getUserName());
            }

            ArrayList<Veranstaltung> veranstaltungen =
                AktuelleSitzung.getVeranstaltungen();
            for (int i = 0; i < veranstaltungen.size(); i++) {
                Veranstaltung veranstaltung = veranstaltungen.get(i);

                String[] terminArray = new String[7];
                terminArray[0] = veranstaltung.getBezeichnung();
                terminArray[1] = veranstaltung.getDatum();
                terminArray[2] = veranstaltung.getUhrzeit();
                terminArray[3] = Aufgabe.getDauer() + "";
                terminArray[4] = veranstaltung.getKommentar();
                terminArray[5] = veranstaltung.getWiederholung() + "";
                terminArray[6] = veranstaltung.getTerminTyp();

                // ...
                String[] sVeranstaltung = new String[4];
                sVeranstaltung[0] = veranstaltung.getRaumnummer();
                sVeranstaltung[1] = veranstaltung.getGebaeude();
                sVeranstaltung[2] = veranstaltung.getDozent();
                sVeranstaltung[3] = veranstaltung.getEcts();

                DatenVerwaltung.speichernVeranstungenArray(terminArray,
                    sVeranstaltung, Benutzer.getUserName());
            }

        } catch (IOException exc) {

            exc.printStackTrace();
        }
    }

    /**
     * 
     */

}
