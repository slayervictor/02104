package com.example;
import GameBoard.*;
import javafx.fxml.FXML;
import javafx.scene.input.*;

import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;
import java.util.Random;


public class PrimaryController {
    private double hSpeed = 7;
    @FXML
    private Rectangle paddle; 

    private Paddle pad;

    private BlockGrid blocks;

    private boolean create = false;

    double velocity = 0;

    public void initialize() {
        pad = new Paddle(paddle); 
        
    }
    
    public void onStep() {
        if (create == false) { // Run once
            blocks = new BlockGrid();
            // Alt der skal køres en gang, skal tilføjes her
            create = true;
        }
        pad.move(velocity);
    
    }

    public void inputHandling(KeyEvent event) {
        switch (event.getCode()) {
            case L:
                velocity = hSpeed;
                break;
                
            case H:
                velocity = -hSpeed;
                break;
        }
    }

    public void stopHandling(KeyEvent event) {
        switch (event.getCode()) {
            case L:
                if (velocity > 0) {
                    velocity = 0;
                }
                break;
            
            case H:
            if (velocity < 0) {
                velocity = 0;
            }
                break;
        }
    }
}
