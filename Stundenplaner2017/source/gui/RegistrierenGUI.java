package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Die Klasse RegistrierenGUI enthält alle GUI-Elemente die zum Registrieren 
 * eines Benutzers benötigt werden.
 * 
 * @author Rakan Al-Swayyed
 */
public class RegistrierenGUI extends JFrame implements ActionListener {

    /**
     * generated serial Version ID.
     */
    private static final long serialVersionUID = -7161567464410238478L;
    /**
     * Label benutzername. 
     */
    private JLabel benutzername = new JLabel("          Benutzername:");
    /** 
     * JTextField textBenutzername. 
     */
    private static JTextField textBenutzername = new JTextField(15);    
    /**
     * Label studiengang. 
     */
    private JLabel studiengang = new JLabel("          Studiengang:");
    /**
     * JTextField textStudiengang. 
     */
    private JTextField textStudiengang = new JTextField(20);
    /**
     * Label passwort.
     */
    private JLabel passwort = new JLabel("          Passwort:");

    /**
     * JPasswordField textPasswort. 
     */
    private JPasswordField textPasswort = new JPasswordField(20);

    /**
     * Label wiPasswort. 
     */
    private JLabel wiPasswort = new JLabel("          Passwort wiederholen:");
    /**
     * JTextField textWiPasswort. 
     */
    private JPasswordField textWiPasswort = new JPasswordField(20);
    /**
     * Label ects. 
     */
    private JLabel ects = new JLabel("          ECTS");

    /**
     * JTextField textEcts. 
     */
    private JTextField textEcts = new JTextField(3);
    /**
     * JButton speichern.
     */
    private JButton speichern = new JButton("Speichern");
    
    /**
     * JButton abbrechen.
     */
    private JButton abbrechen = new JButton("Abbrechen");
    /**
     * Konstruktor der Klasse RegistrierenGUI .
     */
    RegistrierenGUI() {
        
        setTitle("Registrierung");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridLayout(6, 2));
        setLocationRelativeTo(null);        
        // Hier werden die Container im Fenster angeordnet
        add(benutzername);
        add(textBenutzername);
        add(passwort);
        add(textPasswort);
        add(wiPasswort);
        add(textWiPasswort);
        add(ects);
        add(textEcts);
        add(studiengang);
        add(textStudiengang);
        add(speichern);
        add(abbrechen);
        pack();
        setVisible(true);
        //  wenn auf JButton Abbrechen gedrueckt wird rufe fenster Login auf.
        abbrechen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                RegistrierenGUI.this.setVisible(false);
                RegistrierenGUI.this.dispose();
                //mit new LoginGUI(); oeffnet fenster Login.
                new LoginGUI();
            } 
        });
    }
    /**
     * @param args .
     */
    public static void main(String[] args) {
        new RegistrierenGUI();
    }
    /**
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        
        
    }
}
