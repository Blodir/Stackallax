package stackallax.maths;

/**
 * Luokka mallintaa kaksiulotteista vektoria
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

    /**
     * Lisää vektoriin toisen vektorin
     * 
     * @param vector vektori joka halutaan lisätä
     */
    
    public void add(Vector2 vector) {
        x += vector.getX();
        y += vector.getY();

    }
    
    /**
     * Kertoo vektorin kokonaisluvulla
     * 
     * @param i kokonaisluku jolla vektori halutaan kertoa
     */

    public void multiply(int i) {
        x *= i;
        y *= i;
    }
}
