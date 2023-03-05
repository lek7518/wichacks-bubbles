import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Handles the arrow buttons being pushed
 * @author Carey McCollester
 */
public class ArrowButtonChanger implements EventHandler<ActionEvent>{
    private final BubbleGui gui;
    private final BubbleGame game;
    private final String direction;
    private boolean active;

    public ArrowButtonChanger(BubbleGui gui, BubbleGame game, String direction){
        this.gui = gui;
        this.game = game;
        this.direction = direction;
        this.active = true;
    }

    @Override
    public void handle(ActionEvent arg0) {
        if (active){
            game.makeMove(direction);

            String gameStatus = game.getGameStatus();
            gui.getStatusLabel().setText(gameStatus);

            if (gameStatus != "playable"){
                active = false;
            }
        }
    }
}
