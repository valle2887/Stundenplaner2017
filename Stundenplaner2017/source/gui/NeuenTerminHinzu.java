package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
     * JButtongroupe terminTyp. 
     */
    private ButtonGroup terminTyp = new ButtonGroup();
    /**
     * JRadioButton radioVeranstaltung. 
     */
    private JRadioButton radioVeranstaltung = new JRadioButton("Veranstaltung");
    /**
     * JRadioButton radioAufgabe. 
     */
    private JRadioButton radioAufgabe = new JRadioButton("Aufgabe");
    /**
     * JRadioButton radioPruefung. 
     */
    private JRadioButton radioPruefung = new JRadioButton("Pruefung");
    /**
     * Label bezeichnung. 
     */
    private JLabel bezeichnung = new JLabel("Bezeichnung:");
    /** 
     * JTextField textBezeichnung. 
     */
    private JTextField textBezeichnung = new JTextField(20);
    /**
     * Label kategorie. 
     */
    private JLabel kategorie = new JLabel("Kategorie:");
    /**
     * Array vArray mit zwei unterschiedlichen kategorien Universität und 
     * private. 
     */
    private String[] kaArray = {"Universität", "private"};
    /**
     * JComboBox kaKiste. 
     */
    private JComboBox<Object> kaKiste = new JComboBox<Object>(kaArray);
    /**
     * Label datum. 
     */
    private JLabel datum = new JLabel("Datum:");
    /**
     * Array tagArray mit 31 tage. 
     */
    private String[] tagArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", 
        "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", 
        "22", "23", "24", "25", "26", "27" , "28", "29", "30", "31"};
    /**
     * JComboBox tagKiste. 
     */
    private JComboBox<Object> tagKiste = new JComboBox<Object>(tagArray);
    /**
     * Array monatArray mit 12 Monate. 
     */
    private String[] monatArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "11", "12"};
    /**
     * JComboBox monatKiste. 
     */
    private JComboBox<Object> monatKiste = new JComboBox<Object>(monatArray);
    /**
     * Array jahrArray mit 6 Jahre. 
     */
    private String[] jahrArray = {"2017", "2018", "2019", "2020", "2021",
        "2022"};
    /**
     * JComboBox jahrKiste. 
     */
    private JComboBox<Object> jahrKiste = new JComboBox<Object>(jahrArray);
    /**
     * Label uhrzeit. 
     */
    private JLabel uhrzeit = new JLabel("Uhrzeit:");
    /**
     * Array stdArray mit 24 Stunden. 
     */
    private String[] stdArray = {"1", "2", "3", "4", "5", "6", "7", "8", 
        "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
        "21", "22", "23", "00"};
    
    /**
     * JComboBox stundenKiste. 
     */
    private JComboBox<Object> stundenKiste = new JComboBox<Object>(stdArray);
    /**
     * Array minArray mit 15 minuten Intervall. 
     */
    private String[] minArray = {"0", "15", "30", "45"};
    /**
     * JComboBox minutenKiste. 
     */
    private JComboBox<Object> minutenKiste = new JComboBox<Object>(minArray);
    /**
     * Label minP. 
     */
    private JLabel minP = new JLabel("min");
    /**
     * Label dauerP. 
     */
    private JLabel dauerP = new JLabel("Dauer:");
    /**
     * JTextField textDauer. 
     */
    private JTextField textDauerP = new JTextField(3);
    /**
     * Label dauerP. 
     */
    private JLabel notiz = new JLabel("Notiz:");
    /**
     * JTextArea notizArea. 
     */
    private JTextArea notizArea = new JTextArea(5, 20);
    /**
     * Label wiederholbar. 
     */
    private JLabel wiederholbar = new JLabel("wiederholen:");
    /**
     * JButtongroupe wiederJoN. 
     */
    private ButtonGroup wiederJoN = new ButtonGroup();
    /**
     * JRadioButton radioJa. 
     */
    private JRadioButton radioJa = new JRadioButton("nein");
    /**
     * JRadioButton radioNein. 
     */
    private JRadioButton radioNein = new JRadioButton("ja");
    /**
     * Array wieOftArray. 
     */
    private String[] wieOftArray = {"Einmalig", "Taglich", "Wöchenlich", 
        "Monatlich"};
    /**
     * JComboBox wieOft ob einmalig, wochenlich, monatlich. 
     */
    private JComboBox<Object> wieOft = new JComboBox<Object>(wieOftArray);
    //++++++++++++++++++++++++
    /**
     * JCheckBox tage. 
     */
    private JCheckBox mo, di, mi, don, fr, sa, so

    
    
    //++++++++++++++++++++++++
    /**
     * JButton speichern.
     */
    private JButton speichern = new JButton("Speichern");
    /**
     * JButtongroupe panelTerminTyp. 
     */
    private JPanel panelTerminTyp = new JPanel();
    /**
     * JPanel panelBuK. 
     */
    private JPanel panelBuK = new JPanel();
    /**
     * JPanel panelDuU fuer Datum und Uhrzeit.
     */
    private JPanel panelDuU = new JPanel();
    /**
     * JPanel panelNotiz fuer Notize.
     */
    private JPanel panelNotiz = new JPanel();
    /**
     * JPanel panelWieder fuer Wiederholen.
     */
    private JPanel panelWieder = new JPanel();
    /**
     * Konstruktor der Klasse NeuenTerminHinzu .
     */
    public NeuenTerminHinzu() {
        // TODO Auto-generated constructor stub
        setTitle("Termin Hinzufuegen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));
        setResizable(false);
        setLocationRelativeTo(null);
        // RadioButtons werden zu panelTerminTyp zugewiesen.
        panelTerminTyp.add(radioVeranstaltung);
        panelTerminTyp.add(radioAufgabe);
        panelTerminTyp.add(radioPruefung);
        terminTyp.add(radioVeranstaltung);
        terminTyp.add(radioAufgabe);
        terminTyp.add(radioPruefung);
        //fuege zu panelBuK für bezeichnung und Kategorie.
        panelBuK.add(bezeichnung);
        panelBuK.add(textBezeichnung);
        panelBuK.add(kategorie);
        panelBuK.add(kaKiste);
        //fuege zu panelDuU für datum und zeit. 
        panelDuU.add(datum);
        panelDuU.add(tagKiste);
        panelDuU.add(monatKiste);
        panelDuU.add(jahrKiste);
        panelDuU.add(uhrzeit);
        panelDuU.add(stundenKiste);
        panelDuU.add(minutenKiste);
        panelDuU.add(dauerP);
        panelDuU.add(textDauerP);
        panelDuU.add(minP);
        //fuege zu panelNotiz fuer Notiz. 
        panelNotiz.add(notiz);
        panelNotiz.add(notizArea);
        //fuege zu pannelWieder fuer Wiederholen.
        panelWieder.add(wiederholbar);
        panelWieder.add(radioNein);
        panelWieder.add(radioJa);
        panelWieder.add(wieOft);
        wiederJoN.add(radioNein);
        wiederJoN.add(radioJa);
        
     // Hier werden die Container im Fenster angeordnet durch den Layoutmanager
        add(panelTerminTyp);
        add(panelBuK);
        add(panelDuU);
        add(panelNotiz);
        add(panelWieder);
        add(tage);
        add(speichern);
        
        pack();
        setVisible(true);
    }
    /**
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        
        
    }

}
