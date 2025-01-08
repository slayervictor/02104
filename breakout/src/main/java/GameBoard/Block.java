package GameBoard;

import java.util.Arrays;

import com.example.App;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Block {
    private double[] pos;
    private double[] scale; 
    private boolean alive;
    private Rectangle rect;


    public Block(double x, double y, double width, double height, Color color) {
        pos = new double[] {x,y};
        scale = new double[] {width,height};
        rect = new Rectangle(x, y, width, height);
        rect.setFill(color);
        App.addElement(rect);
    }

    public Rectangle getRect() {
        return rect;
    }
    

    public void kill() {
        alive = false;
    }

    public boolean isAlive() {
        return (alive)? alive: false;
    }

    public void setPos(double x, double y) {
        pos[0] = x;
        pos[1] = y;
    }

    public double[] getPos() {
        return pos;
    }

    public String toString() {
        return "is alive? " + isAlive() + " " + Arrays.toString(getPos());
    }
}
