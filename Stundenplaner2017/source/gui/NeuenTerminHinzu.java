package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import daten.AktuelleSitzung;
import daten.Aufgabe;
import daten.Benutzer;
import daten.DatenVerwaltung;
import daten.Veranstaltung;
import daten.Pruefung;
import daten.Aufgabe.Markierung;
import daten.Aufgabe.Typ;
import daten.Aufgabe.Wiederholbarkeit;

/**
 * Die Klasse ist dazu da um neue Termine Hinzuzufuegen.
 * 
 * @author Rakan Al-Swayyed
 */
public class NeuenTerminHinzu extends JFrame implements ActionListener {
    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = 5043569320233706529L;

    /**
     * Label lTerminTyp.
     */
    private JLabel lTerminTyp = new JLabel("Termin Typ wählen:");

    /**
     * JButtongroupe bgTerminTyp.
     */
    private ButtonGroup bgTerminTyp = new ButtonGroup();

    /**
     * JRadioButton rbVeran.
     */
    private JRadioButton rbVeran = new JRadioButton("Veranstaltung");

    /**
     * JRadioButton rbAufg.
     */
    private JRadioButton rbAufg = new JRadioButton("Aufgabe");

    /**
     * JRadioButton rbPruef.
     */
    private JRadioButton rbPruef = new JRadioButton("Pruefung");

    /**
     * Label lBezeichnung.
     */
    private JLabel lBezeichnung = new JLabel("Bezeichnung:");

    /**
     * JTextField tBezeichnung.
     */
    private JTextField tBezeichnung = new JTextField(20);

    /**
     * Label lKategorie.
     */
    private JLabel lKategorie = new JLabel("Kategorie:");

    /**
     * JComboBox cbKategorie hat was von enum Typ.
     */
    // private JComboBox<Object> cbKategorie =
    // new JComboBox<Object>(arrayKategorie);
    private JComboBox<Typ> cbKategorie =
        new JComboBox<Aufgabe.Typ>(Aufgabe.Typ.values());

    /**
     * Label lDatum.
     */
    private JLabel lDatum = new JLabel("Datum:");

    /**
     * Array arrayTag mit 31 tage.
     */
    private String[] arrayTag = {"", "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

    /**
     * JComboBox cbTag.
     */
    private JComboBox<Object> cbTag = new JComboBox<Object>(arrayTag);

    /**
     * Array arrayMonat mit 12 Monate.
     */
    private String[] arrayMonat =
        {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    /**
     * JComboBox cbMonat.
     */
    private JComboBox<Object> cbMonat = new JComboBox<Object>(arrayMonat);

    /**
     * Array arrayJahr mit 6 Jahre.
     */
    private String[] arrayJahr =
        {"", "2017", "2018", "2019", "2020", "2021", "2022"};

    /**
     * JComboBox cbJahr.
     */
    private JComboBox<Object> cbJahr = new JComboBox<Object>(arrayJahr);

    /**
     * Label lPkt1.
     */
    private JLabel lPkt1 = new JLabel(".");

    /**
     * Label lPkt2.
     */
    private JLabel lPkt2 = new JLabel(".");

    /**
     * Label lPkt3.
     */
    private JLabel lPkt3 = new JLabel(".");

    /**
     * Label lPkt4.
     */
    private JLabel lPkt4 = new JLabel(".");

    /**
     * Label lUhrzeit.
     */
    private JLabel lUhrzeit = new JLabel("Uhrzeit:");

    /**
     * Label lDpkt.
     */
    private JLabel lDpkt = new JLabel(":");

    /**
     * Array arrayStd mit 24 Stunden.
     */
    private String[] arrayStd = {"", "0", "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
        "20", "21", "22", "23" };

    /**
     * JComboBox cbStunden.
     */
    private JComboBox<Object> cbStunden = new JComboBox<Object>(arrayStd);

    /**
     * Array arrayMinuten mit 15 minuten Intervall.
     */
    private String[] arrayMinuten = {"", "0", "15", "30", "45" };

    /**
     * JComboBox cbMinuten.
     */
    private JComboBox<Object> cbMinuten = new JComboBox<Object>(arrayMinuten);

    /**
     * JLabel lDeadline.
     */
    private JLabel lDeadline = new JLabel("Deadline:");

    /**
     * Array arrayTagDeadL mit 31 tage.
     */
    private String[] arrayTagDeadL =
        {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
            "24", "25", "26", "27", "28", "29", "30", "31" };

    /**
     * JComboBox cbTagDeadL.
     */
    private JComboBox<Object> cbTagDeadL = new JComboBox<Object>(arrayTagDeadL);

    /**
     * Array arrayMonatDeadL mit 12 Monate.
     */
    private String[] arrayMonatDeadL =
        {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

    /**
     * JComboBox cbMonatDeadL.
     */
    private JComboBox<Object> cbMonatDeadL =
        new JComboBox<Object>(arrayMonatDeadL);

    /**
     * Array arrayJahrDeadL mit 6 Jahre.
     */
    private String[] arrayJahrDeadL =
        {"", "2017", "2018", "2019", "2020", "2021", "2022" };

    /**
     * JComboBox cbJahrDeadL.
     */
    private JComboBox<Object> cbJahrDeadL =
        new JComboBox<Object>(arrayJahrDeadL);

    /**
     * Label lNotiz.
     */
    private JLabel lNotiz = new JLabel("Notiz:");

    /**
     * JTextArea tNotiz.
     */
    private JTextArea tNotiz = new JTextArea(5, 20);

    /**
     * Label lWiederh.
     */
    private JLabel lWiederh = new JLabel("      wiederholung:");
    /**
     * JButtongroupe bgWieder.
     */
    // private ButtonGroup bgWieder = new ButtonGroup();
    /**
     * JRadioButton rbJa.
     */
    // private JRadioButton rbJa = new JRadioButton("nein");
    /**
     * JRadioButton rbNein.
     */
    // private JRadioButton rbNein = new JRadioButton("ja");
    /**
     * arrayWieOft brauchen wir nicht mehr..
     */

    // private String[] arrayWieOft = {"", "Einmalig", "Taglich", "Wöchenlich",
    // "Monatlich"};
    /**
     * JComboBox cbWieOft hat was von enum Wiederholbarkeit ob einmalig,
     * wochenlich.
     */
    private JComboBox<Wiederholbarkeit> cbWieOft =
        new JComboBox<Aufgabe.Wiederholbarkeit>(
            Aufgabe.Wiederholbarkeit.values());

    // private JComboBox<Object> cbWieOft = new JComboBox<Object>(arrayWieOft);
    /**
     * Label lMarker.
     */
    private JLabel lMarker = new JLabel("Marker:");

    /**
     * Array arrayMarker.
     */
    // private String[] arrayMarker =
    // {"", "noch nicht", "noch nicht", "noch nicht", "noch nicht"};
    // marken noch nicht fertig
    /**
     * JComboBox cbMarker fuer marken.
     */
    // private JComboBox<Object> cbMarker = new JComboBox<Object>(arrayMarker);
    private JComboBox<Markierung> cbMarker =
        new JComboBox<Aufgabe.Markierung>(Aufgabe.Markierung.values());

    /**
     * Array arrayDauer.
     */
    private String[] arrayDauer = {"", "30", "60", "90", "120", "240" };

    /**
     * JComboBox cbDauer.
     */
    private JComboBox<Object> cbDauer = new JComboBox<Object>(arrayDauer);

    /**
     * Label lMin.
     */
    private JLabel lMin = new JLabel("min");

    /**
     * Label lDauer.
     */
    private JLabel lDauer = new JLabel("Dauer:");

    /**
     * Label lEcts.
     */
    private JLabel lEcts = new JLabel("      ECTS:");

    /**
     * JTextField tEcts.
     */
    private JTextField tEcts = new JTextField(3);

    /**
     * Label lDozent.
     */
    private JLabel lDozent = new JLabel("      Dozent:");

    /**
     * JTextField tDozent.
     */
    private JTextField tDozent = new JTextField(20);

    /**
     * Label lGebaeude.
     */
    private JLabel lGebaeude = new JLabel("      Gebäude:");

    /**
     * JTextField tGebaeude.
     */
    private JTextField tGebaeude = new JTextField(20);

    /**
     * Label lZugehoerigV .
     */
    private JLabel lZugehoerigV = new JLabel("    Zugehörige Veranstaltung:");

    /**
     * JTextField tZugehoerigV.
     */
    private JTextField tZugehoerigV = new JTextField(20);

    /**
     * Label lRaum.
     */
    private JLabel lRaum = new JLabel("      Raum:    ");

    /**
     * JTextField tRaum.
     */
    private JTextField tRaum = new JTextField(20);

    /**
     * JButton speichern.
     */
    private JButton speichern = new JButton("Speichern");

    /**
     * JButtongroupe p1.
     */
    private JPanel p1 = new JPanel();

    /**
     * JPanel p2.
     */
    private JPanel p2 = new JPanel();

    /**
     * JPanel p3.
     */
    private JPanel p3 = new JPanel();

    /**
     * JPanel p4 .
     */
    private JPanel p4 = new JPanel();

    /**
     * JPanel p5 .
     */
    private JPanel p5 = new JPanel();

    /**
     * JPanel p6 .
     */
    private JPanel p6 = new JPanel();

    /**
     * Konstruktor der Klasse NeuenTerminHinzu .
     */
    public NeuenTerminHinzu() {
        setTitle("Termin Hinzufügen");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 1));
        setResizable(false);
        setLocationRelativeTo(null);
        // methode um Panel Zu Konstruktor fuegen wegen platz mangel
        // ausgelagert.
        fuegePanelZuKonstruktor();

        // methode fehlerDialog zeigt MessageDialog falls was nicht ausgefüllt
        // wurde und wenn alles vollständig ist dann soll er Termin speichern.
        fehlerDialog();
        // methode um daten zu speichern.
        // allesSpeichern();

        pack();
        setVisible(true);
    }

    /**
     * .
     */
    public void fuegePanelZuKonstruktor() {
        // RadioButtons werden zu p1 zugewiesen.
        p1.add(lTerminTyp);
        p1.add(rbAufg);
        p1.add(rbVeran);
        p1.add(rbPruef);
        bgTerminTyp.add(rbVeran);
        bgTerminTyp.add(rbAufg);
        bgTerminTyp.add(rbPruef);
        rbAufg.addActionListener(this);
        rbVeran.addActionListener(this);
        rbPruef.addActionListener(this);

        p2.add(lBezeichnung);
        p2.add(tBezeichnung);
        p2.add(lEcts);
        p2.add(tEcts);
        p2.add(lKategorie);
        p2.add(cbKategorie);
        // Datum
        p2.add(lDatum);
        p2.add(cbTag);
        p2.add(lPkt1);
        p2.add(cbMonat);
        p2.add(lPkt2);
        p2.add(cbJahr);
        // Deadline
        p3.add(lDeadline);
        p3.add(cbTagDeadL);
        p3.add(lPkt3);
        p3.add(cbMonatDeadL);
        p3.add(lPkt4);
        p3.add(cbJahrDeadL);
        // Uhrzeit
        p3.add(lUhrzeit);
        p3.add(cbStunden);
        p3.add(lDpkt);
        p3.add(cbMinuten);
        p3.add(lDauer);
        p3.add(cbDauer);
        p3.add(lMin);
        p3.add(lWiederh);
        p3.add(cbWieOft);
        // p3.add(rbNein);
        // p3.add(rbJa);
        // bgWieder.add(rbNein);
        // bgWieder.add(rbJa);
        p4.add(lDozent);
        p4.add(tDozent);
        p4.add(lGebaeude);
        p4.add(tGebaeude);
        p4.add(lRaum);
        p4.add(tRaum);
        p5.add(lMarker);
        p5.add(cbMarker);
        p5.add(lZugehoerigV);
        p5.add(tZugehoerigV);
        p5.add(lNotiz);
        p5.add(tNotiz);
        p6.add(speichern);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
    }

    /**
     * prueft welche von den drei radiobutton ausgewaehlt wurde.
     * 
     * @param action
     *            .
     */
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == rbAufg) {
            sichtbarkeitAufgabe();
            repaint();
        } else if (action.getSource() == rbVeran) {
            sichtbarkeitVeranstaltung();
            repaint();
        } else if (action.getSource() == rbPruef) {
            sichtbarkeitPruefung();
            repaint();
        }
    }

    /**
     * macht felder sichtbar fuer termin Typ Aufgabe.
     */
    public void sichtbarkeitAufgabe() {
        lDauer.setVisible(true);
        cbDauer.setVisible(true);
        lMin.setVisible(true);
        lGebaeude.setVisible(false);
        tGebaeude.setVisible(false);
        lRaum.setVisible(false);
        tRaum.setVisible(false);
        lDozent.setVisible(false);
        tDozent.setVisible(false);
        lEcts.setVisible(false);
        tEcts.setVisible(false);
        lBezeichnung.setVisible(true);
        tBezeichnung.setVisible(true);
        lKategorie.setVisible(true);
        cbKategorie.setVisible(true);
        // Datum
        lDatum.setVisible(true);
        lPkt1.setVisible(true);
        lPkt2.setVisible(true);
        cbTag.setVisible(true);
        cbMonat.setVisible(true);
        cbJahr.setVisible(true);
        // Deadline
        lDeadline.setVisible(true);
        lPkt3.setVisible(true);
        lPkt4.setVisible(true);
        cbTagDeadL.setVisible(true);
        cbMonatDeadL.setVisible(true);
        cbJahrDeadL.setVisible(true);
        // Uhrzeit
        lUhrzeit.setVisible(true);
        cbStunden.setVisible(true);
        lDpkt.setVisible(true);
        cbMinuten.setVisible(true);
        lWiederh.setVisible(true);
        // rbNein.setVisible(true);
        // rbJa.setVisible(true);
        cbWieOft.setVisible(true);
        lMarker.setVisible(true);
        cbMarker.setVisible(true);
        lNotiz.setVisible(true);
        tNotiz.setVisible(true);
        lZugehoerigV.setVisible(false);
        tZugehoerigV.setVisible(false);
    }

    /**
     * macht felder sichtbar fuer termin Typ Veranstaltung.
     */
    public void sichtbarkeitVeranstaltung() {
        lDauer.setVisible(true);
        cbDauer.setVisible(true);
        lMin.setVisible(true);
        lGebaeude.setVisible(true);
        tGebaeude.setVisible(true);
        lRaum.setVisible(true);
        tRaum.setVisible(true);
        lDozent.setVisible(true);
        tDozent.setVisible(true);
        lEcts.setVisible(true);
        tEcts.setVisible(true);
        lBezeichnung.setVisible(true);
        tBezeichnung.setVisible(true);
        lKategorie.setVisible(true);
        cbKategorie.setVisible(true);
        // Datum
        lDatum.setVisible(true);
        cbTag.setVisible(true);
        lPkt1.setVisible(true);
        lPkt2.setVisible(true);
        cbMonat.setVisible(true);
        cbJahr.setVisible(true);
        // Deadline
        lDeadline.setVisible(false);
        lPkt3.setVisible(false);
        lPkt4.setVisible(false);
        cbTagDeadL.setVisible(false);
        cbMonatDeadL.setVisible(false);
        cbJahrDeadL.setVisible(false);
        // Uhrzeit
        lUhrzeit.setVisible(true);
        cbStunden.setVisible(true);
        lDpkt.setVisible(true);
        cbMinuten.setVisible(true);
        lWiederh.setVisible(true);
        // rbNein.setVisible(true);
        // rbJa.setVisible(true);
        cbWieOft.setVisible(true);
        lMarker.setVisible(true);
        cbMarker.setVisible(true);
        lNotiz.setVisible(true);
        tNotiz.setVisible(true);
        lZugehoerigV.setVisible(false);
        tZugehoerigV.setVisible(false);
    }

    /**
     * macht felder sichtbar fuer termin Typ Pruefung.
     */
    public void sichtbarkeitPruefung() {
        lDauer.setVisible(true);
        cbDauer.setVisible(true);
        lMin.setVisible(true);
        lGebaeude.setVisible(true);
        tGebaeude.setVisible(true);
        lRaum.setVisible(true);
        tRaum.setVisible(true);
        lDozent.setVisible(false);
        tDozent.setVisible(false);
        lEcts.setVisible(false);
        tEcts.setVisible(false);
        lBezeichnung.setVisible(true);
        tBezeichnung.setVisible(true);
        lKategorie.setVisible(true);
        cbKategorie.setVisible(true);
        // Datum
        lDatum.setVisible(true);
        cbTag.setVisible(true);
        lPkt1.setVisible(true);
        lPkt2.setVisible(true);
        cbMonat.setVisible(true);
        cbJahr.setVisible(true);
        // Deadline
        lDeadline.setVisible(false);
        lPkt3.setVisible(false);
        lPkt4.setVisible(false);
        cbTagDeadL.setVisible(false);
        cbMonatDeadL.setVisible(false);
        cbJahrDeadL.setVisible(false);
        // Uhrzeit
        lUhrzeit.setVisible(true);
        cbStunden.setVisible(true);
        lDpkt.setVisible(true);
        cbMinuten.setVisible(true);
        lWiederh.setVisible(false);
        // rbNein.setVisible(true);
        // rbJa.setVisible(true);
        cbWieOft.setVisible(false);
        lMarker.setVisible(true);
        cbMarker.setVisible(true);
        lNotiz.setVisible(true);
        tNotiz.setVisible(true);
        lZugehoerigV.setVisible(true);
        tZugehoerigV.setVisible(true);
    }

    /**
     * methoden aufgabeGewaehlt, pruefGewaehlt, veranGewaehlt ausgelagert da
     * sonst checkstyle fehler methode > 70 zeilen.
     */
    private void fehlerDialog() {
        speichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Termin Typ
                if (!rbAufg.isSelected() && !rbVeran.isSelected()
                    && !rbPruef.isSelected()) {
                    JOptionPane.showMessageDialog(null,
                        "Termin Typ: muss gewaehlt werden", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                } else if (rbAufg.isSelected()) {
                    // methode wenn aufgabeGewaehlt worde.
                    aufgabeGewaehlt();
                } else if (rbPruef.isSelected()) {
                    // methode wenn pruefungGewaehlt worde.
                    pruefGewaehlt();
                } else {
                    // methode wenn veranstaltungGewaehlt worde.
                    veranGewaehlt();
                }
            }
        });
    }

    /**
     * speichern von aufgabe. noch nicht fertig wegen die Klasse
     * AktuelleSitzung.
     */
    //++++++++++++++++++++++++++++++++++
    public void aufgabeSpeichern() {

        Aufgabe aufgabe = new Aufgabe();
        
        //fuer Bezeichnung holen und deklarieren.
        String bezeichnung = tBezeichnung.getText();
        aufgabe.setBezeichnung(bezeichnung);
        
        //fuer Kategorie holen und deklarieren.
        Typ kategorie = (Typ) cbKategorie.getSelectedItem();
        aufgabe.setTerminTyp(kategorie);
        
        //fuer Datum tag, monat, jahr holen und deklarieren.
        Object tag = cbTag.getSelectedItem();
        Object monat = cbMonat.getSelectedItem();
        Object jahr = cbJahr.getSelectedItem();
        aufgabe.setDatum(tag + "." + monat + "." + jahr);
        
        //fuer Deadline tag, monat, jahr holen und deklarieren.
        Object deadlineTag = cbTagDeadL.getSelectedItem();
        Object deadlineMonat = cbMonatDeadL.getSelectedItem();
        Object deadlineJahr = cbJahrDeadL.getSelectedItem();
        aufgabe.setDatum(deadlineTag + "." + deadlineMonat 
            + "." + deadlineJahr);
        
        //fuer Uhrzeit stunden, minuten holen und deklarieren.
        Object stunden = cbStunden.getSelectedItem();
        Object minuten = cbMinuten.getSelectedItem();
        aufgabe.setUhrzeit(stunden + ":" + minuten);
        
        //fuer Dauer in minuten.
        String dauer = (String) cbDauer.getSelectedItem();
        aufgabe.setDauer(dauer);
        
        // fuer wiederholung
        Wiederholbarkeit wiederholung =
            (Wiederholbarkeit) cbWieOft.getSelectedItem();
        aufgabe.setWiederholbarkeitTermin(wiederholung);
        
        //fuer Marker
        Object marker = cbMarker.getSelectedItem() + "";
        aufgabe.setMarkierung(marker);
        
        //fuer Notiz
        String notiz = tNotiz.getText();
        aufgabe.setKommentar(notiz);
        
        AktuelleSitzung aktuelleSitzung = AktuelleSitzung.getAktuelleSitzung();
        aktuelleSitzung.setAufgabe(aufgabe);
    }

    /**
     * speichern von veranstaltung . noch nicht fertig wegen der Klasse
     * AktuelleSitzung.
     */
    public void veranstaltungSpeichern() {
       
        AktuelleSitzung aktuelleSitzung = AktuelleSitzung.getAktuelleSitzung();
        Aufgabe aufgabe = aktuelleSitzung.getAufgabe();
        
        Veranstaltung veranstaltung = new Veranstaltung();
        
        veranstaltung.setBezeichnung(aufgabe.getBezeichnung());
        veranstaltung.setDatum(aufgabe.getDatum());
        veranstaltung.setDauer(aufgabe.getDauer());
        veranstaltung.setKommentar(aufgabe.getKommentar());
        veranstaltung.setTerminTyp(aufgabe.getTerminTyp());
        veranstaltung.setUhrzeit(aufgabe.getUhrzeit());
        veranstaltung
            .setWiederholbarkeitTermin(aufgabe.getWiederholbarkeitTermin());
        
        String gebaeude = tGebaeude.getText();
        veranstaltung.setGebaeude(gebaeude);

        String raumnummer = tRaum.getText();
        veranstaltung.setRaumnummer(raumnummer);

        String dozent = tDozent.getText();
        veranstaltung.setDozent(dozent);

        String ects = tEcts.getText();
        veranstaltung.setEcts(ects);
        

        aktuelleSitzung.setVeranstaltung(veranstaltung);
    }

    // Hier kann erst weitergearbeitet werden, wenn die
    // KalenderGui und AktuelleSitzung fertig sind

    /**
     * speichern von pruefung noch nicht fertig wegen die Klasse
     * AktuelleSitzung.
     */
    public void pruefungSpeichern() {

        AktuelleSitzung aktuelleSitzung = AktuelleSitzung.getAktuelleSitzung();
        Aufgabe aufgabe = aktuelleSitzung.getAufgabe();
        
        Pruefung pruefung = new Pruefung();
        
        pruefung.setBezeichnung(aufgabe.getBezeichnung());
        pruefung.setDatum(aufgabe.getDatum());
        pruefung.setDauer(aufgabe.getDauer());
        pruefung.setKommentar(aufgabe.getKommentar());
        pruefung.setTerminTyp(aufgabe.getTerminTyp());
        pruefung.setUhrzeit(aufgabe.getUhrzeit());
        pruefung
            .setWiederholbarkeitTermin(aufgabe.getWiederholbarkeitTermin());
        
        String gebaeude = tGebaeude.getText();
        pruefung.setGebaeude(gebaeude);

        String raumnummer = tRaum.getText();
        pruefung.setRaumnummer(raumnummer);

        String zugehoerigVeranstaltung = tZugehoerigV.getText();
        pruefung.setZugehoerendeVeranstaltung(zugehoerigVeranstaltung);
        
        aktuelleSitzung.setPruefung(pruefung);
    }

    /**
     * JRadioButton rbAufg wenn gewaehlt dann soll er ueberpruefen ob die felder
     * gewaehlt wurden wenn ja soll der fenster schliessen und speichern.
     */
    public void aufgabeGewaehlt() {
        // Bezeichnung
        if (tBezeichnung.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Bezeichnung: darf nicht leer sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // Katehorie
        } else if (cbKategorie.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Kategorie: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Datum
        } else if (cbTag.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Tag muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbMonat.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Monat muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbJahr.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Jahr muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // DeadLine
        } else if (cbTagDeadL.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Deadline: Tag muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbMonatDeadL.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Deadline: Monat muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbJahrDeadL.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Deadline: Jahr muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // uhrzeit
        } else if ((cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() != 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if ((cbStunden.getSelectedIndex() != 0
            && cbMinuten.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Minuten muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden und " + "Minuten müssen gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Dauer
        } else if (cbDauer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Dauer: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // zum speichern! noch nicht fertig
        } else {

            aufgabeSpeichern();
            
            try {
                AktuelleSitzung aktuelleSitzung =
                    AktuelleSitzung.getAktuelleSitzung();
                
                aktuelleSitzung.aufgHinzu(aktuelleSitzung.getAufgabe());

                DatenVerwaltung.speichernAufagbeArray(
                    aktuelleSitzung.getAufgabe().terminarray(),
                    Benutzer.getUserName());
                
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, "Kein Datenzugriff!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Aufgabe Gespeichert",
                "INFORMATION!", JOptionPane.WARNING_MESSAGE);

            NeuenTerminHinzu.this.setVisible(false);
            NeuenTerminHinzu.this.dispose();
            new KalenderGui();
        }
    }

    /**
     * JRadioButton rbPruef wenn gewaehlt dann soll er ueberpruefen ob die
     * felder gewaehlt wurden wenn ja soll der fenster schliessen und speichern.
     */
    public void pruefGewaehlt() {
        // Bezeichnung
        if (tBezeichnung.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Bezeichnung: darf nicht leer sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // Katehorie
        } else if (cbKategorie.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Kategorie: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Datum
        } else if (cbTag.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Tag muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbMonat.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Monat muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbJahr.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Jahr muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // Uhrzeit
        } else if ((cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() != 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if ((cbStunden.getSelectedIndex() != 0
            && cbMinuten.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Minuten muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden und " + "Minuten müssen gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Dauer
        } else if (cbDauer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Dauer: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // zum speichern! noch nicht fertig
            // Zugehoerige Veranstaltung
        } else if (tZugehoerigV.equals("")) {
            JOptionPane.showMessageDialog(null,
                "Zugehoerige Veranstaltung: muss angegeben sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else {
            // methode umzu speichern.
            pruefungSpeichern();
             
            try {
                AktuelleSitzung aktuelleSitzung =
                    AktuelleSitzung.getAktuelleSitzung();
                
                aktuelleSitzung.pruefHinzu(aktuelleSitzung.getPruefung());

                DatenVerwaltung.speichernPruefungenArray(
                    aktuelleSitzung.getPruefung().terminarray(),
                    aktuelleSitzung.getPruefung().pruefungArray(),
                    Benutzer.getUserName());
                
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, "Kein Datenzugriff!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Pruefung Gespeichert",
                "INFORMATION!", JOptionPane.WARNING_MESSAGE);

            NeuenTerminHinzu.this.setVisible(false);
            NeuenTerminHinzu.this.dispose();
            new KalenderGui();
        }
    }

    /**
     * JRadioButton rbVeran wenn gewaehlt dann soll er ueberpruefen ob die
     * felder ausgefüllt wurden wenn nein dann wird ein ERROR_MESSAGE gezeigt
     * und wenn ja dann weiter zum naechsten feld.
     */
    public void veranGewaehlt() {
        // Bezeichnung
        if (tBezeichnung.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Bezeichnung: darf nicht leer sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // Ects
        } else if (tEcts.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ects: darf nicht leer sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Katehorie
        } else if (cbKategorie.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Kategorie: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Datum
        } else if (cbTag.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Tag muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbMonat.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Monat muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbJahr.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Datum: Jahr muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // uhrzeit
        } else if ((cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() != 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if ((cbStunden.getSelectedIndex() != 0
            && cbMinuten.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Minuten muss gewählt werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden und " + "Minuten müssen gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Dauer
        } else if (cbDauer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Dauer: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // zum speichern! noch nicht fertig
        } else {
            veranstaltungSpeichern();
            
            try {
                AktuelleSitzung aktuelleSitzung =
                    AktuelleSitzung.getAktuelleSitzung();
                
                aktuelleSitzung.veranHinzu(aktuelleSitzung.getVeranstaltung());

                DatenVerwaltung.speichernVeranstungenArray(
                    aktuelleSitzung.getVeranstaltung().terminarray(),
                    aktuelleSitzung.getVeranstaltung().veranstaltungsArray(),
                    Benutzer.getUserName());
                
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(null, "Kein Datenzugriff!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Veranstaltung Gespeichert",
                "INFORMATION!", JOptionPane.WARNING_MESSAGE);

            NeuenTerminHinzu.this.setVisible(false);
            NeuenTerminHinzu.this.dispose();
            new KalenderGui();
        }
    }
}