package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Rakan Al-Swayyed
 */
public class NeuenTerminHinzu extends JFrame implements ActionListener {
    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = 5043569320233706529L;

    /**
     * JButtongroupe bgTerminTyp.
     */
    private static ButtonGroup bgTerminTyp = new ButtonGroup();

    /**
     * JRadioButton rbVeran.
     */
    private static JRadioButton rbVeran = new JRadioButton("Veranstaltung");

    /**
     * JRadioButton rbAufg.
     */
    private static JRadioButton rbAufg = new JRadioButton("Aufgabe");

    /**
     * JRadioButton rbPruef.
     */
    private static JRadioButton rbPruef = new JRadioButton("Pruefung");

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
    private String[] arrayKategorie = {"Universität", "private"};

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
    private String[] arrayTag = {"1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    /**
     * JComboBox cbTag.
     */
    private JComboBox<Object> cbTag = new JComboBox<Object>(arrayTag);

    /**
     * Array arrayMonat mit 12 Monate.
     */
    private String[] arrayMonat =
        {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    /**
     * JComboBox cbMonat.
     */
    private JComboBox<Object> cbMonat = new JComboBox<Object>(arrayMonat);

    /**
     * Array arrayJahr mit 6 Jahre.
     */
    private String[] arrayJahr =
        {"2017", "2018", "2019", "2020", "2021", "2022"};

    /**
     * JComboBox cbJahr.
     */
    private JComboBox<Object> cbJahr = new JComboBox<Object>(arrayJahr);

    /**
     * Label lUhrzeit.
     */
    private JLabel lUhrzeit = new JLabel("Uhrzeit:");

    /**
     * Array arrayStd mit 24 Stunden.
     */
    private String[] arrayStd =
        {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    /**
     * JComboBox cbStunden.
     */
    private JComboBox<Object> cbStunden = new JComboBox<Object>(arrayStd);

    /**
     * Array arrayMinuten mit 15 minuten Intervall.
     */
    private String[] arrayMinuten = {"0", "15", "30", "45"};

    /**
     * JComboBox cbMinuten.
     */
    private JComboBox<Object> cbMinuten = new JComboBox<Object>(arrayMinuten);

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
        {"Einmalig", "Taglich", "Wöchenlich", "Monatlich"};

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
        {"noch nicht", "noch nicht", "noch nicht", "noch nicht"};

    /**
     * JComboBox cbMarker fuer marken.
     */
    private JComboBox<Object> cbMarker = new JComboBox<Object>(arrayMarker);

    /**
     * Array arrayDauer.
     */
    private static String[] arrayDauer = {"30", "60", "90", "120", "240"};

    /**
     * JComboBox cbDauer.
     */
    private static JComboBox<Object> cbDauer = new JComboBox
        <Object>(arrayDauer);

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
    private JLabel lEcts = new JLabel("      ECTS");

    /**
     * JTextField tEcts.
     */
    private static JTextField tEcts = new JTextField(3);

    /**
     * Label lDozent.
     */
    private JLabel lDozent = new JLabel("      Dozent:");

    /**
     * JTextField tDozent.
     */
    private static JTextField tDozent = new JTextField(20);

    /**
     * Label lCampus.
     */
    private JLabel lCampus = new JLabel("      Campus:");

    /**
     * JTextField tCampus.
     */
    private static JTextField tCampus = new JTextField(20);

    /**
     * Label lRaum.
     */
    private JLabel lRaum = new JLabel("      Raum:    ");

    /**
     * JTextField tRaum.
     */
    private static JTextField tRaum = new JTextField(20);
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
     * Konstruktor der Klasse NeuenTerminHinzu .
     */
    public NeuenTerminHinzu() {
        setTitle("Termin Hinzufuegen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));
        setResizable(true);
        setLocationRelativeTo(null);
        // RadioButtons werden zu p1 zugewiesen.
        p1.add(rbAufg);
        p1.add(rbVeran);
        p1.add(rbPruef);
        bgTerminTyp.add(rbVeran);
        bgTerminTyp.add(rbAufg);
        bgTerminTyp.add(rbPruef);
        
        p2.add(lBezeichnung);
        p2.add(tBezeichnung);
        p2.add(lEcts);
        p2.add(tEcts);
        p2.add(lKategorie);
        p2.add(cbKategorie);
        p2.add(lDatum);
        p2.add(cbTag);
        p2.add(cbMonat);
        p2.add(cbJahr);
        p2.add(lUhrzeit);
        p2.add(cbStunden);
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
        p4.add(lDozent);
        p4.add(tDozent);
        p4.add(lCampus);
        p4.add(tCampus);
        p4.add(lRaum);
        p4.add(tRaum);
        p4.add(lMarker);
        p4.add(cbMarker);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(speichern);
        machSichtbar();
        pack();
        setVisible(true);
    }
    /**
     * methode machSichtbar() fuer Aufgabe, Veranstaltung und Pruefung.
     */
    public void machSichtbar() {
        /**
         * wenn rbAufg dann machSichtbar nix besonders. 
         */
        rbAufg.addActionListener(new ActionListener() {
            /**
             * @param e .
             */
            public void actionPerformed(ActionEvent e) {
                lDauer.setVisible(false);
                cbDauer.setVisible(false);
                lMin.setVisible(false);
                lCampus.setVisible(false);
                tCampus.setVisible(false);
                lRaum.setVisible(false);
                tRaum.setVisible(false);
                lDozent.setVisible(false);
                tDozent.setVisible(false);
                lEcts.setVisible(false);
                tEcts.setVisible(false);
                repaint();
            }
        });
        /**
         * wenn rbVeran dann machSichtbar Campus, Raum, Dozent und Ects.
         */
        rbVeran.addActionListener(new ActionListener() {
            /**
             * @param e .
             */
            public void actionPerformed(ActionEvent e) {
                lDauer.setVisible(false);
                cbDauer.setVisible(false);
                lCampus.setVisible(true);
                tCampus.setVisible(true);
                lRaum.setVisible(true);
                tRaum.setVisible(true);
                lDozent.setVisible(true);
                tDozent.setVisible(true);
                lEcts.setVisible(true);
                tEcts.setVisible(true);
                repaint();
            }
        });
        /**
         * wenn rbVeran dann machSichtbar Dauer ,Campus und Raum.
         */
        rbPruef.addActionListener(new ActionListener() {
            /**
             * @param e.
             */
            public void actionPerformed(ActionEvent e) {
                lDauer.setVisible(true);
                cbDauer.setVisible(true);
                lCampus.setVisible(true);
                tCampus.setVisible(true);
                lRaum.setVisible(true);
                tRaum.setVisible(true);
                lDozent.setVisible(false);
                tDozent.setVisible(false);
                lEcts.setVisible(false);
                tEcts.setVisible(false);
                repaint();
            }
        });
    }
    /**
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        
    }
    /**
     * @param args .
     */
    public static void main(String[] args) {
        new NeuenTerminHinzu();
    }
}    

