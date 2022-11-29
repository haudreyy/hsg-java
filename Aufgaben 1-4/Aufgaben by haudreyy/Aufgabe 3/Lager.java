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
    
    private int [] maximalBestand = {maxHolzeinheiten, maxSchrauben, maxFarbeinheiten, maxKissen, maxKarton};
    
    private int [] lagerbestand;
    
    /**
     * Dieser Konstruktor ermöglicht die einfache Erstellung eines Lagers. 
     * Die Anzahl Materialien dieses Lagers müssen eingegeben werden.
     */
    public Lager(int holzeinheiten, int schrauben, int farbeinheiten, int kissen, int karton)
    {
        // Erstellt einen Array für das Lager mit den entsprechenden Materialmengen
        lagerbestand = new int[] {holzeinheiten, schrauben, farbeinheiten, kissen, karton};
    }

    // Diese Methode gibt den aktuellen Lagerbestand aus in die Konsole aus
    public void lagerBestandAusgeben ()
    {
        System.out.print ("Lagerbestand: ");
        System.out.print (lagerbestand [0]+ " Holz, ");
        System.out.print (lagerbestand [1]+ " Schrauben, ");
        System.out.print (lagerbestand [2]+ " Farbe, ");
        System.out.print (lagerbestand [3]+ " Kissen, ");
        System.out.println (lagerbestand [4]+ " Karton. ");
    }
 
    // Gibt die Beschaffungszeit für eine bestimmte Bestellung
    public int gibBeschaffungszeit(int [] bedarf_je_material)
    {
        // Wenn alles Material für eine Bestellung vorhanden ist, dann retourniert die Methode 0 Tage, sonst 2 Tage
        // Die Einheit ist Tage
        int i = 0;
        while (i < lagerbestand.length)
        {
            if (lagerbestand [i] < bedarf_je_material [i])
            {
                //System.out.println("Es ist nicht genug Material vorhanden. 2 Tage Vorlaufzeit nötig.");
                return 2;
            }
            i++;
        }
        //System.out.println("Es ist genug Material vorhanden. 0 Tage Vorlaufzeit!");
        return 0;
    }

    // Hier wird das zu bestellende Material für eine bestimmte Bestellung berechnet
    public boolean genugMaterialVorhanden(int[] benoetigtesMaterial)
    {
        int delta = 0;
        for (int x=0; x < lagerbestand.length; x++)
        {
            delta = benoetigtesMaterial[x] - lagerbestand[x];
           
            if (delta < 0) 
            { delta = 0;}
            else {return false;}
        }
        return true;
    }

    public void lagerAuffuellen()
    {
        int [] materialbestellung = new int[lagerbestand.length];

        for (int i = 0; i < lagerbestand.length; i++)
        {
            materialbestellung[i] = maximalBestand[i]-lagerbestand[i];
        }
        // und bestelle das material
        materialBestellen(materialbestellung);
    }

    public void materialBestellen(int[] materialBestellung)
    {
        Lieferant lieferant = new Lieferant(this, materialBestellung);
        lieferant.start();
    }

    // Das Lager wird je nach Bedarf befüllt
    public void lagerbefuellen(int[] lieferung)
    {
        for (int i = 0; i < lagerbestand.length; i++)
        {
            lagerbestand[i] += lieferung[i];
        }
        System.out.print ("Lager hat folgende Lieferung erhalten: ");
        System.out.print (lieferung [0]+ " an Holz, ");
        System.out.print (lieferung [1]+ " an Schrauben, ");
        System.out.print (lieferung [2]+ " an Farbe, ");
        System.out.print (lieferung [3]+ " an Kissen, ");
        System.out.print (lieferung [4]+ " an Karton.");
        System.out.println();
    }
}
   




