

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
    public void bestellung_aufgeben()
    {
        Bestellung bestellu1 = new Bestellung(2, 2, 1);
        Produktions_Manager produkti1 = new Produktions_Manager();
        produkti1.bestellungInAuftragGeben(bestellu1);
    }

    @Test
    public void bestellung_produzieren()
    {
        Bestellung bestellu1 = new Bestellung(2, 2, 1);
        Produktions_Manager produkti1 = new Produktions_Manager();
        produkti1.bestellungInAuftragGeben(bestellu1);
        produkti1.startNextProductionStep();
    }
}


