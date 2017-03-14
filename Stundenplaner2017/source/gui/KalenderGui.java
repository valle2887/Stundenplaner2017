package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import daten.Benutzer;
import daten.DatenVerwaltung;

// TODO: Auto-generated Javadoc
/**
 * Klasse Gui.
 * 
 * @author Valerian Tjunnikov
 */
public class KalenderGui extends JFrame implements ActionListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9188545393807038651L;

    /** The date. */
    private LocalDateTime date = LocalDateTime.now();

    /** The montag. */
    private LocalDateTime montag =
        date.minusDays(date.getDayOfWeek().getValue() - 1);

    /** The sonntag. */
    private LocalDateTime sonntag =
        date.plusDays(7 - date.getDayOfWeek().getValue());

    /** The kalenderwoche. */
    private int kalenderwoche = getKalenderwoche();

    /** The menue bar. */
    private JMenuBar menueBar = new JMenuBar();

    /** The menu inf. */
    private JMenu menuInf = new JMenu("Info");

    /** The btn links. */
    private JButton btnLinks = new JButton("<<");

    /** The btn rechts. */
    private JButton btnRechts = new JButton(">>");

    /** The lbl woche. */
    private JLabel lblWoche = new JLabel("Woche");

    /** The tbl table. */
    private JTable tblTable = new JTable();

    /** The slp pane. */
    private JScrollPane slpPane = new JScrollPane(tblTable);

    /** The menu benutzer. */
    private JMenu menuBenutzer = new JMenu("Benutzer");

    /** The mi benutzer anzeigen. */
    private JMenuItem miBenutzerAnzeigen = new JMenuItem("Benutzer Info");

    /** The mi benutzer ausloggen. */
    private JMenuItem miBenutzerAusloggen = new JMenuItem("Benutzer ausloggen");

    /** The mi benutzer barbeiten. */
    private JMenuItem miBenutzerBarbeiten =
        new JMenuItem("Benutzer bearbeiten");

    /** The menu termin. */
    private JMenu menuTermin = new JMenu("Termine");

    /** The mi termin bearbeiten. */
    private JMenuItem miTerminBearbeiten = new JMenuItem("Terminbearbeiten");

    /** The mi neuer termin. */
    private JMenuItem miNeuerTermin = new JMenuItem("Neuer Termin");

    /** The mi termine exportieren. */
    private JMenuItem miTermineExportieren =
        new JMenuItem("Termine exportieren");

    /** The mi termine importieren. */
    private JMenuItem miTermineImportieren =
        new JMenuItem("Termine importieren");

    /** The tabellenmodell gruppe A. */
    private DefaultTableModel tabellenmodellGruppeA;

    /** The main container. */
    private Container mainContainer;

    /** The spalten. */
    // Spalten anlegen
    private String[] spalten =
        {"Uhrzeit", "Mo.", "Di.", "Mi.", "Do.", "Fr.", "Sa.", "So." };

    /** The zeilen. */
    // zeilen anlegen
    private String[][] zeilen =
        new String[][] {{"01:00" }, {"02:00" }, {"03:00" }, {"04:00" },
            {"05:00" }, {"06:00" }, {"07:00" }, {"08.00" }, {"09:00" },
            {"10:00" }, {"11:00" }, {"12:00" }, {"13:00" }, {"14:00" },
            {"15:00" }, {"16:00" }, {"17:00" }, {"18:00" }, {"19:00" },
            {"20:00" }, {"21:00" }, {"22:00" }, {"23:00" }, {"00:00" }};

    /** The benutzer. */
    private Benutzer benutzer;

    /**
     * Instantiates a new kalender gui.
     *
     * @param benutzer
     *            the benutzer
     */
    public KalenderGui(Benutzer benutzer) {
        this.benutzer = benutzer;
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

    public KalenderGui(String userName) {
        // TODO Auto-generated constructor stub
    }

    /**
     * Gets the kalenderwoche.
     *
     * @return datum3
     */

    public int getKalenderwoche() {
        Calendar cal = GregorianCalendar.getInstance();
        int datum3 = (cal.get(Calendar.WEEK_OF_YEAR));
        return datum3;
    }

    /**
     * Gedrueck.
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
     * Laden des Kalenders.
     */
    private void laden() {
        String[][] zeilen = new String[24][7];
        ArrayList<String> list = null;
        // laden aus textdatei
        try {
            list = DatenVerwaltung.leseAufgabe(Benutzer.getUserName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < zeilen.length; i++) {
            zeilen[i][0] = this.zeilen[i][0];
        }

        // Parsen des datums
        LocalDate date = null;
        LocalTime time = null;
        String bezeichnung = "";
        for (String string : list) {
            if (string.contains("Datum: ")) {
                DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("'Datum:' d.M.yyyy");
                formatter = formatter.withLocale(Locale.GERMANY);
                date = LocalDate.parse(string, formatter);
            }
            if (string.contains("Uhrzeit: ")) {
                DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("'Uhrzeit:' k:mm");
                formatter = formatter.withLocale(Locale.GERMANY);
                time = LocalTime.parse(string, formatter);
            }
            if (string.contains("Bezeichnung: ")) {
                bezeichnung =
                    string.substring(string.indexOf(" "), string.length() - 1);
            }
        }
        LocalDateTime datetime = LocalDateTime.of(date, time);

        if (datetime.isBefore(sonntag) && datetime.isAfter(montag)) {
            zeilen[datetime.getDayOfWeek().getValue()][datetime.getHour()] =
                bezeichnung;
        }

        this.zeilen = zeilen;
        this.tabellenmodellGruppeA.setDataVector(zeilen, spalten);
        this.tabellenmodellGruppeA.fireTableDataChanged();

    }

    /**
     * Format date.
     *
     * @param date
     *            .
     * @return formatter.
     */
    private String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("E dd.MM.yyyy");
        return formatter.format(date);
    }

    /**
     * Action performed.
     *
     * @param e
     *            .
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLinks)) {
            date = date.minusDays(7);

            kalenderwoche--;

            montag = date.minusDays(date.getDayOfWeek().getValue() - 1);
            sonntag = date.plusDays(7 - date.getDayOfWeek().getValue());

            setTitle("Kalender - KW " + kalenderwoche + " von "
                + formatDate(montag) + " bis " + formatDate(sonntag));

            btnRechts.setText(">>" + (kalenderwoche + 1));
            btnLinks.setText((kalenderwoche - 1) + "<<");

        } else if (e.getSource().equals(btnRechts)) {
            date = date.plusDays(7);

            kalenderwoche++;

            montag = date.minusDays(date.getDayOfWeek().getValue() - 1);
            sonntag = date.plusDays(7 - date.getDayOfWeek().getValue());

            setTitle("Kalender - KW " + kalenderwoche + " von "
                + formatDate(montag) + " bis " + formatDate(sonntag));

            btnRechts.setText(">>" + (kalenderwoche + 1));
            btnLinks.setText((kalenderwoche - 1) + "<<");

        }
        laden();

    }

    /**
     * Hinzufuegen items.
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
     * Menu bar erstellen.
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
     * Btn erstellen.
     */
    public void btnErstellen() {

        btnLinks.addActionListener(this);
        btnRechts.addActionListener(this);
        btnRechts.setText(">>" + (kalenderwoche + 1));
        btnLinks.setText((kalenderwoche - 1) + "<<");
    }

    /**
     * Tbl erstellen.
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
