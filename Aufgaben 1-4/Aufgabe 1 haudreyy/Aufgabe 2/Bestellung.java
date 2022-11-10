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

    // Erstelle ein Lager, woraus das Material genommen wird
    public Lager erstelleLager ()
    {
        Lager lager;
        lager = new Lager (0,0,0,0,0);
        return lager;
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

    // Die Lieferzeit wird für das Objekt Bestellung angegeben
    // Hierfür wird auf ein Objekt Lager Bezug genommen
    public int gibLieferzeit (Lager lager)
    {
        herstellungszeit = gibHerstellungszeit ();
        int beschaffungszeit;
        beschaffungszeit = lager.gibBeschaffungszeit(this);

        // Die Beschaffungszeit ist in Tage und die Herstellungszeit in Stunden
        System.out.println (" Die Lieferung ist in " + beschaffungszeit + " Tage und " + herstellungszeit + " Stunden lieferbar.");

        // Diese Methode gibt die Lieferzeit in Stunden aus
        beschaffungszeit = beschaffungszeit * 24;
        return herstellungszeit + beschaffungszeit;
    } 

    // Das zu bestellende Material wird für das Objekt Bestellung angegeben
    // Hierfür wird auf ein Objekt Lager Bezug genommen
    public void materialZuBestellen (Lager lager)
    {
        int [] materialZuBestellen ; 
        materialZuBestellen = lager.zubestellenMaterial (this);

        System.out.println ( "Für diese Bestellung wurde folgendes Material bestellt:");
        System.out.println (materialZuBestellen [0]+ " an Holz ");
        System.out.println (materialZuBestellen [1]+ " an Schrauben ");
        System.out.println (materialZuBestellen [2]+ " an Farbe ");
        System.out.println (materialZuBestellen [3]+ " an Kissen ");
        System.out.println (materialZuBestellen [4]+ " an Karton ");
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
