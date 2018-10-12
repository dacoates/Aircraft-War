import java.util.*;

/**
 * Write a description of class FlightPlan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route  
{
    // instance variables - replace the example below with your own
    private ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();
    
    int currentWaypoint = 0;

    /**
     * Returns the first waypoint in this FlightPlan
     * 
     */
    public Waypoint getStartingWaypoint(){
        return waypoints.get(0);
    }
    
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
