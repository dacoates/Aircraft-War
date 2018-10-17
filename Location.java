/**
 * Represents a single X, Y coordinate location.
 * 
 * @author (Dave Coates) 
 * @version (October 13, 2018)
 */
public class Location implements Cloneable{

    private int x;
    private int y;
    
    public Location(){}

    /**
     * Constructor for objects of class Location
     */
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public Location clone(){
        return new Location(x, y);
    }
}
