import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Handles the arrow buttons being pushed
 * @author Carey McCollester
 * @author Lydia Klecan
 */
public class ArrowButtonChanger implements EventHandler<ActionEvent>{
    private final BubbleGame game;
    private final String direction;

    public ArrowButtonChanger(BubbleGame game, String direction){
        this.game = game;
        this.direction = direction;
    }

    @Override
    public void handle(ActionEvent arg0) {
        game.makeMove(direction);
    }
}
