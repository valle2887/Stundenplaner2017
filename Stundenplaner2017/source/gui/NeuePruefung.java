package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * @author Rakan Al-Swayyed
 */
public class NeuePruefung extends JFrame implements ActionListener {
    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = 1240792690429142224L;
    /**
     * Label fach. 
     */
    private JLabel fach = new JLabel("      Fach:");
    /** 
     * JTextField textFach. 
     */
    private JTextField textFach = new JTextField(20);
    /**
     * Label campus. 
     */
    private JLabel campus = new JLabel("      Campus:");
    /** 
     * JTextField textCampus. 
     */
    private JTextField textCampus = new JTextField(20);
    /**
     * Label raum. 
     */
    private JLabel raum = new JLabel("      Raum:");
    /** 
     * JTextField textRaum. 
     */
    private JTextField textRaum = new JTextField(20);
    /**
     * JButton abbrechen.
     */
    private JButton abbrechen = new JButton("Abrechen");
    /**
     * JButton speichern.
     */
    private JButton speichern = new JButton("Speichern");
    /**
     * Konstruktor der Klasse NeuePruefung .
     */
    public NeuePruefung() {
        // TODO Auto-generated constructor stub
        setTitle("Neue Prüfung");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        setResizable(false);
        // Hier werden die Elemente den Containern hinzugefügt.
        add(fach);
        add(textFach);
        add(campus);
        add(textCampus);
        add(speichern);
        add(raum);
        add(textRaum);
        add(abbrechen);
        add(speichern);

        pack();
        setVisible(true);
        //  wenn auf JButton Abbrechen gedrueckt wird rufe fenster Login auf.
        abbrechen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                NeuePruefung.this.setVisible(false);
                NeuePruefung.this.dispose();
               //mit Bz. new Test(); wird ein neue window geoeffnet.   
            } 
        });
    }
    /**
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        
        
    }

}
