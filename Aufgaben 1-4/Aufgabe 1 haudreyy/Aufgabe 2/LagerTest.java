

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
    public void Test1()
    {
        Lager lager1 = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellung8 = new Bestellung(2, 2, 88);
        Bestellung bestellung9 = new Bestellung(1, 0, 100);
    }

    @Test
    public void test2()
    {
        Lager lager1 = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellung10 = new Bestellung(1, 0, 76);
        lager1.zubestellenMaterial(bestellung10);
    }

    @Test
    public void test_beschaffungszeit()
    {
        Lager lager5 = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellu1 = new Bestellung(2, 2, 67);
        lager5.gibBeschaffungszeit(bestellu1);
    }
}



