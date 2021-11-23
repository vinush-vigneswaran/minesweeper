package code.tsi.minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGrid {

    @Test
    public void GridSizeTest(){

        int testGridSizeX = 9, testGridSizeY = 7;

        Grid testGame = new Grid();

        char testGameGrid[][] = testGame.createNewGrid(testGridSizeX, testGridSizeY);

        //System.out.println(testGameGrid);

        assertEquals(testGridSizeX,testGameGrid.length,"Failed: X does size does not match");
        assertEquals(testGridSizeY,testGameGrid[0].length,"Failed: Y does size does not match");

    }

}
