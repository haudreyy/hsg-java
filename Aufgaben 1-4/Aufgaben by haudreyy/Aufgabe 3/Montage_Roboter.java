

/**
 * Beschreiben Sie hier die Klasse Montage_Roboter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Montage_Roboter extends Roboter
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse Montage_Roboter
     */
    public Montage_Roboter(Produktions_Manager pm)
    {
        super("Montageroboter", pm);
        this.meinTyp = RoboterTyp.Montage; 
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
