package modele;

public class Coup {
    public int x, y;
    public Coup(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    public int get_x(){ return x; }
    public int get_y(){ return y; }
}
