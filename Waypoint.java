/**
 * Represents a destination Location in an X, Y cordinate grid.
 * 
 * @author (Dave Coates) 
 * @version (October 13, 2018)
 */
public class Waypoint extends Location implements Cloneable{

    public Waypoint(int x, int y){
        super(x, y);
    }
    
    public Waypoint clone(){
        return new Waypoint(getX(), getY());
    }

}
