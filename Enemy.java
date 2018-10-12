    import greenfoot.*;
    
    
public class Enemy extends Actor{
    
    private int velocity = 4;
    private int centerX = 150;
    private int finalX = 25;
    private int finalY = 25;
    public enum Mode{FOLLOW_ROUTE, GOING_TO_FINAL_DESTINATION, STAY_IN_GRID, ATTACK}
    private Mode mode = Mode.FOLLOW_ROUTE;
    private Route route;
    private Waypoint destination;
    private Waypoint finalDestination;
    
    public Enemy(){
        route = new Route();
        route.addWaypoint(new Waypoint(centerX-50, 1));
        route.addWaypoint(new Waypoint(centerX-50, 30));
        route.addWaypoint(new Waypoint(centerX-48, 50));
        route.addWaypoint(new Waypoint(centerX-45, 60));
        route.addWaypoint(new Waypoint(centerX-39, 70));
        route.addWaypoint(new Waypoint(centerX-30, 80));
        route.addWaypoint(new Waypoint(centerX, 110));
        route.addWaypoint(new Waypoint(centerX+50, 150));
        route.addWaypoint(new Waypoint(centerX+105, 190));
        route.addWaypoint(new Waypoint(centerX+115, 200));
        route.addWaypoint(new Waypoint(centerX+125, 215));
        route.addWaypoint(new Waypoint(centerX+134, 230));
        route.addWaypoint(new Waypoint(centerX+138, 240));
        route.addWaypoint(new Waypoint(centerX+140, 250));
        route.addWaypoint(new Waypoint(centerX+138, 260));
        route.addWaypoint(new Waypoint(centerX+136, 270));
        route.addWaypoint(new Waypoint(centerX+132, 280));
        route.addWaypoint(new Waypoint(centerX+120, 290));
        route.addWaypoint(new Waypoint(centerX+110, 296));
        route.addWaypoint(new Waypoint(centerX+95, 303));
        route.addWaypoint(new Waypoint(centerX+80, 304));
        route.addWaypoint(new Waypoint(centerX+55, 300));
        route.addWaypoint(new Waypoint(centerX+40, 290));
        route.addWaypoint(new Waypoint(centerX+29, 280));
        route.addWaypoint(new Waypoint(centerX+24, 270));
        route.addWaypoint(new Waypoint(centerX+23, 250));
        destination = route.getNextWaypoint();
        finalDestination = new Waypoint(25, 25);
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
