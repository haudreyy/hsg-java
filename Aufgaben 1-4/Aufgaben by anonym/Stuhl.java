
/**
 * Die Klasse Stuhl ermöglicht die benötigten Produktionseinheiten und die totale Zeit abzufragen.
 * 
 * @author Gruppe 7
 * @version 1.0
 */
public class Stuhl extends Produkt
{
    // Anzahl an benötigten Teile zur Produktion eines Stuhls
    static private int holzeinheiten = 2;
    static private int schrauben = 10;
    static private int farbeinheiten = 2;
    static private int kartoneinheiten = 1;
    
    // Produktionszeit in Minuten
    static private int produktionsZeit = 22;
    
    // Gibt die Anzahl an benötigten Holzeinheiten zurück
    public int gibHolzeinheiten()
    {
        return holzeinheiten;
    }
    
    // Gibt die Anzahl an benötigten Schrauben zurück
    public int gibSchrauben()
    {
        return schrauben;
    }
    
    // Gibt die Anzahl an benötigten Farbeinheiten zurück
    public int gibFarbeinheiten()
    {
        return farbeinheiten;
    }
    
    // Gibt die Anzahl an benötigten Kartoneinheiten zurück
    public int gibKartoneinheiten()
    {
        return kartoneinheiten;
    }
    
    // Gibt die Produktionszeit in Minuten zurück
    public static int gibProduktionszeit() {
        return produktionsZeit;
    }
}
