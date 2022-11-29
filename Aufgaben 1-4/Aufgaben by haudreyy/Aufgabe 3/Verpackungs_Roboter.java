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
    public Verpackungs_Roboter()
    {
        // weil wir eine superclass haben müssen wir den constructor von der klasse callen
        // siehe https://stackoverflow.com/questions/31397885/must-explicitly-invoke-another-constructor
        super("Verpackungsroboter");
        this.meinTyp = RoboterTyp.Verpackung;
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
