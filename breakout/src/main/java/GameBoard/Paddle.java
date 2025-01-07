package GameBoard;

import javafx.scene.shape.Rectangle;

public class Paddle {
    private Rectangle paddle;

    public Paddle(Rectangle paddle) {
        this.paddle = paddle;
    }

    public void movePaddle(double distance) {
        paddle.setLayoutX(paddle.getLayoutX() + distance);  
    }

    public Rectangle getObject() {
        return paddle;
    }

    @Override
    public String toString() {
        return "" + paddle;
    }
}
