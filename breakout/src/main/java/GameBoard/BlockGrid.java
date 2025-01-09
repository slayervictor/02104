package GameBoard;

import javafx.scene.paint.Color;
import java.util.*;

public class BlockGrid {
    private HashSet<Block> blockGrid = new HashSet<Block>();
    private int m; // width
    private int n; // height

    public BlockGrid() {
        Scanner console = new Scanner(System.in);
        System.out.print("Please choose a height for the block field (1-10): ");
        n = takeInput(console, 1, 10);
        System.out.print("Please choose a width for the block field (5-20): ");
        m = takeInput(console, 5, 20);
        console.close();
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

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double x = margin + offset * (i + 1) + blockWidth * i;
                double y = 970 / 4 + offset * (j + 1) + blockHeight * j;
                blockGrid.add(new Block(x, y, blockWidth, blockHeight, Color.WHITE));
            }
        }
    }

    public int getBlockGridHeight() {
        return n;
    }

    public int getBlockGridWidth() {
        return m;
    }
    
}
