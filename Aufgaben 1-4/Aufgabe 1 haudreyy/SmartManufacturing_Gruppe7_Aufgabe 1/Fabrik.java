import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Fabrik.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
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
        // Instanzvariable initialisieren
        bestellzaehler = 0;
        bestellungen = new ArrayList<Bestellung>();
    }

    public static void main(String[] args)
    {
        Fabrik fabrik = new Fabrik ();
    }
    
    public void bestellungAufgeben (int stuehle, int sofas)
    {
        Bestellung b = new Bestellung(stuehle, sofas, bestellzaehler++);
        bestellungen.add (b);
    }

    public void bestellungenAusgeben ()
    {
        for (Bestellung b : bestellungen)
        {
            String msg = "Bestellung " + b.gibBestellnummer() + ": " 
            + b.gibAnzahlStuehle() + " Stühle und " + b.gibAnzahlSofa() 
            + " Sofas. Dauert insgesamt " + b.gibBeschaffungszeit() + " minuten.";
        System.out.println(msg);
        }
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    
}
