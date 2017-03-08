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
import daten.UserVerwaltung;

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
    private JLabel lblUsername =
        new JLabel("Username: ", +SwingConstants.CENTER);

    /**
     * JTextField.
     */

    private static JTextField txtUsername = new JTextField(20);

    /**
     * Label und Passwortfeld für das Passwort des Users.
     */
    private JLabel lblPasswort =
        new JLabel("Passwort: ", +SwingConstants.CENTER);

    /**
     * JPasswordField.
     */

    private JPasswordField pwPasswort = new JPasswordField(20);

    /**
     * Methode zum einlesen des benutzernamens.
     * 
     * @return benutzerName
     */
    public static String nameLogin() {
        String benutzerName = txtUsername.getText();
        return benutzerName;
    }

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
            public void actionPerformed(ActionEvent event) {
                dispose();
                new RegistrierenGUI();
            }
        });

        btnLogin.addActionListener(this);
        pwPasswort.addActionListener(this);

    }

    /**
     * Autogenerierte Methode.
     * 
     * @param e
     *            .
     */
    public void actionPerformed(ActionEvent e) {
        String username = txtUsername.getText();
        char[] passwortChar = pwPasswort.getPassword();
        String passwort = new String(passwortChar);
        String dateiName = null;
        Scanner dateiScanner = null;
        File file = new File(username + ".txt");
        if (file.exists()) {
            dateiName = username;
            try {
                dateiScanner = new Scanner(new File(dateiName + ".txt"));
            } catch (FileNotFoundException exc) {
                JOptionPane.showMessageDialog(null, "ERROR!", "ERROR!",
                    JOptionPane.ERROR_MESSAGE);
                exc.printStackTrace();
            }
        }
        try {
            if (UserVerwaltung.vergleichPasswort(dateiScanner, dateiName,
                passwort)) {
                Benutzer benutzer = UserVerwaltung.loadBenutzer(username);
                DatenVerwaltung.leseAufgabe(username);
                DatenVerwaltung.lesePruefung(username);
                DatenVerwaltung.leseVeranstaltung(username);
                AktuelleSitzung aktuelleSitzung =
                    AktuelleSitzung.getAktuelleSitzung();
                aktuelleSitzung.setBenutzer(benutzer);
                // JOptionPane.showMessageDialog(null, "ERROR123!");
                new KalenderGui();
                dispose();

            } else {
                JOptionPane.showMessageDialog(null,
                    "Anmeldedaten " + "stimmen nicht ueberein!");
            }

        } catch (IOException e2) {

            e2.printStackTrace();
        }

    }

}
