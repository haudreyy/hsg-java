

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse StuhlTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class StuhlTest
{
    /**
     * Konstruktor fuer die Test-Klasse StuhlTest
     */
    public StuhlTest()
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
    public void test_angabenAusgeben()
    {
        Stuhl stuhl = new Stuhl();
        System.out.println ("" + stuhl.produktionsAblauf [0] + ", " + stuhl.produktionsAblauf [1] + ", "
        + stuhl.produktionsAblauf [2] + ", " + stuhl.produktionsAblauf [3]);
        
        System.out.println ("" + stuhl.produktionsDauer [0] + ", " +stuhl.produktionsDauer [1]
        + ", " +stuhl.produktionsDauer [2]+ ", " +stuhl.produktionsDauer [3]);
        
    }
}

