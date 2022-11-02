import java.util.ArrayList;

/**
 * Die Klasse Fabrik ermöglicht das es, Bestellungen aufzugeben und auszugeben.
 * 
 * @author Gruppe 7
 * @version 1.0
 */
public class Fabrik
{
    private ArrayList<Bestellung> bestellungen;

    public Fabrik()
    {
        bestellungen = new ArrayList<Bestellung>();
    }
    
    public static void main(String args[]) 
    {
        // Hier könnte man Code für den Start einfügen.
        // Es ist nicht konkret bekannt, was hier erwartet wird.
        System.out.println("Bitte benutzen sie das gegebene Programmierinterface zu bestellen.");
    }
    
    // Mit dieser Methode kann man eine neue Bestellung aufgeben
    public void bestellungAufgeben(int sofaAnzahl, int stuhlAnzahl) 
    {
        bestellungen.add(new Bestellung(sofaAnzahl, stuhlAnzahl));
    }
    
    // Diese Methode gibt die vorhandenen Bestellungen aus
    public void bestellungenAusgeben()
    {
        System.out.println("### BESTELLÜBERSICHT ###");
        for(Bestellung bestellung : bestellungen) {
            System.out.println("----------------------------------------------------");
            System.out.println("Bestellungsnummer: " + bestellung.gibBestellungsNr());
            System.out.println("Anzahl Stühle: " + bestellung.gibAnzahlStuehle());
            System.out.println("Anzahl Sofas: " + bestellung.gibAnzahlSofas());
            System.out.println("Minimale Beschaffungszeit (Produktionszeit): " + bestellung.gibBeschaffungsZeit());
            System.out.println("----------------------------------------------------");
        }
    }
    
    // Das erlaubt uns, die Fabrik Klasse besser zu testen
    public ArrayList<Bestellung> gibBestellungliste() {
        return bestellungen;
    }
}
