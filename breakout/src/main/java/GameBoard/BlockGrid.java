package GameBoard;

import javafx.scene.paint.Color;
import java.util.*;

public class BlockGrid {
    private HashSet<Block> blockGrid = new HashSet<Block>();
    private int m; // width
    private int n; // height

    public BlockGrid() {
        Scanner console = new Scanner(System.in);
        System.out.print("Please choose a height for the block field: ");
        int input = console.nextInt();
        
        if ((1 <= input) && (input <= 10)) {
            n = input; 
        } else {
            console.close();
            throw new IllegalArgumentException("n is out of bounds, please let n = {1,...,10}");
        }
        System.out.print("Please choose a width for the block field: ");
        input = console.nextInt();

        if ((5 <= input) && (input <= 20)) {
            m = input;
            console.close();
        } else {
            console.close();
            throw new IllegalArgumentException("m is out of bounds, please let m = {5,...,20}");
        }
        createField();
    }

    private void createField() {
        double blockWidth = 15;
        double blockHeight = 15;
        double offset = 0;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                blockGrid.add(new Block(11+blockWidth/2+(offset+blockHeight)*i, 90+blockHeight/2+(offset+blockHeight)*j, blockWidth, blockHeight, Color.WHITE));
                
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
