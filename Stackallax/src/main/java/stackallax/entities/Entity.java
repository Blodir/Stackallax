package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 * Luokka sisältää peliobjektin perustiedot. Toimii yläluokkana eri tyyppisille objekteille
 *
 * @author Pyry
 */
public abstract class Entity {

    private Vector2 position;
    private int width;
    private int height;
    private Vector2 movement;

    public Entity(int x, int y, int width, int height) {
        position = new Vector2(x, y);
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
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }

    public void setMovement(Vector2 movement) {
        this.movement = movement;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }
    
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), width, height);
    }

    public Vector2 getMovement() {
        return movement;
    }

    public abstract void draw(Graphics2D g);
}
