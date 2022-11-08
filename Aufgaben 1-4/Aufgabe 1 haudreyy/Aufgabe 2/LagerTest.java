

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
    public void lagerTest()
    {
        Lager lagertest = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellungtest1 = new Bestellung(2, 2, 45);
    }

    @Test
    public void lagertest_methode()
    {
        Lager lagertest6 = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellungtest6 = new Bestellung(2, 2, 6);
        lagertest6.berechneBedarf(bestellungtest6);
    }

    @Test
    public void testBeschaffungszeit()
    {
        Lager lagertest6 = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellung6 = new Bestellung(2, 2, 99);
        lagertest6.gibBeschaffungszeit(bestellung6);
    }
}



