
/**
 * Die Klasse Sofa ermöglicht die benötigten Produktionseinheiten und die totale Zeit abzufragen.
 * 
 * @author Gruppe 7
 * @version 1.0
 */
public class Sofa extends Produkt
{
    // Anzahl an benötigten Teile zur Produktion eines Sofas
    static private int holzeinheiten = 4;
    static private int schrauben = 5;
    static private int kissen = 5;
    static private int farbeinheiten = 1;
    static private int kartoneinheiten = 5;
    
    // Produktionszeit in Minuten
    static private int produktionsZeit = 60;
    
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
    
    // Gibt die Anzahl an benötigten Kissen zurück
    public int gibKissen()
    {
        return kissen;
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
