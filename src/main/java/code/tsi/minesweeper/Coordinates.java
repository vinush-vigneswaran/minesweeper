package code.tsi.minesweeper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Coordinates {
    //////////////////////////////////Attribute//////////////////////////////////
    private int x;
    private int y;
    //private int[][] coordinateList;
    ArrayList<int[]> coordinateList = new ArrayList<int[]>();

    //////////////////////////////////Constructor//////////////////////////////////
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(){
    }
    //////////////////////////////////Methods//////////////////////////////////

    public void addToCoordinatesArrayList(int x, int y){
    //public ArrayList<int[]> arrayOfCoordinates(int x, int y){
        this.coordinateList = coordinateList;

        int[] coordinates = {x, y};
        this.coordinateList.add(coordinates);
        //return this.coordinateList;
    }

    public ArrayList<int[]> coordinateArrayList(){

        return this.coordinateList;

    }



}
