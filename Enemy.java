    import greenfoot.*;
    
    
public class Enemy extends Actor{
    
    private int velocity = 2;
    private int centerX = 150;
    public enum Mode{FOLLOW_ROUTE, GOING_TO_FINAL_DESTINATION, STAY_IN_GRID, ATTACK}
    private Mode mode = Mode.FOLLOW_ROUTE;
    private Route route;
    private Waypoint destination;
    private Waypoint finalDestination;
    
    public Enemy(Route route){
        this.route = route;
        destination = route.getNextWaypoint();
        finalDestination = new Waypoint(250, 1);
        mode = Mode.FOLLOW_ROUTE;
    }
    
    public void setFinalDestination(Waypoint finalDestination){
        this.finalDestination = finalDestination;
    }
    
    public Waypoint getDestination(){
        return destination.clone();
    }
    
    public void turnTowards(Waypoint waypoint){
        turnTowards(waypoint.getX(), waypoint.getY());
    }
    
    public void act(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        if(mode == Mode.FOLLOW_ROUTE){
            if(hasReached(destination) && !route.isOver()){
                destination = route.getNextWaypoint();
            }
            if(hasReached(destination) && route.isOver()){
                destination = finalDestination;
                mode = Mode.GOING_TO_FINAL_DESTINATION;
            }
            turnTowards(destination);
            move(velocity);
        }
        if(mode == Mode.GOING_TO_FINAL_DESTINATION){
            if(!hasReached(finalDestination)){
                turnTowards(finalDestination);
                move(velocity);
            }
            if(hasReached(finalDestination)){
                velocity = 0;
                setRotation(90); // face down toward player
                mode = Mode.STAY_IN_GRID;
            }
        }
        if(mode == Mode.STAY_IN_GRID){
            setLocation(finalDestination);
            setRotation(90);
        }
    }
    
    private void setLocation(Waypoint waypoint){
        setLocation(waypoint.getX(), waypoint.getY());
    }
    
    private boolean hasReached(Waypoint waypoint){
        return hasReached(waypoint.getX(), waypoint.getY());
    }
    
    private boolean hasReached(int x, int y){
        //return x == getX() && y == getY();
        
        double x1 = (double)x;
        double y1 = (double)y;
        double x2 = (double)getX();
        double y2 = (double)getY();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance < Math.ceil(velocity * .9); // If within 90% of your velocity to target, then consider target reached.
        
    }
}
