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
        exitTheta = (turn.getExitRotation() - 90) * PI / 180;
        startLocation = new Location(start.getX(), start.getY());
        double currentHeadingDeg = currentRotation;
        double currentHeadingRad = currentHeadingDeg * PI / 180;
        if(turn.getDirection() == Turn.Direction.RIGHT){
            thetaToCenter = (currentHeadingRad + (PI/2)) % (2 * PI);
            startTheta = (thetaToCenter + PI) % (2 * PI);      
        } else {
            thetaToCenter = (currentHeadingRad - (PI/2)) % (2 * PI);
            startTheta = (thetaToCenter - PI) % (2 * PI);
        }
        currentTheta = startTheta;
        circumference = 2 * PI * turn.getRadius();
        centerX = startLocation.getX() + turn.getRadius() * cos(thetaToCenter);
        centerY = startLocation.getY() + turn.getRadius() * sin(thetaToCenter);
        System.out.println("Start: " +startLocation);
        System.out.println("Current rotation: " +currentHeadingRad * 180 / PI);
        System.out.println("Exit theta: " +exitTheta * 180 / PI);
        System.out.println(turn.direction +" radius: " +turn.getRadius());
        System.out.println("thetaToCenter: " +thetaToCenter * 180 / PI);
        System.out.println("Center: " +round(centerX) +", " +round(centerY));
        System.out.println("firstTheta: " +startTheta * 180 / PI);
        System.out.println("");
    }
    
    public void testPointsOfTurn(World world, int move){
        while(true){ //!isExitTheta(currentTheta)){
            System.out.println(getNextLocation(5));
        }
    }
    
    public int getRotation(){
        double rotation = (currentTheta - PI) % (2 * PI);
        System.out.println("rotation (rad): " +rotation +", rotation (deg): " + rotation * 180 / PI);
        int rounded = (int) round(rotation * 180 / PI);
        System.out.println("rounded: " +rounded);
        return rounded;
    }
    
    public Location getNextLocation(int move){
        //System.out.println("\ngetNextLocation(" +move +") currentTheta: " +round(currentTheta * 180 / PI));
        if(turn.direction == Turn.Direction.RIGHT){
            nextTheta = currentTheta - (move / circumference) / 2 * PI;
            System.out.println("nextTheta RIGHT: " + round(nextTheta * 180 / PI));
        }else{
            nextTheta = currentTheta + (move / circumference) / 2 * PI;
            //System.out.println("nextTheta LEFT: " + round(nextTheta * 180 / PI));
        }
        if(isExitTheta(nextTheta)){ // Then we have reached exitTheta so turn is over
            return null;
        } else {
            currentTheta = nextTheta;
            int x = (int) round(centerX + turn.getRadius() * sin(nextTheta));
            int y = (int) round(centerY + turn.getRadius() * cos(nextTheta));
            //System.out.println("Next turn Location: " +x +", " +y);
//            if(testCounter++ > 100)

                System.out.println("nextTheta: " +round(nextTheta * 180 / PI) 
                    +", x, y, " +x +", " +y 
                    +" ,exitTheta = " +round(exitTheta * 180 / PI) 
                    +" delta: " +round(delta * 180 / PI)
                );
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
            System.out.println("   delta: " +delta +", range: " +range);
            return false;
        }
    }
    
    
        
}
