
/**
 * Beschreiben Sie hier die Klasse Sofa.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Sofa extends Produkt
{
    private static int holz =4;
    private static int schrauben = 5;
    private static int kissen = 5;
    private static int farbe = 1;
    private static int karton = 5;

    private static int zeit = 60;

    public static int gibHolz () {return holz;}
    public static int gibKissen () {return kissen;}
    public static int  gibSchrauben () {return schrauben;}
    public static int gibFarbe () {return farbe;}
    public static int gibKarton () {return karton;}
    public static int gibZeit () {return zeit;}

    /**
     * Konstruktor für Objekte der Klasse Sofa
     */
    public Sofa()
    {
    }
}
