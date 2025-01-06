package com.example;

import GameBoard.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;  // Denne import skal være der!
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Opretter en instans af GameBoard.View
        View gameBoardView = new View();

        // Opretter en scene for gameboardet
        scene = gameBoardView.createGameboardView();

        // Sætter scenen på stage (primær scene)
        stage.setScene(scene);
        stage.show();
    }

    // Static metode, der kan kaldes fra controller-klasser for at ændre scenen
    public static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        scene.setRoot(fxmlLoader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}
