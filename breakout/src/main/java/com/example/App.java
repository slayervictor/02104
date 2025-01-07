package com.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Parent root = fxmlLoader.load();

        PrimaryController controller = fxmlLoader.getController();
        scene = new Scene(root, 672, 970);
        scene.setFill(Color.web("#000000")); // Background

        startTimeline(controller);

        stage.setScene(scene);
        stage.show();
    }
    
    public void startTimeline(PrimaryController controller) {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(10), event -> {
                controller.onStep();  // Calls the step event stored in our controller
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); 
        timeline.play();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
