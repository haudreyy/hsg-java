

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
    public void testBeschaffungszeit()
    {
        Bestellung bestellu1 = new Bestellung(2, 1, 23);
        Lager lager1 = new Lager(4, 4, 4, 4, 4);
        bestellu1.gibLieferzeit(lager1);
    }
}


