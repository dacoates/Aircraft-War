import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy_Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyController extends Actor
{
    long thisFrameTime;
    long lastFrameTime = new java.util.Date().getTime();
    long spawnInterval = 500; // .5 seconds
    long nextSpawnTime;
    int enemyCount = 0;
    int finalX = 25;
    int finalY = 55;
    int totalEnemyToSpawn = 55;
    
    
    /**
     * Act - do whatever the Enemy_Controller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        thisFrameTime = new java.util.Date().getTime();
        if(thisFrameTime >= nextSpawnTime && enemyCount < totalEnemyToSpawn){
            Enemy enemy = new Enemy();
            enemyCount++;
            Waypoint finalDestination = new Waypoint(finalX, finalY);
            enemy.setFinalDestination(finalDestination);
            incrementXAndY();
            spawnEnemy(enemy);
            nextSpawnTime = thisFrameTime + spawnInterval;
        }
        lastFrameTime = thisFrameTime;
    }
    
    private void spawnEnemy(Enemy enemy){
        getWorld().addObject(enemy, enemy.getDestination().getX(), enemy.getDestination().getY());
    }
    
    private void incrementXAndY(){
        if(finalX >= getWorld().getWidth() - 25){
            finalX = 25;
            finalY += 25;
        } else {
            finalX += 25;
        }
    }
}
