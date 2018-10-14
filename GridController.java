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
    private enum SwellMode {SWELL, SHRINK, STATIC}
    private SwellMode swellMode = SwellMode.STATIC;
    private enum MoveMode {LEFT, RIGHT, NONE}
    private MoveMode moveMode = MoveMode.NONE;
    private int worldWidth = GameConstants.WORLD_WIDTH;
    private int worldHeight = GameConstants.WORLD_HEIGHT;
    private int moveRate = 1;
    private int swellRate = 1;
    private int swell = 0;
    private int maxSwell = 4;
    private int xOffset = 0;
    private int yOffset = 0;
    private int minXOffset = 0;
    private int gridXSpacing = 40;
    private int gridYSpacing = 40;
    private long thisFrameTime = 0;
    private long moveInterval = 300;
    private long swellInterval = 350;
    private long nextMoveTime = 0;
    private long nextSwellTime = 0;
    
    /**
     * Constructor for objects of class GridController
     * @params rows The number of rows in the grid
     * @params cols The number of cols in the grid
     */
    public GridController(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        moveMode = MoveMode.RIGHT;
        swellMode = SwellMode.SWELL;
    }
    
    public void act(){
        thisFrameTime = new Date().getTime();
        if(moveMode != MoveMode.NONE && thisFrameTime >= nextMoveTime){
            nextMoveTime = thisFrameTime + moveInterval;
            if(moveMode == MoveMode.RIGHT){
                if(xOffset++ > maxXOffset()){
                    moveMode = MoveMode.LEFT;
                }
            }
            if(moveMode == MoveMode.LEFT){
                if(xOffset-- < minXOffset){
                    moveMode = MoveMode.RIGHT;
                }
            }
        }
        if(swellMode != SwellMode.STATIC && thisFrameTime >= nextSwellTime){
            nextSwellTime = thisFrameTime + swellInterval;
            if(swellMode == SwellMode.SWELL){
                if(swell++ > maxSwell){
                    swellMode = SwellMode.SHRINK;
                }
            }
            if(swellMode == SwellMode.SHRINK){
                if(swell-- <= 0){
                    swellMode = SwellMode.SWELL;
                }
            }
        }
    }
    
    public Location getAssignmentLocation(int row, int col){
        return calculateLocation(row, col); // To-do: This is not the correct implementation
    }
    
    private Location calculateLocation(int row, int col){
        return new Location(col * gridXSpacing + xOffset + swell * col, row * gridYSpacing + swell * row * 2);
    }
    
    private int maxXOffset(){
        return worldWidth - (cols * gridXSpacing + cols * swell) - gridXSpacing;
    }
}
