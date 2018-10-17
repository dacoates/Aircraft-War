/**
 * An x and y grid location in the world that can be used in a route.
 * 
 * @author (Dave Coates) 
 * @version (October 16, 2018)
 */
public class Waypoint extends RouteLeg implements Cloneable{

    private Location location;

    /**
     * Constructor for objects of class Waypoint
     */
    public Waypoint(int x, int y){
        location = new Location(x, y);
    }
    
    public Waypoint(Location destination){
        location = destination;
    }
    
    public Waypoint(){
        location = new Location();
    }
    
    public Location getLocation(){
        return location.clone();
    }
    
    public Waypoint clone(){
        return new Waypoint(location.getX(), location.getY());
    }
}
