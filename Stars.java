import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stars extends World{

    private long startTime = new java.util.Date().getTime(); 
    private long spawnInterval = 500; // .5 seconds
    private long nextSpawnTime = startTime + spawnInterval;
    private float playerSpawnPercentX = .5f;
    private float playerSpawnPercentY = .95f;
    

    /**
     * Constructor for objects of class Stars.
     */
    public Stars() {    
        super(600, 800, 1); 
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
