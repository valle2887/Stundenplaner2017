package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
     * Label name. 
     */
    private JLabel name = new JLabel("                Name                ");
    /** 
     * JTextField textName. 
     */
    private static JTextField textName = new JTextField(15);    
    /**
     * Label studiengang. 
     */
    private JLabel studiengang = new JLabel("Studiengang:             ");
    /**
     * JTextField textStudiengang. 
     */
    private JTextField textStudiengang = new JTextField(20);
    /**
     * Label neuePasswort.
     */
    private JLabel neuePasswort = new JLabel("neues Passwort:         ");

    /**
     * JPasswordField textNeuePasswrt. 
     */
    private JPasswordField textNeuePasswrt = new JPasswordField(20);

    /**
     * Label wiPasswort. 
     */
    private JLabel wiPasswort = new JLabel("Passwort wiederholen:");
    /**
     * JTextField textWiPasswort. 
     */
    private JPasswordField textWiPasswort = new JPasswordField(20);
    /**
     * Label ects. 
     */
    private JLabel ects = new JLabel("ECTS");

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
     * JPanel panelName.
     */
    private JPanel panelName = new JPanel();
    /**
     * JPanel panelStudiengang.
     */
    private JPanel panelStudiengang = new JPanel();
    /**
     * JPanel panelNeuePasswort.
     */
    private JPanel panelNeuePasswort = new JPanel();

    /**
     * JPanel panelWiPasswort.
     */
    private JPanel panelWiPasswort = new JPanel();
   
    /**
     * Konstruktor der Klasse RegistrierenGUI .
     */
    RegistrierenGUI() {
        
        setTitle("Registrierung");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridLayout(6, 2));
        setLocationRelativeTo(null);
        // Hier werden die Elemente den Containern hinzugefügt.        
        panelName.add(name);
        panelName.add(textName);
        
        panelStudiengang.add(studiengang);
        panelStudiengang.add(textStudiengang);
        
        panelName.add(ects);
        panelName.add(textEcts);
        
        panelNeuePasswort.add(neuePasswort);
        panelNeuePasswort.add(textNeuePasswrt);
        
        panelWiPasswort.add(wiPasswort);
        panelWiPasswort.add(textWiPasswort);
        
        // Hier werden die Container im Fenster angeordnet
        add(panelName);
        add(panelStudiengang);
        add(panelNeuePasswort);
        add(panelWiPasswort);
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
              //mit Bz. new Test(); wird ein neue window geoeffnet.  
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
