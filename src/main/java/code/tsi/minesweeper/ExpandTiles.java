package code.tsi.minesweeper;

import java.util.ArrayList;
import java.util.Arrays;

public class ExpandTiles {
    //////////////////////////////////Attribute//////////////////////////////////
    private int x_coord;
    private int y_coord;
    private Grid gameGrid;

    //////////////////////////////////Constructor//////////////////////////////////
    public ExpandTiles(){
        //
    }

    //////////////////////////////////Methods//////////////////////////////////
    public void expand(int x_coord, int y_coord, Grid gameGrid) {

        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.gameGrid = gameGrid;

        this.gameGrid.viewBombGrid();

        //find the tightest square

        //get coordinates of all bombs
        ArrayList<int[]> coordArrayList = this.gameGrid.getMineCoordinatesArrayList();
        int listLength = coordArrayList.size();

        float minDiffX = 100000.0f;
        float minDiffY = 100000.0f;
        int[] minCoord =


        for (int i = 0; i < listLength; i++) {

            int[] coordVals = coordArrayList.get(i);
            int xMineCoord = coordVals[0];
            int yMineCoord = coordVals[1];

            float diffX = (float)(this.x_coord - xMineCoord);
            float diffY = (float)(this.x_coord - yMineCoord);

            if (diffX <= minDiffX){

            }

            System.out.println(Arrays.toString(coordArrayList.get(i)));
        }


        char selectedHiddenValue = this.gameGrid.getHiddenGridValue(x_coord, y_coord);

        this.gameGrid.setPlayerGrid(this.x_coord,this.y_coord, 'x');

        System.out.println("These cell have expanded");
        // get grid
        // expand some portion
        // call border with coordinates of border
        // set grid

        //output array

        //AFTER GETTING BOMBS
        this.gameGrid.getBombNum(5,5);

        System.out.println("These cells are the border");
        System.out.println("This many bomb around...");
    }

}
