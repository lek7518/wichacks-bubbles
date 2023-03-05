import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Observes a bubble
 * @author Carey McCollester
 * @author Lydia Klecan
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

        this.images = gui.getImages();
    }

    @Override
    public void bubbleUpdated(int row, int col, Bubble bubble) {
        int twosize = 0;
        if (bubble != null){
            twosize = bubble.getTwosize();
        }

        int bubbleSize;

        try {
            InputStream imageStream = new FileInputStream("images/bub_arrow.png"); //should not happen

            switch (twosize) {
                case 2:
                    imageStream = new FileInputStream("images/bub_sky.png");
                    bubbleSize = 25;
                    break;

                case 4:
                    imageStream = new FileInputStream("images/bub_blue.png");
                    bubbleSize = 50;
                    break;

                case 8:
                    imageStream = new FileInputStream("images/bub_navy.png");
                    bubbleSize = 75;
                    break;

                case 16:
                    imageStream = new FileInputStream("images/bub_purple.png");
                    bubbleSize = 100;
                    break;
                
                case 32:
                    imageStream = new FileInputStream("images/bub_pink.png");
                    bubbleSize = 125;
                    break;

                case 64:
                    imageStream = new FileInputStream("images/bub_orange.png");
                    bubbleSize = 150;
                    break;

                case 128:
                    imageStream = new FileInputStream("images/bub_yellow.png");
                    bubbleSize = 175;
                    break;

                case 256:
                    imageStream = new FileInputStream("images/bub_green.png");
                    bubbleSize = 200;
                    break;

                case 512:
                    imageStream = new FileInputStream("images/bub_teal.png");
                    bubbleSize = 225;
                    break;

                case 1024:
                    imageStream = new FileInputStream("images/bub_army.png");
                    bubbleSize = 250;
                    break;

                case 2048:
                    imageStream = new FileInputStream("images/bub_star.png");
                    bubbleSize = 275;
                    break;
            
                default:    //null 0 no bubble
                    images[row][col].setImage(null);
                    return;
            }

            Image bubbleImage = new Image(imageStream);
            images[row][col].setImage(bubbleImage);
            images[row][col].setX(100 + (row * 200));
            images[row][col].setY(100 + (col * 200));
            images[row][col].setFitWidth(bubbleSize);
            images[row][col].setPreserveRatio(true);
        }
        catch (FileNotFoundException e){
            System.err.println("Image is not found.");
        }
    }
}