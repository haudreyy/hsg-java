import java.util.ArrayList;
import java.util.List;

/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

 /*
        Holz(0),
        Schrauben(1),
        Farbe,
        Kissen,
        Karton
    */

public class Lager
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int maxHolzeinheiten;
    private int maxSchrauben;
    private int maxFarbeinheiten;
    private int maxKissen;
    private int maxKarton;
    private int [] lagerbestand;

    /**
     * Konstruktor für Objekte der Klasse Lager
     */
    public Lager(int holzeinheiten, int schrauben, int farbeinheiten, int kissen, int karton)
    {
        // Instanzvariable initialisieren
        maxHolzeinheiten = 1000;
        maxSchrauben = 5000;
        maxFarbeinheiten = 1000;
        maxKissen = 100;
        maxKarton = 1000;
        lagerbestand = new int[]{holzeinheiten, schrauben, farbeinheiten, kissen, karton} ;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void gibLagerbestand ()
    {
        System.out.println ("Lagerbestand:");
        System.out.println ("Holz:" + lagerbestand [0]);
        System.out.println ("Schrauben:" + lagerbestand [1]);
        System.out.println ("Farbe:" + lagerbestand [2]);
        System.out.println ("Kissen:" + lagerbestand [3]);
        System.out.println ("Karton:" + lagerbestand [4]);
    }

    public int gibLagerbestand (int rohstoff)
    {
        return lagerbestand [rohstoff];
    }
    
    
    public int gibBeschaffungszeit(Bestellung bestellung)
    {
        int sofas = bestellung.gibAnzahlSofa();
        int stuehle = bestellung.gibAnzahlStuehle();
        boolean genug = true;
        int holzbedarf = Stuhl.gibHolz() * stuehle + Sofa.gibHolz() * sofas;

        private int [] bedarf_je_material = {holzbedarf, schraubenbedarf, ......}};
        ///

        for(int i =0 ; i < lagerbestand.length; i++)
        {
            int bedarf = bedarf_je_material [i];
            int bestand = lagerbestand [i];
            if (bestand < bedarf)
            {genug = false;}
        }
        for (int bestand : lagerbestand) {
            
        }

        if (genug) {return 0;}
        else {return 2;}
    }
}


