import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Eine Klasse zum Lesen von Informationen aus einer
 * Datei, in der Webseitenzugriffe protokolliert
 * sind (eine 'Logdatei').
 * Es wird angenommen, dass ein Eintrag in der Logdatei
 * Datums- und Zeitinformationen in folgendem Format
 * enthält:
 * 
 *   Jahr Monat Tag Stunde Minute
 * 
 * Einträge in der Logdatei sind chronologisch
 * aufsteigend sortiert.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.02.29
 */
public class LogdateiLeser implements Iterator<Logeintrag>
{
    // das Format eines Eintrags in der Logdatei
    private String format;
    // ein "Behälter" für die gelesenen Logeintrag-Objekte.
    private ArrayList<Logeintrag> eintraege;
    // ein Iterator über Einträge
    private Iterator<Logeintrag> dataIterator;
    
    /**
     * Erzeuge einen LogdateiLeser, der Einträge aus einer 
     * Logdatei mit dem voreingestellten Namen "weblog.txt"
     * liest.
     */
    public LogdateiLeser() 
    {
        this("weblog.txt");
    }
    
    /**
     * Erzeuge einen LogdateiLeser, der Einträge aus einer
     * Datei mit dem angegebenen Namen liest.
     * @param  dateiname der Name der Logdatei
     */
    public LogdateiLeser(String dateiname)
    {
        // das Format der Daten
        format = "Jahr Monat(1-12) Tag Stunde Minute";       
        // ein "Behälter" für die Einträge
        eintraege = new ArrayList<Logeintrag>();
        
        // versuchen, den kompletten Inhalt der Datei einzulesen
        boolean datenGelesen;
        try{
            //die Datei in der aktuellen Umgebung lokalisieren 
            URL dateiURL = getClass().getClassLoader().getResource(dateiname);
            if(dateiURL == null) {
                throw new FileNotFoundException(dateiname);
            }
            Scanner logdatei = new Scanner(new File(dateiURL.toURI()));
            // lesen der Zeilen bis zum Ende der Datei
            while(logdatei.hasNextLine()) {
                String logzeile = logdatei.nextLine();
                // Zerlegen der Zeile und einfügen in die Eintragsliste
                Logeintrag eintrag = new Logeintrag(logzeile);
                eintraege.add(eintrag);
            }
            logdatei.close();
            datenGelesen = true;
        }
        catch(FileNotFoundException e) {
            System.out.println("Folgendes Problem ist aufgetreten: " + e);
            datenGelesen = false;
        }
        catch(URISyntaxException e) {
            System.out.println("Folgendes Problem ist aufgetreten: " + e);
            datenGelesen = false;
        }
        // Wenn wir die Logdatei nicht lesen konnten, verwenden wir die Simulationsdaten.
        if(!datenGelesen) {
            System.out.println("Datei kann nicht gelesen werden: " +
                               dateiname);
            System.out.println("Es werden stattdessen Simulationsdaten verwendet.");
            erzeugeSimulationsdaten(eintraege);
        }
        // Sortiere die Einträge in aufsteigender Folge an.
        Collections.sort(eintraege);
        zuruecksetzen();
    }
    
    /**
     * Hat dieser Leser weitere Einträge zu liefern?
     * @return true  falls weitere Daten geliefert werden können,
     *               'false' sonst
     */
    public boolean hasNext()
    {
        return dataIterator.hasNext();
    }
    
    /**
     * Liefere den nächsten Eintrag aus der Logdatei
     * in Form eines Logeintrag-Objektes.
     * 
     * @return  ein Exemplar von Logeintrag, das die Daten
     *          der nächsten Zeile enthält
     */
    public Logeintrag next()
    {
        return dataIterator.next();
    }
    
    /**
     * Lösche einen Eintrag.
     * Diese Operation ist nicht erlaubt.
     */
    public void remove()
    {
        System.err.println("Das Loeschen von Eintraegen ist nicht erlaubt.");
    }
    
    /**
     * @return  einen String, der das Format der Daten in der Protokolldatei erklärt
     */
    public String gibFormat()
    {
        return format;
    }
    
    /**
     * Setze den logischen Lesezeiger wieder an den Anfang
     * der Daten dieses LogdateiLesers. Die Daten können auf
     * diese Weise mehrfach ausgelesen werden.
     */
    public void zuruecksetzen()
    {
        dataIterator = eintraege.iterator();
    }
    
    /**
     * Gib die Daten dieses Lesers auf die Konsole aus.
     */
    public void datenAusgeben()
    {
        for (Logeintrag eintrag : eintraege) {
            System.out.println(eintrag);
        }
    }
    
        /**
     * Provide a sample of simulated data.
     * NB: To simplify the creation of this data, no
     * days after the 28th of a month are ever generated.
     * @param data Where to store the simulated LogEntry objects.
     */
    private void erzeugeSimulationsdaten(ArrayList<Logeintrag> daten)
    {
       LogdateiErzeuger erzeuger = new LogdateiErzeuger();
       // Wie viele simulierte Einträge benötigen wir?
        int anzEintraege = 100;
        for(int i = 0; i < anzEintraege; i++) {
            daten.add(erzeuger.erzeugeEintrag());
        }
    }
}
