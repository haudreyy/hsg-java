

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse SofaTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SofaTest
{
    /**
     * Konstruktor fuer die Test-Klasse SofaTest
     */
    public SofaTest()
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
        Sofa sofa = new Sofa();
        System.out.println ("" + sofa.produktionsAblauf [0] + ", " + sofa.produktionsAblauf [1] + ", "
        + sofa.produktionsAblauf [2] + ", " + sofa.produktionsAblauf [3]);
        
        System.out.println ("" + sofa.produktionsDauer [0] + ", " +sofa.produktionsDauer [1]
        + ", " +sofa.produktionsDauer [2]+ ", " +sofa.produktionsDauer [3]);
        
    }
}
