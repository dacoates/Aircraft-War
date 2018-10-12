import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy_Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_Controller extends Actor
{
    long startTime = new java.util.Date().getTime(); 
    long spawnInterval = 250; // .25 seconds
    long nextSpawnTime = startTime + spawnInterval;
    /**
     * Act - do whatever the Enemy_Controller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(new java.util.Date().getTime() >= nextSpawnTime){
            Enemy enemy = new Enemy();
            getWorld().addObject(enemy, enemy.getDestination().getX(), enemy.getDestination().getY());
            nextSpawnTime = nextSpawnTime + spawnInterval;
        }
        
        Enemy enemy = new Enemy();
        
        List<Enemy> enemiesInWorld;
        enemiesInWorld = getWorld().getObjects(Enemy.class);
        if(enemiesInWorld.size() >= 25){
            getWorld().removeObject(this);
        }
    }    
}

