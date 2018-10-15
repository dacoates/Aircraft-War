import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor{
    
    private int velocity = 6;
    
    public Rocket(){
        setRotation(270);
        getImage().rotate(90);
        getImage().scale(22, 10);
    }
    
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        move(velocity);
        if(isTouching(Enemy.class)){
            Enemy enemy = (Enemy) getIntersectingObjects(Enemy.class).get(0);
            getWorld().getObjects(ScoreDisplay.class).get(0).add(enemy.getPointValue());
            removeTouching(Enemy.class);
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(this);
            return;
        }
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }    
}
