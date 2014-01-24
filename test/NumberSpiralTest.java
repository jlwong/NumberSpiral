import main.NumberSpiral;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jwong on 1/24/14.
 */
public class NumberSpiralTest {
    @Test
    public void testNonIntInput() {

    }

    @Test
    public void testValidIntInput() {

    }

    @Test
    public void testSmallSpiral(){
        int spiralValue = 3;
        NumberSpiral numberSpiral = new NumberSpiral();
        String[][] spiralGrid = numberSpiral.createSpiral(spiralValue);
        assertNotNull(spiralGrid);
        assertEquals(2, spiralGrid.length);
        //assert spiral contains correct values
        assertEquals("0", spiralGrid[0][0]);
        assertEquals("1", spiralGrid[0][1]);
        assertEquals("2", spiralGrid[1][1]);
        assertEquals("3", spiralGrid[1][0]);
    }

    @Test
    public void testSingleValueInSpiral(){
        int spiralValue = 0;
        NumberSpiral numberSpiral = new NumberSpiral();
        String[][] spiralGrid = numberSpiral.createSpiral(spiralValue);
        assertNotNull(spiralGrid);
        assertEquals(1, spiralGrid.length);
        //assert spiral contains correct values
        assertEquals("0", spiralGrid[0][0]);
    }

}
