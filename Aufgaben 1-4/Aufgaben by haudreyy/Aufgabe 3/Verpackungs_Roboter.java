/**
 * Beschreiben Sie hier die Klasse Verpackungs_Roboter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Verpackungs_Roboter extends Roboter
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse Verpackungs_Roboter
     */
    public Verpackungs_Roboter(Produktions_Manager pm)
    {
        super("Verpackungsroboter", pm);
        this.meinTyp = RoboterTyp.Verpackung; 
    }

    // diese Methode schaut, was zuletzt produziert wurde
    // public Produkt gibZuletztProduziert () { }

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
