package GameBoard;

import com.example.App;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

// Change int to double
public class Ball {
    private double[] velo = new double[]{0,0};    //change inital velocity when program works
    private double[] pos = new double[]{0,0};
    private double speed = 1;   // change value to increase or decrease ball speed
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
        double dY = Math.sqrt(1-Math.pow(dX, 2));      // Ensures hypotenuse is always 1 for any x
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

    public double[] getPos() {
        return pos;
    }

    // probably a faster way of doing this
    public double[] nextPos(double[] pos, double[] velo) {
        double[] temp = {0,0};
        for (int i = 0; i <= 1; i++) {
            temp[i] = pos[i] + velo[i];
        }
        return temp;
    }

    // probably doesn't work
    public void wallBounce(int[] velo) {
        velo[0] *= -1;
    }

    // probably doesn't work
    public void roofBounce(int[] velo) {
        velo[1] *= -1;
    }

    public boolean collidesWall() {
        return (minWidth <= getPos()[0] && getPos()[0] <= maxWidth)? false: true; 
    }

    public boolean collidesRoof() {
        return (minHeight <= getPos()[1] && getPos()[1] <= maxHeight)? false: true;
    }
}
