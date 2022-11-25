
/**
 * Beschreiben Sie hier die Klasse ThreadUtil.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ThreadUtil {

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void syncedPrintln(String message) {
        synchronized (System.out) {
            System.out.println(message);
        }
    }
}
