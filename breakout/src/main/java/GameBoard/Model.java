package GameBoard;

public class Model {

}

class Block {
    // Arbitrary variables for the blocks 
    public double x;
    public double y; 
    public double width; 
    public double height; 
    
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

class CollisionDetection {
    public static boolean checkCollision(double ballX, double ballY, double ballRadius, Block block) {
        // Get the block position and dimensions from the Block object
        double blockX = block.x; // block.getX();
        double blockY = block.y; // block.getY();
        double blockWidth = block.width; // block.getWidth();
        double blockHeight = block.height; // block.getHeight();

        // Nearest point from ball center to wall of blocks 
        double nearestX = Math.max(blockX, Math.min(ballX, blockX + blockWidth));
        double nearestY = Math.max(blockY, Math.min(ballY, blockY + blockHeight));

        // The distance from the ball to the nearest point
        double deltaX = ballX - nearestX;
        double deltaY = ballY - nearestY;

        // Check if distance is less than radius of ball
        return (deltaX * deltaX + deltaY * deltaY) < (ballRadius * ballRadius);
    }
    public static String checkCollision(double ballX, double ballY, double ballRadius, Block block, double sceneWidth, double sceneHeight) {

        // Check collision with left wall
        if (ballX - ballRadius <= 0) {
            // return gameover; 
        }

        // Check collision with right wall
        if (ballX + ballRadius >= sceneWidth - 11) {
            // return gameover;
        }

        // No collision
        // return ; (When it's not gameover)
    }
}
