package GameBoard;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class View {

    // Denne metode returnerer en Scene til gameboard view
    public Scene createGameboardView() {
        // Opretter en knap til at starte spillet
        Button startButton = new Button("Start Game");

        // Handling af knappen (klik for at starte spillet)
        startButton.setOnAction(e -> startGame());

        // Opretter layout og tilføjer knappen
        StackPane layout = new StackPane();
        layout.getChildren().add(startButton);

        // Returnerer en Scene med knappen
        return new Scene(layout, 32*9, 32*16);  // Størrelse på gameboard
    }

    // Metode til at starte spillet (kan bruges til at skifte scene eller starte spillet)
    private void startGame() {
        System.out.println("Game Started!");
        // Her kan du oprette logikken for at skifte til en gameplay-scene
    }
}
