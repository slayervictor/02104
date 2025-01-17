package GameBoard;

import javafx.scene.paint.Color;
import java.util.*;

import com.example.App;

public class BlockGrid {
    private HashSet<Block> blockGrid = new HashSet<Block>();
    private int m; // width
    private int n; // height

    public BlockGrid() {
        n = App.getN();
        m = App.getM();
        createField();
    }

    int takeInput(Scanner console, int lower, int higher) {
        int temp = console.nextInt();
        if (temp <= higher && temp >= lower) {
            return temp;
        } else {
            System.out.print("Please enter a value within the bounds: {" + lower + ",...," + higher + "} ");
            return takeInput(console, lower, higher);
        }
    }

    private void createField() {
        double margin = 10;
        double offset = 5; 

        double blockWidth = (672 - 2 * margin - offset * (m + 1)) / m;
        double blockHeight = ((970 / 4) - offset * (n + 1)) / n;
        Color col;
        for (int i = 0; i < n; i++) {
                switch ((i/2)%8) {
                    case 0:
                        col = Color.rgb(231,100,154);
                        break;
                    
                    case 1:
                        col = Color.rgb(252,79,81);
                        break;
                    
                    case 2:
                        col = Color.rgb(248,123,65);
                        break;

                    case 3:
                        col = Color.rgb(243,211,42);
                        break;

                    case 4:
                        col = Color.rgb(82,189,85);
                        break;

                    case 5:
                        col = Color.rgb(69,69,229);
                        break;

                    case 6:
                        col = Color.rgb(140,77,243);
                        break;

                    case 7:
                        col = Color.rgb(44,240,239);
                        break;
                
                    default:
                        col = Color.WHITE;
                        break;
                }
            for (int j = 0; j < m; j++) {
                double x = margin + offset * (j + 1) + blockWidth * j;
                double y = 970 / 4 + offset * (i + 1) + blockHeight * i;
                
                blockGrid.add(new Block(x, y, blockWidth, blockHeight, col));
            }
        }
    }

    public int getBlockGridHeight() {
        return n;
    }

    public int getBlockGridWidth() {
        return m;
    }

    public HashSet<Block> getBlockGrid() {
        return blockGrid;
    }

    public void removeBlock(Block block) {
        block.kill();
        blockGrid.remove(block);
        block = null; // For garbage collection purposes, cause then we can actually get rid of the object from our memory ;)
    }
    
}
