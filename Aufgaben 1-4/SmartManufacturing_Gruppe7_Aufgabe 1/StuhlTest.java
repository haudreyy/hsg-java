
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse StuhlTest.
 *
 * @author  Gruppe 7
 * @version 1.0
 */
public class StuhlTest
{
    @BeforeEach
    public void setUp()
    {
    }
    
    @Test
    public void testeProduktionsZeit() {
        Stuhl stuhl = new Stuhl();
        assertEquals(22, stuhl.gibProduktionszeit());
    }

    @AfterEach
    public void tearDown()
    {
    }
}
