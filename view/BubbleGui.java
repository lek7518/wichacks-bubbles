import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class BubbleGui extends Application{
    private BubbleGame game;

    private String status;
    private Label statusLabel = new Label(status);
    private ImageView[][] images;
   

    public void init(){
        status = "Hit the arrow keys to play!";
        statusLabel.setText(status);

        game = new BubbleGame();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.init();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(statusLabel);

        images = new ImageView[game.getRows()][game.getCols()];
        for (int i = 0; i < images.length; i++) {
            for (int index = 0; index < images.length; index++) {
                images[i][index] = new ImageView();
            }
        }

        //background grid image
        InputStream gridStream = new FileInputStream("images/bub_grid.png"); //add image path
        Image grid = new Image(gridStream);
        ImageView gridView = new ImageView();
        gridView.setImage(grid);
        gridView.setX(0);
        gridView.setY(0);
        gridView.setFitWidth(800);
        gridView.setPreserveRatio(true);

        Group bubbleGroup = new Group(gridView);
        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images.length; j++) {
                bubbleGroup.getChildren().add(images[i][j]);
            }
        }
        borderPane.setCenter(bubbleGroup);

        //arrow buttons
        GridPane arrows = new GridPane();
        borderPane.setRight(arrows);

        Button left = new Button();
        InputStream leftStream = new FileInputStream("images/left_arrow.png");
        Image leftArrow = new Image(leftStream);
        ImageView leftView = new ImageView();
        leftView.setImage(leftArrow);
        leftView.setFitWidth(100);
        leftView.setPreserveRatio(true);
        left.setGraphic(leftView);
        arrows.add(left, 0, 1);
        left.setOnAction(new ArrowButtonChanger(this, game, "left"));

        Button right = new Button();
        InputStream rightStream = new FileInputStream("images/right_arrow.png");
        Image rightArrow = new Image(rightStream);
        ImageView rightView = new ImageView();
        rightView.setImage(rightArrow);
        rightView.setFitWidth(100);
        rightView.setPreserveRatio(true);
        right.setGraphic(rightView);
        arrows.add(right, 2, 1);
        right.setOnAction(new ArrowButtonChanger(this, game, "right"));

        Button top = new Button();
        InputStream topStream = new FileInputStream("images/top_arrow.png");
        Image topArrow = new Image(topStream);
        ImageView topView = new ImageView();
        topView.setImage(topArrow);
        topView.setFitWidth(100);
        topView.setPreserveRatio(true);
        top.setGraphic(topView);
        arrows.add(top, 1, 0);
        top.setOnAction(new ArrowButtonChanger(this, game, "up"));

        Button bottom = new Button();
        InputStream bottomStream = new FileInputStream("images/bottom_arrow.png");
        Image bottomArrow = new Image(bottomStream);
        ImageView bottomView = new ImageView();
        bottomView.setImage(bottomArrow);
        bottomView.setFitWidth(100);
        bottomView.setPreserveRatio(true);
        bottom.setGraphic(bottomView);
        arrows.add(bottom, 1, 2);
        bottom.setOnAction(new ArrowButtonChanger(this, game, "down"));

        game.registerObserver(this);
        game.startGame();

        Scene scene = new Scene(borderPane);
        stage.setTitle("Bubble Game");
        stage.setScene(scene);
        stage.show();
    }
    
    public ImageView[][] getImages(){
        return images;
    }
    public Label getStatusLabel() {
        return statusLabel;
    }

    public static void main(String[] args){
        launch(args);
    }
}
