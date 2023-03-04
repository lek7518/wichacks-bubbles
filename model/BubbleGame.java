import java.util.Random;

public class BubbleGame {

    private final static int rows = 4;  //number of rows
    private final static int cols = 4;  //number of columns
    private final Random rand;          //Random generator
    
    private Bubble[][] grid;    //locations not occupied by a bubble

    /**
     * New instance of the bubble game
     */
    public BubbleGame(){
        this.grid = new Bubble[rows][cols];
        this.rand = new Random();

        spawnBubble();
    }

    private void spawnBubble(){
        //get random twosize
        int twosize = rand.nextInt(1, 3); //1 or 2
        twosize = twosize * 2;  //2 or 4

        //get random open location
        Bubble destination = new Bubble(2);
        int row = 0;
        int col = 0;
        while (destination != null){
            row = rand.nextInt(rows);
            col = rand.nextInt(cols);

            destination = grid[row][col];
        }

        //make bubble
        Bubble bubble = new Bubble(twosize);
        grid[row][col] = bubble;
    }

    // /**
    //  * Moves the bubbles on the board
    //  * @param direction "up", "down", "left" or "right"
    //  */
    // private void move(String direction){
    //     int positionModifier = -1;
    //     if (direction == "up" || direction == "right"){
    //         positionModifier = 1;
    //     }
    // }
}