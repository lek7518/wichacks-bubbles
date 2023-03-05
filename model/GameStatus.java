/**
 * Different statuses of the bubble game
 * @author Carey McCollester
 */
public enum GameStatus {
    WIN ("Congratulations you win!"),
    LOSS ("Sorry! You lost."),
    PLAYABLE ("Keep going!");

    private String message;

    private GameStatus(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
