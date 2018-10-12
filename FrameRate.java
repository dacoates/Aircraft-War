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
    /**
     * Act - do whatever the FrameRate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        thisFrameTime = new Date().getTime();
        long frameRate = 1000 / (thisFrameTime - lastFrameTime);
        if(thisFrameTime - lastDisplayTime > displayInterval){
            setImage(new GreenfootImage("" + frameRate, 36, Color.WHITE, Color.BLACK));
            lastDisplayTime = thisFrameTime;
        }
        lastFrameTime = thisFrameTime;
    }
}
