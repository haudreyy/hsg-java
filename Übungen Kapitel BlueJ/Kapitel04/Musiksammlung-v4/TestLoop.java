
/**
 * Beschreiben Sie hier die Klasse TestLoop.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TestLoop
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse TestLoop
     */
    public TestLoop()
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
    
    public void gibMultiples5 ()
    {
        int index = 10;
        while (index < 95)
        {
            if (index%5 == 0) 
            {
                System.out.println (index);
                index ++;
            }
            else 
            {
                index ++;
            }
    
        }
    }
}
