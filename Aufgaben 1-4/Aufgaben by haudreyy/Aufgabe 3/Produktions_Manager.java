import java.util.LinkedList;



/**
 * Beschreiben Sie hier die Klasse Produktions_Manager.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
 
public class Produktions_Manager extends Thread    
{  
    // Insta nzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Holzbearbeitungs_Roboter holzbearbeitungs_Roboter;  
    private Montage_Roboter montage_Roboter; 
    private Lackier_Roboter lackier_Roboter;   
    private Verpackungs_Roboter verpackungs_Roboter;      
    private Lager lager;            

    private LinkedList <Bestellung> inBearbeitung;   
    private LinkedList <Bestellung> inProduktion;
    public LinkedList <Produkt> produkteinProduktion;   

    
    /**
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    public Produktions_Manager(Lager lager)
    {        
        inBearbeitung = new LinkedList<Bestellung>();
        inProduktion = new LinkedList<Bestellung>();
        produkteinProduktion = new LinkedList<Produkt>();

        this.lager = lager;
    }
    
    
    public void bestellungInBearbeitungGeben (Bestellung bestellung)
    {
        System.out.println("Produktionsmanager: Bestellung " + bestellung.gibBestellnummer() + " erhalten");
        inBearbeitung.add (bestellung);
    }

    public void bestellungInProduktionGeben (Bestellung bestellung)
    {
        inProduktion.add (bestellung);
    }

    public void gibProdukteInProduktion (Produkt produkt)
    {
        produkteinProduktion.add(produkt);
        System.out.println("Produktionsmanager: " + produkt.meinTyp + " erhalten mit status " + produkt.aktuellerProduktionsSchritt);
    }

    public void run()
    {
        System.out.println("Thread started"); 
        // Roboter starten
        holzbearbeitungs_Roboter = new Holzbearbeitungs_Roboter(this);
        holzbearbeitungs_Roboter.start();
        verpackungs_Roboter = new Verpackungs_Roboter(this);
        verpackungs_Roboter.start();
        lackier_Roboter = new Lackier_Roboter(this);
        lackier_Roboter.start();
        montage_Roboter = new Montage_Roboter(this);
        montage_Roboter.start();
        // checken ob Liste inBearbeitung Elemente hat
        while (true)
        { 
            Bestellung bestellung = inBearbeitung.poll();
            if (bestellung != null)
            {
                // checken ob genug im Lager
                int benötigteStühle = bestellung.gibAnzahlStuehle();
                int benötigteSofas = bestellung.gibAnzahlSofa();

                int [] bedarf_je_material = bestellung.berechneBedarf(benötigteStühle,benötigteSofas);
                boolean genug = lager.genugMaterialVorhanden(bedarf_je_material);

                // wenn nicht genug, Lager füllen
                if (genug == false)
                {
                    //System.out.println("Lager zuerst füllen");
                    lager.lagerAuffuellen();
                    
                }
                // wenn genug checken, Bestellung weitergeben an inProduktion
                else 
                {
                    inProduktion.add(bestellung);
                    System.out.println("Bestellung jetzt in Produktion");

                    // Lager belasten mit dem nötigen Material für die Bestellung
                    lager.lagerbelasten (bedarf_je_material);

                    // Produkte aus Bestellung nehmen und in Produktion geben
                    for (int i = 0; i < bestellung.gibAnzahlStuehle(); i++)
                    {
                        produkteinProduktion.add(new Stuhl());
                    }
                    for (int i = 0; i < bestellung.gibAnzahlSofa(); i++)
                    {
                        produkteinProduktion.add(new Sofa());
                    }

                }
                
            } 
            
            Produkt nächstesProdukt = produkteinProduktion.poll();
            if (nächstesProdukt != null)
            {
                if (nächstesProdukt.aktuellerProduktionsSchritt >= nächstesProdukt.produktionsAblauf.length)
                {
                    // Wir sind fertig, liefere das produkt an die bestellung.
                    System.out.println(nächstesProdukt.meinTyp + " ist fertig!");
                }
                else // wenn das produkt noch nicht fertig ist
                {
                        Roboter.RoboterTyp nächsterRoboter = nächstesProdukt.produktionsAblauf[nächstesProdukt.aktuellerProduktionsSchritt];
                    //System.out.println("nächster roboter; " + nächsterRoboter);
                
                    if (nächsterRoboter == Roboter.RoboterTyp.Holzverarbeitung)
                    {
                        holzbearbeitungs_Roboter.fuegeProduktHinzu(nächstesProdukt);
                    }

                    if (nächsterRoboter == Roboter.RoboterTyp.Montage)
                    {
                        montage_Roboter.fuegeProduktHinzu(nächstesProdukt);
                    }

                    if (nächsterRoboter == Roboter.RoboterTyp.Verpackung)
                    {
                        verpackungs_Roboter.fuegeProduktHinzu(nächstesProdukt);
                    }

                    if (nächsterRoboter == Roboter.RoboterTyp.Lackierung)
                    {
                        lackier_Roboter.fuegeProduktHinzu(nächstesProdukt);
                    }
                }
                
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
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

