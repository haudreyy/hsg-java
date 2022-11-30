

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse LagerTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LagerTest
{
    /**
     * Konstruktor fuer die Test-Klasse LagerTest
     */
    public LagerTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void test_lagerleer()
    {
        Lager lager1 = new Lager(1, 1, 1, 1, 1);
        lager1.lagerAuffuellen();
        lager1.lagerBestandAusgeben();
    }
}

