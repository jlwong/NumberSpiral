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
        String invalidInput = "abc123";
        NumberSpiral numberSpiral = new NumberSpiral();
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        numberSpiral.setScanner(new Scanner(System.in));

        final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        numberSpiral.startSpiral();

        assertEquals(NumberSpiral.PROMPT + " Some error message. " + NumberSpiral.PROMPT_AGAIN, testOut.toString());
    }

    @Test
    public void testNegativeIntInput() {
        String invalidInput = "-3\n";
        NumberSpiral numberSpiral = new NumberSpiral();
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        numberSpiral.setScanner(new Scanner(System.in));

        final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        numberSpiral.startSpiral();

        assertEquals(NumberSpiral.PROMPT + " Some error message. " + NumberSpiral.PROMPT_AGAIN, testOut.toString());
    }


    @Test
    public void testValidIntInput() {
        String validInput = "3";
        NumberSpiral numberSpiral = new NumberSpiral();
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));
        numberSpiral.setScanner(new Scanner(System.in));

        final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        numberSpiral.startSpiral();

        assertEquals(NumberSpiral.PROMPT + "0 1 \n3 2 \n" + NumberSpiral.PROMPT_AGAIN, testOut.toString());

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
}
