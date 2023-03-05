import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ArrowKeyChanger implements EventHandler<KeyEvent> {
    private final BubbleGui gui;
    private final BubbleGame game;
    private boolean active;

    public ArrowKeyChanger(BubbleGui gui, BubbleGame game){
        this.gui = gui;
        this.game = game;
        this.active = true;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode key = event.getCode();

        if (key == KeyCode.UP){
            game.makeMove("up");
        }
        else if (key == KeyCode.DOWN){
            game.makeMove("down");
        }
        else if (key == KeyCode.RIGHT){
            game.makeMove("right");
        }
        else if (key == KeyCode.LEFT){
            game.makeMove("left");
        }

        GameStatus gameStatus = game.getGameStatus();
            gui.getStatusLabel().setText(gameStatus.toString());

            if (gameStatus != GameStatus.PLAYABLE){
                active = false;
            }
    }
    
}
