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
    private enum LeftRightMode {LEFT, RIGHT, NONE}
    private LeftRightMode leftRightMode = LeftRightMode.NONE;
    private enum UpDownMode {UP, DOWN, NONE}
    private UpDownMode upDownMode = UpDownMode.DOWN;
    private float worldWidth = (float) GameConstants.WORLD_WIDTH;
    private float worldHeight = (float) GameConstants.WORLD_HEIGHT;
    private float leftRightRate = .4f;
    private float maxYOffset = 20f;
    private float swellRate = .02f;
    private float upDownRate = .2f;
    private float swell = 0f;
    private float maxSwell = 10f;
    private float xOffset = 0f;
    private float yOffset = 0f;
    private float minXOffset = 0f;
    private float gridXSpacing = 35 / GameConstants.WORLD_CELL_SIZE;
    private float gridYSpacing = 30 / GameConstants.WORLD_CELL_SIZE;
    private long thisFrameTime = 0;
    private long leftRightInterval = 5;
    private long nextLeftRightTime = 0;
    private long swellInterval = 5;
    private long nextSwellTime = 0;
    private long nextUpDownTime = 0;
    private long upDownInterval = 5;
    
    /**
     * Constructor for objects of class GridController
     * @params rows The number of rows in the grid
     * @params cols The number of cols in the grid
     */
    public GridController(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        leftRightMode = LeftRightMode.RIGHT;
        swellMode = SwellMode.SWELL;
        upDownMode =UpDownMode.DOWN;
    }
    
    public void act(){
        thisFrameTime = new Date().getTime();
        if(leftRightMode != LeftRightMode.NONE && thisFrameTime >= nextLeftRightTime){
            nextLeftRightTime = thisFrameTime + leftRightInterval;
            if(leftRightMode == LeftRightMode.RIGHT){
                if((xOffset += leftRightRate) > maxXOffset()){
                    leftRightMode = LeftRightMode.LEFT;
                }
            }
            if(leftRightMode == LeftRightMode.LEFT){
                if((xOffset -= leftRightRate) < minXOffset){
                    leftRightMode = LeftRightMode.RIGHT;
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
        if(upDownMode != UpDownMode.NONE && thisFrameTime >= nextUpDownTime){
            nextUpDownTime = thisFrameTime + upDownInterval;
            if(upDownMode == UpDownMode.DOWN){
                if((yOffset += upDownRate) >= maxYOffset){
                    yOffset = maxYOffset;
                    upDownMode = UpDownMode.UP;
                }
            }
            if(upDownMode == UpDownMode.UP){
                if((yOffset -= upDownRate) <= 0){
                    yOffset = 0;
                    upDownMode = UpDownMode.DOWN;
                }
            }
        }
    }
    
    public Location getAssignmentLocation(int row, int col){
        return calculateLocation((float) row, (float)col); // To-do: This is not the correct implementation
    }
    
    private Location calculateLocation(float row, float col){
        int x = (int) (col * gridXSpacing + xOffset + swell * col);
        int y = (int) (row * gridYSpacing + yOffset + swell * row * 2);
        return new Location(x, y);
    }
    
    private float maxXOffset(){
        return worldWidth - (cols * gridXSpacing + cols * swell) - gridXSpacing;
    }
}
