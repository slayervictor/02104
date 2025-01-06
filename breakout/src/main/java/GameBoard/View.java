package GameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class View  { 
    // Denne metode returnerer en Scene til gameboard view
    public static Scene createGameboardView() {

        double sceneWidth = 32*9;
        int sceneHeight = 32*16;
        Rectangle leftWall = new Rectangle(0, 0, 16, sceneHeight);
        leftWall.setFill(Color.WHITE);
        Rectangle rightWall = new Rectangle(sceneWidth - 16, 0, sceneWidth, sceneHeight);
        rightWall.setFill(Color.WHITE);
        StackPane root = new StackPane(); 
        root.getChildren().addAll(leftWall, rightWall);
        Scene scene = new Scene(root, sceneWidth, sceneHeight); 
        // Returnerer en Scene med knappen
        return scene;  // Størrelse på gameboard

    }

}