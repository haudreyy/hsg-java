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

    private LinkedList <Bestellung> zuverarbeitenBestellung;
    private LinkedList <Bestellung> inbearbeitungbestellung;

    /**
     * Konstruktor für Objekte der Klasse Produktions_Manager
     */
    public Produktions_Manager()
    {
        holzbearbeitungs_Roboter = new Holzbearbeitungs_Roboter();
        montage_Roboter = new Montage_Roboter();
        lackier_Roboter = new Lackier_Roboter();
        verpackungs_Roboter = new Verpackungs_Roboter();
        
        zuverarbeitenBestellung = new LinkedList<Bestellung>();
        inbearbeitungbestellung = new LinkedList<Bestellung>();

    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    
    public void bestellungInAuftragGeben (Bestellung bestellung)
    {
        zuverarbeitenBestellung.add (bestellung);
    }

    public void bestellungProduzieren (Bestellung bestellung)
    {
        inbearbeitungbestellung.add (bestellung);
    }
    
    //zweiter Versuch
    public void run()
    {
        while (true)
        {
            Bestellung nextBestellung = zuverarbeitenBestellung.poll();
            if(nextBestellung != null)
            {
                System.out.println ("in produktion gesetzt");
                //ThreadUtil.syncedPrintln("Starting to process " + nextBestellung);
                inbearbeitungbestellung.add(nextBestellung);
                //setProductionSequence(nextBestellung);
                //nextProduce.startNextProductionStep();
            } else { System.out.println ("leer");}
        }

        /* 
        // erster Versuch
        if (zuverarbeitenBestellung.size() > 0)
        {
            Bestellung bestellung = zuverarbeitenBestellung.poll();
            this.bestellungProduzieren (bestellung);
        }
        else { System.out.println ("keine Bestellung in Liste inbearbeitungbestellung"); } */
    }

    private void setProductionSequence(Bestellung bestellung)
    {

    }


}
