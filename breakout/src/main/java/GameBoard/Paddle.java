package GameBoard;

import javafx.scene.shape.Rectangle;

public class Paddle {
    private Rectangle paddle;

    public Paddle(Rectangle paddle) {
        this.paddle = paddle;
    }

    public void move(double speed) { // moving and collision with wall
        paddle.setLayoutX(paddle.getLayoutX() + speed);
    }

    public double getX() {
        return paddle.getLayoutX();
    }

    public double getY() {
        return paddle.getLayoutY();
    }

    public double getLength() {
        return paddle.getWidth();
    }

    public double getHeight() {
        return paddle.getHeight();
    }

    public Rectangle getObject() {
        return paddle;
    }

    @Override
    public String toString() {
        return "" + paddle;
    }
}
