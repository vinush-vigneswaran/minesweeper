package code.tsi.minesweeper;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Grid game1 = new Grid();
        // game1.createNewGrid(5,5);

        //System.out.println(Arrays.deepToString(game1.createNewGrid(5,5)));

        game1.createNewGrid(5,5);
        game1.viewGrid();

    }
}
