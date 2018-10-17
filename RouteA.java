/**
 * Write a description of class RouteA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RouteA extends Route 
{
    // instance variables - replace the example below with your own
    private int x;
    private static final int CELL_SIZE = GameConstants.WORLD_CELL_SIZE;

    /**
     * Constructor for objects of class RouteA
     */
    public RouteA(){
        int centerX = GameConstants.WORLD_WIDTH / 2;
        addWaypoint(new Waypoint(centerX-50 * 2 / CELL_SIZE, 1 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX-50 * 2 / CELL_SIZE, 30 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX-48 * 2 / CELL_SIZE, 50 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX-45 * 2 / CELL_SIZE, 60 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX-39 * 2 / CELL_SIZE, 70 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX-30 * 2 / CELL_SIZE, 80 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX, 110 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+50 * 2 / CELL_SIZE, 150 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+62 * 2 / CELL_SIZE, 160 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+78 * 2 / CELL_SIZE, 170 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+88 * 2 / CELL_SIZE, 179 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+97 * 2 / CELL_SIZE, 183 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+105 * 2 / CELL_SIZE, 190 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+105 * 2 / CELL_SIZE, 190 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+115 * 2 / CELL_SIZE, 200 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+125 * 2 / CELL_SIZE, 215 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+134 * 2 / CELL_SIZE, 230 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+138 * 2 / CELL_SIZE, 240 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+140 * 2 / CELL_SIZE, 250 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+138 * 2 / CELL_SIZE, 260 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+136 * 2 / CELL_SIZE, 270 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+132 * 2 / CELL_SIZE, 280 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+120 * 2 / CELL_SIZE, 290 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+110 * 2 / CELL_SIZE, 296 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+95 * 2 / CELL_SIZE, 303 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+80 * 2 / CELL_SIZE, 304 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+55 * 2 / CELL_SIZE, 300 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+40 * 2 / CELL_SIZE, 290 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+29 * 2 / CELL_SIZE, 280 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+24 * 2 / CELL_SIZE, 270 * 2 / CELL_SIZE));
        addWaypoint(new Waypoint(centerX+23 * 2 / CELL_SIZE, 250 * 2 / CELL_SIZE));
    }

}
