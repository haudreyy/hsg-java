import java.util.ArrayList;
import java.util.Random;

/**
 * Die Klasse Beantworter beschreibt Exemplare, die 
 * automatische Antworten generieren. Dies ist die zweite Version 
 * dieser Klasse. In dieser Version generieren wir Antworten, 
 * indem wir zuf�llig eine Antwortphrase aus einer Liste ausw�hlen.
 * 
 * @author     Michael K�lling und David J. Barnes
 * @version    0.2 (2016.02.29)
 */
public class Beantworter
{
    private Random zufallsgenerator;
    private ArrayList<String> antworten;

    /**
     * Erzeuge einen Beantworter
     */
    public Beantworter()
    {
        zufallsgenerator = new Random();
        antworten = new ArrayList<>();
        antwortlisteFuellen();
    }

    /**
     * Generiere eine Antwort.
     * 
     * @return  einen String, der die Antwort enth�lt
     */
    public String generiereAntwort()
    {
        // Erzeuge eine Zufallszahl, die als Index in der Liste der
        // Antworten benutzt werden kann. Die Zahl wird im Bereich von
        // null (inklusiv) bis zur Gr��e der Liste (exklusiv) liegen.
        int index = zufallsgenerator.nextInt(antworten.size());
        return antworten.get(index);
    }

    /**
     * Generiere eine Liste von Standardantworten, aus denen wir eine
     * ausw�hlen k�nnen, wenn wir keine bessere Antwort wissen.
     */
    private void antwortlisteFuellen()
    {
        antworten.add("Das klingt seltsam. K�nnen Sie das ausf�hrlicher beschreiben?");
        antworten.add("Bisher hat sich noch kein Kunde dar�ber beschwert. \n" +
                      "Welche Systemkonfiguration haben Sie?");
        antworten.add("Da brauche ich etwas ausf�hrlichere Angaben.");
        antworten.add("Haben Sie gepr�ft, ob Sie einen Konflikt mit einer DLL haben?");
        antworten.add("Das steht im Handbuch. Haben Sie das Handbuch gelesen?");
        antworten.add("Das klingt alles etwas Wischi-Waschi. Haben Sie einen Experten\n" +
                      "in der N�he, der das besser beschreiben kann?");                     
        antworten.add("Das ist kein Fehler, das ist eine Systemeigenschaft!");
        antworten.add("K�nnten Sie es anders erkl�ren?");
        antworten.add("Haben Sie versucht, die App auf Ihrem Handy auszuf�hren?");
        antworten.add("Ich habe gerade StackOverflow �berpr�ft - das ist auch keine L�sung.");
    }
}
