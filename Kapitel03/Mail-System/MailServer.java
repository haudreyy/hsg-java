import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Ein simples Modell eines Mail-Servers. Der Server kann Nachrichten
 * entgegen nehmen und auf Anfrage an Mail-Clients weiterleiten.
 *
 * @author David J. Barnes und Michael K�lling
 * @version 2016.02.29
 */
public class MailServer
{
    // Speicherstruktur f�r die Nachrichten, die auf dem Server
    // zwischengespeichert werden.
    private List<Nachricht> nachrichten;

    /**
     * Erzeuge einen MailServer.
     */
    public MailServer()
    {
        nachrichten = new ArrayList<>();
    }

    /**
     * Liefere die Anzahl der Nachrichten f�r den angegebenen Benutzer.
     * @param benutzer  Benutzer, dessen Nachrichtenanzahl geliefert
     *                  werden soll
     * @return          die Anzahl der Nachrichten f�r 'benutzer'
     */
    public int anzahlNachrichtenFuer(String benutzer)
    {
        int anzahl = 0;
        for (Nachricht nachricht: nachrichten) {
            if(nachricht.gibEmpfaenger().equals(benutzer)) {
                anzahl++;
            }
        }
        return anzahl;
    }

    /**
     * Liefere die n�chste Nachricht f�r den angegebenen Benutzer.
     * Liefere null, falls keine Nachrichten vorhanden sind.
     * @param benutzer  Benutzer, f�r den die Nachricht geliefert
     *                  werden soll
     * @return          die n�chste Nachricht, falls vorhanden, null sonst.
     */
    public Nachricht gibNaechsteNachrichtFuer(String benutzer)
    {
        Iterator<Nachricht> iterator = nachrichten.iterator();
        while(iterator.hasNext()) {
            Nachricht nachricht = iterator.next();
            if(nachricht.gibEmpfaenger().equals(benutzer)) {
                iterator.remove();
                return nachricht;
            }
        }
        return null;
    }

    /**
     * Leite die angegebene Nachricht auf Anfrage weiter.
     * @param nachricht  die Nachricht, die auf dem Server hinterlegt
     *                   werden soll
     */
    public void leiteWeiter(Nachricht nachricht)
    {
        nachrichten.add(nachricht);
    }
}
