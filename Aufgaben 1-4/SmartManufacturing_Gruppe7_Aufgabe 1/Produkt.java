
/**
 * Die abstrakte Klasse Produkt ermöglicht die Vererbung von Methoden durch konkrete Produkte.
 * 
 * @author Gruppe 7
 * @version 1.0
 */
public abstract class Produkt
{
    // Der Zustand des Produktes wird aktuell durch eine Zahl dargestellt.
    // z.B. 0=unfertig, 1=in Produktion, 2=fertig
    static private int zustand = 0;
    
    // Diese Methode ermöglicht es den Zustand zu ändern
    public void zustandAendern(int neuerZustand)
    {
        zustand = neuerZustand;
    }
    
    // Diese Methode gibt den aktuellen Zustand aus
    public int aktuellerZustand()
    {
        return zustand;
    }
}
