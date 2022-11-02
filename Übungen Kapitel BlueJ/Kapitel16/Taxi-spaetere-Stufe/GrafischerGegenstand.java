import java.awt.Image;
    
/**
 * Ein Gegenstand, der eine grafische Darstellung von
 * sich selbst liefern kann.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.02.29
 */

public interface GrafischerGegenstand extends Gegenstand
{
    public Image gibGrafik();
}
