

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse BestellungTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BestellungTest
{
    /**
     * Konstruktor fuer die Test-Klasse BestellungTest
     */
    public BestellungTest()
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
    public void testLieferzeit()
    {
        Lager lager1 = new Lager(100, 100, 100, 100, 100);
        Bestellung bestellung32 = new Bestellung(2, 2, 32, lager1);
        bestellung32.gibLieferzeit();
    }

    @Test
    public void testBestellungen()
    {
        Lager lager1 = new Lager(10, 10, 10, 10, 10);
        Bestellung bestellu1 = new Bestellung(3, 8, 22, lager1);
        Bestellung bestellu2 = new Bestellung(15, 15, 3, lager1);
    }
}




