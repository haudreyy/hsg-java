import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;

/**
 * Ein AdressbuchDateiverwalter bietet eine Reihe von
 * Datei-Operationen f?r ein Adressbuch an.
 * Diese Methoden demonstrieren einige grundlegende
 * Eigenschaften des Pakets java.io.
 * 
 * @author David J. Barnes und Michael K?lling
 * @version 2016.02.29
 */
public class AdressbuchDateiverwalter
{
    // Das Adressbuch, mit dem gearbeitet wird.
    private Adressbuch buch;
    // Der Name der Datei, in der die Suchergebnisse gespeichert
    // werden.
    private static final String DATEINAME = "Ergebnisse.txt";

    /**
     * Konstruktor f?r Objekte der Klasse AdressbuchDateiverwalter.
     * @param buch  das Adressbuch, das benutzt werden soll
     */
    public AdressbuchDateiverwalter(Adressbuch buch)
    {
        this.buch = buch;
    }
    
    /**
     * Speichere die Ergebnisse einer Suche im Adressbuch
     * in der Datei 'Ergebnisse.txt' im Projektordner.
     * @param praefix  der Schl?ssel-Pr?fix, mit dem gesucht
     *                 werden soll
     */
    public void speichereSuchergebnisse(String praefix) throws IOException
    {
        Path ergebnisdatei = Paths.get(DATEINAME).toAbsolutePath();
        Kontakt[] ergebnisse = buch.suche(praefix);
        FileWriter writer = new FileWriter(ergebnisdatei.toString());
        for(Kontakt kontakt : ergebnisse) {
            writer.write(kontakt.toString());
            writer.write('\n');
            writer.write('\n');
        }
        writer.close();
    }
    
    /**
     * Zeige die Ergebnisse des letzten Aufrufs von
     * speichereSuchergebnisse. Da die Ausgabe auf der
     * Konsole erfolgt, werden alle Probleme von dieser
     * Methode unmittelbar gemeldet.
     */
    public void zeigeSuchergebnisse()
    {
        BufferedReader reader = null;
        try {
            Path ergebnisdatei = Paths.get(DATEINAME).toAbsolutePath();
            reader = new BufferedReader(
                        new FileReader(ergebnisdatei.toString()));
            System.out.println("Ergebnisse ...");
            String zeile;
            zeile = reader.readLine();
            while(zeile != null) {
                System.out.println(zeile);
                zeile = reader.readLine();
            }
            System.out.println();
        }
        catch(FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " +
                               DATEINAME);
        }
        catch(IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " +
                               DATEINAME);
        }
        finally {
            if(reader != null) {
                // Fangen jeder Exception, aber nicht viel zu tun
                try {
                    reader.close();
                }
                catch(IOException e) {
                    System.out.println("Fehler beim Schlie?en: " +
                                       DATEINAME);
                }
            }
        }
    }

    /**
     * F?ge weitere Kontakte aus einer Textdatei dem Adressbuch
     * hinzu. Die Datei sollte ein Element pro Zeile enthalten,
     * plus eine Leerzeile zwischen den Kontakten:
     *     Name \n Telefon \n Adresse \n \n
     * Eine Zeile kann leer sein, wenn die entsprechende
     * Information fehlt.
     * @param dateiname     der Name der Textdatei mit den Daten
     * @throws IOException  bei einem Fehler beim Einlesen
     */
    public void neueKontakteAusDatei(String dateiname) throws IOException
    {
        // Sicherstellen, dass die Datei auffindbar ist.
        URL resource = getClass().getResource(dateiname);
        if(resource == null) {
            throw new FileNotFoundException(dateiname);
        }
        dateiname = resource.getFile();
        BufferedReader reader = new BufferedReader(
                                   new FileReader(dateiname));
        String name;
        name = reader.readLine();
        while(name != null) {
            String telefon = reader.readLine();
            String adresse = reader.readLine();
            // ?berlesen der Leerzeile.
            reader.readLine();
            buch.neuerKontakt(new Kontakt(name, telefon, adresse));
            name = reader.readLine();
        }
        reader.close();
    }
    
    /**
     * Lies die Bin?rversion eines Adressbuchs aus der gegebenen
     * Datei. Wenn der Dateiname kein absoluter Pfad ist, dann
     * wird der Name als relativ zum Projektordner angesehen.
     * @param dateiname  der Name der Datei, aus der zu lesen ist
     * @return           das Adressbuch-Objekt
     * @throws IOException  wenn das Einlesen fehlschl?gt
     */
    public Adressbuch liesAusDatei(String dateiname)
        throws IOException, ClassNotFoundException
    {
        // Sicherstellen, dass die Datei auffindbar ist.
        URL resource = getClass().getResource(dateiname);
        if(resource == null) {
            throw new FileNotFoundException(dateiname);
        }
        try {
            File quelle = new File(resource.toURI());
            ObjectInputStream is = new ObjectInputStream(
                                    new FileInputStream(quelle));
            Adressbuch gespeichertesBuch = (Adressbuch) is.readObject();
            is.close();
            return gespeichertesBuch;
        }
        catch(URISyntaxException e) {
            throw new IOException("Kein g?ltiger Dateiname erstellbar f?r " +
                                  dateiname);
        }        
    }
    
    /**
     * Speichere eine Bin?rversion des Adressbuchs in
     * die Datei mit dem gegebenen Namen. Wenn der Dateiname
     * nicht absolut ist, wird er als relativ zum aktuellen
     * Projektordner angenommen. 
     * @param dateiname     der Name der Datei, in der gespeichert
     *                      werden soll
     * @throws IOException  falls das Speichern aus irgendeinem
     *                      Grund fehlschl?gt
     */
    public void speichereInDatei(String dateiname) throws IOException
    {
        Path zieldatei = Paths.get(dateiname).toAbsolutePath();
        ObjectOutputStream os = new ObjectOutputStream(
                                    new FileOutputStream(zieldatei.toString()));
        os.writeObject(buch);
        os.close();
    }
    
}
