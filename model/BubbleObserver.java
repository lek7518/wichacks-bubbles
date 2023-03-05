/**
 * Observer interface for BubbleGame
 * @author Carey McCollester
 * @author Lydia Klecan
 */
public interface BubbleObserver {
    /**
     * Notify observer of bubble being changed
     * @param row position in rows
     * @param col position in columns
     */
    public void bubbleUpdated(int row, int col, Bubble bubble);
}