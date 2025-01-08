package GameBoard;

import java.util.Scanner;

public class BlockGrid {
    private int[][] blockGrid;
    private int height;
    private int width;

    public BlockGrid() {
        Scanner console = new Scanner(System.in);
        int n, m;
        int input = console.nextInt();
        
        if ((1 <= input) && (input <= 10)) {
            n = console.nextInt(); 
            console.close();
        } else {
            console.close();
            throw new IllegalArgumentException("n is out of bounds, please let n = {1,...,10}");
        }
        
        input = console.nextInt();

        if ((5 <= input) && (input <= 20)) {
            m = console.nextInt();
            console.close();
        } else {
            console.close();
            throw new IllegalArgumentException("m is out of bounds, please let m = {5,...,20}");
        }
        
        blockGrid(m, n);
        
    }

    public int[][] blockGrid(int width, int height) {
        // Width and height hardcoded for now, function is scalable, for future needs
        width = 14;
        height = 8;
        this.blockGrid = new int[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                blockGrid(width, height)[i][j] = 1;
            }
        }
        return blockGrid(width, height);
    }

    public int getBlockGridHeight() {
        return blockGrid(width, height).length;
    }

    public int getBlockGridWidth() {
        return blockGrid(width, height)[0].length;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < getBlockGridHeight(); i++) {
            for (int j = 0; j <getBlockGridHeight(); j++) {
                str += blockGrid(width, height)[i][j];
            }
            str += "\n";
        }
        return str;
    }

    
}
