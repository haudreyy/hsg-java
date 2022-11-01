import java.util.ArrayList;

/**
 * Eine Klasse zur Verwaltung von Audiodateien.
 * 
 * @author David J. Barnes und Michael Kölling.
 * @version 2016.02.29
 */
public class MusikSammlung
{
    // Eine ArrayList, in der die Namen von Audiodateien gespeichert werden können.
    private ArrayList<String> dateien;

    /**
     * Erzeuge eine MusikSammlung.
     */
    public MusikSammlung()
    {
        dateien = new ArrayList<>();
    }

    /**
     * Füge der Sammlung eine Datei hinzu.
     * @param  dateiname die hinzuzufügende Datei
     */
    public void dateiHinzufuegen(String dateiname)
    {
        dateien.add(dateiname);
    }

    /**
     * Liefere die Anzahl der Dateien in dieser Sammlung.
     * @return  die Anzahl der Dateien in dieser Sammlung
     */
    public int gibAnzahlDateien()
    {
        return dateien.size();
    }


    /**
     * Gib eine Datei aus der Sammlung auf die Konsole aus.
     * @param index  der Index der Datei, deren Name ausgegeben werden soll
     */
    public void dateiAusgeben(int index)
    {
        if(index >= 0 && index < dateien.size()) {
            String dateiname = dateien.get(index);
            System.out.println(dateiname);
        }
    }    
    
    /**
     * Entferne eine Datei aus der Sammlung.
     * @param index  der Index der zu entfernenden Datei
     */
    public void entferneDatei(int index)
    {
        if(index >= 0 && index < dateien.size()) {
            dateien.remove(index);
        }
    }
    
    public void drittletzteDateientfernen ()
    {
        dateien.remove (gibAnzahlDateien()-3);
    }
    
    public void checkIndex (int index)
    {
        if (index >= 0 && index < dateien.size()-1)
        {
            System.out.println ("Check was positive. No error.");
        }
        
        else 
        {
            System.out.println ("Check was negative. Error.");
        }
    }

}
