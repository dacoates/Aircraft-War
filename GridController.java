import java.util.*;

/**
 * Write a description of class GridController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridController{
    
    private float rows;
    private float cols;
    private enum SwellMode {SWELL, SHRINK, STATIC}
    private SwellMode swellMode = SwellMode.STATIC;
    private enum MoveMode {LEFT, RIGHT, NONE}
    private MoveMode moveMode = MoveMode.NONE;
    private float worldWidth = (float) GameConstants.WORLD_WIDTH;
    private float worldHeight = (float) GameConstants.WORLD_HEIGHT;
    private float moveRate = .4f;
    private float swellRate = .02f;
    private float swell = 0f;
    private float maxSwell = 10f;
    private float xOffset = 0f;
    private float yOffset = 0f;
    private float minXOffset = 0f;
    private float gridXSpacing = 35 / GameConstants.WORLD_CELL_SIZE;
    private float gridYSpacing = 30 / GameConstants.WORLD_CELL_SIZE;
    private long thisFrameTime = 0;
    private long moveInterval = 5;
    private long swellInterval = 5;
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
                if((xOffset += moveRate) > maxXOffset()){
                    moveMode = MoveMode.LEFT;
                }
            }
            if(moveMode == MoveMode.LEFT){
                if((xOffset -= moveRate) < minXOffset){
                    moveMode = MoveMode.RIGHT;
                }
            }
        }
        if(swellMode != SwellMode.STATIC && thisFrameTime >= nextSwellTime){
            nextSwellTime = thisFrameTime + swellInterval;
            if(swellMode == SwellMode.SWELL){
                if((swell += swellRate) >= maxSwell){
                    swell = maxSwell;
                    swellMode = SwellMode.SHRINK;
                }
            }
            if(swellMode == SwellMode.SHRINK){
                if((swell -= swellRate) <= 0){
                    swell = 0;
                    swellMode = SwellMode.SWELL;
                }
            }
        }
    }
    
    public Location getAssignmentLocation(int row, int col){
        return calculateLocation((float) row, (float)col); // To-do: This is not the correct implementation
    }
    
    private Location calculateLocation(float row, float col){
        int x = (int) (col * gridXSpacing + xOffset + swell * col);
        int y = (int) (row * gridYSpacing + swell * row * 2);
        return new Location(x, y);
    }
    
    private float maxXOffset(){
        return worldWidth - (cols * gridXSpacing + cols * swell) - gridXSpacing;
    }
}
