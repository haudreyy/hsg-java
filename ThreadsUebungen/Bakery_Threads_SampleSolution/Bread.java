
/**
 * Write a description of class Bread here.
 *
 * @author Jonathan Gruss
 * @version 15.11.22
 */
public class Bread extends Produce
{
    public static final int BAKING_TIME = 2000;
    public static final int KNEADING_TIME = 1000;

    public Bread(String customer) {
        super(customer);
    }

    @Override
    public String toString() {
        return "Bread for " + getCustomer();
    }
}
