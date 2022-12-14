import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse FahrgastquelleTest.
 *
 * @author David J. Barnes und Michael K?lling
 * @version 2016.02.29
 */
public class FahrgastquelleTest 
{
    private Fahrgastquelle quelle;
    
    /**
     * Konstruktor f?r die Test-Klasse FahrgastquelleTest.
     */
    public FahrgastquelleTest()
    {
    }

    /**
     * Setzt das Testger?st f?r den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        Taxiunternehmen unternehmen = new Taxiunternehmen();
        quelle = new Fahrgastquelle(unternehmen);
    }

    /**
     * Gibt das Testger?st wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
        quelle = null;
    }

    /**
     * Test der erfolgreichen Abholung eines Fahrgastes.
     */
    @Test
    public void testAbholung()
    {
        assertEquals(true, quelle.erbitteAbholung());
    }

}
