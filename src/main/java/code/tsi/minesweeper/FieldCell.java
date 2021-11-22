package code.tsi.minesweeper;

public class FieldCell{

    //////////////////////////////////Attribute//////////////////////////////////


    //////////////////////////////////Constructor//////////////////////////////////


    //////////////////////////////////Methods//////////////////////////////////
    public void select(int x, int y) {
        System.out.println("Selected this");
        // check grid for state (free, flagged, bomb)
        // if free:
        //      Selected.free()
        // else if bomb:
        //      Selected.bomb()
        //else if flag:
        //      Selected.flag()

    }

    public void flag(int x, int y) {
        System.out.println("Flagged this");
        // get grid
        // add flag to grid position
    }

}