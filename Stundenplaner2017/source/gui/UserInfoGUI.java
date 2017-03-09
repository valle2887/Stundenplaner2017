package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import daten.AktuelleSitzung;

/**
 * Klasse, welche die Daten des Benutzers anzeigt.
 * @author Christian Lindenberg
 */
public class UserInfoGUI extends JFrame {
    
    /**
     * UID.
     */
    private static final long serialVersionUID = 1470199715109444935L;
    /**
     * Label Username.
     */
    private JLabel lblName = new JLabel("Username: ", SwingConstants.CENTER);
    /**
     * Label, welches den Usernamen des aktuellen Users anzeigt.
     */
    private JLabel lblUsername = new JLabel("");
    /**
     * Label Studiengang.
     */
    private JLabel lblStudiengang = 
        new JLabel("Studiengang: ", SwingConstants.CENTER);
    /**
     * Label, welches den Studiengang des aktuellen Users anzeigt.
     */
    private JLabel lblUserStudiengang = new JLabel("");
    /**
     * Label ECTS.
     */
    private JLabel lblECTS = new JLabel("ECTS: ", SwingConstants.CENTER);
    /**
     * Label, welches die Credits des aktuellen Users anzeigt.
     */
    private JLabel lblUserECTS = new JLabel("");

    /**
     * Methode um die Daten des aktuellen Benutzers in den UserLabels 
     * anzeigen zu lassen.
     */
    public void infoAnzeigen() {
        lblUsername.setText(AktuelleSitzung.getBenutzer().getUsername());
        lblUserStudiengang.setText(
            AktuelleSitzung.getBenutzer().getStudiengang());
        lblUserECTS.setText(AktuelleSitzung.getBenutzer().getEcts());
    }
    /**
     * Konstruktorklasse fuer die UserInfoGUI.
     */
    
   
    public UserInfoGUI() {
        setTitle("User Information");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null); 
        
        add(lblName);
        add(lblUsername);
       
        add(lblStudiengang);
        add(lblUserStudiengang);
       
        add(lblECTS);
        add(lblUserECTS);
        
        infoAnzeigen();
        
        //TODO Methode fuer befuellen der Felder
        
        pack();
        setVisible(true);
    }
}
