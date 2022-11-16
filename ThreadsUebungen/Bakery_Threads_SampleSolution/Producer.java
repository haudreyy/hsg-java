import java.util.LinkedList;

public abstract class Producer extends Thread
{
    private LinkedList<Produce> produceToProcess;
    public Producer() {
        produceToProcess = new LinkedList<>();
    }

    @Override
    public void run() {
        while (true) {
            // TODO: Ex3 - if it has a produce process it and start next step
            Produce nextProduce = produceToProcess.poll();
            if (nextProduce != null) {
                processProduce(nextProduce);
                nextProduce.startNextProductionStep();
            }
            
            ThreadUtil.sleep(1000);
        }
    }

    public void addProduce(Produce produce) {
        this.produceToProcess.add(produce);
    }

    private void processProduce(Produce produce) {
        int productionTime = produce.getProductionTime(this);

        ThreadUtil.syncedPrintln(this + " Starting to process " + produce + " for " + productionTime + "ms");
        ThreadUtil.sleep(productionTime);
        ThreadUtil.syncedPrintln(this + " Finished produce: " + produce);
    }
}
