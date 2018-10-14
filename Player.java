import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Red here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int Vx = 0;
    private int Vy = 0;
    private boolean canFire;
    
    public Player(){
        getImage().scale(50, 50);
    }
    
    /**
     * Act - do whatever the Red wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (Greenfoot.isKeyDown("right")){
            Vx = 2;
        }    
        
        if (Greenfoot.isKeyDown("left")){
            Vx = -2;
        }
        
        if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")){
            Vx = 0;  
        }
        
        if (Greenfoot.isKeyDown("space") && canFire){
            Rocket rocket = new Rocket();
            getWorld().addObject(rocket, getX(), getY());
            canFire = false;
        }
        
        if (!Greenfoot.isKeyDown("space")){
            canFire = true;
        }
        
        setLocation(getX() + Vx, getY() + Vy);
       
    }    
}


