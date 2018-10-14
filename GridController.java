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
    private Mode mode = Mode.STATIC;
    private enum Movement {LEFT, RIGHT, NONE}
    private Movement movement = Movement.NONE;
    private int moveRate = 1;
    private int swellRate = 1;
    private int swellFactor = 0;
    private int maxSwell = 3;
    private int xOffset = 0;
    private int yOffset = 0;
    private int maxXOffset = 25;
    private int minXOffset = 0;
    private int gridXSpacing = 20;
    private int gridYSpacing = 20;
    long thisFrameTime = 0;
    long lastMoveTime = 0;
    long lastSwellTime = 0;
    long moveInterval = 300;
    long swellInterval = 350;
    
    /**
     * Constructor for objects of class GridController
     * @params rows The number of rows in the grid
     * @params cols The number of cols in the grid
     */
    public GridController(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        movement = Movement.RIGHT;
        mode = Mode.SWELL;
    }
    
    public void act(){
        thisFrameTime = new Date().getTime();
        if(movement != Movement.NONE && thisFrameTime - lastMoveTime > moveInterval){
            lastMoveTime = thisFrameTime;
            if(movement == Movement.RIGHT){
                if(xOffset++ > maxXOffset){
                    movement = Movement.LEFT;
                }
            }
            if(movement == Movement.LEFT){
                if(xOffset-- < minXOffset){
                    movement = Movement.RIGHT;
                }
            }
        }
        if(mode != Mode.STATIC && thisFrameTime - lastSwellTime > swellInterval){
            lastSwellTime = thisFrameTime;
            if(mode == Mode.SWELL){
                if(swellFactor++ > maxSwell){
                    mode = Mode.SHRINK;
                }
            }
            if(mode == Mode.SHRINK){
                if(swellFactor-- <= 0){
                    mode = Mode.SWELL;
                }
            }
        }
    }
    
    public Location getAssignmentLocation(int row, int col){
        return calculateLocation(row, col); // To-do: This is not the correct implementation
    }
    
    private Location calculateLocation(int row, int col){
        return new Location(col * gridXSpacing + xOffset + swellFactor * col, row * gridYSpacing + swellFactor * row * 2);
    }
}
