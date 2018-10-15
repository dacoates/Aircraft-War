import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class FrameRate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FrameRate extends Actor
{
    long lastFrameTime = new Date().getTime();
    long thisFrameTime = lastFrameTime;
    long lastDisplayTime = lastFrameTime;
    long displayInterval = 750; // Display every .75 seconds.
    
    public FrameRate(){
        setImage(new GreenfootImage("FPS:", 24, Color.RED, Color.BLACK));
    }
    
    /**
     * 
     */
    public void act(){
        thisFrameTime = new Date().getTime();
        long frameRate = 1000 / (thisFrameTime - lastFrameTime + 1); // avoid divide by zero error
        if(thisFrameTime - lastDisplayTime > displayInterval){
            setImage(new GreenfootImage("FPS:" + frameRate, 24, Color.RED, Color.BLACK));
            lastDisplayTime = thisFrameTime;
        }
        lastFrameTime = thisFrameTime;
    }
}
