
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
        if (tage.gibWert() == 1)
        {
            monate.erhoehen();
            if (monate.gibWert() == 1 || monate.gibWert() == 3 || monate.gibWert() == 5 
            || monate.gibWert() == 7 || monate.gibWert() == 8 || monate.gibWert() == 10 
            || monate.gibWert() == 12)
            {
                tage.setzeLimit (32);
            }
            
            if (monate.gibWert() == 2)
            {
                tage.setzeLimit (28);
            }
            
            else 
            {
                tage.setzeLimit (30);
            }
        }
        if (monate.gibWert() == 1)
        {
            jahre.erhoehen();
        }
        anzeigeAktualisieren();
    
    System.out.println ("" + tage.gibWert() + "." + tage.gibLimit());    
    }
    
    
    

    /**
     * Setze die Uhrzeit dieser Anzeige auf die gegebene 'stunde' und
     * 'minute'.
     */
    public void setzeUhrzeit(int tag, int monat, int jahr, int stunde, int minute)
    {
        stunden.setzeWert(stunde);
        minuten.setzeWert(minute);
        tage.setzeWert(tag);
        monate.setzeWert(monat);
        jahre.setzeWert(jahr);
        
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
        zeitanzeige = tage.gibAnzeigewert(2) + "." + monate.gibAnzeigewert(2) + "." 
        + jahre.gibAnzeigewert(4) + "  " + stunden.gibAnzeigewert(2) + ":" 
        + minuten.gibAnzeigewert(2);
    }
}
