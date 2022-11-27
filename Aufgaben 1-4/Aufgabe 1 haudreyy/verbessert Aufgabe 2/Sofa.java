
/**
 * Die Klasse Sofa ermöglicht die benötigten Produktionseinheiten und die totale Zeit abzufragen.
 * 
 * @author Gruppe 7
 * @version 2.0
 */
public class Sofa extends Produkt
{
    // Anzahl an benötigten Teile zur Produktion eines Sofas
    // Diese sind hier "static", weil sie für jedes Objekt der Klasse Sofas zutreffen und gelten
    private static int holz =4;
    private static int schrauben = 5;
    private static int kissen = 5;
    private static int farbe = 1;
    private static int karton = 5;

    // Produktionszeit in Minuten
    private static int zeit = 60;

    /**
     * Konstruktor für Objekte der Klasse Sofa
     */
    public Sofa()
    {
        produktionsSchritte = new boolean [] {false,false,false,false};
        meinTyp = Produkttyp.Sofa;
    }

    // Verschiedene get-Methoden
    public static int gibHolz () {return holz;}
    public static int gibKissen () {return kissen;}
    public static int gibSchrauben () {return schrauben;}
    public static int gibFarbe () {return farbe;}
    public static int gibKarton () {return karton;}
    public static int gibZeit () {return zeit;}
}
