package com.example;


import GameBoard.Paddle;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;

public class PrimaryController {
    private double hSpeed = 7;
    @FXML
    private Rectangle paddle; 

    private Paddle pad;

    public void initialize() {
        pad = new Paddle(paddle); 
    }
    
    public void inputHandling(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                pad.move(hSpeed);
                break;
            case LEFT:
                pad.move(-hSpeed);
                break;
            default:
                break;
        }
    }
}
