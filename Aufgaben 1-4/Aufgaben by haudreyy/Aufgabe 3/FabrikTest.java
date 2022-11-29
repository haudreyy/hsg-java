

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class FabrikTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FabrikTest
{
    /**
     * Default constructor for test class FabrikTest
     */
    public FabrikTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void FabrikTest1()
    {
        Fabrik fabrik1 = new Fabrik();
        fabrik1.bestellungAufgeben(2, 6);
        fabrik1.bestellungAufgeben(1, 1);
        fabrik1.bestellungAufgeben(3, 8);
        fabrik1.lagerAuffuellen();
        fabrik1.bestellungenAusgeben();
    }
}

