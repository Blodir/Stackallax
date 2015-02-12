package stackallax.handlers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import stackallax.entities.Obstacle;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 * Luokka pitää lukua esteistä (Obstacle) ja huolen turhien poistosta.
 *
 * @author Pyry
 */
public class ObstacleManager {
    public static final int OBSTACLEHEIGHT = 50;
    public static final int OBSTACLEWIDTH = 50;
    
    private final ArrayList<Obstacle> obstacles = new ArrayList<>();
    
    /**
     * Luo uuden esteen
     */
    
    public void spawn() {
        Obstacle o = new Obstacle(Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - OBSTACLEHEIGHT, OBSTACLEWIDTH, OBSTACLEHEIGHT);
        o.setMovement(new Vector2(-1 * Game.SPEED, 0));
        obstacles.add(o);
    }
    
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
    
    /**
     * Päivittää jokaisen obstaclen sijainnin sekä huolehtii että ruudulta pois olevat poistetaan
     */
    
    public void update() {
        ArrayList<Obstacle> removables = new ArrayList<>();
        for (Obstacle o : obstacles) {
            o.update();
            if (o.getX() < -50) {
                removables.add(o);
            }
        }
        for (Obstacle removable : removables) {
            obstacles.remove(removable);
        }
    }
    
    public void draw(Graphics2D g) {
        for (Obstacle o : obstacles) {
            o.draw(g);
        }
    }
}
