package main;

/**
 * Created by jwong on 1/24/14.
 */
public class NumberSpiral {

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

        int length = (int) Math.sqrt(spiralValue)+1;
        String[][] spiral = new String[length][length];

        // add initial 0 value to grid
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

    public static void main(String[] args){
    }
}
