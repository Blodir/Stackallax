package stackallax.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import stackallax.maths.Vector2;

/**
 * Luokka varastoi yksittäisen taustan tiedoista sekä piirrosta
 * 
 * @author Pyry
 */
public class Background {

    private BufferedImage image;

    private Vector2 position;
    private Vector2 movement;

    public Background(int x, int y, String filepath) {
        position = new Vector2(x, y);

        try {
            image = ImageIO.read(new File(filepath));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public BufferedImage getImage() {
        return image;
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

    public Vector2 getMovement() {
        return movement;
    }

    public int getImageWidth() {
        return image.getWidth();
    }

    /**
     * Siirtää taustoja movement vektorin mukaisen määrän
     */
    
    public void update() {
        position.add(movement);
    }
}
