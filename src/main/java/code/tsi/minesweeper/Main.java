package code.tsi.minesweeper;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Grid game1 = new Grid();
        Scanner userInput = new Scanner(System.in);
        Selected select = new Selected();

        //////////////////////////// INITIATE GAME /////////////////////////
        game1.createNewGrid(5,5);
        game1.createBombNumGrid();

        //////////////////////////// FOR DEBUGGING  /////////////////////////
        System.out.println("___________ BOMB SCORES: BTS ___________");
        game1.viewBombGrid();
        //game1.setBombGrid(0,0,'f');

        //////////////////////////// USER PLAY STARTS /////////////////////////
        System.out.println("__________ GAMEPLAY ____________");
        System.out.println("Please type x-value: ");
        int x_value = userInput.nextInt();
        System.out.println("Please type y-value: ");
        int y_value = userInput.nextInt();
        System.out.println("Next move will be placed on: (" + x_value + "," + y_value + ")" );
        System.out.println("Flag or Select  (f/s): ");
        char action = userInput.nextLine();
        System.out.println("You chose: " + action);

        //////////////////////////// BOARD GAME CHECK /////////////////////////
        char selectedTileValue = game1.getGridValue(x_value,y_value);

        select.action(x_value,y_value, action, game1);

        //System.out.println("The tile is currently: "selectedTileValue);

        game1.viewGrid();
        //game1.setGrid(0,0,'f');

        //get bomb value of a coordinate
        System.out.println(game1.getBombNum(0,1));

    }
}
