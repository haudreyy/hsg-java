
/**
 * Beschreiben Sie hier die Klasse Produktions_Manager.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Produktions_Manager extends Thread
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Holzbearbeitungs_Roboter holzbearbeitungs_Roboter;
    private Montage_Roboter montage_Roboter;
    private Lackier_Roboter lackier_Roboter;
    private Verpackungs_Roboter verpackungs_Roboter;

    private int x;

    /**
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    public Produktions_Manager()
    {
        // Instanzvariable initialisieren
        x = 0;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int beispielMethode(int y)
    {
        // tragen Sie hier den Code ein
        return x + y;
    }
}
