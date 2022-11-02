
import java.util.ArrayList;

/**
 * Die Klasse Bestellung ermöglicht Informationen über diese zu erfassen und mit der Bestellung umzugehen.
 * 
 * @author Gruppe 7
 * @version 1.0
 */
public class Bestellung
{
    // Diese Instanzvariablen sind nicht global (was static wäre), da sie sonst über alle Bestellungen
    // gleich wären. Das ist natürlich nicht gewünscht.
    private ArrayList<Produkt> bestellteProdukte;
    private boolean bestellBestaetigung = false;
    private int beschaffungsZeit;
    private int anzahlStuehle;
    private int anzahlSofas;
    private long bestellungsNr;
    
    // Dieser Konstruktor ermöglicht die einfache Erstellung einer neuen Bestellung
    public Bestellung(int bestellteSofas, int bestellteStuehle)
    {
        bestellteProdukte = new ArrayList<Produkt>();
        
        // Hier überprüfen wir, ob eine korrekte Bestellung vorliegt.
        if(bestellteSofas < 0 || bestellteStuehle < 0) {
            System.out.println("Fehler! Sie können keine negativen Bestellungen aufgeben.");
            System.out.println("Die entsprechende Zahl wurde genullt.");
            if(bestellteSofas < 0) {
                bestellteSofas = 0;
            }
            if(bestellteStuehle < 0) {
                bestellteStuehle = 0;
            }
        }
        anzahlStuehle = bestellteStuehle;
        anzahlSofas = bestellteSofas;
        
        // Erstelle eine zufällige Bestellnummer, Kollisionen sind möglich, aber unwahrscheinlich
        bestellungsNr = (long) (Math.random() * Long.MAX_VALUE);
        
        // Minimale Beschaffungszeit (wenn man alles direkt produzieren kann, mit einem parallen Maschinenwechsel)
        // Angabe in Minuten
        beschaffungsZeit = anzahlStuehle * Stuhl.gibProduktionszeit() + anzahlSofas * Sofa.gibProduktionszeit() + 60;
    }
    
    // Ermöglicht das bestätigen der Bestellung
    public void bestellungBestaetigen()
    {
        bestellBestaetigung = true;
    }
    
    // Ermöglicht das Setzen der Beschaffungszeit
    public void setzeBeschaffungsZeit(int neueBeschaffungsZeit)
    {
        beschaffungsZeit = neueBeschaffungsZeit;
    }
    
    // Verschiedene get-Methoden
    
    public boolean gibBestellBestaetigung()
    {
        return bestellBestaetigung;
    }
    
    public int gibBeschaffungsZeit()
    {
        return beschaffungsZeit;
    }
    
    public long gibBestellungsNr()
    {
        return bestellungsNr;
    }
    
    public int gibAnzahlStuehle()
    {
        return anzahlStuehle;
    }
    
    public int gibAnzahlSofas()
    {
        return anzahlSofas;
    }
}
