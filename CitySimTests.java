import org.junit.Test;
import static org.junit.Assert.*;

//import org.mockito.*;


public class CitySimTests {
     
    
    
    // This tests to see that the program runs in the correct order and with the
    // appropriate amount runs. A failure consists of <5 or >5 drivers and them
    // not being in ascending order.
    @Test
    public void testFunFiveDrivers() {
        CitySim cs = new CitySim(5128);
        int[] test = cs.run();
        assertTrue(test.length == 5);
        assertTrue(test[0] < test[1] && test[1] < test[2] && test[2] < test[3] && test[3] < test[4]);
    }
}