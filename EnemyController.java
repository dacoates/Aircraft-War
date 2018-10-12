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
    long spawnInterval = 50; // .1 seconds
    long nextSpawnTime;
    int enemyCount = 0;
    private int finalX1 = 25;
    private int finalY1 = 25;
    private int finalX2 = 150;
    private int finalY2 = 25;
    int totalEnemyToSpawn = 50;
    Route routeA1, routeA2;
    
    public EnemyController(){
        routeA1 = getRouteA1();
        routeA2 = routeA1.getVerticalMirrorRoute(150);
    }
    
    
    /**
     * Act - do whatever the Enemy_Controller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        thisFrameTime = new java.util.Date().getTime();
        if(thisFrameTime >= nextSpawnTime && enemyCount < totalEnemyToSpawn){
            enemyCount++;
            Enemy enemy;
            Route routeA1;
            if(enemyCount % 2 == 0){
                routeA1 = getRouteA1();
                enemy = new Enemy(routeA1);
                enemy.setFinalDestination(new Waypoint(finalX2, finalY2));
                incrementFinalX2AndY2();
            } else {
                enemy = new Enemy(getRouteA1().getVerticalMirrorRoute(150));
                enemy.setFinalDestination(new Waypoint(finalX1, finalY1));
                incrementFinalX1AndY1();
            }
            spawn(enemy);
            nextSpawnTime = thisFrameTime + spawnInterval;
        }
        lastFrameTime = thisFrameTime;
    }
    
    private void spawn(Enemy enemy){
        getWorld().addObject(enemy, enemy.getDestination().getX(), enemy.getDestination().getY());
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
    
    public static Route getRouteA1(){
        Route route = new Route();
        int centerX = 150;
        route.addWaypoint(new Waypoint(centerX-50, 1));
        route.addWaypoint(new Waypoint(centerX-50, 30));
        route.addWaypoint(new Waypoint(centerX-48, 50));
        route.addWaypoint(new Waypoint(centerX-45, 60));
        route.addWaypoint(new Waypoint(centerX-39, 70));
        route.addWaypoint(new Waypoint(centerX-30, 80));
        route.addWaypoint(new Waypoint(centerX, 110));
        route.addWaypoint(new Waypoint(centerX+50, 150));
        route.addWaypoint(new Waypoint(centerX+62, 160));
        route.addWaypoint(new Waypoint(centerX+78, 170));
        route.addWaypoint(new Waypoint(centerX+88, 179));
        route.addWaypoint(new Waypoint(centerX+97, 183));
        route.addWaypoint(new Waypoint(centerX+105, 190));
        route.addWaypoint(new Waypoint(centerX+105, 190));
        route.addWaypoint(new Waypoint(centerX+115, 200));
        route.addWaypoint(new Waypoint(centerX+125, 215));
        route.addWaypoint(new Waypoint(centerX+134, 230));
        route.addWaypoint(new Waypoint(centerX+138, 240));
        route.addWaypoint(new Waypoint(centerX+140, 250));
        route.addWaypoint(new Waypoint(centerX+138, 260));
        route.addWaypoint(new Waypoint(centerX+136, 270));
        route.addWaypoint(new Waypoint(centerX+132, 280));
        route.addWaypoint(new Waypoint(centerX+120, 290));
        route.addWaypoint(new Waypoint(centerX+110, 296));
        route.addWaypoint(new Waypoint(centerX+95, 303));
        route.addWaypoint(new Waypoint(centerX+80, 304));
        route.addWaypoint(new Waypoint(centerX+55, 300));
        route.addWaypoint(new Waypoint(centerX+40, 290));
        route.addWaypoint(new Waypoint(centerX+29, 280));
        route.addWaypoint(new Waypoint(centerX+24, 270));
        route.addWaypoint(new Waypoint(centerX+23, 250));
        return route;
    }
}
