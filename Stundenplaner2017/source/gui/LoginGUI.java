package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import daten.DatenVerwaltung;

/**
 * Klasse des Loginfensters, erbt von JFrame.
 * 
 * @author Christian Lindenberg
 */
public class LoginGUI extends JFrame implements ActionListener {

    /**
     * Automatisch generierte SerialVersionUID.
     */
    private static final long serialVersionUID = 4962550853434863882L;

    /**
     * Label und Textfeld f&uuml;r den Usernamen.
     */
    private JLabel lblUsername = new JLabel("Username: ", +
        SwingConstants.CENTER);

    /**
     * JTextField.
     */

    private JTextField txtUsername = new JTextField(20);

    /**
     * Label und Passwortfeld für das Passwort des Users.
     */
    private JLabel lblPasswort = new JLabel("Passwort: ", +
        SwingConstants.CENTER);

    /**
     * JPasswordField.
     */

    private JPasswordField pwPasswort = new JPasswordField(20);

    /**
     * Buttons fuer den Login des Users und für die Registrierung eines neuen
     * Users.
     */
    private JButton btnLogin = new JButton("Login");

    /**
     * JButton.
     */

    private JButton btnRegister = new JButton("Registrieren");

    /**
     * Konstruktorklasse des Loginfensters.
     */

    public LoginGUI() {
        setLocationRelativeTo(null);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3, 2));
        this.add(lblUsername);
        this.add(txtUsername);
        this.add(lblPasswort);
        this.add(pwPasswort);
        this.add(btnLogin);
        this.add(btnRegister);

        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);

        pack();
        setVisible(true);
    }
    
    /**
     * ActionListener fuer die Buttons Login und Registrieren.
     * @param event wird uebergeben
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnLogin) {
           
            String benutzerName = txtUsername.getText();
            char[] passwortChar = pwPasswort.getPassword();
            String pw = new String(passwortChar);
            String dateiName = null;
            Scanner scan = null;
               
            File datei = new File(benutzerName + ".txt");
            if (datei.exists()) {
                dateiName = benutzerName;
                
                try {
                    scan = new Scanner(new File(dateiName + ".txt"));
                } catch (FileNotFoundException exc) {
                    // TODO Auto-generated catch block
                    exc.printStackTrace();
                }
            }
            try {
                if (DatenVerwaltung.vergleichPasswort(scan, benutzerName,
                        pw)) {
                    DatenVerwaltung.loadBenutzer(benutzerName);
                        
                    DatenVerwaltung.leseAufgabe(benutzerName);
             
                    DatenVerwaltung.lesePruefung(benutzerName);
              
                    DatenVerwaltung.leseVeranstaltung(benutzerName);
          
               
                    dispose();
                    new KalenderGui(); 
              
                }
                
                      
            } catch (IOException e) {
                e.printStackTrace();
                
                    
            }
        
        }
        if (event.getSource() == btnRegister) {
            dispose();
            new RegistrierenGUI();
        }
        // TODO Auto-generated method stub
                
                
    }
}



