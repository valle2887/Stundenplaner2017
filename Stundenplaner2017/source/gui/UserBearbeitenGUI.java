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

public class UserBearbeitenGUI extends JFrame implements ActionListener {
    
    /**
     * Automatisch generierte SerialVersionUID
     */
    private static final long serialVersionUID = 173569253861900744L;
    
    /**
     * Label und Textfeld um dem User einen neuen Namen geben zu können.
     */
    private JLabel lblNeuerName = 
        new JLabel("Neuer Name: ", SwingConstants.CENTER);
    private JTextField txtNeuerName = new JTextField(20);
    
    /**
     * Label und Textfeld um dem User einen neuen Studiengang geben zu können.
     */
    private JLabel lblNeuStudiengang = 
        new JLabel("Neuer Studiengang: ", SwingConstants.CENTER);
    private JTextField txtNeuStudiengang = new JTextField(20);
    
    /**
     * Label und Textfeld um dem User eine 
     * neue Anzahl an Creditpunkten zu geben.
     */
    private JLabel lblNeuECTS = 
        new JLabel("Neue ECTS: ", SwingConstants.CENTER);
    private JTextField txtNeuECTS = new JTextField(3);
    
    /**
     * Label und Passwortfeld um dem User ein neues Passwort geben zu können
     */
    private JLabel lblNeuPW = 
        new JLabel("Neues Passwort: ", SwingConstants.CENTER);
    private JPasswordField pwNeuPasswort = new JPasswordField(20);
    
    /**
     * Label und Passwortfeld zum erneutem 
     * angeben des neu gewählten Passwortes des Users
     */
    private JLabel lblPWnochmal = 
        new JLabel("Passwort wiederholen: ", SwingConstants.CENTER);
    private JPasswordField pwNeuPasswordNochmal = new JPasswordField(20);
    
    /**
     * Buttons um die Aktualisierten Daten zu 
     * speichern oder um den Vorgang abzubrechen
     */
    private JButton btnSpeichern = new JButton("Speichern");
    
    private JButton btnAbbruch = new JButton("Abbrechen");
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
    
    /**
     * Konstruktorklasse des Fensters um die User bearbeiten zu können
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
 
