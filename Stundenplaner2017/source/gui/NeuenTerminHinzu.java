package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private JLabel kategorie = new JLabel("Kategorie");
    /**
     * Array vArray mit zwei unterschiedlichen kategorien Universität und 
     * private. 
     */
    private String[] vArray = {"Universität", "private"};
    /**
     * JComboBox vKiste. 
     */
    private JComboBox<Object> vKiste = new JComboBox<Object>(vArray);
    /**
     * Label Datum. 
     */
    private JLabel datum = new JLabel("Datum");
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
     * Label dauer. 
     */
    private JLabel dauer = new JLabel("Dauer:");
    /**
     * JTextField textDauer. 
     */
    private JTextField textDauer = new JTextField(3);
    /**
     * JTextArea kommentar. 
     */
    private JTextArea kommentar = new JTextArea(40, 3);
    /**
     * Label artDesTermins. 
     */
    private JLabel artDesTermins = new JLabel("Bitte wählen Sie Art des "
        + "Termins:");
    /**
     * JButton aufgabe.
     */
    private JButton aufgabe = new JButton("Aufgabe");
    /**
     * JButton veranstaltung.
     */
    private JButton veranstaltung = new JButton("Veranstaltung");
    /**
     * JButton pruefung.
     */
    private JButton pruefung = new JButton("Prüfung");
    
    /**
     * JButton abbrechen.
     */
    private JButton abbrechen = new JButton("Abrechen");
    /**
     * JButton speichern.
     */
    private JButton speichern = new JButton("Speichern");
    /**
     * JPanel panelDatum.
     */
    private JPanel panelDatum = new JPanel();
    /**
     * JPanel panelUhrzeit.
     */
    private JPanel panelUhrzeit = new JPanel();
    /**
     * JPanel panelDauer.
     */
    private JPanel panelDauer = new JPanel();
    /**
     * Konstruktor der Klasse NeuenTerminHinzu .
     */
    public NeuenTerminHinzu() {
        // TODO Auto-generated constructor stub
        setTitle("Termin Hinzufuegen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 1));
        setResizable(false);
        
        panelDatum.add(datum);
        panelDatum.add(tagKiste);
        panelDatum.add(monatKiste);
        panelDatum.add(jahrKiste);
        
        panelUhrzeit.add(stundenKiste);
        panelUhrzeit.add(minutenKiste);
        
        panelDauer.add(dauer);
        panelDauer.add(textDauer);
        
        
        add(bezeichnung);
        add(textBezeichnung);
        add(kategorie);
        add(vKiste);
        add(panelDatum);
        add(panelUhrzeit);
        add(panelDauer);
        add(aufgabe);
        add(veranstaltung);
        add(pruefung);
        add(abbrechen);
        add(speichern);
        
        
        pack();
        setVisible(true);
    }
    /**
     * @param args .
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new NeuenTerminHinzu();
    }
    /**
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        
        
    }

}
