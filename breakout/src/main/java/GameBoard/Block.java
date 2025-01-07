package GameBoard;

public class Block {
    private double[] pos = {0,0};
    private boolean alive;

    public boolean kill() {
        return !(alive);
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
}
