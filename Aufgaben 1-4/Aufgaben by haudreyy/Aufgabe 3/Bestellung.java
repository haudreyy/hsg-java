import java.util.ArrayList;

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
    private int beschaffungszeit;
    private int herstellungszeit;
    private int lieferzeit;
    private int bestellnummer;
    private int anzahlStuehle;
    private int anzahlSofa;
    private int[] materialbedarf;
    private int stuehleFertig;
    private int sofasFertig;

    // Dieser Konstruktor ermöglicht die einfache Erstellung einer neuen Bestellung
    // Parameter dafür sind: Anzahl Stühle, Anzahl Sofas und die Bestellnummer
    public Bestellung(int stuehle, int sofas, int nummer, Lager lager)
    {
        // Keine negativen Werte eingeben
        if (stuehle < 0 || sofas < 0 || nummer < 0) 
        {System.out.println ("Error: Keine negativen Werte erlaubt");}
        
        else {
        bestellnummer = nummer;
        anzahlStuehle = stuehle;
        anzahlSofa = sofas;
        
        System.out.println("Bestellung " + bestellnummer + ": Wird aufgenommen...");
        materialbedarf = berechneBedarf(stuehle, sofas);
        
        // Herstellungszeit der Produkte in minuten
        int herstellungszeitMinuten = sofas * Sofa.gibZeit() + stuehle * Stuhl.gibZeit();
        // LieferZeit soll in Stunden sein, also müssen wir das umrechnen
        herstellungszeit = (int)Math.ceil((herstellungszeitMinuten / 60));
        // Beschaffungszeit der Materialien, kann über das Lager herausgefunden werden
        beschaffungszeit = lager.gibBeschaffungszeit(materialbedarf) * 24;
        // Die Lieferzeit berechnet sich nun aus den anderen beiden zusammen
        lieferzeit = herstellungszeit + beschaffungszeit;
        

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
        }}

        bestellbestaetigung = "Bestellung " + bestellnummer +": Erfolgreich aufgegeben! Die Lieferzeit beträgt " + lieferzeit + " Stunden.";
        System.out.println(bestellbestaetigung);
    }

    public void BearbeitungsZeitAusgeben()
    {
        System.out.println("Bestellung " + bestellnummer+ ": Die Bestellung wird insgesamt " + herstellungszeit + " (Herstellung) + " + beschaffungszeit + "(Beschaffung) Stunden brauchen.");
    }

    // Berechnet den Bedarf an Material für eine bestimmte Bestellung
    public int [] berechneBedarf (int stuehle, int sofas)
    {        
        // Wieviel Material braucht man dafür?
        int holzbedarf = Stuhl.gibHolz() * stuehle + Sofa.gibHolz() * sofas;
        int schraubenbedarf = Stuhl.gibSchrauben() * stuehle + Sofa.gibSchrauben() * sofas;
        int farbbedarf = Stuhl.gibFarbe() * stuehle + Sofa.gibFarbe() * sofas;
        int kissenbedarf = Sofa.gibKissen() * sofas;
        int kartonbedarf = Stuhl.gibKarton() * stuehle + Sofa.gibKarton() * sofas;
        
        // Bedarf in einem Array zusammengefasst
        int [] bedarf_je_material = {holzbedarf, schraubenbedarf, farbbedarf, kissenbedarf, kartonbedarf};

        System.out.print ("Bestellung " + bestellnummer + ": Es wird folgendes Material benötigt:");
        System.out.print (bedarf_je_material [0]+ " an Holz, ");
        System.out.print (bedarf_je_material [1]+ " an Schrauben, ");
        System.out.print (bedarf_je_material [2]+ " an Farbe, ");
        System.out.print (bedarf_je_material [3]+ " an Kissen, ");
        System.out.println (bedarf_je_material [4]+ " an Karton. ");

        return bedarf_je_material;
    }
    
    // Verschiedene get-Methoden
    public int gibBestellnummer()
    {
        return bestellnummer;
    }

    public int gibHerstellungszeit()
    {
        return herstellungszeit;
    }

    public int gibLieferzeit ()
    {        
        return lieferzeit;
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
