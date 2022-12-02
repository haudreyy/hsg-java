

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
    public void test_run_inProduktiongeben1()
    {
        Lager lager1 = new Lager(1, 1, 1, 1, 1);
        Bestellung bestellu1 = new Bestellung(2, 2, 1, lager1);
        Produktions_Manager produkti2 = new Produktions_Manager(lager1);
        produkti2.bestellungInBearbeitungGeben(bestellu1);
        produkti2.run();
    }

    @Test
    public void test_run_inProduktiongeben2()
    {
        Lager lager2 = new Lager(3, 3, 3, 3, 3);
        Produktions_Manager produkti1 = new Produktions_Manager(lager2);
        Bestellung bestellu1 = new Bestellung(2, 2, 1, lager2);
        produkti1.bestellungInBearbeitungGeben(bestellu1);
        produkti1.run();
    }

    @Test
    public void test_void_inProduktiongeben3()
    {
        Lager lager3 = new Lager(100, 100, 100, 100, 100);
        Bestellung bestellu1 = new Bestellung(2, 2, 4, lager3);
        Produktions_Manager produkti1 = new Produktions_Manager(lager3);
        produkti1.bestellungInBearbeitungGeben(bestellu1);
        produkti1.run();
    }

    @Test
    public void test_void_lagerbelasten()
    {
        System.out.println("start Test"); 
        Lager lager4 = new Lager(4, 4, 4, 4, 4);
        Produktions_Manager produkti1 = new Produktions_Manager(lager4);
        produkti1.start();
        Bestellung bestellu22 = new Bestellung(3, 3, 1, lager4);
        produkti1.bestellungInBearbeitungGeben(bestellu22);
        
        System.out.println("end test");         
    }
}




