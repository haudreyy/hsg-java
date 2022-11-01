
/**
 * Die Klasse Nummernanzeige repr�sentiert Darstellungen von
 * digitalen Werten, die von null bis zu einem vorgegebenen Limit
 * reichen k�nnen. Das Limit wird definiert, wenn eine Nummernanzeige
 * erzeugt wird. Die darstellbaren Werte reichen von null bis limit-1.
 * Wenn beispielsweise eine Nummernanzeige f�r die Sekunden einer
 * digitalen Uhr verwendet werden soll, w�rde man ihr Limit auf 60
 * setzen, damit die dargestellten Werte von 0 bis 59 reichen.
 * Wenn der Wert einer Nummernanzeige erh�ht wird, wird bei Erreichen
 * des Limits der Wert automatisch auf null zur�ckgesetzt.
 * 
 * @author Michael K�lling und David J. Barnes
 * @version 2016.02.29
 */
public class Nummernanzeige
{
    private int limit;
    private int wert;
    private int initialwert;

    /**
     * Konstruktor f�r Exemplare der Klasse Nummernanzeige.
     * Setzt das Limit, bei dem die Anzeige zur�ckgesetzt wird.
     */
    public Nummernanzeige(int anzeigeLimit, int intialwert)
    {
        limit = anzeigeLimit;
        wert = initialwert;
        this.initialwert = intialwert;
    }
    
    /**
     * Zweiter Konstruktor, falls kein Limit wie bei Jahren
     */
    public Nummernanzeige(int intialwert)
    {
        limit = 9999;
        wert = initialwert;
        this.initialwert = intialwert;
    }

    /**
     * Liefere den aktuellen Wert als int.
     */
    public int gibWert()
    {
        return wert;
    }

    public void setzeLimit (int neueLimite)
    {
        limit = neueLimite;
    }
    
    /**
     * Liefere den Anzeigewert, also den Wert dieser Anzeige als
     * einen String mit zwei Ziffern. Wenn der Wert der Anzeige
     * kleiner als zehn ist, wird die Anzeige mit einer f�hrenden
     * Null einger�ckt.
     */
    public String gibAnzeigewert(int l�nge)
    {
        if (l�nge == 2) // f�r Stunden, Minuten und Tage
        { if (wert < 10) 
            {
                return "0" +wert;
            }
            else {
                return "" + wert;
            }
        }
        
        else if (l�nge == 3) 
        { if (wert < 10) 
            {
                return "00" +wert;
            }
            else if (wert < 100) 
            {
                return "0" + wert;
            }
            else {
                return "" + wert;
            }
        }
        
        else if (l�nge == 4)
        { if (wert < 10) 
            {
                return "000" +wert;
            }
            else if (wert < 100) 
            {
                return "00" + wert;
            }
            else if (wert < 1000)
            {
                return "0" + wert;
            }
            else {
                return "" + wert;
            }
        }
        
        else 
        {
        return "" + wert;
        }
    }

    /**
     * Setze den Wert der Anzeige auf den angegebenen 'ersatzwert'.
     * Wenn der angegebene Wert unter null oder �ber dem Limit liegt,
     * tue nichts.
     */
    public void setzeWert(int ersatzwert)
    {
        if((ersatzwert >= 0) && (ersatzwert < limit)) 
        {
            wert = ersatzwert;
        }
    }

    /**
     * Erh�he den Wert um eins. Wenn das Limit erreicht ist, setze
     * den Wert wieder auf null.
     */
    public void erhoehen()
    {
        wert = (wert + 1) % limit;
    }
}
