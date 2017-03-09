package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Rakan Al-Swayyed
 * brauchen wir vielleicht nicht wegen dialog.
 */
public class TerminUebersicht extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 3595038144600060637L;
    /**
     * JButton loeschen.
     */
    private JButton loeschen = new JButton("Löschen");
    /**
     * JButton bearbeiten.
     */
    private JButton bearbeiten = new JButton("Bearbeiten");
    /**
     * 
     */
    public TerminUebersicht() {
        setTitle("Termin Übersicht");

        erzeugePanel();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(770, 560);


        setVisible(true);
    }
    /**
     * 
     */
    private void erzeugePanel() {
        BorderLayout bLayout = new BorderLayout();
        GridLayout grid = new GridLayout(6, 1);

        //JPanel p
        JPanel p = new JPanel();
        final JPanel liste = new JPanel();
        liste.setLayout(grid);
         //JScrollPane scroll.
        JScrollPane scroll = new JScrollPane(liste);
        
        p.setLayout(bLayout);
        p.add(new JLabel("Deine Termine: "), BorderLayout.NORTH);
        p.add(scroll, BorderLayout.EAST);
        
        add(p);
        liste.add(bearbeiten);
        liste.add(loeschen);
    }
    /**
     * @param args .
     */
    public static void main(String[] args) {
        new TerminUebersicht();
    }
    /**
     * @param e
     *            .
     */
    public void actionPerformed(ActionEvent e) {

    }
}
