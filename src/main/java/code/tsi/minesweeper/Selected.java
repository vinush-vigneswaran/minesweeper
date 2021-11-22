package code.tsi.minesweeper;

public class Selected{
    //////////////////////////////////Attribute//////////////////////////////////


    //////////////////////////////////Constructor//////////////////////////////////


    //////////////////////////////////Methods//////////////////////////////////
    public void bomb() {
        System.out.println("This is a bomb. You have been yeeted out ");
        // Game over!
    }

    public void free() {
        System.out.println("This is land, well done. Now press another.");
        // Call mainlandCell Expand function
    }

    public void flag() {
        System.out.println("You have selected a flag. Try again.");
        // lets player play again
    }

}
