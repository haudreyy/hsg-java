import java.util.ArrayList;

/**
 * Die abstrakte Klasse Produkt ermöglicht die Vererbung von Methoden durch konkrete Produkte.
 * 
 * @author Gruppe 7
 * @version 2.0
 */
public class Produkt
{
    public String meinZustand;

    /**
     * Konstruktor für Objekte der Klasse Produkt
     * Der Zustand wird hier in Form eines Strings angegeben. Später und wenn nötig kann man diesen anhand eines Integers angeben.
     * Dafür sollte man genauer wissen was für Zustände angenommen werden können (z.B. 0=unfertig, 1=in Produktion, 2=fertig).
     */
    public Produkt()
    {
        meinZustand = "bestellt";
    }

    // Diese Methode ändert den Zustand
    public void setZustand(String neuerZustand)
    {
        meinZustand = neuerZustand;
    }

    // Diese Methode gibt den Zustand
    public String gibZustand()
    {
        return meinZustand;
    }
}