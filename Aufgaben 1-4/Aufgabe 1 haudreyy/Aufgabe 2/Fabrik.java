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
    
    /**
     * Konstruktor für Objekte der Klasse Fabrik
     */
    public Fabrik()
    {
        // Instanzvariable werden initialisiert
        bestellzaehler = 0;
        bestellungen = new ArrayList<Bestellung>();
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
        Bestellung b = new Bestellung(stuehle, sofas, bestellzaehler++);
        bestellungen.add (b);
    }

    // Diese Methode gibt die vorhandenen Bestellungen aus
    public void bestellungenAusgeben ()
    {
        for (Bestellung b : bestellungen)
        {
            String msg = "Bestellung " + b.gibBestellnummer() + ": " 
            + b.gibAnzahlStuehle() + " Stühle und " + b.gibAnzahlSofa() 
            + " Sofas. Dauert insgesamt "; //+ */ b.gibLieferzeit() */  + " minuten.";
            
            System.out.println(msg);
        }
    }
}
