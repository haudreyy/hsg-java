import java.util.LinkedList;

/**
 * Abstrakte Klasse Roboter - beschreiben Sie hier die Klasse
 * 
 * @author (Ihr Name)
 * @version (eine Version-Nummer oder ein Datum)
 */
public abstract class Roboter extends Thread
{
    public enum RoboterTyp{
        Holzverarbeitung,
        Lackierung,
        Montage,
        Verpackung
    }
    private LinkedList<Produkt> warteschlange;       
    String name; 
    private Produktions_Manager produktionsManager; 
    // wir nehmen einach mal stuhl als 'erstes letztes produkt'   
    private Produkt.Produkttyp letztesProdukt =  Produkt.Produkttyp.Stuhl; 
 
    public RoboterTyp meinTyp;
 
    public Roboter(String name, Produktions_Manager pm)
    {
        this.produktionsManager = pm; 
        this.name = name;
        warteschlange = new LinkedList<Produkt>();

    }

    public void run()
    {
        System.out.println(this.name + " gestartet.");
        while (true) 
        {
            Produkt nextProdukt = warteschlange.poll();
            if (nextProdukt != null) 
            {
                produziereProdukt(nextProdukt);
            }
            
            ThreadUtil.sleep(1000);
        }
    }

    public void fuegeProduktHinzu(Produkt produkt)
    {
        System.out.println(name + " hat " + produkt.meinTyp + " erhalten.");
        warteschlange.add(produkt);
    }

    public void produziereProdukt(Produkt produkt)
    {
        if (produkt.meinTyp != letztesProdukt)
        {
            // wir müssen den roboter umkonfigurieren auf das neue produkt, 1 stunde
            try 
            {
                
                Thread.sleep(1 * 1000);
            } 
            catch (InterruptedException e) {} 
        }
        System.out.println(this.name + " verarbeitet jetzt "  + produkt.meinTyp.toString());
        // produktionsZeit vom Produkt auslesen mithilfe von produkt.aktuellerProduktionsSchritt
        // und dem array int[] produktionsDauer > produkt.produktionsdauer[produkt.aktuellerproduktionsSchritt]
        int produktionsZeit = produkt.produktionsDauer [produkt.aktuellerProduktionsSchritt];
        // von minuten in stunden umwandeln und als milisekunden für den thread.sleep speichern
        long produktionsZeitMillisekunden = Math.round(((double)produktionsZeit / 60 * 1000));
        //System.out.println(this.name + " dauer in millisekunden: "  + produktionsZeitMillisekunden);
        
        //produziere das produkt
        try 
        {
            Thread.sleep(produktionsZeitMillisekunden);
        } 
        catch (InterruptedException e) {} 

        produkt.aktuellerProduktionsSchritt += 1;
        produktionsManager.gibProdukteInProduktion(produkt);
    }
}
