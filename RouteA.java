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
        int centerX = 150;
        addWaypoint(new Waypoint(centerX-50, 1));
        addWaypoint(new Waypoint(centerX-50, 30));
        addWaypoint(new Waypoint(centerX-48, 50));
        addWaypoint(new Waypoint(centerX-45, 60));
        addWaypoint(new Waypoint(centerX-39, 70));
        addWaypoint(new Waypoint(centerX-30, 80));
        addWaypoint(new Waypoint(centerX, 110));
        addWaypoint(new Waypoint(centerX+50, 150));
        addWaypoint(new Waypoint(centerX+62, 160));
        addWaypoint(new Waypoint(centerX+78, 170));
        addWaypoint(new Waypoint(centerX+88, 179));
        addWaypoint(new Waypoint(centerX+97, 183));
        addWaypoint(new Waypoint(centerX+105, 190));
        addWaypoint(new Waypoint(centerX+105, 190));
        addWaypoint(new Waypoint(centerX+115, 200));
        addWaypoint(new Waypoint(centerX+125, 215));
        addWaypoint(new Waypoint(centerX+134, 230));
        addWaypoint(new Waypoint(centerX+138, 240));
        addWaypoint(new Waypoint(centerX+140, 250));
        addWaypoint(new Waypoint(centerX+138, 260));
        addWaypoint(new Waypoint(centerX+136, 270));
        addWaypoint(new Waypoint(centerX+132, 280));
        addWaypoint(new Waypoint(centerX+120, 290));
        addWaypoint(new Waypoint(centerX+110, 296));
        addWaypoint(new Waypoint(centerX+95, 303));
        addWaypoint(new Waypoint(centerX+80, 304));
        addWaypoint(new Waypoint(centerX+55, 300));
        addWaypoint(new Waypoint(centerX+40, 290));
        addWaypoint(new Waypoint(centerX+29, 280));
        addWaypoint(new Waypoint(centerX+24, 270));
        addWaypoint(new Waypoint(centerX+23, 250));
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
