package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program that will create a clockwise number spiral based on user input.
 *
 * @author Jennifer Wong
 */
public class NumberSpiral {

    public static final String PROMPT = "Please enter a non-negative integer:\n";
    public static final String PROMPT_AGAIN = "Create another spiral?[y/n]\n";
    public final static String ERROR_MSG = "That was not a non-negative integer.\n";

    private Scanner scanner;

    /**
     * Setter for scanner
     *
     * @param scanner - scanner so input can be read in through prompt or set through tests.
     */
    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }

    /**
     * Getter scanner
     *
     * @return scanner - scanner to read input
     */
    public Scanner getScanner(){
        return this.scanner;
    }

    /**
     * Create a clockwise number spiral based on a value entered by the user
     *
     * @param spiralValue the size of the spiral given by the user
     * @return a n x n string array containing the spiral
     */
    public String[][] createSpiral(int spiralValue){
        if(spiralValue < 0){
            return null;
        }

        int length = (int) Math.sqrt(spiralValue);
        String[][] spiral = getInitialSpiral(length + 1);

        // add initial 0 value to spiral
        int currentNum = 0;
        int row = length/2;
        int col = length/2;
        spiral[row][col] = String.valueOf(currentNum);
        currentNum++;

        // values to keep track of # of slots over to keep going in one direction
        int numberOver = 1;
        int stopValue;

        while (currentNum <= spiralValue){
            //Move right
            stopValue = col + numberOver;
            while(col < stopValue && currentNum <= spiralValue){
                col++;
                spiral[row][col] = String.valueOf(currentNum);
                currentNum++;
            }

            //Move down
            stopValue = row + numberOver;
            while(row < stopValue && currentNum <= spiralValue){
                row++;
                spiral[row][col] = String.valueOf(currentNum);
                currentNum++;
            }

            //numberOver increments by 1 after one move right and down
            numberOver++;

            //Move left
            stopValue = col - numberOver;
            while(col > stopValue && currentNum <= spiralValue){
                col--;
                spiral[row][col] = String.valueOf(currentNum);
                currentNum++;
            }

            //Move up
            stopValue = row - numberOver;
            while(row > stopValue && currentNum <= spiralValue){
                row--;
                spiral[row][col] = String.valueOf(currentNum);
                currentNum++;
            }

            //numberOver increments by 1 after one move left and up
            numberOver++;
        }

        return spiral;
    }

    /**
     * Create an n x n string array initialized to empty string.
     *
     * @param length is size of the arrays
     * @return length x length array of empty strings
     */
    private String[][] getInitialSpiral(int length){
        String[][] spiral = new String[length][length];
        for (int row = 0; row < length; row++){
            for(int col = 0; col < length; col++){
                spiral[row][col] = "";
            }
        }
        return spiral;
    }

    /**
     * Print out the spiral
     *
     * @param spiral n x n string array containing number spiral
     */
    public void printSpiral(String[][] spiral){
        int length = spiral.length;
        // pad values to match the width of largest possible value in spiral
        int width = String.valueOf(length*length).length();
        String format = "%" + String.valueOf(width) + "s ";
        for(int row=0; row < length; row++){
            for(int col=0; col < length; col++){
                System.out.print(String.format(format, spiral[row][col]));
            }
            System.out.println("");
        }
    }

    /**
     * Prompt the user for a value to generate the number spiral
     *
     * A spiral will be generated for any integer >= 0.
     * For any other values the program will return an error message and re-prompt the user for a spiral value.
     */
    public void startSpiral(){
        Scanner scanner = this.getScanner();
        System.out.print(PROMPT);
        while (scanner.hasNext()){
            try{
                int spiralSize = scanner.nextInt();
                if (spiralSize >= 0) {
                    String[][] spiral = createSpiral(spiralSize);
                    printSpiral(spiral);
                }
                else {
                    System.out.print(ERROR_MSG);
                }
            }catch(InputMismatchException exception){
                System.out.print(ERROR_MSG);
            }
            scanner.nextLine(); // consume the eol for each input
            System.out.print(PROMPT_AGAIN);
            boolean inputPresent = scanner.hasNext();
            if(!inputPresent || (inputPresent && !(scanner.next().equalsIgnoreCase("y")))){
                break;
            }else{
                System.out.print(PROMPT);
            }
        }
    }

    /**
     * Main method that will execute on program start.
     *
     * @param args no arguments needed to run
     */
    public static void main(String[] args){
        NumberSpiral numberSpiral = new NumberSpiral();
        numberSpiral.setScanner(new Scanner(System.in));
        numberSpiral.startSpiral();
    }
}
