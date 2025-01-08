package GameBoard;

import java.util.Arrays;

public class Block {
    private double[] pos = {0,0};
    private boolean alive;

    public void kill() {
        alive = false;
    }

    public boolean isAlive() {
        return (alive)? alive: !(alive);
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
