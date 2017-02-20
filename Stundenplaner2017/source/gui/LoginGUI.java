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
public class LoginGUI extends JFrame implements ActionListener {

    /**
     * Automatisch generierte SerialVersionUID
     */
    private static final long serialVersionUID = 4962550853434863882L;
    
    /**
     * Label und Textfeld für den Usernamen.
     */
    private JLabel lblUsername 
        = new JLabel("Username: ", SwingConstants.CENTER);
    
//    private JLabel txtUsername = new JTextField(20);
    
    /**
     * Label und Passwortfeld für das Passwort des Users.
     */
    private JLabel lblPasswort
        = new JLabel("Passwort: ", SwingConstants.CENTER);
    
    private JPasswordField pwPasswort = new JPasswordField(20);
    
    /**
     * Buttons für den Login des Users und für die 
     * Registrierung eines neuen Users
     */
    private JButton btnLogin = new JButton("Login");
    
    private JButton btnRegister = new JButton("Registrieren");
    
    /**
     * Konstruktorklasse des Loginfensters
    */
    public LoginGUI() {
        setLocationRelativeTo(null);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLayout(new GridLayout(3, 2));
        this.add(lblUsername);
//        this.add(txtUsername);
    
        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        
        pack();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
 