import java.util.HashSet;
import java.util.Set;

public class BubbleGame {

    private final static int rows = 4;  //number of rows
    private final static int cols = 4;   //number of columns
    
    private Set<Location> openLocations;    //locations not occupied by a bubble
    private Bubble[] bubbles;               //bubbles active in game

    /**
     * New instance of the bubble game
     */
    public BubbleGame(){
        this.openLocations = new HashSet<>();
        this.bubbles = new Bubble[rows*cols];
    }
}