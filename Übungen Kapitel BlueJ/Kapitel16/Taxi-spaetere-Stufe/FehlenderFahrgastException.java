
/**
 * Signal, dass kein Fahrgast am Abholpunkt war.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 2016.02.29
 */
public class FehlenderFahrgastException extends RuntimeException
{
    private Fahrzeug fahrzeug;
    /**
     * Konstruktor f�r Objekte der Klasse FehlenderFahrgastException. 
     * @param fahrzeug  das Fahrzeug, das einen Passagier erwartet
     */
    public FehlenderFahrgastException(Fahrzeug fahrzeug)
    {
        super("Kein Fahrgast am Abholpunkt.");
    }

    /**
     * @return  das Fahrzeug, f�r das kein Fahrgast vorhanden war
     */
    public Fahrzeug gibFahrzeug()
    {
        return fahrzeug;
    }
}
