
/**
 * Beschreiben Sie hier die Klasse Stuhl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Stuhl extends Produkt
{
    // static variablen gelten für die KLASSE, also sind sie bei allen Objekten dieser klasse gleich
    private static int holz = 2;
    private static int schrauben = 10;
    private static int farbe = 2;
    private static int karton = 1;

    private static int zeit = 22;
    
    /**
     * Konstruktor für Objekte der Klasse Stuhl
     */
    public Stuhl()
    {
    }

    public static int gibHolz () {return holz;}
    public static int gibSchrauben () {return schrauben;}
    public static int gibFarbe () {return farbe;}
    public static int gibKarton () {return karton;}
    public static int gibZeit () {return zeit;}
    


    
}
