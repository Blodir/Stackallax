package stackallax.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import stackallax.maths.Vector2;

/**
 *
 * @author Pyry
 */
public class Background {
    private BufferedImage image;

    private int x;
    private int y;
    private Vector2 movement;

    public Background(int x, int y) {
        this.x = x;
        this.y = y;
        
        try {
            image = ImageIO.read(new File(getClass().getResource("background.png").toURI()));
        }
        catch (Exception e) { System.out.println(e); }
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
    
    public int getImageWidth() {
        //return image.getWidth();
        return 500;
    }

    public void update() {
        x += movement.getX();
        y += movement.getY();
    }

    public void draw(Graphics2D g) {
        //draw background here
        //g.drawImage(image, getX(), getY(), null);
    }
}
