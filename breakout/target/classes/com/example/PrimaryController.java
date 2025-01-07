package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.shape.*;

public class PrimaryController {
    
    @FXML
    private Rectangle paddle;

    // Called in App
    public void onStep() {
        // Hent nuværende x-position
        paddle.setLayoutX(paddle.getLayoutX()+7);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
