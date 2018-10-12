import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stars extends World{

    long startTime = new java.util.Date().getTime(); 
    long spawnInterval = 500; // .5 seconds
    long nextSpawnTime = startTime + spawnInterval;

    /**
     * Constructor for objects of class Stars.
     */
    public Stars() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 400, 3); 
        
        Red dot = new Red();
        addObject(dot, 150, 350);

        EnemyController enemyController = new EnemyController();
        addObject(enemyController, 1, 1);
    }
}
