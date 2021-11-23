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

        char selectedHiddenValue = this.gameGrid.getHiddenGridValue(x_coord, y_coord);
        char selectedPlayerValue = this.gameGrid.getPlayerGridValue(x_coord, y_coord);

        if (selectedPlayerValue == 'f'){
            flag();
        }
        else if ((selectedHiddenValue == 'o')&&(selectedPlayerValue == 'o')){
            free();
        }
        else if (selectedHiddenValue == 'm'){
            mine();
        }
        else if (selectedPlayerValue == 'x'){
            occupied();
        }
        //TODO: change this sout to return string
        System.out.println(this.messageToPlayer);

    }

    public String mine() {

        if ((action == 'f') || (action == 'F')){
            // convert selected tile to flag
            this.gameGrid.setPlayerGrid(this.x_coord,this.y_coord, 'f');
            this.messageToPlayer = "Flagged!";

        }
        else if ((action == 's') || (action == 'S')){
            // Game over!
            this.messageToPlayer = "This is a bomb. You have been yeeted out. Game Over.";
            gameGrid.setGameOver(true);

        }
        return this.messageToPlayer;
    }

    public String free() {

        if ((action == 'f') || (action == 'F')){
            // convert selected tile to flag
            this.gameGrid.setPlayerGrid(this.x_coord,this.y_coord, 'f');
            this.messageToPlayer = "Flagged!";
        }
        else if ((action == 's') || (action == 'S')){
            ExpandTiles clickTo = new ExpandTiles();
            clickTo.expand(this.x_coord,this.y_coord, gameGrid);
            this.messageToPlayer = "This is land, well done. Now press another.";
        }

        return this.messageToPlayer;
        // Call mainlandCell Expand function
    }

    public String flag() {
        // lets player play again
        this.gameGrid.setPlayerGrid(this.x_coord,this.y_coord, 'o');
        this.messageToPlayer = "You have unflagged this tile.";
        return this.messageToPlayer;
    }

    public String occupied() {
        // lets player play again
        this.messageToPlayer = "You have already clicked on this coordinate. Try again.";
        return this.messageToPlayer;
    }

}
