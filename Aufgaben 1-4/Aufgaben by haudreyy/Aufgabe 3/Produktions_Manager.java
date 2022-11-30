import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Produktions_Manager.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class Produktions_Manager extends Thread 
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Holzbearbeitungs_Roboter holzbearbeitungs_Roboter;
    private Montage_Roboter montage_Roboter;
    private Lackier_Roboter lackier_Roboter;
    private Verpackungs_Roboter verpackungs_Roboter;

    private LinkedList <Bestellung> inBearbeitung;
    private LinkedList <Bestellung> inProduktion;
    private LinkedList <Produkt> produkteinProduktion;

    
    /**
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    public Produktions_Manager()
    {
        holzbearbeitungs_Roboter = new Holzbearbeitungs_Roboter();
        montage_Roboter = new Montage_Roboter();
        lackier_Roboter = new Lackier_Roboter();
        verpackungs_Roboter = new Verpackungs_Roboter();
        
        inBearbeitung = new LinkedList<Bestellung>();
        inProduktion = new LinkedList<Bestellung>();
        produkteinProduktion = new LinkedList<Produkt>();
    }
    
    
    public void bestellungInBearbeitungGeben (Bestellung bestellung)
    {
        inBearbeitung.add (bestellung);
    }

    public void bestellungInProduktionGeben (Bestellung bestellung)
    {
        inProduktion.add (bestellung);
    }

    public void gibProdukteInProduktion (Produkt produkt)
    {

    }

    public void run(Lager lager)
    {
        // checken ob Liste inBearbeitung Elemente hat
        while (true)
        {
            if (inBearbeitung.size() > 0)
            {
            // checken ob genug im Lager
            Bestellung bestellung = inBearbeitung.getFirst();
            int benötigteStühle = bestellung.gibAnzahlStuehle();
            int benötigteSofas = bestellung.gibAnzahlSofa();

            
            int [] bedarf_je_material = bestellung.berechneBedarf(benötigteStühle,benötigteSofas);
            boolean genug = lager.genugMaterialVorhanden(bedarf_je_material);
            System.out.println ("" + genug);

            // wenn nicht genug, Lager füllen
            if (genug == false)
            {
                lager.lagerAuffuellen();
                System.out.println("Lager wird zuerst gefüllt");
        
            }
            // wenn genug checken, Bestellung weitergeben an inProduktion
            else 
            {
                bestellung = inBearbeitung.poll();
                inProduktion.add(bestellung);
                System.out.println("Bestellung jetzt inProduktion");
                System.out.println ("" + inBearbeitung.size());
            }
            }    
        }
        

        
        
        /* 
        // zweiter Versuch
        while (true)
        {
            Bestellung nextBestellung = zuverarbeitenBestellung.poll();
            if(nextBestellung != null)
            {
                System.out.println ("Bestellung " + nextBestellung.gibBestellnummer() + " wird verarbeitet.");
                //ThreadUtil.syncedPrintln("Starting to process " + nextBestellung);
                inbearbeitungbestellung.add(nextBestellung);
                //setProductionSequence(nextBestellung);
                //nextProduce.startNextProductionStep();
            } else { System.out.println ("leer");}
        }
 
        // erster Versuch
        if (zuverarbeitenBestellung.size() > 0)
        {
            Bestellung bestellung = zuverarbeitenBestellung.poll();
            this.bestellungProduzieren (bestellung);
        }
        else { System.out.println ("keine Bestellung in Liste inbearbeitungbestellung"); } 
    } */

    }


}

