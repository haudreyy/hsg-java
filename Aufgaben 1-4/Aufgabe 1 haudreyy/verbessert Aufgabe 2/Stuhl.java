
/**
 * Die Klasse Stuhl ermöglicht die benötigten Produktionseinheiten und die totale Zeit abzufragen.
 * 
 * @author Gruppe 7
 * @version 2.0
 */
 public class Stuhl extends Produkt
{
    // Anzahl an benötigten Teile zur Produktion eines Stuhls
    // Diese sind hier "static", weil sie für jedes Objekt der Klasse Stuhl zutreffen und gelten
    private static int holz = 2;
    private static int schrauben = 10;
    private static int farbe = 2;
    private static int karton = 1;

    // Produktionszeit in Minuten
    private static int zeit = 22;
    
    /**
     * Konstruktor für Objekte der Klasse Stuhl
     */
    public Stuhl()
    {
        produktionsSchritte = new boolean [] {false,false,false,false};
        meinTyp = Produkttyp.Stuhl;
    }

    // Verschiedene get-Methoden
    public static int gibHolz () {return holz;}
    public static int gibSchrauben () {return schrauben;}
    public static int gibFarbe () {return farbe;}
    public static int gibKarton () {return karton;}
    public static int gibZeit () {return zeit;}
    


    
}
