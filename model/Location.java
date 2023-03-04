public class Location {
    //row - x pos
    private final int row;
    //colomn - y pos
    private final int col;

    /**
     * Creates a Location on the board
     * @param row x position on grid
     * @param col y position on grid
     */
    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }
}
