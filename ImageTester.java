import greenfoot.*;

/**
 * Write a description of class ImageTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageTester extends Actor{
    
    public ImageTester(){
        GreenfootImage image = new GreenfootImage(100, 100);
        image.setColor(Color.WHITE);
        image.drawRect(0, 0, 50, 50);
        setImage(image);
    }
    
    public void act(){
    }
}
