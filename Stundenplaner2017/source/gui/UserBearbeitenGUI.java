package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import daten.AktuelleSitzung;
import daten.Benutzer;
import daten.UserVerwaltung;

/** Klasse, um das Fenster zum Bearbeiten eines Users aufzurufen, erbt von
 * JFrame und implementiert ActionListener.
 * @author Christian Lindenberg
 */
public class UserBearbeitenGUI extends JFrame implements ActionListener {
    
    /**
     * Automatisch generierte SerialVersionUID.
     */
    private static final long serialVersionUID = 173569253861900744L;
    
    /**
     * Label um dem User einen neuen Studiengang geben zu koennen.
     */
    private JLabel lblNeuStudiengang = 
        new JLabel("Neuer Studiengang: ", SwingConstants.CENTER);
    /**
     * Textfeld, um dem User einen neuen Studiengang geben zu koennen.
     */
    private JTextField txtNeuStudiengang = new JTextField(20);
    
    /**
     * Label um dem User eine neue Anzahl an Creditpunkten zu geben.
     */
    private JLabel lblNeuECTS = 
        new JLabel("Neue ECTS: ", SwingConstants.CENTER);
    /** Textfeld, um dem User eine neue Anzahl an Creditpunkten zu geben.
     */
    private JTextField txtNeuECTS = new JTextField(3);
    /**
     * Label fuer das neue Passwort.
     */
    private JLabel lblNeuPasswort = new JLabel("Neues Passwort: "
        , SwingConstants.CENTER);
    /**
     * Textfeld fuer das neue Passwort.
     */
    private JTextField txtNeuPasswort = new JTextField(20);
    /**
     * Label fuer das nochmals eingegebene Passwort.
     */
    private JLabel lblPasswortNochmal = new JLabel("Passwort nochmal "
        , SwingConstants.CENTER);
    /**
     * Textfeld fuer das nochmal eingegebene Passwort.
     */
    private JTextField txtNeuPasswortNochmal = new JTextField(20);
    
    /**
     * Button um die aktualisierten Daten zu speichern.
     */
    private JButton btnSpeichern = new JButton("Speichern");
    /**
     * Button um das aktualisieren er Daten abzubrechen.
     */
    private JButton btnAbbrechen = new JButton("Abbrechen");
    /**
     * Button um einen Benutzer zu loeschen.
     */
    private JButton btnLoeschen = new JButton("Loeschen");
    /**
     * Methode fuer die Buttonklicks, wenn auf Speichern gedrueckt wird,
     * werden die geaenderten Daten gespeichert, und wenn auf abbrechen
     * gedrueckt wird, kommt der User wieder ins Hauptfenster zurueck.
     * @param event 
     */
    /**
     * Methode, um einen bestehenden Nutzer zu loeschen.
     * @param userName wird uebergeben
     * @return userGeloescht
     */
    public boolean userLoeschen(String userName) {
        AktuelleSitzung.getBenutzer();
        userName = Benutzer.getUserName();
        File file = new File(userName + ".txt");
        boolean userGeloescht = file.delete();
        return userGeloescht;
        
    }

    /**
     * Methode, zum aendern der UserDaten.
     */
    public void userAendern() {
        String[] daten = new String[4];
        daten[0] = txtNeuPasswort.getText();
        daten[1] = txtNeuStudiengang.getText();
        daten[2] = txtNeuECTS.getText();
        daten[3] = txtNeuPasswortNochmal.getText();

        if (!daten[0].equals("")) {
            if (daten[0].equals(daten[3])) {
                try {
                    UserVerwaltung.bearbeitenBenutzer(LoginGUI.nameLogin(),
                        daten);
                    AktuelleSitzung.getAktuelleSitzung();
                    AktuelleSitzung.getBenutzer().setStudiengang(daten[1]);
                    AktuelleSitzung.getBenutzer().setEcts(daten[2]);    
                    AktuelleSitzung.getBenutzer().setPasswort(daten[0]);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(null, "Error!");
                }
                dispose();
                new KalenderGui(AktuelleSitzung.getBenutzer());
            } else {
                
                JOptionPane.showMessageDialog(null, "Passwoerter stimmen "
                    + "nicht ueberein!");
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bitte Passwort eingeben!");
        }
    }
    
    /**
     * Konstruktorklasse des Fensters um die User bearbeiten zu koennen.
     */
    public UserBearbeitenGUI() {
        setLocationRelativeTo(null);
        setTitle("Benutzerdaten ändern");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(7, 2));
        this.add(lblNeuStudiengang);
        this.add(txtNeuStudiengang);
        this.add(lblNeuECTS);
        this.add(txtNeuECTS);
        this.add(lblNeuPasswort);
        this.add(txtNeuPasswort);
        this.add(lblPasswortNochmal);
        this.add(txtNeuPasswortNochmal);
        this.add(btnSpeichern);
        this.add(btnAbbrechen);
        this.add(btnLoeschen);
        txtNeuECTS.setText(AktuelleSitzung.getBenutzer().getEcts());
        AktuelleSitzung.getBenutzer();
        txtNeuStudiengang.setText(
            Benutzer.getStudiengang());
        btnAbbrechen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();       
            }
        });
        btnLoeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int wirklich = JOptionPane.showConfirmDialog(null,
                    "Wirklich loeschen?", "Wirklich loeschen?",
                    JOptionPane.YES_NO_OPTION);
                if (wirklich == JOptionPane.YES_OPTION) {
                    AktuelleSitzung.getBenutzer();
                    UserVerwaltung.loeschenBenutzer(Benutzer.getUserName());
                    dispose();
                    new LoginGUI();
                } else if (wirklich == JOptionPane.NO_OPTION) {
                    JOptionPane.getRootFrame().dispose();
                }
            } 
        });
        btnSpeichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    userAendern();      
                    
            }         
        });
        pack();
        setVisible(true);
    }
/**
 * Autogeneriert.
 * @param e 
 */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
   
