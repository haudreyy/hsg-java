import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Beschreiben Sie hier die Klasse Bestellung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bestellung
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList <Produkt> produkte;
    private String bestellbestaetigung;
    private int beschaffungszeit;
    private int bestellnummer;
    private int anzahlStuehle;
    private int anzahlSofa;

    /**
     * Konstruktor für Objekte der Klasse Bestellung
     */
    public Bestellung(int stuehle, int sofas, int nummer)
    {
        anzahlStuehle = stuehle;
        anzahlSofa = sofas;
        beschaffungszeit = sofas * Sofa.gibZeit() + stuehle * Stuhl.gibZeit();
        bestellnummer = nummer;
        bestellbestaetigung = "Bestellung wurde erfolgreich aufgenommen!";
        produkte = new ArrayList<Produkt>();

        int index = 0;
        while (index < stuehle) 
        {
            produkte.add(new Stuhl());
            index ++;
        }

        index = 0;
        while (index < sofas) 
        {
            produkte.add(new Sofa());
            index ++;
        }
        System.out.println(produkte.size());
            
        
    }


    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public String gibBestellbestaetigung()
    {
        return bestellbestaetigung;
    }
    
    public int gibBestellnummer()
    {
        return bestellnummer;
    }
    
    public int gibBeschaffungszeit()
    {
        return beschaffungszeit;
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
