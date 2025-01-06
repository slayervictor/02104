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
    public Scene createGameboardView() {
        // Opretter en knap til at starte spillet
        Button startButton = new Button("Start Game");

        // Handling af knappen (klik for at starte spillet)
        startButton.setOnAction(e -> startGame());

        double sceneWidth = 32*9;
        int sceneHeight = 32*16;
        Rectangle topWall = new Rectangle(0, 0, sceneWidth, 20);
        topWall.setFill(Color.WHITE);
        Rectangle bottomWall = new Rectangle(0, sceneHeight - 20, sceneWidth, 20);
        bottomWall.setFill(Color.WHITE);
        Rectangle leftWall = new Rectangle(0, 0, 20, sceneHeight);
        leftWall.setFill(Color.WHITE);
        Rectangle rightWall = new Rectangle(sceneWidth - 20, 0, 20, sceneHeight);
        rightWall.setFill(Color.WHITE);
        StackPane root = new StackPane(); 
        root.getChildren().addAll(topWall, bottomWall, leftWall, rightWall);
        Scene scene = new Scene(root, sceneWidth, sceneHeight); 
        // Opretter layout og tilføjer knappen
        StackPane layout = new StackPane();
        layout.getChildren().add(startButton);

        // Returnerer en Scene med knappen
        return scene;  // Størrelse på gameboard
    }

    // Metode til at starte spillet (kan bruges til at skifte scene eller starte spillet)
    private void startGame() {
        System.out.println("Game Started!");
        // Her kan du oprette logikken for at skifte til en gameplay-scene
    }

}