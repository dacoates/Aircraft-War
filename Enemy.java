    import greenfoot.*;
    
    
public class Enemy extends Actor{
    
    private String id = "";
    private int velocity = GameConstants.DEFAULT_ENEMY_VELOCITY;
    private int turnRadius = 300;
    public enum Mode{FOLLOW_ROUTE, GOING_TO_GRID_ASSIGNMENT, STAY_IN_GRID, ATTACK, LEFT_TURN, RIGHT_TURN}
    private Mode mode = Mode.FOLLOW_ROUTE;
    private Mode nextMode;
    private Route route;
    private Location destination;
    private boolean canFire = true;
    private int fireProbability = 3;
    private GridController gridController;
    private int gridRow;
    private int gridCol;
  
    public Enemy(Route route){
        this.route = route;
        destination = route.getNextWaypoint();
        mode = Mode.FOLLOW_ROUTE;
        getImage().scale(50, 50);
    }
    
    public void setGridController(GridController gridController, int row, int col){
        this.gridController = gridController;
        this.gridRow = row;
        this.gridCol = col;
    }
    
    public Location getDestination(){
        return destination.clone();
    }
    
    public void turnTowards(Location waypoint){
        turnTowards(waypoint.getX(), waypoint.getY());
    }
    
    public void act(){
        if(mode == Mode.RIGHT_TURN){
            setRotation(getRotation() + 360 / turnRadius * velocity);
            move(velocity);
            if(getRotation() >= 270 - 360 / turnRadius && getRotation() <= 270 + 360 / turnRadius){
                mode = nextMode;
            }
        }
        if(mode == Mode.LEFT_TURN){
            setRotation(getRotation() - 360 / turnRadius * velocity);
            move(velocity);
            if(getRotation() >= 270 - 360 / turnRadius && getRotation() <= 270 + 360 / turnRadius){
                mode = nextMode;
            }
        }
        if(mode == Mode.FOLLOW_ROUTE){
            if(hasReached(destination) && !route.isOver()){
                destination = route.getNextWaypoint();
            }
            if(hasReached(destination) && route.isOver()){
                destination = gridController.getAssignmentLocation(gridRow, gridCol);
                mode = Mode.GOING_TO_GRID_ASSIGNMENT;
            }
            turnTowards(destination);
            move(velocity);
        }
        if(mode == Mode.GOING_TO_GRID_ASSIGNMENT){
            if(!hasReached(gridController.getAssignmentLocation(gridRow, gridCol))){
                turnTowards(gridController.getAssignmentLocation(gridRow, gridCol));
                move(velocity);
            }
            if(hasReached(gridController.getAssignmentLocation(gridRow, gridCol))){
                velocity = 0;
                setRotation(90); // face down toward player
                mode = Mode.STAY_IN_GRID;
            }
        }
        if(mode == Mode.STAY_IN_GRID){
            //setLocation(finalDestination);
            setLocation(gridController.getAssignmentLocation(gridRow, gridCol));
            setRotation(90);
        }
        if(Greenfoot.getRandomNumber(10000) < fireProbability && canFire){
            getWorld().addObject(new EnemyRocket(), getX(), getY());
            canFire = false;
        }  
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    private void setLocation(Location waypoint){
        setLocation(waypoint.getX(), waypoint.getY());
    }
    
    private boolean hasReached(Location waypoint){
        if(mode == Mode.FOLLOW_ROUTE && hasReached(530, 400)){
            mode = Mode.RIGHT_TURN;
            nextMode = Mode.GOING_TO_GRID_ASSIGNMENT;
        }
        if(mode == Mode.FOLLOW_ROUTE && hasReached(70, 400)){
            mode = Mode.LEFT_TURN;
            nextMode = Mode.GOING_TO_GRID_ASSIGNMENT;
        }
        return hasReached(waypoint.getX(), waypoint.getY());
    }
    
    private boolean hasReached(int x, int y){
        double x1 = (double)x;
        double y1 = (double)y;
        double x2 = (double)getX();
        double y2 = (double)getY();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance < Math.ceil(velocity * .9); // If within 90% of your velocity to target, then consider target reached.
    }
}
