    import greenfoot.*;
    
    
public class Enemy extends Actor{
    
    private String id = "";
    private int velocity = GameConstants.DEFAULT_ENEMY_VELOCITY;
    private int turnRate = 23;
    private int turnExit = 270;
    public enum Mode{FOLLOW_ROUTE, GOING_TO_GRID_ASSIGNMENT, STAY_IN_GRID, ATTACK, LEFT_TURN, RIGHT_TURN}
    private Mode mode = Mode.FOLLOW_ROUTE;
    private Mode nextMode;
    private Route route;
    private Waypoint destination;
    private boolean canFire = false;
    private int fireProbability = 3;
    private GridController gridController;
    private int gridRow;
    private int gridCol;
    private long thisFrameTime = 0;
    private long turnInterval = 30;
    private long nextTurnTime = 0;
    private int pointValue = GameConstants.DEFAULT_ENEMY_POINT_VALUE;
  
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
    
    public void setFireMode(boolean enable){
        this.canFire = enable;
    }
    
    public Waypoint getDestination(){
        return destination.clone();
    }
    
    public void turnTowards(Location location){
        turnTowards(location.getX(), location.getY());
    }
    
    public void turnTowards(Waypoint waypoint){
        turnTowards(waypoint.getLocation());
    }
    
    public void act(){
        thisFrameTime = new java.util.Date().getTime();
        if(mode == Mode.RIGHT_TURN){
            if(thisFrameTime >= nextTurnTime){
                setRotation((getRotation() + turnRate ) % 360);
                nextTurnTime = thisFrameTime + turnInterval;
            }
            move(velocity);
            if(getRotation() >= turnExit - turnRate  && getRotation() <= turnExit + turnRate){
                mode = nextMode;
            }
        }
        if(mode == Mode.LEFT_TURN){
            if(thisFrameTime >= nextTurnTime){
                setRotation((getRotation() - turnRate) % 360);
                nextTurnTime = thisFrameTime + turnInterval;
            }
            move(velocity);
            if(getRotation() >= turnExit - turnRate && getRotation() <= turnExit + turnRate){
                mode = nextMode;
            }
        }
        if(mode == Mode.FOLLOW_ROUTE){
            if(hasReached(destination) && !route.isOver()){
                destination = route.getNextWaypoint();
            }
            if(hasReached(destination) && route.isOver()){
                destination = new Waypoint(gridController.getAssignmentLocation(gridRow, gridCol));
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
                canFire = true;
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
    
    private void setLocation(Location location){
        setLocation(location.getX(), location.getY());
    }
    
    private boolean hasReached(Location location){
        if(mode == Mode.FOLLOW_ROUTE && hasReached(530, 400)){
            mode = Mode.RIGHT_TURN;
            nextMode = Mode.GOING_TO_GRID_ASSIGNMENT;
        }
        if(mode == Mode.FOLLOW_ROUTE && hasReached(70, 400)){
            mode = Mode.LEFT_TURN;
            nextMode = Mode.GOING_TO_GRID_ASSIGNMENT;
        }
        return hasReached(location.getX(), location.getY());
    }
    
    private boolean hasReached(Waypoint waypoint){
        return hasReached(waypoint.getLocation());
    }
    
    
    private boolean hasReached(int x, int y){
        double x1 = (double)x;
        double y1 = (double)y;
        double x2 = (double)getX();
        double y2 = (double)getY();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance < Math.ceil(velocity * .9); // If within 90% of your velocity to target, then consider target reached.
    }
    
    public int getPointValue(){
        return this.pointValue;
    }
    
    public void setPointVAlue(int pointValue){
        this.pointValue = pointValue;
    }
}
