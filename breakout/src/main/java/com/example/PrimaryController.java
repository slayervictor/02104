package com.example;

import GameBoard.Paddle;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class PrimaryController {
    @FXML
    private Rectangle paddle; 

    private Paddle pad;

    public void initialize() {
        pad = new Paddle(paddle); 
    }

    public void onStep() {
        pad.movePaddle(7);  
    }
}
