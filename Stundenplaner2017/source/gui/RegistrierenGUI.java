package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import daten.DatenVerwaltung;

/**
 * Die Klasse RegistrierenGUI enthält alle GUI-Elemente die zum Registrieren 
 * eines Benutzers benötigt werden.
 * 
 * @author Christian Lindenberg
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
        
        btnSpeichern.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                
                registerUser();
                
            }
            
        });
        
        btnAbbrechen.addActionListener(this);
        pack();
        setVisible(true);
        
    }

   /**
    * Methode, um die Eingaben auf Korrektheit zu ueberpruefen, bzw. ob Felder
    * leergelassen wurden.
    * @return eingabeKorrekt
    */ 
    public boolean eingabenUeberpruefen() {
        boolean eingabeKorrekt = true;
        if (txtUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username wurde nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        }
        if (txtStudiengang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Studiengang wurde nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        }
        if (pwPasswort.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Passwort wurde nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        }
        if (pwPasswortNochmal.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Das wiederholte Passwort "
                + "wurde nicht eingegeben.");
            eingabeKorrekt = false;
        }
        if (!pwPasswort.equals(pwPasswortNochmal)) {
            JOptionPane.showMessageDialog(null, "Passwoerter stimmen nicht "
                + "ueberein.");
            eingabeKorrekt = false;
        }
        
        if (txtECTS.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Credits wurden nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        }
        try {
            int i = Integer.parseInt(txtECTS.getText());
            if (i < 0) {
                JOptionPane.showMessageDialog(null, "Credits duerfen nicht "
                    + "negativ sein.");
                eingabeKorrekt = false;
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(null, "Credits duerfen nicht "
                   + "negativ sein.");
            eingabeKorrekt = false;
        }
        
        return eingabeKorrekt;
    }
    
    /**
     * Methode um einen User zu registrieren.
     */
    public void registerUser() {
        String name = txtUsername.getText();
        char[] passwort = pwPasswort.getPassword();
        char[] passwort2 = (char[]) pwPasswortNochmal.getPassword();
        String studiengang = txtStudiengang.getText();
        String punkte = txtECTS.getText();
        
        if (eingabenUeberpruefen()) {
            File schreiben = new File(name + ".txt");
            if (!schreiben.exists()) {
                try {
                    DatenVerwaltung.speichernVonBenutzerdaten(name, 
                        passwort, studiengang, punkte);

                    dispose();
                    new LoginGUI();            
                    
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            }
        }
    }
    /**
     * Methode um durch einen Klick auf den Button Speichern die Userdaten
     * zu speichern (noch nicht implementiert) oder durch Abbrechen die Aktion
     * abzubrechen.
     * @param event wird uebergeben
     */
    public void actionPerformed(ActionEvent event) {
        
        
        if (event.getSource() == btnSpeichern) {
            registerUser();
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
