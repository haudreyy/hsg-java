

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * Die Test-Klasse FabrikTest.
 *
 * @author  Gruppe 7
 * @version 1.0
 */
public class FabrikTest
{
    @BeforeEach
    public void setUp()
    {
    }
    
    @Test                                                 
    public void testeFabrikErstellung() {
        // Testet die Erstellung einer Fabrik
        Fabrik fabrik = new Fabrik();
    }
    
    @Test                                                 
    public void testeBestellungAufgeben() {
        // Testet ob man eine Bestellung bei einer Fabrik aufgeben kann und diese die korrekten Produkte enthält
        Fabrik fabrik = new Fabrik();
        fabrik.bestellungAufgeben(3, 10);
        assertEquals(3, fabrik.gibBestellungliste().get(0).gibAnzahlSofas());
        assertEquals(10, fabrik.gibBestellungliste().get(0).gibAnzahlStuehle());
    }
    
    @Test                                                 
    public void testeBestellungenAusgeben() {
        // Testet, ob man die Bestellungen ausgeben kann.
        Fabrik fabrik = new Fabrik();
        fabrik.bestellungAufgeben(3, 7);
        fabrik.bestellungAufgeben(2, 1);
        fabrik.bestellungenAusgeben();
    }

    @AfterEach
    public void tearDown()
    {
    }
}
