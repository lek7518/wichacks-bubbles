import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.image.Image;
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
        for (int i = 0; i < images.length; i++) {
            for (int index = 0; index < images.length; index++) {
                images[i][index] = new ImageView();
            }
        }
    }

    @Override
    public void bubbleUpdated(int row, int col, Bubble bubble) {
        int twosize = 0;
        if (bubble != null){
            twosize = bubble.getTwosize();
        }

        try {
            InputStream imageStream = new FileInputStream("images/bub_arrow.png"); //should not happen
        
            switch (twosize) {
                case 2:
                    imageStream = new FileInputStream("images/bub_sky.png");
                    break;

                case 4:
                    imageStream = new FileInputStream("images/bub_blue.png");
                    break;

                case 8:
                    imageStream = new FileInputStream("images/bub_navy.png");
                    break;

                case 16:
                    imageStream = new FileInputStream("images/bub_purple.png");
                    break;
                
                case 32:
                    imageStream = new FileInputStream("images/bub_pink.png");
                    break;

                case 64:
                    imageStream = new FileInputStream("images/bub_orange.png");
                    break;

                case 128:
                    imageStream = new FileInputStream("images/bub_yellow.png");
                    break;

                case 256:
                    imageStream = new FileInputStream("images/bub_green.png");
                    break;

                case 512:
                    imageStream = new FileInputStream("images/bub_teal.png");
                    break;

                case 1024:
                    imageStream = new FileInputStream("images/bub_army.png");
                    break;

                case 2048:
                    imageStream = new FileInputStream("images/bub_star.png");
                    break;
            
                default:    //null 0 no bubble
                    imageStream = null;
                    break;
            }

            Image bubbleImage = new Image(imageStream);
            images[row][col].setImage(bubbleImage);
            images[row][col].setX(-300 + (row * 200));
            images[row][col].setY(300 - (col * 200));
        }
        catch (FileNotFoundException e){
            System.err.println("Image is not found.");
        }
    }
}