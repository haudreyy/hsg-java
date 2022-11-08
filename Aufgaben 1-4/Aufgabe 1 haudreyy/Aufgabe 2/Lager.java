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
        Farbe (2),
        Kissen (3),
        Karton (4)
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
    public void lagerBestandAusgeben ()
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
    
    public int [] berechneBedarf (Bestellung bestellung)
    {
        int sofas = bestellung.gibAnzahlSofa();
        int stuehle = bestellung.gibAnzahlStuehle();
        
        int holzbedarf = Stuhl.gibHolz() * stuehle + Sofa.gibHolz() * sofas;
        int schraubenbedarf = Stuhl.gibSchrauben() * stuehle + Sofa.gibSchrauben() * sofas;
        int farbbedarf = Stuhl.gibFarbe() * stuehle + Sofa.gibFarbe() * sofas;
        int kissenbedarf = Sofa.gibKissen() * sofas;
        int kartonbedarf = Stuhl.gibKarton() * stuehle + Sofa.gibKarton() * sofas;

        int [] bedarf_je_material = {holzbedarf, schraubenbedarf , farbbedarf ,kissenbedarf ,kartonbedarf};
                
        return bedarf_je_material;
    } 
 

    public int gibBeschaffungszeit(Bestellung bestellung)
    {
        int [] bedarf_je_material = berechneBedarf (bestellung);

        int i = 0;
        while (i < lagerbestand.length)
        {
            if (lagerbestand [i] < bedarf_je_material [i])
            {
                System.out.println("returning 2");
                return 2;
            }
            i++;
        }
        System.out.println("returning 0");
        return 0;
    }


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
  

    public int [] lagerAuffüllen ()
    {
        int [] lagerGanzGefüllt = {maxHolzeinheiten, maxSchrauben, maxFarbeinheiten, maxKissen, maxKarton};
        int [] zubestellenMaterialalles = new int[5];
        int delta = 0;

        for (int x=0; x < lagerbestand.length; x++)
        {
            delta = lagerGanzGefüllt [x] - lagerbestand [x];
            zubestellenMaterialalles [x] = delta;
        }
        
        System.out.println ("" + zubestellenMaterialalles [0] + zubestellenMaterialalles [1]
        + zubestellenMaterialalles [2] + zubestellenMaterialalles [3] + zubestellenMaterialalles [4]);
        return zubestellenMaterialalles;
    }

}
   




