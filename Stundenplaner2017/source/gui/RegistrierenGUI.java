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

import daten.UserVerwaltung;

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
                dispose();
                new LoginGUI();
                
            }
            
        });
        
        btnAbbrechen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
                new LoginGUI();
            }
        });
        pack();
        setVisible(true);
        
    }

   /**
    * Methode, um die Eingaben auf Korrektheit zu ueberpruefen, bzw. ob Felder
    * leergelassen wurden.
    * @return eingabeKorrekt
    */ 
    public boolean eingabenUeberpruefen() {
        String pass, wiederholen;
        pass = new String(pwPasswort.getPassword());
        wiederholen = new String(pwPasswortNochmal.getPassword());
        boolean eingabeKorrekt = true;
        if (txtUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username wurde nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        } else if (txtStudiengang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Studiengang wurde nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        } else if (pwPasswort.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Passwort wurde nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        } else if (pwPasswortNochmal.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Das wiederholte Passwort "
                + "wurde nicht eingegeben.");
            eingabeKorrekt = false;
        } else if (!pass.isEmpty() && !pass.equals(wiederholen)) {
            JOptionPane.showMessageDialog(null, "Passwoerter stimmen nicht "
                + "ueberein.");
            eingabeKorrekt = false;
       
        } else if (txtECTS.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Credits wurden nicht "
                + "eingegeben.");
            eingabeKorrekt = false;
        } else if (pass.isEmpty() || !pass.equals(wiederholen)) {
            JOptionPane.showMessageDialog(null, "Bitte das erste Passwort "
                + "eingeben.");
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
        String userName = txtUsername.getText();
        char[] passwort = pwPasswort.getPassword();
        String studiengang = txtStudiengang.getText();
        String ects = txtECTS.getText();
        /*
         * Wenn alles in richtig eingegeben wurde, wird ueberprueft ob schon
         * eine Datei mit dem Namen vorhanden ist, wenn dies nicht der Fall
         * ist, wird die Methode in UserVerwaltung speichernVonBenutzerDaten
         * ausgefuehrt.
         */
        if (eingabenUeberpruefen()) {
            File schreiben = new File(userName + ".txt");
            if (!schreiben.exists()) {
                try {
                    UserVerwaltung.speichernVonBenutzerdaten(userName, 
                        passwort, studiengang, ects);

                    dispose();
                    new LoginGUI();            
                    
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            } else {
                JOptionPane.showMessageDialog(null, "User existiert bereits!");
            }
        }
    }

    /**
     * Automatisch generierte Methode.
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
        
    
}
