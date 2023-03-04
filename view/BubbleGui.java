import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class BubbleGui extends Application{
    private String status;
    private Label statusLabel = new Label(status);

    public void init(){
        status = "Hit the arrow keys to play!";
        statusLabel.setText(status);

        //BubbleGame.addObserver(this);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.init();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(statusLabel);

        //background grid image
        InputStream gridStream = new FileInputStream("D"); //add image path
        Image grid = new Image(gridStream);
        ImageView gridView = new ImageView();
        gridView.setImage(grid);
        gridView.setX(0);
        gridView.setY(0);
        gridView.setFitWidth(800);
        gridView.setPreserveRatio(true);
        borderPane.setCenter(gridView);

        //arrow buttons
        GridPane arrows = new GridPane();
        borderPane.setRight(arrows);
        InputStream stream = new FileInputStream("arrow button"); //add image path
        Image arrow = new Image(stream);

        Button left = new Button();
        ImageView leftView = new ImageView();
        leftView.setImage(arrow);
        leftView.setRotate(leftView.getRotate() + 90);
        arrows.add(left, 1, 0);

        Button right = new Button();
        ImageView rightView = new ImageView();
        rightView.setImage(arrow);
        rightView.setRotate(rightView.getRotate() + 270);
        arrows.add(right, 1, 2);

        Button top = new Button();
        ImageView topView = new ImageView();
        topView.setImage(arrow);
        arrows.add(top, 0, 1);

        Button bottom = new Button();
        ImageView bottomView = new ImageView();
        bottomView.setImage(arrow);
        bottomView.setRotate(bottomView.getRotate() + 180);
        arrows.add(bottom, 2, 1);


        Scene scene = new Scene(borderPane);
        stage.setTitle("Bubble Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
