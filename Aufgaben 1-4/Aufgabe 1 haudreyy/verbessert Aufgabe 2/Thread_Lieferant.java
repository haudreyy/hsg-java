
/**
 * Beschreiben Sie hier die Klasse Thread_Lieferant.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Thread_Lieferant extends Thread
{
    // Konstruktor noch leer?
    public Thread_Lieferant() 
    {
    }

 public void run()
    {
        System.out.println ("thread is running");
        try 
        {
            Thread.sleep(2000);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        System.out.println ("thread is back");
    } 

    public static void main (String args[])
    {

    }





}   
