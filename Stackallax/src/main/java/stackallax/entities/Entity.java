package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public abstract class Entity {

    private int x;
    private int y;
    private int width;
    private int height;
    private Vector2 movement;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
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
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public Vector2 getMovement() {
        return movement;
    }

    public abstract void draw(Graphics2D g);
}
