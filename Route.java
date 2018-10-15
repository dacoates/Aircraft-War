import java.util.*;

/**
 * A list of Waypoints for an Enemy to follow that describe the path to be taken.
 * 
 * @author (Dave Coates) 
 * @version (October 2018)
 */
public class Route{

    private ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();
    int currentWaypoint = 0;

    /**
     * Returns the first waypoint in this Route regardless of what the next Waypoint is.
     */
    public Waypoint getStartingWaypoint(){
        return waypoints.get(0);
    }
    
    
    /**
     * Returns the next Waypoint in this rounte. Calling this method repeatedly will allow the calling class to consume
     * all Waypoints in the route.
     * @Return Returns null if there are no more Waypoints.
     */
    public Waypoint getNextWaypoint(){
       Waypoint nextWaypoint = waypoints.get(currentWaypoint++);
       if(currentWaypoint >= waypoints.size()){
           return null;
        }
       return nextWaypoint;
    }
    
    public Waypoint getCurrentWaypoint(){
        return waypoints.get(currentWaypoint);
    }
    
    public void addWaypoint(Waypoint w){
        waypoints.add(w);
    }
    
    public boolean isOver(){
        return currentWaypoint >= waypoints.size() - 1;
    }
    
    public boolean hasMoreWaypoints(){
        return !isOver();
    }
        
    public Route getVerticalMirrorRoute(int centerX){
        Route newRoute = new Route();
        for(int i = 0; i < waypoints.size(); i++){
            Waypoint wp = waypoints.get(i);
            newRoute.addWaypoint(new Waypoint(centerX + centerX - wp.getX(), wp.getY()));
        }
        return newRoute;
    }
}
