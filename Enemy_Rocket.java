import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Enemy_Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_Rocket extends Actor
{
    boolean aim = true;
    /**
     * Act - do whatever the Enemy_Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Explosion explosion = new Explosion();
        if (aim == true){
            List reds = getWorld().getObjects(Red.class);
            if(reds.size() >= 1){
                Red red = (Red)reds.get(0);
                turnTowards(red.getX(), red.getY());
                aim = false;
            } else {
                setRotation(90);
            }
        }
        if (isAtEdge()){
            getWorld().removeObject(this);
            return;
        }
        move(2);
        if (isTouching(Red.class)){
            removeTouching(Red.class);
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(this);
        }
    }    
}
