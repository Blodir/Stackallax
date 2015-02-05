package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public abstract class Entity {

    private int x;
    private int y;
    private Vector2 movement;

    public Entity(int x, int y) {
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

    public abstract void draw(Graphics2D g);
}
