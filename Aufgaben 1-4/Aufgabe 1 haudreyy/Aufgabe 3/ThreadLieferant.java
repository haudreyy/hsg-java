
import java.lang.Thread;
/**
 * Beschreiben Sie hier die Klasse ThreadLieferant.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ThreadLieferant extends Lieferant
{
    // run method
    public void run (int [] bestellMenge)
    {
        int [] bestellung = bestellungAufgeben(bestellMenge);
        System.out.println ("Lieferant Thread läuft");
    }

    //main method
    public static void main (String[] args)
    {
        //create object
        Thread threadLieferant = new Thread();
        threadLieferant.start();
        


    }

}
