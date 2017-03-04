package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);

        pack();
        setVisible(true);
    }
    /** 
     * Ueberprueft die Logindaten des Users.
     * @param benutzerName Der name des Users.
     * @param passwort Das Passwort des Users
     *      werden uebergeben
     * @return loginErfolgreich
     */
    private boolean checkLogin(Benutzer benutzerName, String passwort) {
        boolean loginErfolgreich = false;
        if (benutzerName.equals(Benutzer.getUsername()) 
            && passwort.equals(Benutzer.getPasswort())) {
            AktuelleSitzung.setBenutzer(benutzerName);
            try {
                DatenVerwaltung.loadBenutzer(benutzerName);
            } catch (IOException exc1) {
                // TODO Auto-generated catch block
                exc1.printStackTrace();
            }
            try {
                DatenVerwaltung.leseAufgabe(benutzerName);
            } catch (IOException exc) {
                // TODO Auto-generated catch block
                exc.printStackTrace();
            }
            try {
                DatenVerwaltung.lesePruefung(benutzerName);
            } catch (IOException exc) {
                // TODO Auto-generated catch block
                exc.printStackTrace();
            }
            try {
                DatenVerwaltung.leseVeranstaltung(benutzerName);
            } catch (IOException exc) {
                // TODO Auto-generated catch block
                exc.printStackTrace();
            }
            loginErfolgreich = true;
        }
        return loginErfolgreich;
    }
    

    /**
     * ActionListener fuer die Buttons Login und Registrieren.
     * @param event wird uebergeben
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnLogin) {
            if (checkLogin(txtUsername.getText(),
                new String(pwPasswort.getPassword()))) {

                dispose();
                new KalenderGui(); 
            }
            
        } else {   
            JOptionPane.showMessageDialog(null,
                "Username oder Passwort falsch");
        }
        if (event.getSource() == btnRegister) {
            dispose();
            new RegistrierenGUI();
        }
        // TODO Auto-generated method stub
    }
}

