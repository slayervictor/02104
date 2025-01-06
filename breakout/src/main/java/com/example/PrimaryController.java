package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import GameBoard.View;

public class PrimaryController {

    @FXML
    private void switchToSecondary() {
        // Opret gameboard-view
        MainMenu.View gameboardView = new MainMenu.View();

        // Skift root til gameboard-layout
        App.setScene(gameboardView.createMainMenuView());
    }

}
