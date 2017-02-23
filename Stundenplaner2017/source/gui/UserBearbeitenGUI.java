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
     * Label, um dem User einen neuen Namen geben zu koennen.
     */
    private JLabel lblNeuerName = 
        new JLabel("Neuer Name: ", SwingConstants.CENTER);
    
    /**
     * Textfeld, um dem User einen neuen Namen geben zu koennen.
     */
    private JTextField txtNeuerName = new JTextField(20);
    
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
    private JButton btnAbbruch = new JButton("Abbrechen");
    
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
    }
    
    /**
     * Konstruktorklasse des Fensters um die User bearbeiten zu koennen.
     */
    public UserBearbeitenGUI() {
        setLocationRelativeTo(null);
        setTitle("Benutzerdaten ändern");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(6, 2));
        
        this.add(lblNeuerName);
        this.add(txtNeuerName);
        
        this.add(lblNeuStudiengang);
        this.add(txtNeuStudiengang);
        this.add(lblNeuECTS);
        this.add(txtNeuECTS);
        
        this.add(lblNeuPW);
        this.add(pwNeuPasswort);
        
        this.add(lblPWnochmal);
        this.add(pwNeuPasswordNochmal);
        
        this.add(btnSpeichern);
        this.add(btnAbbruch);
        
        pack();
        setVisible(true);
    }
}
 
