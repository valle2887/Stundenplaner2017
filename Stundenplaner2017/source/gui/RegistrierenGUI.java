package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Die Klasse RegistrierenGUI enthält alle GUI-Elemente die zum Registrieren 
 * eines Benutzers benötigt werden.
 * 
 * @author Rakan Al-Swayyed
 */
public class RegistrierenGUI extends JFrame implements ActionListener {

    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = -7161567464410238478L;
    /**
     * Label benutzername. 
     */
    private JLabel lblUsername = 
        new JLabel("Benutzername: ", SwingConstants.CENTER);
    /** 
     * JTextField textBenutzername. 
     */
    private static JTextField txtUsername = new JTextField(20);    
    /**
     * Label studiengang. 
     */
    private JLabel lblStudiengang = 
        new JLabel("Studiengang: ", SwingConstants.CENTER);
    /**
     * JTextField textStudiengang. 
     */
    private JTextField txtStudiengang = new JTextField(20);
    /**
     * Label passwort.
     */
    private JLabel lblPasswort = 
        new JLabel("Passwort: ", SwingConstants.CENTER);

    /**
     * JPasswordField textPasswort. 
     */
    private JPasswordField pwPasswort = new JPasswordField(20);

    /**
     * Label wiPasswort. 
     */
    private JLabel lblPasswortNochmal = new 
        JLabel("Passwort wiederholen:", SwingConstants.CENTER);
    /**
     * JTextField textWiPasswort. 
     */
    private JPasswordField pwPasswortNochmal = new JPasswordField(20);
    /**
     * Label ects. 
     */
    private JLabel lblECTS = new JLabel("ECTS:", SwingConstants.CENTER);

    /**
     * JTextField txtEcts. 
     */
    private JTextField txtECTS = new JTextField(3);
    /**
     * JButton speichern.
     */
    private JButton btnSpeichern = new JButton("Speichern");
    
    /**
     * JButton abbrechen.
     */
    private JButton btnAbbrechen = new JButton("Abbrechen");
    /**
     * Konstruktor der Klasse RegistrierenGUI .
     */
    RegistrierenGUI() {
        
        setTitle("Registrierung");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridLayout(6, 2));
        setLocationRelativeTo(null);        
        // Hier werden die Container im Fenster angeordnet
        add(lblUsername);
        add(txtUsername);
        add(lblPasswort);
        add(pwPasswort);
        add(lblPasswortNochmal);
        add(pwPasswortNochmal);
        add(lblECTS);
        add(txtECTS);
        add(lblStudiengang);
        add(txtStudiengang);
        add(btnSpeichern);
        add(btnAbbrechen);
        pack();
        setVisible(true);
        //  wenn auf JButton Abbrechen gedrueckt wird rufe fenster Login auf.
        
    }
    /**
     * Methode um durch einen Klick auf den Button Speichern die Userdaten
     * zu speichern (noch nicht implementiert) oder durch Abbrechen die Aktion
     * abzubrechen.
     * @param event wird uebergeben
     */
    public void actionPerformed(ActionEvent event) {
        
        if (event.getSource() == btnSpeichern) {
            dispose();
            new LoginGUI();
        } else {
            
            
            if (event.getSource() == btnAbbrechen) {
                dispose();
                new LoginGUI();
            } 
            
        }
        
    }
    
}
