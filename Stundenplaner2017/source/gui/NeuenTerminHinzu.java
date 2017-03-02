package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import daten.Termin;
import daten.Termin.Typ;
import daten.Termin.Wiederholbarkeit;

/**
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
     * Array arrayKategorie mit zwei unterschiedlichen kategorien Universität
     * und private.
     */
    //arrayKategorie brauchen wir nicht mehr.
    //private String[] arrayKategorie = {"", "Universität", "private" };
    /**
     * JComboBox cbKategorie hat was von enum Typ.
     */
    private JComboBox<Typ> cbKategorie = new JComboBox<Termin.Typ>(Termin.
        Typ.values());
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
     * arrayWieOft brauchen wir nicht mehr..
     */
    //private String[] arrayWieOft = {"", "Einmalig", "Taglich", "Wöchenlich", 
    //"Monatlich"};
    //private JComboBox<Object> cbWieOft = new JComboBox<Object>(arrayWieOft);
    /**
     * JComboBox cbWieOft hat was von enum Wiederholbarkeit ob einmalig, 
     * wochenlich.
     */
    private JComboBox<Wiederholbarkeit> cbWieOft = new JComboBox<Termin
        .Wiederholbarkeit>(Termin.Wiederholbarkeit.values());
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
     * Label lEcts.
     */
    private JLabel lEcts = new JLabel("      ECTS");
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
     * Label lCampus.
     */
    private JLabel lCampus = new JLabel("      Campus:");
    /**
     * JTextField tCampus.
     */
    private JTextField tCampus = new JTextField(20);
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
     * Konstruktor der Klasse NeuenTerminHinzu .
     */
    public NeuenTerminHinzu() {
        setTitle("Termin Hinzufügen");
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
        // methode fehlerDialog.
        fehlerDialog();

        p2.add(lBezeichnung);
        p2.add(tBezeichnung);
        p2.add(lEcts);
        p2.add(tEcts);
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
        pack();
        setVisible(true);
    }
    /**
     * @param action
     *            .
     */
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == rbAufg) {
            lDauer.setVisible(true);
            cbDauer.setVisible(true);
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
        } else if (action.getSource() == rbVeran) {
            lDauer.setVisible(true);
            cbDauer.setVisible(true);
            lCampus.setVisible(true);
            tCampus.setVisible(true);
            lRaum.setVisible(true);
            tRaum.setVisible(true);
            lDozent.setVisible(true);
            tDozent.setVisible(true);
            lEcts.setVisible(true);
            tEcts.setVisible(true);
            repaint();
        } else if (action.getSource() == rbPruef) {
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
    }
    /**
     * methoden aufgabeGewaehlt, pruefGewaehlt, veranGewaehlt ausgelagert da 
     * sonst checkstyle fehler methode > 70 zeilen.
     */
    private void fehlerDialog() {
        speichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Termin Typ
                if (!rbAufg.isSelected() && !rbVeran.isSelected()
                    && !rbPruef.isSelected()) {
                    JOptionPane.showMessageDialog(null,
                        "Termin Typ: muss gewaehlt werden", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                } else if (rbAufg.isSelected()) {
                    aufgabeGewaehlt();
                } else if (rbPruef.isSelected()) {
                    pruefGewaehlt();
                } else {
                    veranGewaehlt();
                }
            }
        });
    }
    /**
     * JRadioButton rbAufg wenn gewaehlt dann soll er ueberpruefen ob die 
     * felder gewaehlt wurden wenn ja soll der fenster schliessen und speichern.
     */
    public void aufgabeGewaehlt() {
        // Bezeichnung
        if (tBezeichnung.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Bezeichnung: darf nicht leer sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // Katehorie
        } else if (cbKategorie.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Kategorie: muss gewählt sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
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
                "Uhrzeit: Stunden muss gewählt werden!",
                "Error!", JOptionPane.ERROR_MESSAGE);
        } else if ((cbStunden.getSelectedIndex() != 0
            && cbMinuten.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Minuten muss gewählt werden!",
                "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden und "
                    + "Minuten müssen gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            //Dauer
        } else if (cbDauer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Dauer: muss gewählt sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // zum speichern! noch nicht fertig
        } else {
            JOptionPane.showMessageDialog(null,
                "Jetzt kann gespeichert werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            NeuenTerminHinzu.this.setVisible(false);
            NeuenTerminHinzu.this.dispose();
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
            JOptionPane.showMessageDialog(null,
                "Kategorie: muss gewählt sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
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
                "Uhrzeit: Stunden muss gewählt werden!",
                "Error!", JOptionPane.ERROR_MESSAGE);
        } else if ((cbStunden.getSelectedIndex() != 0
            && cbMinuten.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Minuten muss gewählt werden!",
                "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (cbStunden.getSelectedIndex() == 0
            && cbMinuten.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Uhrzeit: Stunden und "
                    + "Minuten müssen gewählt sein!",
                "Error!", JOptionPane.ERROR_MESSAGE);
            // Dauer
        } else if (cbDauer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Dauer: muss gewählt sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
        // zum speichern! noch nicht fertig
        } else {
            JOptionPane.showMessageDialog(null,
                "Jetzt kann gespeichert werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            NeuenTerminHinzu.this.setVisible(false);
            NeuenTerminHinzu.this.dispose();
        }
    }
    /**
     * JRadioButton rbVeran wenn gewaehlt dann soll er ueberpruefen ob die
     * felder gewaehlt wurden wenn ja soll der fenster schliessen und speichern.
     */
    public void veranGewaehlt() {
        // Bezeichnung
        if (tBezeichnung.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Bezeichnung: darf nicht leer sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // Ects
        } else if (tEcts.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                "Ects: darf nicht leer sein!", "Error!",
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
            //Dauer
        } else if (cbDauer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                "Dauer: muss gewählt sein!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            // zum speichern! noch nicht fertig
        } else {
            JOptionPane.showMessageDialog(null,
                "Jetzt kann gespeichert werden!", "Error!",
                JOptionPane.ERROR_MESSAGE);
            NeuenTerminHinzu.this.setVisible(false);
            NeuenTerminHinzu.this.dispose();  
        }
    }
    /**
     * @param args
     *            .
     */
    public static void main(String[] args) {
        new NeuenTerminHinzu();
    }
}