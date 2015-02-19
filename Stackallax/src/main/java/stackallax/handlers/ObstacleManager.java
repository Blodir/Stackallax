package stackallax.handlers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import stackallax.entities.Obstacle;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 * Luokka luo esteitä (Obstacle), varastoi niitä ja pitää huolen turhien poistosta.
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
    
    /**
     * Generoi esteet niin monen framen ajaksi kunnes nopeus muuttuu
     */
    
    public void generateLevel() {
        while(!spawnWillBeInScreen()) {
            
        }
    }
    
    /**
     * Jokaisen kentän tulee olla kokonaan poistunut ruudulta ennen kuin seuraava generoidaan
     * @return whether or not will the next spawn be in screen when increase of speed occurs.
     */
    
    public boolean spawnWillBeInScreen() {
        return false;
    }
    
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
    
    /**
     * Päivittää jokaisen obstaclen sijainnin, huolehtii että ruudulta pois olevat poistetaan sekä kutsuu generateLevel()
     * @param score
     */
    
    public void update(int score) {
        ArrayList<Obstacle> removables = new ArrayList<>();
        
        if (score > 0 && score % 1000 == 0) {
            generateLevel();
        }
        
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
