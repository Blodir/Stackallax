package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Yksinkertainen Entity-luokan perivä pelimaailman esteitä mallintava luokkka.
 *
 * @author Pyry
 */
public class Obstacle extends Entity {

    public Obstacle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
