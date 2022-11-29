import java.util.ArrayList;
/**
 * Die Klasse Fabrik ermöglicht Bestellungen aufzugeben und auszugeben.
 * 
 * @author Gruppe 7
 * @version 2.0
 */
public class  Fabrik
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList <Bestellung> bestellungen;
    private int bestellzaehler;
    private Lager lager;
    private Produktions_Manager produktionsManager; 
    
    /**
     * Konstruktor für Objekte der Klasse Fabrik
     * Es wird eine Fabrik mit Lager erstellt
     */
    public Fabrik()
    { 
        // Instanzvariable werden initialisiert
        bestellzaehler = 0;
        bestellungen = new ArrayList<Bestellung>();
        lager = new Lager(0,0,0,0,0);
        System.out.println("Fabrik erstellt");

        produktionsManager = new Produktions_Manager();
        //produktionsManager.start();
    } 

    // Hier die Main-Methode
    public static void main(String[] args)
    {
        Fabrik fabrik = new Fabrik ();
    }
    
    // Mit dieser Methode kann man eine neue Bestellung aufgeben
    public void bestellungAufgeben (int stuehle, int sofas)
    {
        if (stuehle < 0 || sofas < 0) 
        {System.out.println ("Error: Keine negativen Werte erlaubt");}
        else 
        {
        Bestellung bestellung = new Bestellung(stuehle, sofas, bestellzaehler++, lager);
        bestellung.BearbeitungsZeitAusgeben();
        bestellungen.add (bestellung);
        }

        // Bestellung wird der LinkedList bestellungInAuftragGeben hinzugefügt
        // produktionsManager.bestellungInAuftragGeben ();
    }

    // Diese Methode gibt die vorhandenen Bestellungen aus
    public void bestellungenAusgeben ()
    {
        for (Bestellung bestellung : bestellungen)
        {
            String msg = "Bestellung " + bestellung.gibBestellnummer() + ": " 
            + bestellung.gibAnzahlStuehle() + " Stühle und " + bestellung.gibAnzahlSofa() 
            + " Sofas. Lieferzeit insgesamt "+ bestellung.gibLieferzeit ()  + " Stunden.";
            
            System.out.println(msg);
        }
    }

    public void lagerAuffuellen()
    {
        lager.lagerAuffuellen();
    }
}
