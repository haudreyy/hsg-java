/**
 * Diese Klasse definiert Zähler für die Akteurstypen
 * in einer Simulation.
 * Ein Zähler wird über einen Namen identifiziert und 
 * zählt, wie viele Akteure des Typs innerhalb der Simulation
 * jeweils existieren.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.02.29
 */
public class Zaehler
{
    // Ein Name für den Akteurstyp in dieser Simulation
    private String name;
    // Wie viele von diesem Typ existieren in der Simulation.
    private int zaehler;

    /**
     * Initialisiere mit dem Namen des Typs.
     * @param name  ein Name, z.B. "Fuchs"
     */
    public Zaehler(String name)
    {
        this.name = name;
        zaehler = 0;
    }
    
    /**
     * @return  den Namen des Typs dieses Zählers
     */
    public String gibName()
    {
        return name;
    }

    /**
     * @return  den aktuellen Zählerstand dieses Typs
     */
    public int gibStand()
    {
        return zaehler;
    }

    /**
     * Erhöhe diesen Zähler um eins.
     */
    public void erhoehen()
    {
        zaehler++;
    }
    
    /**
     * Setze diesen Zähler auf null zurück.
     */
    public void zuruecksetzen()
    {
        zaehler = 0;
    }
}
