package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private static final long serialVersionUID = 9188545393807038651L;

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
    private JMenu menuInf = new JMenu("Info");

    /**
     * 
     */
    private JButton btnLinks = new JButton("<<");

    /**
     * 
     */
    private JButton btnRechts = new JButton(">>");

    /**
     * 
     */
    private JLabel lblWoche = new JLabel("Woche");

    /**
     * 
     */
    private JTable tblTable = new JTable();

    /**
     * 
     */
    private JScrollPane slpPane = new JScrollPane(tblTable);

    /**
     * 
     */
    private JPanel contentPane = new JPanel();

    /**
     * 
     */
    private JMenu menuBenutzer = new JMenu("Benutzer");

    /**
     * 
     */
    private JMenuItem miBenutzerAnzeigen = new JMenuItem("Benutzer Info");

    /**
     * 
     */
    private JMenuItem miBenutzerAusloggen = new JMenuItem("Benutzer ausloggen");

    /**
     * 
     */
    private JMenuItem miBenutzerBarbeiten =
        new JMenuItem("Benutzer bearbeiten");

    /**
     * 
     */
    private JMenu menuTermin = new JMenu("Termine");

    /**
     * 
     */
    private JMenuItem miTerminBearbeiten = new JMenuItem("Terminbearbeiten");

    /**
     * 
     */
    private JMenuItem miNeuerTermin = new JMenuItem("Neuer Termin");

    /**
     * 
     */
    private JMenuItem miTermineExportieren =
        new JMenuItem("Termine exportieren");

    /**
     * 
     */
    private JMenuItem miTermineImportieren =
        new JMenuItem("Termine importieren");

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
        {"Uhrzeit", "Mo.", "Di.", "Mi.", "Do.", "Fr.", "Sa.", "So."};

    /**
     * 
     */
    // zeilen anlegen
    private String[][] zeilen =
        {{"01:00"}, {"02:00"}, {"03:00"}, {"04:00"}, {"05:00"},
            {"06:00"}, {"07:00"}, {"08.00"}, {"09:00"}, {"10:00"},
            {"11:00"}, {"12:00"}, {"13:00"}, {"14:00"}, {"15:00"},
            {"16:00"}, {"17:00"}, {"18:00"}, {"19:00"}, {"20:00"},
            {"21:00"}, {"22:00"}, {"23:00"}, {"00:00"}};

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

        menuBarErstellen();

        btnErstellen();

        lblWoche = new JLabel();
        lblWoche.setText("Woche");
        lblWoche.setPreferredSize(new Dimension(30, 2));

        hinzufuegenItems();

        this.mainContainer = this.getContentPane();

        this.mainContainer.setLayout(new BorderLayout());

        tabellenmodellGruppeA = new DefaultTableModel(zeilen, spalten);

        gedrueck();
        tblErstellen();
        mainContainer.add(new JScrollPane(tblTable));
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    /**
     * @return datum3
     */

    public int getKalenderwoche() {
        Calendar cal = GregorianCalendar.getInstance();
        int datum3 = (cal.get(Calendar.WEEK_OF_YEAR));
        return datum3;
    }

    /**
     * 
     */
    public void gedrueck() {

        miBenutzerAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setResizable(false);
                setLocationRelativeTo(null);
                new UserInfoGUI();
            }
        });

        miBenutzerAusloggen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI();

            }
        });

        miBenutzerBarbeiten.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserBearbeitenGUI();

            }
        });

        miNeuerTermin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                KalenderGui.this.setVisible(false);
                new NeuenTerminHinzu();
            }
        });

        miTerminBearbeiten.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        miTermineExportieren.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        menuInf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        btnLinks.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    /**
     * @param date .
     * @return formatter.
     */
    private String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("E dd.MM.yyyy");
        return formatter.format(date);
    }
    /**
     * @param e .
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLinks)) {
            date = date.minusDays(7);

            kalenderwoche--;

            LocalDateTime montag =
                date.minusDays(date.getDayOfWeek().getValue() - 1);
            LocalDateTime sonntag =
                date.plusDays(7 - date.getDayOfWeek().getValue());

            setTitle("Kalender - KW " + kalenderwoche + " von "
                + formatDate(montag) + " bis " + formatDate(sonntag));

            btnRechts.setText(">>" + (kalenderwoche + 1));
            btnLinks.setText((kalenderwoche - 1) + "<<");

        } else if (e.getSource().equals(btnRechts)) {
            date = date.plusDays(7);

            kalenderwoche++;

            LocalDateTime montag =
                date.minusDays(date.getDayOfWeek().getValue() - 1);
            LocalDateTime sonntag =
                date.plusDays(7 - date.getDayOfWeek().getValue());

            setTitle("Kalender - KW " + kalenderwoche + " von "
                + formatDate(montag) + " bis " + formatDate(sonntag));

            btnRechts.setText(">>" + (kalenderwoche + 1));
            btnLinks.setText((kalenderwoche - 1) + "<<");

        }

    }
    //// mausListener
    // /**
    // * @param e
    // */
    // public void mousePressed(KalenderGui kalenderGui) {
    //
    // if (MouseEvent.BUTTON1 == 2) {
    // new NeuenTerminHinzu();
    // } else if (MouseEvent.BUTTON2 == 1) {
    // JPopupMenu popmen = new JPopupMenu();
    // popmen.add(miTerminBearbeiten);
    // popmen.add(miTermineExportieren);
    // popmen.add(miTermineImportieren);
    //
    // }
    //

    /**
     * 
     */
    public void hinzufuegenItems() {

        menuBenutzer.add(miBenutzerAnzeigen);
        miBenutzerAnzeigen.addActionListener(this);
        menuBenutzer.add(miBenutzerBarbeiten);
        miBenutzerBarbeiten.addActionListener(this);
        menuBenutzer.add(miBenutzerAusloggen);
        miBenutzerAusloggen.addActionListener(this);
        menuTermin.add(miNeuerTermin);
        miNeuerTermin.addActionListener(this);
        menuTermin.add(miTerminBearbeiten);
        miTerminBearbeiten.addActionListener(this);
        menuTermin.add(miTermineExportieren);
        miTermineExportieren.addActionListener(this);
        menuTermin.add(miTermineImportieren);
    }

    /**
     * 
     */
    public void menuBarErstellen() {

        menueBar.add(menuBenutzer);
        menueBar.add(menuTermin);
        menueBar.add(menuInf);
        menueBar.add(btnLinks);
        menueBar.add(btnRechts);
        menueBar.add(lblWoche);
        menueBar.add(btnRechts);
        this.setJMenuBar(menueBar);
    }

    /**
     * 
     */
    public void btnErstellen() {

        btnLinks.addActionListener(this);
        btnRechts.addActionListener(this);
        btnRechts.setText(">>" + (kalenderwoche + 1));
        btnLinks.setText((kalenderwoche - 1) + "<<");
    }

    /**
     * 
     */
    public void tblErstellen() {

        tblTable = new JTable(tabellenmodellGruppeA) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int x, int y) {
                return false;
            }
        };

        tblTable.getTableHeader().setEnabled(false);

        tblTable.setAutoResizeMode(4);
    }
}
