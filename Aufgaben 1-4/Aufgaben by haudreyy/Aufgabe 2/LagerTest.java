

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
        Bestellung bestellungtest1 = new Bestellung(2, 2, 45, lagertest);
    }

    @Test
    public void lagertest_methode()
    {
        Lager lagertest6 = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellungtest6 = new Bestellung(2, 2, 6, lagertest6);
        lagertest6.berechneBedarf(bestellungtest6);
    }

    @Test
    public void testBeschaffungszeitNachbestellen()
    {
        Lager lagertest6 = new Lager(2, 2, 2, 2, 2);
        Bestellung bestellung6 = new Bestellung(2, 2, 99, lagertest6);
        lagertest6.gibBeschaffungszeit(bestellung6);
    }

    @Test
    public void testBeschaffungszeitNichtNachbestellen()
    {
        Lager lagertest9 = new Lager(100, 100, 100, 100, 100);
        Bestellung bestellung9 = new Bestellung(2, 2, 53, lagertest9);
        lagertest9.gibBeschaffungszeit(bestellung9);
    }

    @Test
    public void testNachbestellenAberNurEinzeln()
    {
        Lager testlager3 = new Lager(13, 31, 5, 11, 12);
        Bestellung bestellungtest3 = new Bestellung(2, 2, 31, testlager3);
        testlager3.gibBeschaffungszeit(bestellungtest3);
    }

    @Test
    public void testZuBestellenMaterial()
    {
        Lager lager1 = new Lager(13, 33, 3, 1, 13);
        Bestellung bestellungtest7 = new Bestellung(2, 2, 43, lager1);
        lager1.zubestellenMaterial (bestellungtest7);
    }

    @Test
    public void testLagerauffüllen()
    {
        Lager lager1 = new Lager(0, 0, 0, 0, 0);
        Lieferant testLieferant = new Lieferant();
        lager1.lagerAuffüllen(testLieferant );
    }

    @Test
    public void testLagerauffüllenEinzeln()
    {
        Lager lager1 = new Lager(200, 100, 35, 22, 1000);
        
        Lieferant testLieferant = new Lieferant();
        lager1.lagerAuffüllen(testLieferant);
    }

    @Test
    public void testLieferant()
    {
        Lieferant lieferant1 = new Lieferant();
        Lager lager1 = new Lager(100, 100, 100, 100, 100);
        Bestellung bestellung1 = new Bestellung(2, 2, 12, lager1);
        lager1.zubestellenMaterial(bestellung1);
    }
}









