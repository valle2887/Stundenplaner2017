package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import daten.Aufgabe;

/**
 * @author Rakan Al-Swayyed
 */
public class AufgabeDialog extends JDialog implements ActionListener {
    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = 4299275630620623952L;
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
     * Array arrayKategorie mit zwei unterschiedlichen kategorien Universität
     * und private.
     */
    private String[] arrayKategorie = {"", "Universität", "private" };
    /**
     * JComboBox cbKategorie.
     */
    private JComboBox<Object> cbKategorie =
        new JComboBox<Object>(arrayKategorie);
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
    private JLabel lWiederh = new JLabel("wiederholen:");
    /**
     * JButtongroupe bgWieder.
     */
    private ButtonGroup bgWieder = new ButtonGroup();
    /**
     * JRadioButton rbJa.
     */
    private JRadioButton rbJa = new JRadioButton("nein");
    /**
     * JRadioButton rbNein.
     */
    private JRadioButton rbNein = new JRadioButton("ja");
    /**
     * Array arrayWieOft.
     */
    private String[] arrayWieOft =
        {"", "Einmalig", "Taglich", "Wöchenlich", "Monatlich"};
    /**
     * JComboBox cbWieOft ob einmalig, wochenlich, monatlich.
     */
    private JComboBox<Object> cbWieOft = new JComboBox<Object>(arrayWieOft);
    /**
     * Label lMarker.
     */
    private JLabel lMarker = new JLabel("Marker:");
    /**
     * Array arrayMarker.
     */
    private String[] arrayMarker =
        {"", "noch nicht", "noch nicht", "noch nicht", "noch nicht"};
    /**
     * JComboBox cbMarker fuer marken.
     */
    private JComboBox<Object> cbMarker = new JComboBox<Object>(arrayMarker);
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
    private JLabel lMin = new JLabel("min");
    /**
     * Label lDauer.
     */
    private JLabel lDauer = new JLabel("Dauer:");
    /**
     * JButton speichern.
     */
    private JButton aendern = new JButton("Ändern");
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
     * Konstruktor der Klasse NeuenTerminHinzu .
     * @param aufgabe .
     */
    public AufgabeDialog(Aufgabe aufgabe) {
        setTitle("Aufgabe Dialog");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));
        setResizable(true);
        setLocationRelativeTo(null);
        // die zuvor Ausgefuellten felder der aufgabe angezeigt.
        //Bezeichnung
        tBezeichnung.setText(aufgabe.getBezeichnung());
        //Kategorie
        cbKategorie.setSelectedItem(aufgabe.getTerminTyp());
        //Datum
        String[] datum = aufgabe.getDatum().split(":");
        cbTag.setSelectedItem(datum[0]);
        cbMonat.setSelectedItem(datum[1]);
        cbJahr.setSelectedItem(datum[2]);
        //Uhrzeit
        String[] uhrzeit = aufgabe.getUhrzeit().split(":");
        cbStunden.setSelectedItem(uhrzeit[0]);
        cbMinuten.setSelectedItem(uhrzeit[1]);
        //Dauer
        cbDauer.setSelectedItem(aufgabe.getDauer());
        //Notiz
        tNotiz.setText(aufgabe.getKommentar());
        //wiederholbarkeit
        cbWieOft.setSelectedItem(aufgabe.getWiederholbarkeitTermin());
        //Deadline ?????
        
        //extra methode weil methode zu lang war.
        panelUNDContainer();

        pack();
        setVisible(true);

    }
    /** extra methode fuer fuege zu panel  & fuege zu container weil die 
     * methode zu lang war .
     */
    public void panelUNDContainer() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));
        setResizable(true);
        setLocationRelativeTo(null);
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
        p2.add(lKategorie);
        p2.add(cbKategorie);
        p2.add(lDatum);
        p2.add(cbTag);
        p2.add(lPkt1);
        p2.add(cbMonat);
        p2.add(lPkt2);
        p2.add(cbJahr);
        p2.add(lUhrzeit);
        p2.add(cbStunden);
        p2.add(lDpkt);
        p2.add(cbMinuten);
        p2.add(lDauer);
        p2.add(cbDauer);
        p2.add(lMin);
        p3.add(lWiederh);
        p3.add(rbNein);
        p3.add(rbJa);
        p3.add(cbWieOft);
        p3.add(lMarker);
        p3.add(cbMarker);
        p3.add(lNotiz);
        p3.add(tNotiz);
        bgWieder.add(rbNein);
        bgWieder.add(rbJa);
        p4.add(lMarker);
        p4.add(cbMarker);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(aendern);
        pack();
        setVisible(true);
    }
    /**
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {  
    }


}
