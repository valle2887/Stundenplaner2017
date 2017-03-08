package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Klasse Gui.
 * 
 * @author Valerian Tjunnikov
 */
public class KalenderGui extends JFrame implements ActionListener {

    /**
     * 
     */
    private LocalDateTime date = LocalDateTime.now();

    /**
     * 
     */
    private int kalenderwoche = getKalenderwoche();

    /**
     * 
     */
    private JMenuBar menueBar = new JMenuBar();

    /**
     * 
     */
    private JMenu info = new JMenu("Info");

    /**
     * 
     */
    private JMenu kw = new JMenu("kw");

    /**
     * 
     */
    private JButton buttonLinks = new JButton("<<");

    /**
     * 
     */
    private JButton buttonRechts = new JButton(">>");

    /**
     * 
     */
    private JLabel txtWoche = new JLabel("Woche");

    /**
     * 
     */
    private JTable table = new JTable();

    /**
     * 
     */
    private JScrollPane scrollPane = new JScrollPane(table);

    /**
     * 
     */
    private JPanel contentPane = new JPanel();

    /**
     * 
     */
    private JMenu benutzer = new JMenu("Benutzer");

    /**
     * 
     */
    private JMenuItem benutzerAnzeigen = new JMenuItem("Benutzer Info");

    /**
     * 
     */
    private JMenuItem benutzerAusloggen = new JMenuItem("Benutzer ausloggen");

    /**
     * 
     */
    private JMenuItem benutzerBarbeiten = new JMenuItem("Benutzer bearbeiten");

    /**
     * 
     */
    private JMenu termin = new JMenu("Termine");

    /**
     * 
     */
    private JMenuItem terminBearbeiten = new JMenuItem("Terminbearbeiten");

    /**
     * 
     */
    private JMenuItem neuerTermin = new JMenuItem("Neuer Termin");

    /**
     * 
     */
    private JMenuItem termineExportieren = new JMenuItem("Termine exportieren");

    /**
     * 
     */
    private JMenuItem termineImportieren = new JMenuItem("Termine importieren");

    /**
     * 
     */
    private DefaultTableModel tabellenmodellGruppeA;

    /**
     * 
     */
    private Container mainContainer;

    /**
     * 
     */
    // Spalten anlegen
    private String[] spalten =
        { "Uhrzeit", "Mo.", "Di.", "Mi.", "Do.", "Fr.", "Sa.", "So." };

    /**
     * 
     */
    // zeilen anlegen
    private String[][] zeilen =
        { { "01:00" }, { "02:00" }, { "03:00" }, { "04:00" }, { "05:00" },
            { "06:00" }, { "07:00" }, { "08.00" }, { "09:00" }, { "10:00" },
            { "11:00" }, { "12:00" }, { "13:00" }, { "14:00" }, { "15:00" },
            { "16:00" }, { "17:00" }, { "18:00" }, { "19:00" }, { "20:00" },
            { "21:00" }, { "22:00" }, { "23:00" }, { "00:00" } };

    /**
     * 
     */
    public KalenderGui() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        LocalDateTime montag =
            date.minusDays(date.getDayOfWeek().getValue() - 1);
        LocalDateTime sonntag =
            date.plusDays(7 - date.getDayOfWeek().getValue());

        setTitle("Kalender - KW " + kalenderwoche + " von " + formatDate(montag)
            + " bis " + formatDate(sonntag));

        menueBar.add(benutzer);
        menueBar.add(termin);
        menueBar.add(info);
        menueBar.add(buttonLinks);
        menueBar.add(buttonRechts);

        buttonLinks.addActionListener(this);
        buttonRechts.addActionListener(this);

        txtWoche = new JLabel();
        txtWoche.setText("Woche");
        menueBar.add(txtWoche);
        txtWoche.setPreferredSize(new Dimension(30, 2));

        menueBar.add(buttonRechts);

        benutzer.add(benutzerAnzeigen);
        benutzerAnzeigen.addActionListener(this);
        benutzer.add(benutzerBarbeiten);
        benutzerBarbeiten.addActionListener(this);
        benutzer.add(benutzerAusloggen);
        benutzerAusloggen.addActionListener(this);
        termin.add(neuerTermin);
        neuerTermin.addActionListener(this);
        termin.add(terminBearbeiten);
        terminBearbeiten.addActionListener(this);
        termin.add(termineExportieren);
        termineExportieren.addActionListener(this);
        termin.add(termineImportieren);

        this.setJMenuBar(menueBar);

        this.mainContainer = this.getContentPane();

        this.mainContainer.setLayout(new BorderLayout());

        tabellenmodellGruppeA = new DefaultTableModel(zeilen, spalten);

        table = new JTable(tabellenmodellGruppeA);
        table.getTableHeader().setEnabled(false);

        table.setAutoResizeMode(4);

   
        gedrueck();

        mainContainer.add(new JScrollPane(table));
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    /**
     * @return datum3
     */

    public int getKalenderwoche() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String datum = cal.get(Calendar.DAY_OF_MONTH) + ".";
        datum += (cal.get(Calendar.MONTH) + 1) + ".";
        datum += cal.get(Calendar.YEAR);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String datum2 = (cal.get(Calendar.DAY_OF_MONTH) + 1) + ".";
        datum2 += (cal.get(Calendar.MONTH) + 1) + ".";
        datum2 += cal.get(Calendar.YEAR);
        int datum3 = (cal.get(Calendar.WEEK_OF_YEAR));
        return datum3;
    }

    /**
     * 
     */
    public void gedrueck() {

        benutzerAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setResizable(false);
                setLocationRelativeTo(null);
                new UserInfoGUI();
            }
        });

        benutzerAusloggen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI();

            }
        });

        benutzerBarbeiten.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserBearbeitenGUI();

            }
        });

        neuerTermin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                KalenderGui.this.setVisible(false);
                new NeuenTerminHinzu();
            }
        });

        terminBearbeiten.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        termineExportieren.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        info.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        buttonLinks.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    /**
     * @return formatter
     * @param date
     */
    private String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("E dd.MMMM.yyyy");
        return formatter.format(date);
    }

    /**
     *
     * 
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buttonLinks)) {
            date = date.minusDays(7);

            kalenderwoche--;

            LocalDateTime montag =
                date.minusDays(date.getDayOfWeek().getValue() - 1);
            LocalDateTime sonntag =
                date.plusDays(7 - date.getDayOfWeek().getValue());

            setTitle("Kalender - KW " + kalenderwoche + " von "
                + formatDate(montag) + " bis " + formatDate(sonntag));

            buttonRechts.setText(">>" + (kalenderwoche + 1));
            buttonLinks.setText((kalenderwoche - 1) + "<<");

        } else if (e.getSource().equals(buttonRechts)) {
            date = date.plusDays(7);

            kalenderwoche++;

            LocalDateTime montag =
                date.minusDays(date.getDayOfWeek().getValue() - 1);
            LocalDateTime sonntag =
                date.plusDays(7 - date.getDayOfWeek().getValue());

            setTitle("Kalender - KW " + kalenderwoche + " von "
                + formatDate(montag) + " bis " + formatDate(sonntag));

            buttonRechts.setText(">>" + (kalenderwoche + 1));
            buttonLinks.setText((kalenderwoche - 1) + "<<");

        }

    }
////    mausListener
//    /**
//     * @param e
//     */
//    public void mousePressed(KalenderGui kalenderGui) {
//
//        if (MouseEvent.BUTTON1 == 2) {
//            new NeuenTerminHinzu();
//        } else if (MouseEvent.BUTTON2 == 1) {
//            JPopupMenu popmen = new JPopupMenu();
//            popmen.add(terminBearbeiten);
//            popmen.add(termineExportieren);
//            popmen.add(termineImportieren);
//
//        }
//
    

}
