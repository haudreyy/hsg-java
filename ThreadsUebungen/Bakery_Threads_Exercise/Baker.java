import java.util.HashMap;
import java.util.LinkedList;

/**
 * Write a description of class Baker here.
 *
 * @author Jonathan Gruss
 * @version 15.11.22
 */
public class Baker extends Thread
{
    private LinkedList<Produce> produceToProcess; 
    private LinkedList<Produce> produceInProcess;

    private KneadingMachine kneadingMachine;
    private Oven oven; // hier Ofen in Bäker Klasse

    public Baker()
    {
        produceToProcess = new LinkedList<>();
        produceInProcess = new LinkedList<>();

        kneadingMachine = new KneadingMachine();
        oven = new Oven();

        kneadingMachine.start();
        oven.start(); // auch ein Thread, den wir von Anfang an
    }

    public void addProduce(Produce produce) {
        this.produceToProcess.add(produce);
    }

    public void run(){
        while(true){ //hier solange true wird es gerunt --> endlos?

            // TODO: Ex1.1 - If there is any produce to process
            // add to processing list, set sequence, and start processing
            Produce nextProduce = produceToProcess.poll(); //erstes Produkt wird aus Liste rausgenommen (und entfernt) und ins next produce reingetan
            if (nextProduce ≠ null) 
            {
                ThreadUtil.syncedPrintln("[Baker] start processing");
                // checken ob, alles gepullt wurde und alles in bearbeitung ist
                produceInProcess.add(nextProduce); 
                // Bäker weiss wir Produkte prodziert werden müssen --> set production sequence (ist sequenz von wie Produkt erstellt werden muss)
                setProductionSequence(nextProduce); // Produktionssequenz für dieses Produkt
                // Produkt kann gestartet werden
                nextProduce.startNextProductionStep();

                //In lösung noch thread eingefügt

            }
    
            // TODO: Ex1.3 Check all produce in process
            // If any is processed, remove it
            // wenn produkt fertig ist, dann will man diese rausnehmen


            ThreadUtil.sleep(1000);
        }
    }

    private void setProductionSequence(Produce produce) {
        LinkedList<Producer> productionSequence = new LinkedList<>();
        HashMap<Producer, Integer> productionTimes = new HashMap<>();

        // TODO: Ex1.2 - Add production sequence and times for each produce type
        // beide unten sollen im Produkt gesetzt werden

        produce.setProductionSequence(productionSequence);
        produce.setProductionTimes(productionTimes);
    }
}
