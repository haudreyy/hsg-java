import java.util.LinkedList;

/**
 * Abstrakte Klasse Roboter - beschreiben Sie hier die Klasse
 * 
 * @author (Ihr Name)
 * @version (eine Version-Nummer oder ein Datum)
 */
public abstract class Roboter extends Thread
{

    private LinkedList<Produkt> warteschlange;
    private String name;

    private boolean busy;
 
    public Roboter(String name)
    {
        this.name = name;
    }

    public void run()
    {
        while (true)
        {
            if (warteschlange.size() > 0)
            {
                produziereProdukt(warteschlange.poll());
            }
        }
    }

    public void fuegeProduktHinzu(Produkt produkt)
    {
        warteschlange.add(produkt);
    }

    public void setzteProduktionsZeit(int zeit)
    {
        produktionsZeit = zeit;
    }

    public void produziereProdukt(Produkt produkt)
    {
        boolean valid = warteschlange.remove(produkt);
        if (valid)
        {
            try {
                Thread.sleep(produktionsZeit * 1000);
            } catch (InterruptedException e) {
            }
            produkt.setZustand("produziert");
        }
        else 
        {
            System.out.println("Produkt was produziert werden sollte war nicht mehr in der Warteschlange.");
        }
    }

    public String gibNamen()
    {
        return name;
    }
}
