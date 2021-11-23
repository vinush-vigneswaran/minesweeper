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
        game1.createNewPlayerGrid();
        game1.createBombNumGrid();

        //////////////////////////// FOR DEBUGGING  /////////////////////////
        System.out.println("___________ BOMB SCORES: BTS ___________");
        game1.viewBombGrid();
        //game1.setBombGrid(0,0,'f');

        System.out.println("___________ VIEW HIDDEN MINES ___________");
        game1.viewGrid();

        System.out.println("___________ PLAYER INITIAL BOARD ___________");
        game1.viewPlayerGrid();

        //////////////////////////// USER PLAY STARTS /////////////////////////
        while (!(game1.isGameOver())) {


            System.out.println("__________ GAMEPLAY ____________");
            System.out.println("Please type x,y,(f,s): ");
            int x_value = userInput.nextInt();
            //System.out.println("Please type y-value: ");
            int y_value = userInput.nextInt();
            //System.out.println("Next move will be placed on: (" + x_value + "," + y_value + ")" );
            //System.out.println("Flag or Select  (f/s): ");
            char action = userInput.next().charAt(0);
            //System.out.println("You chose: " + action);


            //////////////////////////// BOARD GAME CHECK /////////////////////////

            select.action(x_value, y_value, action, game1);
            game1.viewPlayerGrid();



        }
    }
}
