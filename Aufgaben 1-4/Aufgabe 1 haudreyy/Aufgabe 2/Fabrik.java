import java.util.ArrayList;
/**
 * Die Klasse Fabrik ermöglicht Bestellungen aufzugeben und auszugeben.
 * 
 * @author Gruppe 7
 * @version 2.0
 */
public class Fabrik
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList <Bestellung> bestellungen;
    private int bestellzaehler;
    private Lager lager;
    
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
    }

    // Hier die Main-Methode
    public static void main(String[] args)
    {
        Fabrik fabrik = new Fabrik ();
        // Man könnte Code für den Start einfügen
    }
    
    // Mit dieser Methode kann man eine neue Bestellung aufgeben
    public void bestellungAufgeben (int stuehle, int sofas)
    {
        if (stuehle < 0 || sofas < 0) 
        {System.out.println ("Error: Keine negativen Werte erlaubt");}
        
        else {
        Bestellung bestellung = new Bestellung(stuehle, sofas, bestellzaehler++);
        bestellung.gibBearbeitungszeit (lager);
        bestellungen.add (bestellung);}
    }

    // Diese Methode gibt die vorhandenen Bestellungen aus
    public void bestellungenAusgeben ()
    {
        for (Bestellung bestellung : bestellungen)
        {
            String msg = "Bestellung " + bestellung.gibBestellnummer() + ": " 
            + bestellung.gibAnzahlStuehle() + " Stühle und " + bestellung.gibAnzahlSofa() 
            + " Sofas. Dauert insgesamt "; //+ */ b.gibLieferzeit() */  + " minuten.";
            
            System.out.println(msg);
        }
    }

    // Hiermit kann die Fabrik sein Lager füllen
    public void lagerAuffüllen ()
    {
        lager.lagerAuffüllen ();
    }
}
