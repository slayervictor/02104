package GameBoard;

import com.example.App;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.*;

// Change int to double
public class Ball {
    private double[] velo = new double[2];    //change inital velocity when program works
    private double[] pos = new double[2];
    private double speed = 3.5;   // change value to increase or decrease ball speed
    private Rectangle rect;
    private boolean moving = false;
    private Paddle pad;
    private BlockGrid blockGrid;
    private HashSet<Block> blocks;

    // temp variables move to App.java
    private double sideWall = 10;
    private double minWidth = 0 + sideWall;
    private double maxWidth = 672 - sideWall;
    private double minHeight = 92+34;
    
    public Ball(double x, double y, Paddle pad, BlockGrid blockgrid) {
        this.pad = pad;
        this.blockGrid = blockgrid;
        blocks = blockgrid.getBlockGrid();
        double dX = speed*.5*((Math.random()*2-1) > 0 ? 1 : -1);  // -1 < rand < 1
        double dY = -speed*.5;      // Ensures hypotenuse is always speed for any x
        setVelo(dX, dY);
        rect = new Rectangle(0,0,13,10);
        setPos(x,y);
        rect.setFill(Color.rgb(158, 158, 158));
        App.addElement(rect);
    }

    public void setMoving(boolean input) {
        moving = input;
    }

    public boolean isMoving() {
        return moving;
    }

    public double getSpeed() {
        return speed;
    }

    public void setVelo(double dX, double dY) {
        velo[0] = dX;
        velo[1] = dY;
    }

    public double[] getVelo() {
        return velo;
    }

    public double getXVelo() {
        return velo[0];
    }

    public double getYVelo() {
        return velo[1];
    }

    public void setPos(double x, double y) {
        pos[0] = x;
        pos[1] = y;
    }

    public double[] getPos() {
        return pos;
    }

    public double getXPos() {
        return pos[0];
    }
    
    public double getYPos() {
        return pos[1];
    }

    public void nextPos() {
        if (moving) {
        pos = new double[] {pos[0]+velo[0],pos[1]+velo[1]};
        if (collidesWall() || collidesBlockHorizontal() || collidesSidePaddle()) {
            wallBounce();
        } else if (collidesRoof() || collidesBlockVertical() || collidesTopPaddle()) {
            roofBounce();
        }
        rect.setLayoutX(pos[0]);
        rect.setLayoutY(pos[1]);
        } else {
            rect.setLayoutX(pos[0]);
            rect.setLayoutY(pos[1]);
        }
    }

    public void wallBounce() {
        velo[0] *= -1;
    }

    public void roofBounce() {
        velo[1] *= -1;
    }

    public boolean collidesWall() {
        return (minWidth <= getXPos() && getXPos()+rect.getWidth() <= maxWidth)? false: true; 
    }

    public boolean collidesRoof() {
        return (minHeight <= getYPos() )? false: true;
    }

    public boolean collidesBlockHorizontal() {
        boolean collisionDetected = false;
        for (Block b : blocks) {
            boolean yCollides = (b.getPos()[1] + b.getRect().getHeight() >= getYPos() &&
                                 b.getPos()[1] <= getYPos() + rect.getHeight());
            boolean xCollides = (b.getPos()[0] <= getXPos() + velo[0] + rect.getWidth() &&
                                 b.getPos()[0] + b.getRect().getWidth() >= getXPos() + velo[0]);
    
            if (xCollides && yCollides) {
                blocks.remove(b);
                blockGrid.removeBlock(b);
                collisionDetected = true;
                break;
            }
        }
        return collisionDetected;
    }
    
    public boolean collidesBlockVertical() {
        boolean collisionDetected = false;
        for (Block b : blocks) {
            boolean yCollides = (b.getPos()[1] + b.getRect().getHeight() >= getYPos() + velo[1] &&
                                 b.getPos()[1] <= getYPos() + rect.getHeight() + velo[1]);
            boolean xCollides = (b.getPos()[0] <= getXPos() &&
                                 b.getPos()[0] + b.getRect().getWidth() >= getXPos() + rect.getWidth());
    
            if (xCollides && yCollides) {
                blocks.remove(b);
                blockGrid.removeBlock(b);
                collisionDetected = true;
                break;
            }
        }
        return collisionDetected;
    }
    
    public boolean collidesTopPaddle() {
        // Check if the ball is within the paddle's bounds horizontally and vertically
        boolean withinPaddleX = pad.getX() <= getXPos() + rect.getWidth() &&
                                getXPos() <= pad.getX() + pad.getLength();
        boolean yCollides = pad.getY() <= getYPos() + velo[1] + rect.getHeight() &&
                            pad.getY() + pad.getHeight() >= getYPos() + velo[1];
    
        return withinPaddleX && yCollides;
    }
    
    public boolean collidesSidePaddle() {
        // Check if the ball is within the paddle's bounds vertically and horizontally
        boolean withinPaddleY = pad.getY() <= getYPos() + rect.getHeight() &&
                                getYPos() <= pad.getY() + pad.getHeight();
        boolean xCollides = pad.getX() <= getXPos() + velo[0] + rect.getWidth() &&
                            pad.getX() + pad.getLength() >= getXPos() + velo[0];
    
        return withinPaddleY && xCollides;
    }
}
