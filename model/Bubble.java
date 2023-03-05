/**
 * Represents a bubble
 * @author Carey McCollester
 * @author Lydia Klecan
 */
public class Bubble {
    private int twosize;    //twosize - bubble size 2 (2^1-11)
    
    /**
     * Creates new Bubble
     * @param twosize factor of 2 (2^1-11)
     * @param location location on grid
     */
    public Bubble(int twosize){
        this.twosize = twosize;
    }

    public int getTwosize() {
        return twosize;
    }

    /**
     * Multiplies twosize by 2 to simulate merging bubbles
     */
    public void merge(){
        twosize *= 2;
    }
}
