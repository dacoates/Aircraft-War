import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    int timer = 0;
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer = timer % 5;
        timer = timer + 1;

        if (timer == 0){
            setImage("Explosion 2.gif");
        }
        else if(timer == 1){
            setImage("Explosion 3.gif");
        }
        else if(timer == 2){
            setImage("Explosion 4.gif");
        }
        else if(timer == 3){
            setImage("Explosion 5.gif");
        }
        else{
            setImage("Explosion 6.gif");
            Greenfoot.delay(1);
            getWorld().removeObject(this);
        }
        
        Greenfoot.delay(1);
    }    
}


