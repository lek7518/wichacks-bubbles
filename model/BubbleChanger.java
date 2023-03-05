/**
 * Observes a bubble
 * @author Carey McCollester
 */
public class BubbleChanger implements BubbleObserver{
    private BubbleGame game;    //Bubble game
    private BubbleGui gui;      //GUI of the bubble game

    /**
     * Creates new BubbleChanger for observing the bubbles
     * @param game BubbleGame game
     * @param gui  BubbleGUI gui
     */
    public BubbleChanger(BubbleGame game, BubbleGui gui){
        this.game = game;
        this.gui = gui;
    }

    @Override
    public void bubbleUpdated(int row, int col, Bubble bubble) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bubbleUpdated'");
    }
}