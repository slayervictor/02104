package GameBoard;

// Change int to double
public class Ball {
    private int[] velo = new int[]{0,0};    //change inital velocity when program works
    private int[] pos = new int[]{0,0};
    
    public void setVelo(int dX, int dY) {
        velo[0] = dX;
        velo[1] = dY;
    }

    public int[] getVelo() {
        return velo;
    }

    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }

    public int[] getPos() {
        return pos;
    }

    // probably a faster way of doing this
    public int[] nextPos(int[] pos, int[] velo) {
        int[] temp = {0,0};
        for (int i = 0; i <= 1; i++) {
            temp[i] = pos[i] + velo[i];
        }
        return temp;
    }

    public void wallBounce(int[] velo) {
        velo[0] *= -1;
    }

    public void roofBounce(int[] velo) {
        velo[1] *= -1;
    }
}
