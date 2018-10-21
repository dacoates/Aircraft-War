import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TurnTester extends Actor{
    
    TurnCalculator calc;
    boolean tested = false;
    
    public TurnTester(){
        Turn turn = new Turn(Turn.Direction.RIGHT, 10f, 270);
        Location start = new Location(0, 0);
        int currentRotation = 45;
        int exitRotation = 270;
        calc = new TurnCalculator(turn, start, currentRotation);
    }

    public void act(){
        if(!tested){
            calc.testPointsOfTurn(getWorld(), 5);
            tested = true;
        }
    }    
}
