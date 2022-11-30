

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse Produktions_ManagerTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Produktions_ManagerTest
{
    /**
     * Konstruktor fuer die Test-Klasse Produktions_ManagerTest
     */
    public Produktions_ManagerTest()
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
    public void test_run()
    {
        Lager lager1 = new Lager(1, 1, 1, 1, 1);
        Bestellung bestellu1 = new Bestellung(2, 2, 1, lager1);
        Produktions_Manager produkti2 = new Produktions_Manager();
        produkti2.bestellungInBearbeitungGeben(bestellu1);
        produkti2.run();
    }

    @Test
    public void test2_run()
    {
        Lager lager2 = new Lager(3, 3, 3, 3, 3);
        Produktions_Manager produkti1 = new Produktions_Manager();
        Bestellung bestellu1 = new Bestellung(2, 2, 1, lager2);
        produkti1.bestellungInBearbeitungGeben(bestellu1);
        produkti1.run(lager2);
    }

    @Test
    public void test_void3_vollLager()
    {
        Lager lager3 = new Lager(100, 100, 100, 100, 100);
        Bestellung bestellu1 = new Bestellung(2, 2, 4, lager3);
        Produktions_Manager produkti1 = new Produktions_Manager();
        produkti1.bestellungInBearbeitungGeben(bestellu1);
        produkti1.run(lager3);
    }
}



