/**
 * Observer interface for BubbleGame
 * @author Carey McCollester
 */
public interface BubbleObserver {
    /**
     * Notify observer of bubble being changed
     * @param row position in rows
     * @param col position in columns
     */
    public void bubbleUpdated(int row, int col, Bubble bubble);
}