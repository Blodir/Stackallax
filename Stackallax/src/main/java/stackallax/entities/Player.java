package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public class Player extends Entity {

    public static final int PLAYERWIDTH = 50;
    public static final int PLAYERHEIGHT = 50;
    
    public Player(int x, int y) {
        super(x, y, PLAYERWIDTH, PLAYERHEIGHT);
    }

    public void update() {
        super.setX(super.getX() + super.getMovement().getX());
        super.setY(super.getY() + super.getMovement().getY());
    }

    public void jump() {
        if (super.getMovement().getY() == 0) {
            super.getMovement().setY(-15);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), 50, 50);
    }
}
