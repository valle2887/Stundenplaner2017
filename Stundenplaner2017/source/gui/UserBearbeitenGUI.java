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
     * Label um dem User ein neues Passwort geben zu koennen.
     */
    private JLabel lblNeuPW = 
        new JLabel("Neues Passwort: ", SwingConstants.CENTER);
    /**
     * Passwortfeld, um dem User ein neues Passwort geben zu koennen.
     */
    private JPasswordField pwNeuPasswort = new JPasswordField(20);
    
    /**
     * Label zum erneutem angeben des neu gewaehlten Passwortes des Users.
     */
    private JLabel lblPWnochmal = 
        new JLabel("Passwort wiederholen: ", SwingConstants.CENTER);
    /**
     * Passwortfeld zum erneuten angeben des neu gewaehlten Passwortes des
     * Users.
     */
    private JPasswordField pwNeuPasswordNochmal = new JPasswordField(20);
    
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
        userName = Benutzer.getUsername();
        File file = new File(userName + ".txt");
        boolean userGeloescht = file.delete();
        return userGeloescht;
        
    }
    
    /**
     * Methode, die den Buttonklick ausfuehrt.
     * @param event wird uebergeben
     */
    /*
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnSpeichern) {
            dispose();
            new LoginGUI();
        } else {
            
            
            if (event.getSource() == btnAbbrechen) {
                dispose();
                new KalenderGui();
            } 
            
            
            if (event.getSource() == btnLoeschen) {
                int auswahl = JOptionPane.showConfirmDialog(null,
                    "Wirklich loeschen?", "Wirklich loeschen?",
                    JOptionPane.YES_NO_OPTION);
                if (auswahl == JOptionPane.YES_OPTION) {
                    userLoeschen(getName());
                } else if (auswahl == JOptionPane.NO_OPTION) {
                    dispose();
                }
                    
            }
        }
    }
    */
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
        
        this.add(lblNeuPW);
        this.add(pwNeuPasswort);
        
        this.add(lblPWnochmal);
        this.add(pwNeuPasswordNochmal);
        
        this.add(btnSpeichern);
        this.add(btnAbbrechen);
        this.add(btnLoeschen);
        
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
                    UserVerwaltung.loeschenBenutzer(Benutzer.getUsername());
                    dispose();
                    new LoginGUI();
                } else if (wirklich == JOptionPane.NO_OPTION) {
                    JOptionPane.getRootFrame().dispose();
                }
            }
            
            
        });
        
        pack();
        setVisible(true);
        


            
       
    }


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
 
