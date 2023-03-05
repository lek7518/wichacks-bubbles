import java.util.Random;

public class BubbleGame {

    private final static int rows = 4;  //number of rows
    private final static int cols = 4;  //number of columns
    private final Random rand;          //Random generator

    private BubbleObserver observer;

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

    /**
     * Moves the bubbles on the board
     * @param direction "up", "down", "left" or "right"
     */
     private void makeMove(String direction){
        for (int row = 0; row < rows; row++) {  //go thhrough each spot on grid
            for (int col = 0; col < cols; col++) {
                int neighborCol = 0;
                int neighborRow = 0;
                int moveRow = 0;
                int moveCol = 0;

                if (direction == "right"){
                    row = (rows - 1) - row;     //right to left
                    neighborCol = col - 1;
                    neighborRow = row;
                    moveRow = row;
                    moveCol = col + 1;
                }
                else if (direction == "left"){
                    neighborCol = col + 1;
                    neighborRow = row;
                    moveRow = row;
                    moveCol = col - 1;
                }
                else if (direction == "down"){
                    col = (cols - 1) - col;     //bottom to top
                    neighborCol = col;
                    neighborRow = row - 1;
                    moveRow = row + 1;
                    moveCol = col;
                }
                else {
                    neighborCol = col;
                    neighborRow = row + 1;
                    moveRow = row - 1;
                    moveCol = col;
                }

                //merging
                if(neighborRow >= 0 && neighborCol >= 0 && neighborRow < rows 
                        && neighborCol < cols){
                    if (grid[neighborRow][neighborCol] != null){
                        if (grid[neighborRow][neighborCol].getTwosize() == grid[row][col].getTwosize()){
                            grid[row][col].merge();
                            grid[neighborRow][neighborCol] = null;
                        }
                    }
                }
                //moving
                if (moveRow >= 0 && moveCol >= 0 && moveRow < rows && moveCol < cols){
                    if (grid[moveRow][moveCol] == null){
                        grid[moveRow][moveCol] = grid[row][col];
                        grid[row][col] = null;
                    }
                }
            }
        }
    }

    public void registerObserver(BubbleGui gui){
        observer = new BubbleChanger(this, gui);
    }
}