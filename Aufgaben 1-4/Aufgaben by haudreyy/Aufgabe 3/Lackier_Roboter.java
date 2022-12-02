
/**
 * Beschreiben Sie hier die Klasse Lackier_Roboter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Lackier_Roboter extends Roboter
{
    public Lackier_Roboter(Produktions_Manager pm)
    {
        super("Lackier_Roboter", pm);
        this.meinTyp = RoboterTyp.Lackierung; 
    }
}
