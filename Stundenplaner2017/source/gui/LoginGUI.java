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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import daten.AktuelleSitzung;
import daten.Benutzer;
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
        pack();
        setVisible(true);    
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrierenGUI();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e1) {
                String name = txtUsername.getText();
                char[] passwortChar = pwPasswort.getPassword();
                String passwort = new String(passwortChar);
                String dateiName;
                Scanner dateiScanner = null;               
                File file = new File(name + ".txt");
                if (file.exists()) {
                    dateiName = name;
                    
                    try {
                        dateiScanner = 
                            new Scanner(new File(dateiName + ".txt"));
                    } catch (FileNotFoundException exc) {
                        JOptionPane.showMessageDialog(null, "ERROR!", 
                            "ERROR!", JOptionPane.ERROR_MESSAGE);
                        exc.printStackTrace();
                    }
                }
                try {
                    if (DatenVerwaltung.vergleichPasswort(dateiScanner, name,
                            passwort)) {
                        Benutzer benutzer =
                            DatenVerwaltung.loadBenutzer(name);
                        DatenVerwaltung.leseAufgabe(name);
                        DatenVerwaltung.lesePruefung(name);
                        DatenVerwaltung.leseVeranstaltung(name);
                        AktuelleSitzung aktuelleSitzung =
                            AktuelleSitzung.getAktuelleSitzung();
                        aktuelleSitzung.setBenutzer(benutzer);
                        new KalenderGui();           
                   
                        dispose();
                  
                    }
                    
                          
                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(null, "ERROR!", 
                        "ERROR!", JOptionPane.ERROR_MESSAGE);
                    e2.printStackTrace();   
                }  
            }
        });
            
        
    }

    /**
     * Autogenerierte Methode.
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
            



