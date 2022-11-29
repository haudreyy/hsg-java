import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * * Die Klasse Bestellung ermöglicht Informationen über diese zu erfassen und mit der Bestellung umzugehen.
 * 
 * Wichtige Bemerkung bzgl. Begrifflichkeiten:
 * Beschaffungszeit = die Zeit, die das Lager braucht um Material nachzubestellen beim Lieferant (entweder 0 oder 2)
 * Herstellungszeit (in der Aufgabenstellung "Produktionszeit")= die Zeit, die die Firma braucht um die Bestellung zu bearbeiten und somit die Stühle und Sofas herzustellen
 * Bearbeitungszeit (in der Aufgabenstellung "Lieferzeit") = die Summe aus Beschaffungszeit und Herstellungszeit, dh. so lange muss der Kunde mindestens auf seine Bestellung warten
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
    private int standardLieferzeit = 1;
    private int lieferzeit;
    private int bestellnummer;
    private int anzahlStuehle;
    private int anzahlSofa;
    private int[] materialbedarf;
    private Lager lager;

    // Dieser Konstruktor ermöglicht die einfache Erstellung einer neuen Bestellung
    // Parameter dafür sind: Anzahl Stühle, Anzahl Sofas und die Bestellnummer
    public Bestellung(int stuehle, int sofas, int nummer, Lager lager_in)
    {
        // Keine negativen Werte eingeben
        if (stuehle < 0 || sofas < 0 || nummer < 0) 
        {
            System.out.println ("Error: Keine negativen Werte erlaubt");
            bestellbestaetigung = "Bestellung war nicht erfolgreich.";
        }
        else 
        {
            bestellnummer = nummer;
            anzahlStuehle = stuehle;
            anzahlSofa = sofas;
            lager = lager_in;

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

            // Berechne den Materialbedarf
            materialbedarf = berechneMaterialBedarf();

            // Berechne herstellungszeit (arbeitszeit in Minuten)
            herstellungszeit = sofas * Sofa.gibZeit() + stuehle * Stuhl.gibZeit();
            
            // Berechne Lieferzeit (Tage)
            lieferzeit = berechneLieferzeit();

            // Gib die Bestellbestätigung
            bestellbestaetigung = gibBestellBestaetigung();

        }
        // Gibt Bestellbestätigung
        System.out.println (bestellbestaetigung);
}

    // Gibt eine Bestellbestätigung aus
    public String gibBestellBestaetigung()
    {
        // Die Auftragsbestätigung prüft wie lange die Bestellung bearbeitet werden muss (inkl. Zeit für Materiallieferungen aus Lager)
        bestellbestaetigung = "Vielen Dank für Ihre Bestellung. Die Lieferzeit beträgt " + lieferzeit + "Tage.";

        return bestellbestaetigung;
    }

    // Berechnet den Bedarf an Material für eine bestimmte Bestellung
    private int [] berechneMaterialBedarf ()
    {
        // Wieviel Material braucht man dafür?
        int holzbedarf = Stuhl.gibHolz() * anzahlStuehle + Sofa.gibHolz() * anzahlSofa;
        int schraubenbedarf = Stuhl.gibSchrauben() * anzahlStuehle + Sofa.gibSchrauben() * anzahlSofa;
        int farbbedarf = Stuhl.gibFarbe() * anzahlStuehle + Sofa.gibFarbe() * anzahlSofa;
        int kissenbedarf = Sofa.gibKissen() * anzahlSofa;
        int kartonbedarf = Stuhl.gibKarton() * anzahlStuehle + Sofa.gibKarton() * anzahlSofa;
        
        // Bedarf in einem Array zusammengefasst
        int [] bedarf_je_material = {holzbedarf, schraubenbedarf , farbbedarf ,kissenbedarf ,kartonbedarf};
        return bedarf_je_material;
    } 

    // Die Bearbeitungszeit wird für das Objekt Bestellung angegeben
    // Hierfür wird auf ein Objekt Lager Bezug genommen
    public int berechneLieferzeit ()
    {
        // An einem Tag werden 400 Minuten an den Aufträgen gearbeitet.
        double arbeitszeit = (double) herstellungszeit / 400;

        // Die Arbeitszeit wird hoch gerundet auf ganze Tage
        System.out.println (arbeitszeit);
        int arbeitstage = (int) arbeitszeit;

        int zeit = standardLieferzeit + arbeitstage + lager.gibBeschaffungszeit(this);

        // Diese Methode gibt die Lieferzeit in Tagen aus
        return zeit;
    }

    // Verschiedene get-Methoden
    public int gibLieferzeit ()
    {
        return lieferzeit;
    }

    public int gibHerstellungszeit()
    {
        return herstellungszeit;
    }

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
