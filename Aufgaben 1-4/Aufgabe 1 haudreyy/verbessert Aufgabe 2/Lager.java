import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Lager verwaltet die Materialien, welche benötigt werden um Bestellungen zu beabrbeiten.
 * 
 * @author (Gruppe 7) 
 * @version (version 2.0)
 */

 /* Die Materialien in den Arrays entsprechen der folgenden Reihenfolge:
        [0] Holz,
        [1] Schrauben,
        [2] Farbe,
        [3] Kissen,
        [4] Karton
    */

public class Lager
{
    // Instanzvariablen - hier befinden sich die Instanzvariabeln, welche in der Klasse Lager genutzt werden
    private final static int maxHolzeinheiten = 1000;
    private final static int maxSchrauben = 5000;
    private final static int maxFarbeinheiten = 1000;
    private final static int maxKissen= 100;
    private final static int maxKarton = 1000;
    
    private int [] lagerbestand;


    /**
     * Dieser Konstruktor ermöglicht die einfache Erstellung eines Lagers. 
     * Die Anzahl Materialien dieses Lagers müssen eingegeben werden.
     */
    public Lager(int holzeinheiten, int schrauben, int farbeinheiten, int kissen, int karton)
    {
        // Erstellt einen Array für das Lager mit den entsprechenden Materialmengen
        lagerbestand = new int[]{holzeinheiten, schrauben, farbeinheiten, kissen, karton} ;
    }

    // Diese Methode gibt den aktuellen Lagerbestand aus in die Konsole aus
    public void lagerBestandAusgeben ()
    {
        System.out.println ("Lagerbestand:");
        System.out.println ("Holz:" + lagerbestand [0]);
        System.out.println ("Schrauben:" + lagerbestand [1]);
        System.out.println ("Farbe:" + lagerbestand [2]);
        System.out.println ("Kissen:" + lagerbestand [3]);
        System.out.println ("Karton:" + lagerbestand [4]);
    }

    // Diese Methode gibt den Lagerstand je nach Material an
    public int gibLagerbestand (int material)
    {
        return lagerbestand [material];
    }
    
    // Berechnet den Bedarf an Material für eine bestimmte Bestellung
    public int [] berechneBedarf (Bestellung bestellung)
    {
        // Wieviele Stühle und Sofas wurden bestellt?
        int sofas = bestellung.gibAnzahlSofa();
        int stuehle = bestellung.gibAnzahlStuehle();
        
        // Wieviel Material braucht man dafür?
        int holzbedarf = Stuhl.gibHolz() * stuehle + Sofa.gibHolz() * sofas;
        int schraubenbedarf = Stuhl.gibSchrauben() * stuehle + Sofa.gibSchrauben() * sofas;
        int farbbedarf = Stuhl.gibFarbe() * stuehle + Sofa.gibFarbe() * sofas;
        int kissenbedarf = Sofa.gibKissen() * sofas;
        int kartonbedarf = Stuhl.gibKarton() * stuehle + Sofa.gibKarton() * sofas;
        
        // Bedarf in einem Array zusammengefasst
        int [] bedarf_je_material = {holzbedarf, schraubenbedarf , farbbedarf ,kissenbedarf ,kartonbedarf};
        return bedarf_je_material;
    } 
 
    // Gibt die Beschaffungszeit für eine bestimmte Bestellung
    public int gibBeschaffungszeit(Bestellung bestellung)
    {
        int [] bedarf_je_material = berechneBedarf (bestellung);

        // Wenn alles Material für eine Bestellung vorhanden ist, dann retourniert die Methode 0 Tage, sonst 2 Tage
        // Die Einheit ist Tage
        int i = 0;
        while (i < lagerbestand.length)
        {
            if (lagerbestand [i] < bedarf_je_material [i])
            {
                return 2;
            }
            i++;
        }
        return 0;
    }

    // Hier wird das zu bestellende Material für eine bestimmte Bestellung berechnet
    public int [] zubestellenMaterial (Bestellung bestellung)
    {
        int [] bedarf_je_material = berechneBedarf (bestellung);
        int [] zubestellenMaterial = new int[5];
        int delta = 0;


        for (int x=0; x < lagerbestand.length; x++)
        {
            delta = bedarf_je_material [x] - lagerbestand [x];
           
            if (delta < 0) 
            { delta = 0;}
            
            zubestellenMaterial [x] = delta;
        }
        return zubestellenMaterial;
    }
  
    // Diese Methode füllt das Lager komplett auf.
    public void lagerAuffüllen ()
    {
        int [] lagerGanzGefüllt = {maxHolzeinheiten, maxSchrauben, maxFarbeinheiten, maxKissen, maxKarton};
        int [] zubestellenMaterial = new int[5];

        // Berechnet wieviel bestellt werden muss um die maximale Kapazität zu erreichen
        for (int x=0; x < lagerbestand.length; x++)
        {
            zubestellenMaterial [x] = lagerGanzGefüllt [x] - lagerbestand [x];
        }
        // Es wird ein Objekt der Klasse Lieferant erstellt
        Lieferant lieferant = new Lieferant();
        // Dieses erhält das zu bestellende Material
        int[] lieferung = lieferant.bestellungAufgeben(zubestellenMaterial);
        // Das Lager wird gefüllt
        lagerbefuellen(lieferung);
    }

    // Das Lager wird befüllt
    public void lagerbefuellen(int[] lieferung)
    {
        for (int i = 0; i < lagerbestand.length; i++)
        {
            lagerbestand[i] += lieferung[i];
        }
    }



}
   




