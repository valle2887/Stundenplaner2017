package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import daten.DatenVerwaltung;
import daten.Aufgabe;
//import daten.Veranstaltung;
//import daten.Pruefung;
//import daten.Termin;
/**
 * @author Rakan Al-Swayyed
 */
public class AufgabeDialog extends JFrame implements ActionListener {
    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = 5043569320233706529L;
    /**
     * Label lTerminTyp.
     */
    private JLabel lTerminTyp = new JLabel("Termin Typ wählen:");
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
    private String[] arrayKategorie = {"", "Universität", "private" };
    /**
     * JComboBox cbKategorie hat was von enum Typ.
     */
    private JComboBox<Object> cbKategorie =
        new JComboBox<Object>(arrayKategorie);
    //private JComboBox<Typ> cbKategorie = new JComboBox<Termin.Typ>(Termin.
      //  Typ.values());
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
   // private JLabel lDeadline = new JLabel("Deadline:");
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
    private JLabel lWiederh = new JLabel("wiederholung:");
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
    private String[] arrayWieOft = {"", "Einmalig", "Taglich", "Wöchenlich", 
        "Monatlich"};
    /**
     * JComboBox cbWieOft hat was von enum Wiederholbarkeit ob einmalig, 
     * wochenlich.
     */
    //private JComboBox<Wiederholbarkeit> cbWieOft = new JComboBox<Termin
      //  .Wiederholbarkeit>(Termin.Wiederholbarkeit.values());
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
     * Konstruktor der Klasse NeuenTerminHinzu .
     */
    public AufgabeDialog() {
        setTitle("Termin Hinzufügen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        setResizable(true);
        setLocationRelativeTo(null);

       //methode um Panel Zu Konstruktor fuegen wegen platz mangel ausgelagert. 
        fuegePanelZuKonstruktor();

        pack();
        setVisible(true);
    }
    /** 
     *            .
     */
    public void fuegePanelZuKonstruktor() {
        // RadioButtons werden zu p1 zugewiesen.
        p1.add(lTerminTyp);
        
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
        //p3.add(rbNein);
       // p3.add(rbJa);
        p3.add(cbWieOft);
        p3.add(lMarker);
        p3.add(cbMarker);
        p3.add(lNotiz);
        p3.add(tNotiz);
       // bgWieder.add(rbNein);
       // bgWieder.add(rbJa);
        p5.add(speichern);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
    }
    /**
     * speichern von aufgabe.
     */
    public void aufgabeSpeichern() {
        
        Aufgabe aufgabe = new Aufgabe();
        
        String bezeichnung = tBezeichnung.getText();
        aufgabe.setBezeichnung(bezeichnung);
        
        String datum = cbTag.getSelectedItem() + "." + cbMonat.getSelectedItem()
            + "." + cbJahr.getSelectedItem();
        aufgabe.setDatum(datum);
        
        String zeit =
            cbStunden.getSelectedItem() + ":" + cbMinuten.getSelectedItem();
        aufgabe.setUhrzeit(zeit);
        
       // int dauer = cbDauer.getSelectedItem();
        //aufgabe.setDauer(dauer);
        
        String notiz = tNotiz.getText();
        aufgabe.setKommentar(notiz);
        
        //String wiederholen = cbWieOft.getSelectedItem();
       // aufgabe.setWiederholbarkeitTermin(wiederholen);
        
       // String kategorie = cbKategorie.getSelectedItem();
       // aufgabe.setTerminTyp(kategorie);
    }
    /**
     * @param args .
     */
    public static void main(String[] args) {
        new AufgabeDialog();
    }
    /**
     *@param e .
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}