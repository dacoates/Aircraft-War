import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() - 10);
        Rocket rocket = new Rocket();
        Enemy enemy1 = new Enemy();
        if (isAtEdge()){
            getWorld().removeObject(this);
            return;
        }
        if (isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            Explosion e = new Explosion();
            getWorld().addObject(e, getX(), getY());
            getWorld().removeObject(this);
            return;
        }
    }    
}
