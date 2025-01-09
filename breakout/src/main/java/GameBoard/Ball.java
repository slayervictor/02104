package GameBoard;

import com.example.App;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.*;

// Change int to double
public class Ball {
    private double[] velo = new double[2];    //change inital velocity when program works
    private double[] pos = new double[2];
    private double speed = 5;   // change value to increase or decrease ball speed
    private Rectangle rect;
    private boolean moving = false;
    private Paddle pad;
    private BlockGrid blockGrid;
    private HashSet<Block> blocks;

    // temp variables move to App.java
    private double sideWall = 10;
    private double minWidth = 0 + sideWall;
    private double maxWidth = 672 - sideWall;
    private double roof = 92+34;
    private double minHeight = 0;
    private double maxHeight = 970 - roof;
    
    public Ball(double x, double y, Paddle pad, BlockGrid blockgrid) {
        this.pad = pad;
        this.blockGrid = blockgrid;
        blocks = blockgrid.getBlockGrid();
        double dX = speed*.5*((Math.random()*2-1) > 0 ? 1 : -1);  // -1 < rand < 1
        double dY = -speed*.5;      // Ensures hypotenuse is always speed for any x
        System.out.println(-Math.sqrt(speed-Math.pow(dX, 2)));
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

    public void setPos(double x, double y) {
        pos[0] = x;
        pos[1] = y;
    }

    public double[] getPos() {
        return pos;
    }

    public void nextPos() {
        //System.out.println("x: " + rect.getLayoutX() + " | y: " + rect.getLayoutY());
        if (moving) {
        pos = new double[] {pos[0]+velo[0],pos[1]+velo[1]};
        if (collidesWall() || collidesBlockHorizontal()) {
            wallBounce();
        } else if (collidesRoof() || collidesBlockVertical()) {
            roofBounce();
        } else if (collidesTopPaddle()) {
            roofBounce();
        } else if (collidesSidePadddle()) {
            wallBounce();
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
        return (minWidth <= getPos()[0] && getPos()[0] <= maxWidth)? false: true; 
    }

    public boolean collidesRoof() {
        return (minHeight <= getPos()[1] /*&& getPos()[1] <= maxHeight*/)? false: true;
    }

    public boolean collidesBlockHorizontal() {
        for (Block b : blocks) {
            if (b.isAlive()) {
                boolean ycollides = b.getPos()[1]+b.getRect().getHeight() >= getPos()[1] && b.getPos()[1] <= getPos()[1];
                if (b.getPos()[0] <= pos[0]+velo[0] && ycollides && b.getPos()[0]+b.getRect().getWidth() >= pos[0]+velo[0]) {
                    blocks.remove(b);
                    b.kill();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean collidesBlockVertical() {
        for (Block b : blocks) {
            if (b.isAlive()) {
                boolean ycollides = b.getPos()[1]+b.getRect().getHeight() >= getPos()[1]+velo[1] && b.getPos()[1] <= getPos()[1]+velo[1];
                if (b.getPos()[0] <= pos[0] && ycollides && b.getPos()[0]+b.getRect().getWidth() >= pos[0]) {
                    blocks.remove(b);
                    b.kill();
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean collidesTopPaddle() {
        return (pad.getY() >= getPos()[1]+getVelo()[1])? true: false;
    }
    // pad.getX - pad.width <= ball.pos <= pad.getx + pad.width 

    public boolean collidesSidePadddle() {
        return (pad.getX() == getPos()[1]+pad.getLength()/2)? true: false;
    }
    /*
    public void handleReflection(boolean hitVerticalWall, boolean hitHorizontalWall) {
        if (hitVerticalWall) {
            velo[0] = -velo[0]; 
        }
        if (hitHorizontalWall) {
            velo[1] = -velo[1]; 
        }
    }

    public void updatePosition() {
        nextPos(); 
        if (collidesWall()) {
            handleReflection(true, false);
        }
        if (collidesRoof()) {
            handleReflection(false, true); 
        }
    }
    */
}
