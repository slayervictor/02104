package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import GameBoard.*;

public class PrimaryController {

    @FXML
    private void switchToSecondary() {
        
    // Create a new scene programmatically
        StackPane root = new StackPane();
        root.getChildren().add(new Label("Breakout"));
        
        Scene newScene = View.createGameboardView(); // Set the desired width and height

        // Get the current stage and set the new scene
        Stage currentStage = (Stage) root.getScene().getWindow();
        currentStage.setScene(newScene);
    }

}
