package GameBoard;

public class CollisionDetection {
    public boolean checkCollision(double ballX, double ballY, double ballRadius, Block block) {
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

    public String checkCollision(double ballX, double ballY, double ballRadius, Block block, double sceneWidth, double sceneHeight) {

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
        return "";
    }
}
