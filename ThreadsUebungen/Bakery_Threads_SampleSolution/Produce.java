import java.util.HashMap;
import java.util.LinkedList;

/**
 * Abstract class Good - write a description of the class here
 *
 * @author Jonathan Gruss
 * @version 15.11.22
 */
public class Produce
{
    private LinkedList<Producer> productionSequence;
    private HashMap<Producer, Integer> productionTimes;
    private boolean isProcessed;
    private final String customer;

    public Produce(String customer) {
        this.productionSequence = new LinkedList<>();
        this.productionTimes = new HashMap<>();
        this.isProcessed = false;
        this.customer = customer;
    }

    public void setProductionSequence(LinkedList<Producer> productionSequence) {
        this.productionSequence = productionSequence;
    }

    public void startNextProductionStep() {
        // TODO: Ex2 - Start the next production step
        // If the production sequence has a next producer, add produce to it
        // If the production sequence is empty, set isProcessed to true
        
        if (productionSequence.size() > 0) {
            Producer nextProducer = productionSequence.poll();
            nextProducer.addProduce(this);
        } else {
            System.out.println("[Produce] Finished processing: " + this);
            isProcessed = true;
        }
    }

    public void setProductionTimes(HashMap<Producer, Integer> productionTimes) {
        this.productionTimes = productionTimes;
    }

    public int getProductionTime(Producer producer) {
        return productionTimes.get(producer);
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public String getCustomer() {
        return customer;
    }
}
