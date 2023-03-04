public class Bubble {
    //twosize - bubble size 2 (2^1-11)
    private int twosize;
    //location - location on grid
    private Location location;
    
    /**
     * Creates new Bubble
     * @param twosize factor of 2 (2^1-11)
     * @param location location on grid
     */
    public Bubble(int twosize, Location location){
        this.twosize = twosize;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
    public int getTwosize() {
        return twosize;
    }

    /**
     * Moves location of the bubble
     * @param destination where the bubble is moved to
     */
    public void move(Location destination){
        location = destination;
    }
}
