import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class EnemyController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyController extends Actor{
    
    long thisFrameTime;
    long spawnInterval = 80; // .08 seconds
    long nextSpawnTime;
    int enemyCount = 0;
    private int finalX1 = 25;
    private int finalY1 = 25;
    private int finalX2 = 150;
    private int finalY2 = 25;
    private int gridRow1 = 1;
    private int gridCol1 = 1;
    private int gridRow2 = 1;
    private int gridCol2 = 6;
    int totalEnemyToSpawn = 50;
    Route routeA1, routeA2;
    GridController gridController;
    
    public EnemyController(){
        routeA1 = new RouteA();
        routeA2 = routeA1.getVerticalMirrorRoute(150);
        gridController = new GridController(5, 10);
        setImage(new GreenfootImage("", 1, Color.BLACK, Color.BLACK));
    }
    
    
    /**
     * Act - do whatever the EnemyController wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        gridController.act();
        thisFrameTime = new java.util.Date().getTime();
        if(thisFrameTime >= nextSpawnTime && enemyCount < totalEnemyToSpawn){
            enemyCount++;
            Enemy enemy;
            Route routeA1;
            if(enemyCount % 2 == 0){
                routeA1 = new RouteA();
                enemy = new Enemy(routeA1);
                enemy.setGridController(gridController, gridRow1, gridCol1);
                incrementGridAssignment1();
            } else {
                enemy = new Enemy(new RouteA().getVerticalMirrorRoute(getWorld().getWidth()/2));
                enemy.setGridController(gridController, gridRow2, gridCol2);
                incrementGridAssignment2();
            }
            spawn(enemy);
            nextSpawnTime = thisFrameTime + spawnInterval;
        }
    }
    
    private void spawn(Enemy enemy){
        int spawnX = enemy.getDestination().getX();
        int spawnY = enemy.getDestination().getY();
        getWorld().addObject(enemy, spawnX, spawnY);
    }
    
    private void incrementGridAssignment1(){
        if(gridCol1 >= 5){
            gridCol1 = 1;
            gridRow1++;
        } else {
            gridCol1++;
        }
    }
    
    private void incrementGridAssignment2(){
        if(gridCol2 >= 10){
            gridCol2 = 6;
            gridRow2++;
        } else {
            gridCol2++;
        }
    }
    
    private void incrementFinalX1AndY1(){
        if(finalX1 == 125){
            finalX1 = 25;
            finalY1 += 25;
        } else {
            finalX1 += 25;
        }
    }
    
    private void incrementFinalX2AndY2(){
        if(finalX2 == 250){
            finalX2 = 150;
            finalY2 += 25;
        } else {
            finalX2 += 25;
        }
    }
}
