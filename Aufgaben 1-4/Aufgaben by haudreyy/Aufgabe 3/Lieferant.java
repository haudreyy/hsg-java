
/**
* Die Klasse Lieferant nimmt Materialbestellungen aus dem Lager an und gibt Material zurück
 * 
 * @author (Gruppe 7) 
 * @version (version 2.0)
 */

 /* Die Materialien in den Arrays entsprechen der folgenden Reihenfolge:
        [0] Holz,
        [1] Schrauben,
        [2] Farbe,
        [3] Kissen,
        [4] Karton
 */
public class Lieferant extends Thread
{
    private Lager lager;
    private int[] materialBestellung;
    // Es gibt keine besonderen Instanzvariabeln
    // Der Konstruktor ist hier nicht besonders
    public Lieferant(Lager lager, int[] materialBestellung)
    {
        this.lager = lager;
        this.materialBestellung = materialBestellung;        
    }

    @Override
    public void run ()
    {
        System.out.println("Lieferant nimmt Bestellung entgegen.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Lieferant liefert.");
        lager.lagerbefuellen(materialBestellung);
    }
}
