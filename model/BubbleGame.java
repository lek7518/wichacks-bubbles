import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BubbleGame {

    private final static int rows = 4;  //number of rows
    private final static int cols = 4;  //number of columns
    private final Random rand;          //Random generator
    
    private Location[] openLocations;    //locations not occupied by a bubble
    private Set<Bubble> bubbles;               //bubbles active in game

    /**
     * New instance of the bubble game
     */
    public BubbleGame(){
        this.openLocations = new Location[rows*cols];
        this.bubbles = new HashSet<>();
        this.rand = new Random();

        setUpOpenLocations();
        spawnBubble();
    }

    /**
     * Sets up all locations and places them in openLocations
     */
    private void setUpOpenLocations(){
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Location gridLocation = new Location(r, c);

                openLocations[index] = gridLocation;
                index++;
            }
        }
    }

    private void spawnBubble(){
        //get random twosize
        int twosize = rand.nextInt(1, 3); //1 or 2
        twosize = twosize * 2;  //2 or 4

        //get random open location
        Location destination = null;
        int index = 0;
        while (destination == null){
            index = rand.nextInt(openLocations.length);
            destination = openLocations[index];
        }
        openLocations[index] = null;

        //make bubble
        Bubble bubble = new Bubble(twosize, destination);
        bubbles.add(bubble);
    }
}