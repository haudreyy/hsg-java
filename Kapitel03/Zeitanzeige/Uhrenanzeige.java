
/**
 * Die Klassen Uhrenanzeige implementiert die Anzeige einer Digitaluhr.
 * Die Anzeige zeigt Stunden und Minuten. Der Anzeigebereich reicht von
 * 00:00 (Mitternacht) bis 23:59 (eine Minute vor Mitternacht).
 *
 * Eine Uhrenanzeige sollte minütlich "Taktsignale" (über die Operation
 * "taktsignalGeben") erhalten, damit sie die Anzeige aktualisieren 
 * kann. Dies geschieht, wie man es bei einer Uhr erwartet: Die 
 * Stunden erhöhen sich, wenn das Minutenlimit einer Stunde erreicht
 * ist.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2016.02.29
 */
public class Uhrenanzeige
{
    private Nummernanzeige stunden;
    private Nummernanzeige minuten;
    private Nummernanzeige tage;
    private Nummernanzeige monate;
    private Nummernanzeige jahre;
    private String zeitanzeige;    // simuliert die tatsächliche Anzeige
    
    /**
     * Konstruktor für Uhrm wo man Initialwert und, wenn vorhanden Limite eingibt
     */
    public Uhrenanzeige()
    {
        stunden = new Nummernanzeige(24,0);
        minuten = new Nummernanzeige(60,0);
        tage = new Nummernanzeige (32,1);
        monate = new Nummernanzeige (13,1);
        jahre = new Nummernanzeige (2000);
        anzeigeAktualisieren();
    }


    /**
     * Diese Operation sollte einmal pro Minute aufgerufen werden -
     * sie sorgt dafür, dass diese Uhrenanzeige um eine Minute
     * weiter gestellt wird.
     */
    public void taktsignalGeben()
    {
        minuten.erhoehen();
        if(minuten.gibWert() == 0) 
        {  // Limit von minuten wurde erreicht!
            stunden.erhoehen();
        }
        if (stunden.gibWert() == 0)
        {
            tage.erhoehen();
        }
        if (tage.gibWert() == 31 && monate.gibWert () == 1 || 3 || 5 || 7 || 8 ||10 || 12 )
        {
            monate.erhoehen();
        }
        anzeigeAktualisieren();
    }

    /**
     * Setze die Uhrzeit dieser Anzeige auf die gegebene 'stunde' und
     * 'minute'.
     */
    public void setzeUhrzeit(int stunde, int minute)
    {
        stunden.setzeWert(stunde);
        minuten.setzeWert(minute);
        anzeigeAktualisieren();
    }

    /**
     * Liefere die aktuelle Uhrzeit dieser Uhrenanzeige im Format SS:MM.
     */
    public String gibUhrzeit()
    {
        return zeitanzeige;
    }
    
    /**
     * Aktualisiere die interne Zeichenkette, die die Zeitanzeige hält.
     */
    private void anzeigeAktualisieren()
    {
        zeitanzeige = stunden.gibAnzeigewert() + ":"
                      + minuten.gibAnzeigewert();
    }
}
