
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse SofaTest.
 *
 * @author  Gruppe 7
 * @version 1.0
 */
public class SofaTest
{
    @BeforeEach
    public void setUp()
    {
    }
    
    @Test
    public void testeProduktionsZeit() {
        Sofa sofa = new Sofa();
        assertEquals(60, sofa.gibProduktionszeit());
    }

    @AfterEach
    public void tearDown()
    {
    }
}
