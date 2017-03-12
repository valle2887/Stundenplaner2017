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

import daten.Pruefung;
import daten.Aufgabe;

/**
 * @author Rakan Al-Swayyed
 */
public class PruefungDialog extends JDialog implements ActionListener {
    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = 5043569320233706529L;
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
     * JComboBox cbKategorie hat was von enum Typ.
     */
    //private JComboBox<Object> cbKategorie =
      //  new JComboBox<Object>(arrayKategorie);
    private JComboBox<daten.Termin.Typ> cbKategorie = 
        new JComboBox<Aufgabe.Typ>(Aufgabe.
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
   // private JLabel lDeadline = new JLabel("Deadline:");
    /**
     * Label lNotiz.
     */
    private JLabel lNotiz = new JLabel("            Notiz:");
    /**
     * JTextArea tNotiz.
     */
    private JTextArea tNotiz = new JTextArea(5, 20);
    /**
     * Label lMarker.
     */
    private JLabel lMarker = new JLabel("       Marker:");
    /**
     * Array arrayMarker.
     */
    //private String[] arrayMarker =
      //  {"", "noch nicht", "noch nicht", "noch nicht", "noch nicht"};
    /**
     * JComboBox cbMarker fuer marken.
     */
    //private JComboBox<Object> cbMarker = new JComboBox<Object>(arrayMarker);
    private JComboBox<daten.Termin.Markierung> cbMarker = new JComboBox<Aufgabe
        .Markierung>(Aufgabe.Markierung.values());
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
    private JLabel lDauer = new JLabel("        Dauer:");
    /**
     * Label lGebaeude.
     */
    private JLabel lGebaeude = new JLabel("      Gebäude:");
    /**
     * JTextField tGebaeude.
     */
    private JTextField tGebaeude = new JTextField(20);
    /**
     * Label lRaum.
     */
    private JLabel lRaum = new JLabel("      Raum:    ");
    /**
     * JTextField tRaum.
     */
    private JTextField tRaum = new JTextField(20);
    /**
     * Label lZugehoerigV .
     */
    private JLabel lZugehoerigV =
        new JLabel("    Zugehörige Veranstaltung:");
    /**
     * JTextField tZugehoerigV.
     */
    private JTextField tZugehoerigV = new JTextField(20);
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
     * Konstruktor der Klasse NeuenTerminHinzu .
     */
    public PruefungDialog() {
        setTitle("Prüfung");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        setResizable(true);
        setLocationRelativeTo(null);

       //methode um Panel Zu Konstruktor fuegen wegen platz mangel ausgelagert. 
        fuegePanelZuKonstruktor();
        
        buttonsSundLoe();
        
        pack();
        setVisible(true);
    }
    /**
     * .
     */
    public void fuegePanelZuKonstruktor() {
        p1.add(lTerminTyp);
        p1.add(tTerminTyp);
        p1.add(lBezeichnung);
        p1.add(tBezeichnung);
        p1.add(lKategorie);
        p1.add(cbKategorie);
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
        p3.add(lGebaeude);
        p3.add(tGebaeude);
        p3.add(lRaum);
        p3.add(tRaum);
        p3.add(lMarker);
        p3.add(cbMarker);
        p4.add(lNotiz);
        p4.add(tNotiz);
        p4.add(lZugehoerigV);
        p4.add(tZugehoerigV);
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
    public void buttonsSundLoe() {
        //speichen
        speichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pruefung pruefung = new Pruefung();
                String bezeichnung = tBezeichnung.getText();
                pruefung.setBezeichnung(bezeichnung);
                String datum =
                    cbTag.getSelectedItem() + "." + cbMonat.getSelectedItem()
                        + "." + cbJahr.getSelectedItem();
                pruefung.setDatum(datum);
                String zeit = cbStunden.getSelectedItem() + ":"
                    + cbMinuten.getSelectedItem();
                pruefung.setUhrzeit(zeit);
                // int dauer = cbDauer.getSelectedItem();
                // pruefung.setDauer(dauer);
                String notiz = tNotiz.getText();
                pruefung.setKommentar(notiz);
                // String wiederholen = cbWieOft.getSelectedItem();
                // pruefung.setWiederholbarkeitTermin(wiederholen);
                // String kategorie = cbKategorie.getSelectedItem();
                // pruefung.setTerminTyp(kategorie);
                JOptionPane.showMessageDialog(null,
                    "Prüfung Bearbeitet", "INFORMATION!",
                    JOptionPane.WARNING_MESSAGE);
                PruefungDialog.this.setVisible(false);
                PruefungDialog.this.dispose();
                new KalenderGui();
            }
        });
        //Loeschen
        loeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pruefung pruefung = new Pruefung();
                String bezeichnung = tBezeichnung.getText();
                pruefung.setBezeichnung(bezeichnung);
                String datum =
                    cbTag.getSelectedItem() + "." + cbMonat.getSelectedItem()
                        + "." + cbJahr.getSelectedItem();
                pruefung.setDatum(datum);
                String zeit = cbStunden.getSelectedItem() + ":"
                    + cbMinuten.getSelectedItem();
                pruefung.setUhrzeit(zeit);

                // int dauer = cbDauer.getSelectedItem();
                // aufgabe.setDauer(dauer);

                String notiz = tNotiz.getText();
                pruefung.setKommentar(notiz);
                // String wiederholen = cbWieOft.getSelectedItem();
                // pruefung.setWiederholbarkeitTermin(wiederholen);
                // String kategorie = cbKategorie.getSelectedItem();
                // pruefung.setTerminTyp(kategorie);
               
                JOptionPane.showMessageDialog(null,
                    "Prüfung Gelöscht", "INFORMATION!",
                    JOptionPane.WARNING_MESSAGE);

                PruefungDialog.this.setVisible(false);
                PruefungDialog.this.dispose();
                new KalenderGui();
                
            }
        });
        
    }
    /**
     *@param e .
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}