public class Location {
    private final int row;      //row - x pos
    private final int col;      //colomn - y pos
    private Bubble contents;    //null or bubble in the location

    /**
     * Creates a Location on the board
     * @param row x position on grid
     * @param col y position on grid
     */
    public Location(int row, int col){
        this.row = row;
        this.col = col;
        this.contents = null;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Bubble getContents() {
        return contents;
    }
}
