package GameBoard;

public class Model {

}

class Block {
    
}

class Blockgrid {
    private int[][] blockGrid;
    private int height;
    private int width;

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

class Ball {
    private int[] velo = new int[]{0,0};    //change inital velocity when program works
    private int[] pos = new int[]{0,0};
    
    public void setVelo(int dX, int dY) {
        velo[0] = dX;
        velo[1] = dY;
    }

    public int[] getVelo() {
        return velo;
    }

    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }

    public int[] getPos() {
        return pos;
    }

    // probably a faster way of doing this
    public int[] nextPos(int[] pos, int[] velo) {
        int[] temp = {0,0};
        for (int i = 0; i <= 1; i++) {
            temp[i] = pos[i] + velo[i];
        }
        return temp;
    }

    public void wallBounce(int[] velo) {
        velo[0] *= -1;
    }

    public void roofBounce(int[] velo) {
        velo[1] *= -1;
    }

}
