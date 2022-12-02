
/**
 * Beschreiben Sie hier die Klasse Holzbearbeitungs_Roboter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Holzbearbeitungs_Roboter extends Roboter
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    /**
     * Konstruktor für Objekte der Klasse Holzbearbeitungs_Roboter
     */
    public Holzbearbeitungs_Roboter(Produktions_Manager pm)
    {
        super("Holzbearbeitungsroboter", pm);
        this.meinTyp = RoboterTyp.Holzverarbeitung; 
    }

}
