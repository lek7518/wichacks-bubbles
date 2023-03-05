import javafx.scene.image.ImageView;

/**
 * Observes a bubble
 * @author Carey McCollester
 */
public class BubbleChanger implements BubbleObserver{
    private BubbleGame game;        //Bubble game
    private BubbleGui gui;          //GUI of the bubble game
    private ImageView images[][];   //images in their respective grid position

    /**
     * Creates new BubbleChanger for observing the bubbles
     * @param game BubbleGame game
     * @param gui  BubbleGUI gui
     */
    public BubbleChanger(BubbleGame game, BubbleGui gui){
        this.game = game;
        this.gui = gui;

        this.images = new ImageView[game.getRows()][game.getCols()];
    }

    @Override
    public void bubbleUpdated(int row, int col, Bubble bubble) {
        int twosize = 0;
        if (bubble != null){
            twosize = bubble.getTwosize();
        }

        switch (twosize) {
            case 2:
                
                break;

            case 4:
                
                break;

            case 8:
                
                break;

            case 16:
                
                break;
            
            case 32:
                
                break;

            case 64:

                break;

            case 128:

                break;

            case 256:

                break;

            case 512:

                break;

            case 1024:

                break;

            case 2048:

                break;
        
            default:    //null 0 no bubble
                
                break;
        }
    }
}