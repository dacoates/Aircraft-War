import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Concrete World subclass.
 * 
 * @author (Devon Coates and Dave Coates) 
 * @version (Fall 2018)
 */
public class Stars extends World{

    private float playerSpawnPercentX = .5f;  // Player spawn X as a percentage of World width.
    private float playerSpawnPercentY = .95f; // Player spawn Y as a percentage of World height.

    public Stars(){    
        super(GameConstants.WORLD_WIDTH, GameConstants.WORLD_HEIGHT, GameConstants.WORLD_CELL_SIZE); 
        addObject(new Player(), getSpawnX(), getSpawnY());
        addObject(new EnemyController(), 1, 1);
    }
    
    private int getSpawnX(){
        float width = (float) getWidth();
        return (int) (width * playerSpawnPercentX);
    }
    
    private int getSpawnY(){
        float height = (float) getHeight();
        return (int) (height * playerSpawnPercentY);
    }
}
