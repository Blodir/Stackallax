package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public class Player {

    private int x;
    private int y;
    private Vector2 movement;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMovement(Vector2 movement) {
        this.movement = movement;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2 getMovement() {
        return movement;
    }

    public void update() {
        //Simple collision detection with ground
        if (getY() < Game.WINDOWSIZE.getHeight() - 50) {
            movement.setY(movement.getY() + Game.GRAVITY);
        }
        x += movement.getX();
        y += movement.getY();
        if (getY() >= Game.WINDOWSIZE.getHeight() - 50) {
            setY((int) (Game.WINDOWSIZE.getHeight() - 50));
            movement.setY(0);
        }
    }

    public void jump() {
        if (movement.getY() == 0) {
            movement.setY(-10);
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), 50, 50);
    }
}
