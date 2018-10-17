/**
 * Defines a turn as following a circle to the left or right with a specific radius and exit heading in degrees.
 * 
 * @author (Dave Coates) 
 * @version (October 14, 2018)
 */
public class Turn extends RouteLeg{
    
    public enum Direction {RIGHT, LEFT}
    private Direction direction;
    private float radius;
    private int exitRotation;

    /**
     * Constructor for objects of class Turn
     */
    public Turn(Direction direction, float radius, int exitRotation){
        this.direction = direction;
        this.radius = radius;
        this.exitRotation = exitRotation;
    }
    
    

}
