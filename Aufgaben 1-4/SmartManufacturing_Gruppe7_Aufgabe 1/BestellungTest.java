

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse BestellungTest.
 *
 * @author  Gruppe 7
 * @version 1.0
 */
public class BestellungTest
{
    @BeforeEach
    public void setUp()
    {
    }
    
    @Test
    public void testeBestellungsErstellung() {
        // Testet das Erstellen einer Bestellung
        Bestellung bestellung = new Bestellung(3, 4);
    }
    
    @Test
    public void testeBestellungsInhalt() {
        // Testet, ob bei eine Bestellung auch die korrekte Anzahl an Produkten vorhanden ist
        Bestellung bestellung = new Bestellung(3, 4);
        assertEquals(3, bestellung.gibAnzahlSofas());
        assertEquals(4, bestellung.gibAnzahlStuehle());
    }
    
    @Test
    public void testeBestellungbesaetigung() {
        // Testet, ob das Bestätigen einer Bestellung funktioniert
        Bestellung bestellung = new Bestellung(3, 4);
        assertEquals(false, bestellung.gibBestellBestaetigung());
        bestellung.bestellungBestaetigen();
        assertEquals(true, bestellung.gibBestellBestaetigung());
    }
    
    @Test
    public void testeNegativeBestellung() {
        // Testet, ob man negative Mengen bestellen kann
        Bestellung bestellung = new Bestellung(-23, 3);
        assertEquals(0, bestellung.gibAnzahlSofas());
        assertEquals(3, bestellung.gibAnzahlStuehle());
    }

    @AfterEach
    public void tearDown()
    {
    }
}
