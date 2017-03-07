package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Klasse, welche die Daten des Benutzers anzeigt.
 * @author Christian Lindenberg
 */
public class UserInfoGUI extends JFrame {
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
     * Label Semester.
     */
    private JLabel lblSemester =
        new JLabel("Semester: ", SwingConstants.CENTER);
    /**
     * Label, welches das Semester des aktuellen Users anzeigt.
     */
    private JLabel lblUserSemester = new JLabel("");
    /**
     * Label ECTS.
     */
    private JLabel lblECTS = new JLabel("ECTS: ", SwingConstants.CENTER);
    /**
     * Label, welches die Credits des aktuellen Users anzeigt.
     */
    private JLabel lblUserECTS = new JLabel("");

    /**
     * Konstruktorklasse fuer die UserInfoGUI.
     */
    public UserInfoGUI() {
        setTitle("User Information");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        setLayout(new GridLayout(4, 2));
        setLocationRelativeTo(null); 
        
        add(lblName);
        add(lblUsername);
       
        add(lblStudiengang);
        add(lblUserStudiengang);
       
        add(lblSemester);
        add(lblUserSemester);
       
        add(lblECTS);
        add(lblUserECTS);
        
        //TODO Methode fuer befuellen der Felder
        
        pack();
        setVisible(true);
    }
}
