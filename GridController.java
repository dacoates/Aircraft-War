import java.util.*;

/**
 * Write a description of class GridController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridController{

    private int rows;
    private int cols;
    private enum Mode {SWELL, SHRINK, STATIC}
    private Mode mode = Mode.SWELL;
    private enum Movement {LEFT, RIGHT, NONE}
    private Movement movement = Movement.NONE;
    private int moveRate = 2;
    private int swellFactor = 2;
    private int xOffset = 0;
    private int yOffset = 0;
    
    /**
     * Constructor for objects of class GridController
     * @params rows The number of rows in the grid
     * @params cols The number of cols in the grid
     */
    public GridController(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }
    
    public void act(){
        
    }

    public Location getAssignmentLocation(int row, int col){
        return calculateLocation(row, col); // To-do: This is not the correct implementation
    }
    
    private Location calculateLocation(int row, int col){
        return new Location(col * 25 + yOffset, row * 25 + xOffset);
    }
}
