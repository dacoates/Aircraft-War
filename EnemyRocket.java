import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Enemy_Rocket here.
 * 
 * @author (Devon Coates) 
 * @version (October, 13, 2018)
 */
public class EnemyRocket extends Actor{
    
    boolean canAim = false;
    

    
    public EnemyRocket(){
        super();
        setRotation(90);
    }
    
    public void enableTargetAquisition(boolean enabled){
        this.canAim = enabled;
    }
    
    /**
     * Act - do whatever the Enemy_Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Explosion explosion = new Explosion();
        if (canAim == true){
            List reds = getWorld().getObjects(Player.class);
            if(reds.size() >= 1){
                Player red = (Player)reds.get(0);
                turnTowards(red.getX(), red.getY());
                canAim = false;
            } else {
                setRotation(90);
            }
        }
        if (isAtEdge()){
            getWorld().removeObject(this);
            return;
        }
        move(2);
        if (isTouching(Player.class)){
            removeTouching(Player.class);
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(this);
        }
    }    
}
