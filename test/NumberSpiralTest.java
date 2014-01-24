import main.NumberSpiral;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jwong on 1/24/14.
 */
public class NumberSpiralTest {

    @Test
    public void testNonIntInput() {
        String nonIntInput = "abc123\n";
        String startSpiralOutput = getStartSpiralOutput(nonIntInput);
        assertEquals(NumberSpiral.PROMPT + NumberSpiral.ERROR_MSG + NumberSpiral.PROMPT_AGAIN, startSpiralOutput);
    }

    @Test
    public void testNegativeIntInput() {
        String negativeInput = "-3\n";
        String startSpiralOutput = getStartSpiralOutput(negativeInput);
        assertEquals(NumberSpiral.PROMPT + NumberSpiral.ERROR_MSG + NumberSpiral.PROMPT_AGAIN, startSpiralOutput);
    }


    @Test
    public void testValidIntInput() {
        String validInput = "3\n";
        String startSpiralOutput = getStartSpiralOutput(validInput);
        assertEquals(NumberSpiral.PROMPT + "0 1 \n3 2 \n" + NumberSpiral.PROMPT_AGAIN, startSpiralOutput);

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
    public void testLargeSpiral(){
        int spiralValue = 110;
        NumberSpiral numberSpiral = new NumberSpiral();
        String[][] spiralGrid = numberSpiral.createSpiral(spiralValue);
        assertNotNull(spiralGrid);
        assertEquals(11, spiralGrid.length);
        //assert diagonal values in spiral contains correct values
        assertEquals("110", spiralGrid[0][0]);
        assertEquals("72", spiralGrid[1][1]);
        assertEquals("42", spiralGrid[2][2]);
        assertEquals("20", spiralGrid[3][3]);
        assertEquals("6", spiralGrid[4][4]);
        assertEquals("0",   spiralGrid[5][5]);
        assertEquals("2", spiralGrid[6][6]);
        assertEquals("12", spiralGrid[7][7]);
        assertEquals("30", spiralGrid[8][8]);
        assertEquals("56", spiralGrid[9][9]);
        assertEquals("90", spiralGrid[10][10]);
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

    @Test
    public void testPrintSpiral(){
        String[][] testSpiral = {{"6","7","8","9"},
                                 {"5","0","1","10"},
                                 {"4","3","2","11"},
                                 {"", "", "", "12"},};

        final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        NumberSpiral numberSpiral = new NumberSpiral();
        numberSpiral.printSpiral(testSpiral);

        assertEquals(" 6  7  8  9 \n 5  0  1 10 \n 4  3  2 11 \n         12 \n", testOut.toString());
    }

    private String getStartSpiralOutput(String input){
        NumberSpiral numberSpiral = new NumberSpiral();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        numberSpiral.setScanner(new Scanner(System.in));

        final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        numberSpiral.startSpiral();

        return testOut.toString();
    }

}
