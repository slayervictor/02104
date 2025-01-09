package GameBoard;

import com.example.App;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

// Change int to double
public class Ball {
    private double[] velo = new double[]{0,0};    //change inital velocity when program works
    private double[] pos = new double[]{0,0};
    private double speed = 1.0/100;   // change value to increase or decrease ball speed
    private Rectangle rect;

    // temp variables move to App.java
    private double sideWall = 10;
    private double minWidth = 0 + sideWall;
    private double maxWidth = 672 - sideWall;
    private double roof = 92+34;
    private double minHeight = 0;
    private double maxHeight = 970 - roof;
    
    public Ball(double x, double y) {
        double dX = (Math.random()*2)-1;  // -1 < rand < 1         
        double dY = -Math.sqrt(speed-Math.pow(dX, 2));      // Ensures hypotenuse is always speed for any x
        setPos(x, y);
        setVelo(dX, dY);
        rect = new Rectangle(x,y,13,10);
        rect.setFill(Color.rgb(158, 158, 158));
        App.addElement(rect);
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
    /*
    public void move(double speed) { // moving and collision with wall
        paddle.setLayoutX(paddle.getLayoutX() + speed);
    }
    */

    public double[] getPos() {
        return pos;
    }

    public void nextPos() {
        System.out.println("x: " + pos[0] + "y: " + pos[1]);
        pos = new double[] {pos[0]+velo[0],pos[1]+velo[1]};
        rect.setLayoutX(getPos()[0]);
        rect.setLayoutY(getPos()[1]);
    }

    // probably doesn't work
    public void wallBounce() {
        velo[0] *= -1;
    }

    // probably doesn't work
    public void roofBounce() {
        velo[1] *= -1;
    }

    public boolean collidesWall() {
        return (minWidth <= getPos()[0] && getPos()[0] <= maxWidth)? false: true; 
    }

    public boolean collidesRoof() {
        return (minHeight <= getPos()[1] && getPos()[1] <= maxHeight)? false: true;
    }
}
