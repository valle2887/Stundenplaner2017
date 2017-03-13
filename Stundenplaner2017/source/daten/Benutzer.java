package daten;

/**
 * Klasse, welche den Benutzer zeigt, seinen Name, sein Passwort, Semester,
 * ECTs, Studiengang, und die personalierte Terminliste.
 * 
 * @author Christian Lindenberg
 */
public class Benutzer {
    /**
     * Name des users.
     */
    private static String userName;

    /**
     * Passwort des users.
     */
    private static String passwort;

    /**
     * Credits des users.
     */
    private String ects;

    /**
     * Studiengang des users.
     */
    private static String studiengang;

    /**
     * Klassenkonstruktor.
     * @param usName der Name des Users
     * @param usPW das Passwort des Users
     * @param usECTS die Credits des Users
     * @param usStud der Studiengang des Users werden uebergeben.
     */
    public Benutzer(String usName, String usPW, String usECTS, String usStud) {
        userName = usName;
        passwort = usPW;
        ects = usECTS;
        studiengang = usStud;

    }

    /**
     * Getter fuer den Usernamen.
     * 
     * @return username Ist der einzugebende Name fuer den Login.
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * Setter fuer den Usernamen.
     * 
     * @param userName
     *            Fuer den Login benötigt.
     */
    public void setUserName(String userName) {
        Benutzer.userName = userName;
    }

    /**
     * Getter für das Passwort.
     * 
     * @return passwort Ist das Passwort, welches vom User festgelegt wurde.
     */
    public static String getPasswort() {
        return passwort;
    }

    /**
     * Setter fuer das Passwort.
     * 
     * @param passwort
     *            Fuer den Login benötigt.
     */
    public void setPasswort(String passwort) {
        Benutzer.passwort = passwort;
    }

    /**
     * Getter für ECTS.
     * 
     * @return ects Die Credits des Users.
     */
    public String getEcts() {
        return ects;
    }

    /**
     * Setter fuer die ECTs.
     * 
     * @param ects
     *            Die Credits des Users.
     */
    public void setEcts(String ects) {
        this.ects = ects;
    }

    /**
     * Getter fuer den Studiengang.
     * 
     * @return studiengang
     */
    public static String getStudiengang() {
        return studiengang;
    }

    /**
     * Setter fuer den Studiengang.
     * 
     * @param studiengang
     *            Der Studiengang des Users
     */
    public void setStudiengang(String studiengang) {
        Benutzer.studiengang = studiengang;
    }

}
