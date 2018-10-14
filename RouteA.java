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

    /**
     * Constructor for objects of class RouteA
     */
    public RouteA(){
        int centerX = GameConstants.WORLD_WIDTH / 2;
        addWaypoint(new Waypoint(centerX-50*2, 1*2));
        addWaypoint(new Waypoint(centerX-50*2, 30*2));
        addWaypoint(new Waypoint(centerX-48*2, 50*2));
        addWaypoint(new Waypoint(centerX-45*2, 60*2));
        addWaypoint(new Waypoint(centerX-39*2, 70*2));
        addWaypoint(new Waypoint(centerX-30*2, 80*2));
        addWaypoint(new Waypoint(centerX, 110*2));
        addWaypoint(new Waypoint(centerX+50*2, 150*2));
        addWaypoint(new Waypoint(centerX+62*2, 160*2));
        addWaypoint(new Waypoint(centerX+78*2, 170*2));
        addWaypoint(new Waypoint(centerX+88*2, 179*2));
        addWaypoint(new Waypoint(centerX+97*2, 183*2));
        addWaypoint(new Waypoint(centerX+105*2, 190*2));
        addWaypoint(new Waypoint(centerX+105*2, 190*2));
        addWaypoint(new Waypoint(centerX+115*2, 200*2));
        addWaypoint(new Waypoint(centerX+125*2, 215*2));
        addWaypoint(new Waypoint(centerX+134*2, 230*2));
        addWaypoint(new Waypoint(centerX+138*2, 240*2));
        addWaypoint(new Waypoint(centerX+140*2, 250*2));
        addWaypoint(new Waypoint(centerX+138*2, 260*2));
        addWaypoint(new Waypoint(centerX+136*2, 270*2));
        addWaypoint(new Waypoint(centerX+132*2, 280*2));
        addWaypoint(new Waypoint(centerX+120*2, 290*2));
        addWaypoint(new Waypoint(centerX+110*2, 296*2));
        addWaypoint(new Waypoint(centerX+95*2, 303*2));
        addWaypoint(new Waypoint(centerX+80*2, 304*2));
        addWaypoint(new Waypoint(centerX+55*2, 300*2));
        addWaypoint(new Waypoint(centerX+40*2, 290*2));
        addWaypoint(new Waypoint(centerX+29*2, 280*2));
        addWaypoint(new Waypoint(centerX+24*2, 270*2));
        addWaypoint(new Waypoint(centerX+23*2, 250*2));
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
