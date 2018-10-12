import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start1 extends Actor
{
    /**
     * Act - do whatever the Start1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Stars());
        }
        if (Greenfoot.getMouseInfo() != null &&
            Greenfoot.getMouseInfo() != null &&
            Greenfoot.getMouseInfo().getX() > getX() - getImage().getWidth() / 2 &&
            Greenfoot.getMouseInfo().getX() < getX() + getImage().getWidth() / 2 &&
            Greenfoot.getMouseInfo().getY() > getY() - getImage().getHeight() / 2 &&
            Greenfoot.getMouseInfo().getY() < getY() + getImage().getHeight() / 2){
                setImage("Start 2.gif");
        }
       
        else{
            setImage("Start.gif");
        }

    }
}

