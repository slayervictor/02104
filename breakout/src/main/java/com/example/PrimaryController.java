package com.example;
import GameBoard.*;
import javafx.fxml.FXML;
import javafx.scene.input.*;

import javafx.scene.shape.Rectangle;
import java.util.Random;


public class PrimaryController {
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
    pad.movePaddle(7);
    
}

}
