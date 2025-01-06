package MainMenu;

import com.example.App;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class View {

    // Denne metode returnerer en Scene til gameboard view
    public Scene createMainMenuView() {
        // Opretter en knap til at starte spillet
        Button startButton = new Button("Start Game");

        Text t = new Text("HEJ");

        // Handling af knappen (klik for at starte spillet)
        startButton.setOnAction(e -> startGame());

        // Opretter layout og tilføjer knappen
        BorderPane layout = new BorderPane();
        layout.setBottom(startButton);
        layout.setTop(t);

        // Returnerer en Scene med knappen
        return new Scene(layout, 32*9, 32*16);  // Størrelse på gameboard
    }

    // Metode til at starte spillet (kan bruges til at skifte scene eller starte spillet)
    private void startGame() {
        
    }
}
