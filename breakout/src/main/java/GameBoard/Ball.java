package GameBoard;

import com.example.App;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

// Change int to double
public class Ball {
    private double[] velo = new double[2];    //change inital velocity when program works
    private double[] pos = new double[2];
    private double speed = 5;   // change value to increase or decrease ball speed
    private Rectangle rect;
    private boolean moving = false;
    private Paddle pad;
    private BlockGrid blockGrid;

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
        if (collidesWall()) {
            wallBounce();
        } else if (collidesRoof()) {
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
        return (minWidth <= getPos()[0] && getPos()[0] <= maxWidth)? false: true; 
    }

    public boolean collidesRoof() {
        return (minHeight <= getPos()[1] && getPos()[1] <= maxHeight)? false: true;
    }

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
}
