package code.tsi.minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Grid {


    //////////////////////////////////Attribute//////////////////////////////////
    private int gridSizeX;
    private int gridSizeY;
    private char[][] gameGrid;
    private int[][] mineNumGrid;
    private int[][] mineLocation;


    //////////////////////////////////Constructor//////////////////////////////////
    public Grid(){
        //
    }

    public Grid(int gridSizeX, int gridSizeY){
        this.gridSizeY = gridSizeY;
        this.gridSizeX = gridSizeX;
    }

    //////////////////////////////////Methods//////////////////////////////////

    public char[][] createNewGrid(int gridSizeX, int gridSizeY) {

        this.gridSizeY = gridSizeY;
        this.gridSizeX = gridSizeX;

        //create a 2d array
        char gameGrid[][]  = new char[gridSizeX][gridSizeY];

        //get random number
        Random randNum = new Random();

        //assign bomb(b) or field(o) to each cell
        for (int i = 0; i < gridSizeX; i++) {
            for (int j = 0; j < gridSizeY; j++) {
                int randInt = randNum.nextInt(100);

                // random bomb distribution
                if(randInt <= 20){
                    gameGrid[i][j] = 'm'; //mine
//                    int[] currLoc = {i, j};
//                    //Coordinates.arrayOfCoordinates(i,j);
//                    System.out.println(Arrays.toString(currLoc));
                    //this.mineLocation = ArrayUtils.add(this.mineLocation, currLoc) ;//store location
                }
                else{
                    gameGrid[i][j] = 'o'; //avail cell
                }
            }
        }
        this.gameGrid = gameGrid;
        //System.out.println(Arrays.deepToString(this.gameGrid));
        return this.gameGrid;
    }

    public void viewGrid() {
        //print game grid as newline arrays
        //System.out.println(Arrays.deepToString(this.gameGrid));
        //to add: coordinate ticks


        for (char[] row : this.gameGrid) {
            for (char val : row) {
                System.out.print(val + "  ");
            }
            //split into new lines
            System.out.println();
        }
    }

    public String bombNumGrid() {
        return Arrays.deepToString(this.mineNumGrid);
    }

    public void setGrid(int size) {

    }

    public void getGrid() {

    }

}
