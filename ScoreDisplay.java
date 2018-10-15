import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Track and display the palyer's score
 * 
 * @author (Davie Coates) 
 * @version (October 14, 2018)
 */
public class ScoreDisplay extends Actor{
    
    private long score = 0;
    
    public ScoreDisplay(){
        setImage(new GreenfootImage("Score:", 24, Color.RED, Color.BLACK));
    }

    public void act(){
        setImage(new GreenfootImage("Score:" + score, 24, Color.RED, Color.BLACK));
    }    
    
    public void add(int score){
        this.score += score;
    }
}
