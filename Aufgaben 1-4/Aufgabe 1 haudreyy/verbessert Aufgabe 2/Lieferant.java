
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
public class Lieferant
{
    // Es gibt keine besonderen Instanzvariabeln
    // Der Konstruktor ist hier nicht besonders
    public Lieferant()
    {
    }

    // Bestellungen werden hier aufgegeben
    public int[] bestellungAufgeben(int[] bestellMengen)
    {
        Thread_Lieferant thread = new Thread_Lieferant();
        thread.run();
        
        System.out.println("Lieferant liefert " + bestellMengen[0] + " Holz, " + bestellMengen[1] +" Schrauben, "
        + bestellMengen[2] + " Farbe, " + bestellMengen[3] + " Kissen und " + bestellMengen[4] + " Karton.");
        return bestellMengen;
    }

}
