

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse FabrikTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class FabrikTest
{
    /**
     * Konstruktor fuer die Test-Klasse FabrikTest
     */
    public FabrikTest()
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
    public void finalTest1()
    {
        Fabrik fabrik1 = new Fabrik();
        fabrik1.bestellungAufgeben(1, 3);
        fabrik1.bestellungAufgeben(2, 2);
        fabrik1.bestellungenAusgeben();
    }

    @Test
    public void finalTest2()
    {
        Fabrik testFabrik_1 = new Fabrik();
        testFabrik_1.bestellungenAusgeben();
        testFabrik_1.bestellungAufgeben(11, 2);
        testFabrik_1.lagerAuffüllen();
        testFabrik_1.bestellungAufgeben(3, 5);
        testFabrik_1.bestellungenAusgeben();
    }

    @Test
    public void finalTest3()
    {
        Fabrik fabrik1 = new Fabrik();
        fabrik1.bestellungAufgeben(2, 3);
        fabrik1.bestellungAufgeben(33, 22);
        fabrik1.lagerAuffüllen();
        fabrik1.bestellungenAusgeben();
        fabrik1.bestellungAufgeben(2, 2);
        fabrik1.bestellungenAusgeben();
    }

    @Test
    public void finalTest_mehrereBestellungen()
    {
        Fabrik fabrik1 = new Fabrik();
        fabrik1.bestellungAufgeben(2, 2);
        fabrik1.bestellungAufgeben(4, 15);
        fabrik1.bestellungAufgeben(10, 15);
    }
}




