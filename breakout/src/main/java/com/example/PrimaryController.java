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

    public void initialize() {
        pad = new Paddle(paddle); 
        
    }
    
    public void onStep() {
        if (create == false) { // Run once
            blocks = new BlockGrid();
            // Alt der skal køres en gang, skal tilføjes her
            create = true;
        }
    
    }
/*
    public void inputHandling(KeyEvent event) {
        switch (event.getCode()) {
            case L:
                pad.move(hSpeed);
                System.out.println("L was pressed");
                break;
            case H:
                pad.move(-hSpeed);
                System.out.println("H was pressed");
                break;
            default:
                break;
        }
    }
    */

    public void inputHandling(KeyEvent event) {
        if (event.getCode() == KeyCode.L) {
            pad.move(hSpeed);
            System.out.println("L was pressed");
        } else if (event.getCode() == KeyCode.H) {
            pad.move(-hSpeed);
            System.out.println("H was Pressed");
        }
    }
}
