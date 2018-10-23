import greenfoot.*;
import static java.lang.Math.*;

/**
 * A calculator class that will calculate the next point along the circumference of a circle of a turn.
 * 
 * @author (Dave Coates) 
 * @version (October 16, 2018)
 */
public class TurnCalculator{

    private Turn turn;
    private Location startLocation;
    private double startTheta;
    private double currentTheta;
    private double exitTheta;
    
    private double nextTheta;
    private double lastTheta;
    private double thetaToCenter;
    private double centerX;
    private double centerY;
    private double circumference;
    //private double deltaTheta;
    int testCounter = 0; 

    public TurnCalculator(Turn turn, Location start, int currentRotation){
        this.turn = turn;
        exitTheta = (turn.getExitRotation() - 90);
        startLocation = new Location(start.getX(), start.getY());
        double currentHeadingDeg = currentRotation;
        if(turn.getDirection() == Turn.Direction.RIGHT){
            thetaToCenter = (currentHeadingDeg + 90) % (360);
            startTheta = (thetaToCenter + 180) % (360);      
        } else {
            thetaToCenter = (currentHeadingDeg - 90) % (360);
            startTheta = (thetaToCenter - 180) % (360);
        }
        currentTheta = startTheta;
        circumference = 2 * PI * turn.getRadius();
        centerX = startLocation.getX() + turn.getRadius() * cos(thetaToCenter * PI / 180);
        centerY = startLocation.getY() + turn.getRadius() * sin(thetaToCenter * PI / 180);
        System.out.println("Start: " +startLocation);
        System.out.println("Current rotation: " +currentHeadingDeg);
        System.out.println("Exit theta: " +exitTheta);
        System.out.println(turn.direction +" radius: " +turn.getRadius());
        System.out.println("thetaToCenter: " +thetaToCenter);
        System.out.println("Center: " +round(centerX) +", " +round(centerY));
        System.out.println("firstTheta: " +startTheta);
        System.out.println("");
    }
    
    public void testPointsOfTurn(World world, int move){
        while(true){ //!isExitTheta(currentTheta)){
            System.out.println(getNextLocation(5));
        }
    }
    
    public int getRotation(){
        double rotation = (currentTheta - 90) % (360);
        int rounded = (int) round(rotation);
        System.out.println("rotation: " +rotation +", rounded: " +rounded);
        return rounded;
    }
    
    public Location getNextLocation(int move){
        if(turn.direction == Turn.Direction.RIGHT){
            nextTheta = currentTheta - (move / circumference) * 360;
            System.out.println("nextTheta RIGHT: " + round(nextTheta));
        }else{
            nextTheta = currentTheta + (move / circumference) * 360;
            //System.out.println("nextTheta LEFT: " + round(nextTheta * 180 / PI));
        }
        if(isExitTheta(nextTheta)){ // Then we have reached exitTheta so turn is over
            return null;
        } else {
            currentTheta = nextTheta;
            int x = (int) round(centerX + turn.getRadius() * sin(nextTheta * PI / 180));
            int y = (int) round(centerY + turn.getRadius() * cos(nextTheta * PI / 180));
                System.out.println("nextTheta: " +round(nextTheta) 
                  //+", x, y, " +x +", " +y 
                    +" ,exitTheta = " +round(exitTheta) 
                    +" delta: " +round(delta)
                    +" ,rotation = " +getRotation() 
                );
                System.out.println(x +", " +y);
            return new Location(x, y);
        }
    }
    
    double delta;
    double range;
    private boolean isExitTheta(double theta){
        delta = abs(theta - exitTheta);
        range = 2 * PI / 360;
        boolean done = delta <= range;
        if(done){
            System.out.println("Done: delta: " +delta +", range: " +range);
            return true;
        } else {
            //System.out.println("   delta: " +delta +", range: " +range);
            return false;
        }
    }
    
    
        
}
