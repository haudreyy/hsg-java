import java.util.Random;

/**
 * Steuerung der zufallsbasierten Elemente der Simulation. Indem dieser 
 * gemeinsame Randomisierer mit festgelegtem Initialisierungswert (SEED)
 * benutzt wird, sind wiederholte Durchl�ufe exakt gleich (was beim Testen
 * hilfreich sein kann). Setzen Sie 'nutzeGemeinsam' auf 'false', um jedes
 * Mal ein anderes zuf�lliges Verhalten zu bekommen.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 2016.02.29
 */
public class Zufallssteuerung
{
    // Vorgabe f�r den SEED-Wert, der die Erzeugung der Zufallszahlen steuert
    private static final int SEED = 1111;
    // Ein gemeinsam genutztes Random-Objekt, falls ben�tigt
    private static final Random rand = new Random(SEED);
    // Bestimmt, ob ein gemeinsam genutzer Zufallsgenerator zur Verf�gung gestellt wird.
    private static final boolean nutzeGemeinsam = true;

    /**
     * Konstruktor f�r Objekte der Klasse Zufallssteuerung
     */
    public Zufallssteuerung()
    {
    }

    /**
     * Liefert einen Zufallsgenerator.
     * @return  ein Random-Objekt
     */
    public static Random gibZufallsgenerator()
    {
        if(nutzeGemeinsam) {
            return rand;
        }
        else {
            return new Random();
        }
    }
    
    /**
     * Setzt die Zufallssteuerung zurueck.
     * Hat keinen Effekt, wenn f�r die Zufallssteuerung kein 
     * gemeinsam genutzer Zufallsgenerator verwendet wird.
     */
    public static void zuruecksetzen()
    {
        if(nutzeGemeinsam) {
            rand.setSeed(SEED);
        }
    }
}
