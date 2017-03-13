package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import daten.AktuelleSitzung;
import daten.Aufgabe;
import daten.Aufgabe.Markierung;
import daten.Aufgabe.Typ;
import daten.Aufgabe.Wiederholbarkeit;

/**
 * @author Rakan Al-Swayyed
 */
public class AufgabeDialog extends JDialog implements ActionListener {
    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = 5043569320233706529L;
    /**
     * Aufgabe aufgabe auf null gesetzt.
     */
    private Aufgabe aufgabe = null;
    /**
     * Label lTerminTyp.
     */
    private JLabel lTerminTyp = new JLabel("Termin Typ:");

    /**
     * JTextField tTerminTyp.
     */
    private JTextField tTerminTyp = new JTextField(15);

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
     * Array arrayKategorie mit zwei unterschiedlichen kategorien Universität
     * und private.
     */
    // arrayKategorie brauchen wir nicht mehr.
    // private String[] arrayKategorie = {"", "Universität", "private" };
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
     * Label lPkt1.
     */
    private JLabel lPkt1 = new JLabel(".");

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
     * Label lPkt2.
     */
    private JLabel lPkt2 = new JLabel(".");

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
     * Label lUhrzeit.
     */
    private JLabel lUhrzeit = new JLabel("          Uhrzeit:");

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
    private String[] arrayMinuten = {"", "0", "15", "30", "45"};

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
    private String[] arrayTagDeadL = {"", "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", 
        "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31" };

    /**
     * JComboBox cbTagDeadL.
     */
    private JComboBox<Object> cbTagDeadL = new JComboBox<Object>(arrayTagDeadL);

    /**
     * Array arrayMonatDeadL mit 12 Monate.
     */
    private String[] arrayMonatDeadL =
        {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    /**
     * Label lPkt3.
     */
    private JLabel lPkt3 = new JLabel(".");

    /**
     * Label lPkt1.
     */
    private JLabel lPkt4 = new JLabel(".");

    /**
     * JComboBox cbMonatDeadL.
     */
    private JComboBox<Object> cbMonatDeadL =
        new JComboBox<Object>(arrayMonatDeadL);

    /**
     * Array arrayJahrDeadL mit 6 Jahre.
     */
    private String[] arrayJahrDeadL =
        {"", "2017", "2018", "2019", "2020", "2021", "2022"};

    /**
     * JComboBox cbJahrDeadL.
     */
    private JComboBox<Object> cbJahrDeadL =
        new JComboBox<Object>(arrayJahrDeadL);

    /**
     * Label lNotiz.
     */
    private JLabel lNotiz = new JLabel("            Notiz:");

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
    /**
     * JComboBox cbMarker fuer marken.
     */
    // private JComboBox<Object> cbMarker = new JComboBox<Object>(arrayMarker);
    private JComboBox<Markierung> cbMarker =
        new JComboBox<Aufgabe.Markierung>(Aufgabe.Markierung.values());

    /**
     * Array arrayDauer.
     */
    private String[] arrayDauer = {"", "30", "60", "90", "120", "240"};

    /**
     * JComboBox cbDauer.
     */
    private JComboBox<Object> cbDauer = new JComboBox<Object>(arrayDauer);

    /**
     * Label lMin.
     */
    private JLabel lMin = new JLabel("min               ");

    /**
     * Label lDauer.
     */
    private JLabel lDauer = new JLabel("Dauer:");

    /**
     * JButton speichern.
     */
    private JButton speichern = new JButton("Speichern");

    /**
     * JButton loeschen.
     */
    private JButton loeschen = new JButton("Loeschen");

    /**
     * JPanel p1.
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
     * Aufgabe aufgabe muss geleich null.
     */
    //private Aufgabe aufgabe = null;

    /**
     * Konstruktor der Klasse NeuenTerminHinzu .
     * @param aufgabe von variablen typs Aufgabe .
     */
    public AufgabeDialog(Aufgabe aufgabe) {
        setTitle("Aufgabe");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
         // Dialog wird auf modal gesetzt
        setModal(true);
        setLocationRelativeTo(null);
        this.aufgabe = aufgabe;
        //array fuer datum und getrennt durch punkt
        String[] datum = aufgabe.getDatum().split(".");
        //uhrzeit array.
        String[] uhrzeit = aufgabe.getUhrzeit().split(":");
        // deadline array .
        String[] deadline = aufgabe.getDeadline().split(".");
        // rufe daten auf die gespeichert worden+++++++++++++++++
        tBezeichnung.setText(aufgabe.getBezeichnung());
        //Termin Typ uni oder private
        tTerminTyp.setText(aufgabe.getTerminTyp() + "");
        //Datum
        cbTag.setSelectedItem(datum[0]);
        cbMonat.setSelectedItem(datum[1]);
        cbJahr.setSelectedItem(datum[2]);
        //uhrzeit.
        cbStunden.setSelectedItem(uhrzeit[0]);
        cbMinuten.setSelectedItem(uhrzeit[1]);
        //Deadline
        cbTagDeadL.setSelectedItem(deadline[0]);
        cbMonatDeadL.setSelectedItem(deadline[1]);
        cbJahrDeadL.setSelectedItem(deadline[2]);
        //WiederholbarkeitTermin.
        cbWieOft.setSelectedItem(aufgabe.getWiederholbarkeitTermin());
        //Marker
        cbMarker.setSelectedItem(aufgabe.getMarkierung());
        //Dauer.
        cbDauer.setSelectedItem(Aufgabe.getDauer());
        //Notiz.
        tNotiz.setText(aufgabe.getKommentar());

        // methode um Panel Zu Konstruktor fuegen wegen platz mangel
        // ausgelagert.
        fuegePanelZuKonstruktor();
        // this.aufgabe = aufgabe;
        // methode bSundLoe fuer speichern und loeschen.
        bSundLoe();
        
        pack();
        setVisible(true);
    }

    /**
     * .
     */
    public void fuegePanelZuKonstruktor() {
        speichern.addActionListener(this);
        // RadioButtons werden zu p1 zugewiesen.
        p1.add(lTerminTyp);
        p1.add(tTerminTyp);
        p1.add(lBezeichnung);
        p1.add(tBezeichnung);
        p1.add(lKategorie);
        p1.add(cbKategorie);
        // Datum
        p2.add(lDatum);
        p2.add(cbTag);
        p2.add(lPkt1);
        p2.add(cbMonat);
        p2.add(lPkt2);
        p2.add(cbJahr);
        // Uhrzeit
        p2.add(lUhrzeit);
        p2.add(cbStunden);
        p2.add(lDpkt);
        p2.add(cbMinuten);
        // Deadline
        p3.add(lDeadline);
        p3.add(cbTagDeadL);
        p3.add(lPkt3);
        p3.add(cbMonatDeadL);
        p3.add(lPkt4);
        p3.add(cbJahrDeadL);
        // Dauer
        p3.add(lDauer);
        p3.add(cbDauer);
        p3.add(lMin);
        p3.add(lWiederh);
        // p3.add(rbNein);
        // p3.add(rbJa);
        p3.add(cbWieOft);
        p4.add(lMarker);
        p4.add(cbMarker);
        p4.add(lNotiz);
        p4.add(tNotiz);
        // bgWieder.add(rbNein);
        // bgWieder.add(rbJa);
        p5.add(speichern);
        p5.add(loeschen);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
    }

    /**
     * buttons loeschen und speichern.
     */
    public void bSundLoe() {
        // speichen
        speichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // methode pruefenOK ueberprueft ob man speichern kann.
                pruefenOK();

                JOptionPane.showMessageDialog(null, "Aufgabe Bearbeitet",
                    "INFORMATION!", JOptionPane.WARNING_MESSAGE);

                AufgabeDialog.this.setVisible(false);
                AufgabeDialog.this.dispose();
                new KalenderGui();
            }
        });
        // Loeschen
        loeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // loeschen aus der AktuelleSitzung
                AktuelleSitzung aktuelleSitzung =
                    AktuelleSitzung.getAktuelleSitzung();
                AktuelleSitzung.getAufgaben()
                    .remove(AufgabeDialog.this.aufgabe);

                JOptionPane.showMessageDialog(null, "Aufgabe Gelöscht",
                    "INFORMATION!", JOptionPane.WARNING_MESSAGE);

                AufgabeDialog.this.setVisible(false);
                AufgabeDialog.this.dispose();
                new KalenderGui();
            }
        });

    }

    /**
     * methode prueft ob alles inordnung.
     */
    public void pruefenOK() {
        if (tBezeichnung.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Bezeichnung: darf nicht leer sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        } else if (cbKategorie.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Kategorie: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
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
        } else if (cbDauer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Dauer: muss gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            Aufgabe aufgabe = AufgabeDialog.this.aufgabe;
            aufgabe.setBezeichnung(tBezeichnung.getText());
            aufgabe.setTerminTyp((Typ) cbKategorie.getSelectedItem());
            aufgabe.setDatum(cbTag.getSelectedItem() + "."
                + cbMonat.getSelectedItem() + "." + cbJahr.getSelectedItem());
            aufgabe.setUhrzeit(cbStunden.getSelectedItem() + ":"
                + cbMinuten.getSelectedItem());
            aufgabe.setDeadline(cbTagDeadL.getSelectedItem() + "."
                + cbMonatDeadL.getSelectedItem() + "."
                + cbJahrDeadL.getSelectedItem());
            aufgabe.setWiederholbarkeitTermin(
                (Wiederholbarkeit) cbWieOft.getSelectedItem());
            aufgabe.setMarkierung(cbMarker.getSelectedItem());
            aufgabe.setDauer(cbDauer.getSelectedItem());
            aufgabe.setKommentar(tNotiz.getText());
            JOptionPane.showMessageDialog(null, "Aufgabe Bearbeitet",
                "INFORMATION!", JOptionPane.WARNING_MESSAGE);
        }
    }    
    /**
     * @param e    .
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}