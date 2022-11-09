import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * * Die Klasse Bestellung ermöglicht Informationen über diese zu erfassen und mit der Bestellung umzugehen.
 * 
 * @author Gruppe 7
 * @version 2.0
 */
public class Bestellung
{
    // Die Instanzvariablen für die Klasse Bestellung werden hier kreiert. 
    private ArrayList <Produkt> produkte;
    private String bestellbestaetigung;
    private int herstellungszeit;
    private int bestellnummer;
    private int anzahlStuehle;
    private int anzahlSofa;

    // Dieser Konstruktor ermöglicht die einfache Erstellung einer neuen Bestellung
    // Parameter dafür sind: Anzahl Stühle, Anzahl Sofas und die Bestellnummer
    public Bestellung(int stuehle, int sofas, int nummer)
    {
        anzahlStuehle = stuehle;
        anzahlSofa = sofas;
        herstellungszeit = sofas * Sofa.gibZeit() + stuehle * Stuhl.gibZeit();
        bestellnummer = nummer;
        bestellbestaetigung = "Bestellung wurde erfolgreich aufgenommen!";
        produkte = new ArrayList<Produkt>();

        // Für jeden Stuhl wird ein Objekt erstellt
        int index = 0;
        while (index < stuehle) 
        {
            produkte.add(new Stuhl());
            index ++;
        }

        // Für jedes Sofa wird ein Objekt erstellt
        index = 0;
        while (index < sofas) 
        {
            produkte.add(new Sofa());
            index ++;
        }
    }

    // Gibt eine Bestellbestätigung aus
    public String gibBestellbestaetigung()
    {
        return bestellbestaetigung;
    }

    // Gibt die Herstellungszeit
    public int gibHerstellungszeit()
    {
        return herstellungszeit;
    }

    public int gibLieferzeit ()
    {
        herstellungszeit = gibHerstellungszeit ();
        // beschaffungszeit = 
        // gibBeschaffungszeit(Bestellung bestellung);

        return herstellungszeit;
    }
    
    // Verschiedene get-Methoden
    public int gibBestellnummer()
    {
        return bestellnummer;
    }
    
    public int gibAnzahlStuehle()
    {
        return anzahlStuehle;
    }

    public int gibAnzahlSofa()
    {
        return anzahlSofa;
    }
}
