import java.util.HashMap;

/**
 * Write a description of class Bakery here.
 *
 * @author Jonathan Gruss
 * @version 15.11.22
 */
public class Bakery
{
    private Baker baker;
    private HashMap<Integer, Produce> produces;
    private static int produceId = 0;

    public Bakery(Baker baker)
    {
        produces = new HashMap<>();

        this.baker = baker;
        baker.start();
    }

    public void addProduce(Produce produce) {
        this.produces.put(produceId++, produce);
        baker.addProduce(produce);
    }

    public static void main(String[] args) {

        Baker baker = new Baker();
        Bakery bakery = new Bakery(baker);

        bakery.addProduce(new Bread("John"));
        bakery.addProduce(new Bread("Jane"));
        
        ThreadUtil.sleep(10_000);
        System.exit(0);
        
        // Optional - Add an additional produce type (e.g. a Cake)
        // Optional - Add a new producer (e.g. a CakeDecorator)
        
    }
}
