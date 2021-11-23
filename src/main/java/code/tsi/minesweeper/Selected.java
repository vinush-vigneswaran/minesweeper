package code.tsi.minesweeper;

public class Selected{
    //////////////////////////////////Attribute//////////////////////////////////
    private int x_coord;
    private int y_coord;
    private char selected_tile;
    private Grid gameGrid;
    private char action;
    private String messageToPlayer;


    //////////////////////////////////Constructor//////////////////////////////////
    public Selected(){
        this.selected_tile = selected_tile;
        this.messageToPlayer = "";
    }

    //////////////////////////////////Methods//////////////////////////////////

    public void action(int x_coord, int y_coord, char action, Grid gameGrid) {

        this.selected_tile = selected_tile;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.gameGrid = gameGrid;
        this.action = action;

        char selectedTileValue = this.gameGrid.getGridValue(x_coord, y_coord);

        if (selectedTileValue == 'f'){
            flag();
        }
        else if (selectedTileValue == 'o'){
            free();
        }
        else if (selectedTileValue == 'm'){
            mine();
        }

    }

    public void mine() {
        this.messageToPlayer = "This is a bomb. You have been yeeted out. Game Over.";
        gameGrid.isGameOver(true);
        // Game over!
    }

    public void free() {

        if ((action == 'f') || (action == 'F')){
            // convert selected tile to flag
            this.gameGrid.setGrid(this.x_coord,this.y_coord, 'f');
            this.messageToPlayer = "Flagged!";

        }
        else if ((action == 's') || (action == 'S')){
            this.gameGrid.setGrid(this.x_coord,this.y_coord, 'f');
            //TODO: ADD THE EXPAND THINGY
            this.messageToPlayer = "This is land, well done. Now press another.";
        }

        // Call mainlandCell Expand function
    }

    public void flag() {
        System.out.println("You have selected a flag. Try again.");
        // lets player play again
    }

}
