import java.util.Random;

/**
 * Game of merging bubbles
 * @author Carey McCollester
 */
public class BubbleGame {

    private final static int rows = 4;  //number of rows
    private final static int cols = 4;  //number of columns
    private final Random rand;          //Random generator

    private BubbleObserver observer;

    private Bubble[][] grid;    //locations not occupied by a bubble
    private String gameStatus;    //state of the game "win" "loss" "playable"

    /**
     * New instance of the bubble game
     */
    public BubbleGame(){
        this.grid = new Bubble[rows][cols];
        this.rand = new Random();
        this.gameStatus = "playable";
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
        observer.bubbleUpdated(row, col, bubble);
    }

    /**
     * Moves the bubbles on the board
     * @param direction "up", "down", "left" or "right"
     */
     public void makeMove(String direction){
        boolean validMove = false;

        for (int a = 0; a < rows; a++) {  //go through each spot on grid
            for (int b = 0; b < cols; b++) {
                int neighborCol = 0;
                int neighborRow = 0;
                int moveRow = 0;
                int moveCol = 0;

                int row = b;
                int col = a;
                if (direction == "down"){
                    col = (cols - 1) - a;

                    neighborCol = col + 1;
                    neighborRow = row;
                    moveRow = row;
                    moveCol = col + 1;
                }
                else if (direction == "up"){
                    neighborCol = col - 1;
                    neighborRow = row;
                    moveRow = row;
                    moveCol = col - 1;
                }
                else if (direction == "left"){
                    row = a;
                    col = b;

                    neighborCol = col;
                    neighborRow = row + 1;
                    moveRow = row - 1;
                    moveCol = col;
                }
                else {
                    row = (rows - 1) - a;
                    col = b;

                    neighborCol = col;
                    neighborRow = row - 1;
                    moveRow = row + 1;
                    moveCol = col;
                }

                //merging
                if(neighborRow >= 0 && neighborCol >= 0 && neighborRow < rows && neighborCol < cols){
                    if (grid[neighborRow][neighborCol] != null && grid[row][col] != null){
                        if (grid[neighborRow][neighborCol].getTwosize() == grid[row][col].getTwosize()){
                            grid[row][col].merge();
                            observer.bubbleUpdated(row, col, grid[row][col]);

                            grid[neighborRow][neighborCol] = null;
                            observer.bubbleUpdated(neighborRow, neighborCol, null);

                            validMove = true;
                        }
                    }
                }
                //moving
                if (moveRow >= 0 && moveCol >= 0 && moveRow < rows && moveCol < cols && grid[row][col] != null){
                    if (grid[moveRow][moveCol] == null){
                        grid[moveRow][moveCol] = grid[row][col];
                        observer.bubbleUpdated(moveRow, moveCol, grid[moveRow][moveCol]);

                        grid[row][col] = null;
                        observer.bubbleUpdated(row, col, null);

                        validMove = true;
                    }
                }
            }
        }
        if (validMove){
            spawnBubble();  //new bubble added after player makes move
        }
        updateGameStatus();
    }

    /**
     * Checks game status
     * @return "win", "loss" and "playable"
     */
    private void updateGameStatus(){
        int bubbleCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != null){
                    bubbleCount++;

                    if (grid[r][c].getTwosize() == 2048){
                        gameStatus = "win";
                        return;
                    }
                }
            }
        }

        if (bubbleCount != rows*cols){
            gameStatus = "playable";
            return;
        }
        else{
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int currentTwosize = grid[r][c].getTwosize();
                    int targetTwosize = 0;

                    if ((r - 1) >= 0){
                        targetTwosize = grid[r - 1][c].getTwosize();
                        if (targetTwosize == currentTwosize){
                            gameStatus = "playable";
                            return;
                        }
                    }
                    else if ((c - 1) >= 0){
                        targetTwosize = grid[r][c - 1].getTwosize();
                        if (targetTwosize == currentTwosize){
                            gameStatus = "playable";
                            return;
                        }
                    }
                    else if ((c + 1) < cols){
                        targetTwosize = grid[r][c + 1].getTwosize();
                        if (targetTwosize == currentTwosize){
                            gameStatus = "playable";
                            return;
                        }
                    }
                    else if ((r + 1) < rows){
                        targetTwosize = grid[r + 1][c].getTwosize();
                        if (targetTwosize == currentTwosize){
                            gameStatus = "playable";
                            return;
                        }
                    }
                }
            }
        }
        gameStatus = "loss";
    }

    public void startGame(){
        spawnBubble();
    }

    public int getCols() {
        return cols;
    }
    public int getRows() {
        return rows;
    }
    public String getGameStatus() {
        return gameStatus;
    }

    public void registerObserver(BubbleGui gui){
        observer = new BubbleChanger(this, gui);
    }
}