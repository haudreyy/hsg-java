import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Fabrik.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Produkt
{
    public String meinZustand;

    /**
     * Konstruktor für Objekte der Klasse Fabrik
     */
    public Produkt()
    {
        meinZustand = "bestellt";
    }

    public void setZustand(String neuerZustand)
    {
        meinZustand = neuerZustand;
    }

    public String gibZustand()
    {
        return meinZustand;
    }
}