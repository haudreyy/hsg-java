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
    private Oven oven;

    public Baker()
    {
        produceToProcess = new LinkedList<>();
        produceInProcess = new LinkedList<>();

        kneadingMachine = new KneadingMachine();
        oven = new Oven();

        kneadingMachine.start();
        oven.start();
    }

    public void addProduce(Produce produce) {
        this.produceToProcess.add(produce);
    }

    public void run(){
        while(true){
            // TODO: Ex1.1 - If there is any produce to process
            // add to processing list, set sequence, and start processing
            Produce nextProduce = produceToProcess.poll();
            if(nextProduce != null){
                ThreadUtil.syncedPrintln("[Baker] Starting to process " + nextProduce);
                produceInProcess.add(nextProduce);
                setProductionSequence(nextProduce);
                nextProduce.startNextProductionStep();
            }

            // TODO: Ex1.3 Check all produce in process
            // If any is processed, remove it
            for (Produce produce : produceInProcess) {
                if(produce.isProcessed()){
                    produceInProcess.remove(produce);
                    ThreadUtil.syncedPrintln("[Baker] Finished processing " + produce);
                }
            }

            ThreadUtil.sleep(1000);
        }
    }

    private void setProductionSequence(Produce produce) {
        LinkedList<Producer> productionSequence = new LinkedList<>();
        HashMap<Producer, Integer> productionTimes = new HashMap<>();

        // TODO: Ex1.2 - Add production sequence and times for each produce type
        if (produce instanceof Bread) {
            productionSequence.add(kneadingMachine);
            productionTimes.put(kneadingMachine, Bread.KNEADING_TIME);
            productionSequence.add(oven);
            productionTimes.put(oven, Bread.BAKING_TIME);
        }

        produce.setProductionSequence(productionSequence);
        produce.setProductionTimes(productionTimes);
    }
}
