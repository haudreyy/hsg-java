
/**
 * Beschreiben Sie hier die Klasse Stunden.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Auswerter
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int zugriffeinStunden;

    /**
     * Konstruktor für Objekte der Klasse Stunden
     */
    public static void main (String [] args)
    {
        int [] zugriffeinStunden = new int [24];
        zugriffeinStunden [1] = 5;
        System.out.println ( zugriffeinStunden [1]);
        
        int position = 20;
        int zugriff = 500;
        zugriffeinStunden [position] = zugriff;
        
        System.out.println ( zugriffeinStunden [20]);
        
        zugriffeinStunden [1] = zugriffeinStunden [1] - 3;
        System.out.println ( zugriffeinStunden [1]);
    }

    /**
     * Werte dem Array zuordnen
     */
    public void eingabeZugriffinStunde(int anzahlZugriff, int inStunde)
    {
        int position = inStunde;

        
    }
}
