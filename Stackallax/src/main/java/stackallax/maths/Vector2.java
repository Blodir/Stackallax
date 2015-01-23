package stackallax.maths;

/**
 *
 * @author Pyry
 */
public class Vector2 {

    private int x;
    private int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void add(Vector2 vector) {
        x += vector.getX();
        y += vector.getY();

    }

    public void multiply(int i) {
        x *= i;
        y *= i;
    }
}
