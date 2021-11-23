package code.tsi.minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Grid {


    //////////////////////////////////Attribute//////////////////////////////////
    private int gridSizeX;
    private int gridSizeY;
    private char[][] gameGrid;
    private int[][] mineNumGrid;
    private Coordinates coord = new Coordinates();
    private boolean gameOver = false;


    //////////////////////////////////Constructor//////////////////////////////////
    public Grid(){

    }

    public Grid(int gridSizeX, int gridSizeY){
        this.gridSizeY = gridSizeY;
        this.gridSizeX = gridSizeX;
    }

    //////////////////////////////////Methods//////////////////////////////////

    public char[][] createNewGrid(int gridSizeX, int gridSizeY) {

        this.gridSizeY = gridSizeY;
        this.gridSizeX = gridSizeX;
        this.coord = coord;

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

                        // save mine coordinates
                        int[] currLoc = {i, j};

                        this.coord.addToCoordinatesArrayList(i,j);
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

    public void createBombNumGrid() {
        // create a 2d array of zeros
        int mineNumGrid[][]  = new int[gridSizeX][gridSizeY];
        //Arrays.fill(mineNumGrid, 0);

        // obtain list of bomb coordinates
        ArrayList<int[]> bombArrayList = this.coord.coordinateArrayList();

        // set values on grid
        int listLength = bombArrayList.size();

        for (int i = 0; i < listLength; i++) {

            int[] coordVals = bombArrayList.get(i);
            int xMineCoord = coordVals[0];
            int yMineCoord = coordVals[1];

            // does L to R scan, and adds 1 to three left position to coord
            if (xMineCoord != this.gridSizeX-1){
                mineNumGrid[xMineCoord + 1][yMineCoord] += 1;
                if (yMineCoord != this.gridSizeY - 1){
                    mineNumGrid[xMineCoord + 1][yMineCoord + 1] += 1;
                }
                if (yMineCoord != 0){
                    mineNumGrid[xMineCoord + 1][yMineCoord - 1] += 1;
                }

                //mineNumGrid[xMineCoord + 1][yMineCoord + 1] += 1;
            }
            // does L to R scan, and adds 1 to three right position to coord
            if (xMineCoord != 0){
                mineNumGrid[xMineCoord - 1][yMineCoord] += 1;
                //mineNumGrid[xMineCoord - 1][yMineCoord - 1] += 1;
                if (yMineCoord != this.gridSizeY - 1){
                    mineNumGrid[xMineCoord - 1][yMineCoord + 1] += 1;
                }
                if (yMineCoord != 0){
                    mineNumGrid[xMineCoord - 1][yMineCoord - 1] += 1;
                }
            }
            // does up to down, and adds 1 to lower position to coord
            if (yMineCoord != this.gridSizeY - 1){
                mineNumGrid[xMineCoord][yMineCoord + 1] += 1;
                //mineNumGrid[xMineCoord+1][yMineCoord + 1] += 1;

            }
            // does up to down, and adds 1 to upper position to coord
            if (yMineCoord != 0){
                mineNumGrid[xMineCoord][yMineCoord - 1] += 1;

            }
        }
        this.mineNumGrid = mineNumGrid;
    }

    public String viewBombCoordinates() {
        // obtain list of bomb coordinates
        ArrayList<int[]> coordArrayList = this.coord.coordinateArrayList();

        // get size to iteratively print each coordinate
        int listLength = coordArrayList.size();
        System.out.println("There are " + listLength + " bombs.");

        for (int i = 0; i < listLength; i++) {
            System.out.println(Arrays.toString(coordArrayList.get(i)));
        }

        return Arrays.deepToString(this.mineNumGrid);

    }

    public void viewBombGrid() {
        //print game grid as newline arrays
        //System.out.println(Arrays.deepToString(this.gameGrid));
        //to add: coordinate ticks


        for (int[] row : this.mineNumGrid) {
            for (int val : row) {
                System.out.print(val + "  ");
            }
            //split into new lines
            System.out.println();
        }
    }

    public void setGrid(int x, int y, char c) {
        this.gameGrid[x][y] = c;
    }

    public char[][] getGrid() {
        return this.gameGrid;
    }

    public int getBombNum(int x, int y) {
        return this.mineNumGrid[x][y];
    }

    public char getGridValue(int x, int y) {
        return this.gameGrid[x][y];
    }
    public boolean isGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        return this.gameOver;
    }
}
