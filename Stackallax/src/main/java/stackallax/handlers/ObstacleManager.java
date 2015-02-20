package stackallax.handlers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
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
    
    private Random rand;
    
    public ObstacleManager() {
        rand = new Random();
        spawnWithProbability(100, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - OBSTACLEHEIGHT);
    }
    
    /**
     * Luo uuden esteen
     */
    
    public void spawn() {
        Obstacle o = new Obstacle(Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - OBSTACLEHEIGHT, OBSTACLEWIDTH, OBSTACLEHEIGHT);
        o.setMovement(new Vector2(-1 * Game.SPEED, 0));
        obstacles.add(o);
    }
    
    public void spawnWithProbability(int probability, int x, int y) {
        if (rand.nextInt(100) <= probability) {
            Obstacle o = new Obstacle(x, y, OBSTACLEWIDTH, OBSTACLEHEIGHT);
            o.setMovement(new Vector2(-1 * Game.SPEED, 0));
            obstacles.add(o);
        }
    }
    
    /**
     * Generoi esteet niin monen framen ajaksi kunnes nopeus muuttuu
     */
    
    public void generateLevel() {
        int firstSpawnDistance = Game.WINDOWSIZE.width;
        int lastSpawnDistance = 5000;
        int playerJumpDistance = Game.SPEED * 21; //jump lasts for 21 frames
        for (int focusX = firstSpawnDistance; focusX <= lastSpawnDistance; focusX++) {
            System.out.println("spawning");
            //spawnataan eka
            if (focusX == firstSpawnDistance) {
                spawnWithProbability(100, focusX, Game.WINDOWSIZE.height - OBSTACLEHEIGHT);
            }
            //pelaaja pystyy hypätä laatikolta toiselle
            if (focusX - playerJumpDistance == obstacles.get(obstacles.size() - 1).getX()) {
                spawnWithProbability(10, focusX, Game.WINDOWSIZE.height - OBSTACLEHEIGHT);
            }
        }
    }
    
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
    
    /**
     * Päivittää jokaisen obstaclen sijainnin, huolehtii että ruudulta pois olevat poistetaan sekä kutsuu generateLevel()
     * @param score
     */
    
    public void runSpawner() {
        int playerJumpDistance = Game.SPEED * 21; //jump lasts for 21 frames
        
        if (!obstacles.isEmpty()) {
            if (Game.WINDOWSIZE.width - obstacles.get(obstacles.size() - 1).getX() > playerJumpDistance) {
                spawnWithProbability(1, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - OBSTACLEHEIGHT);
            }
        } else {
            //ground level spawn
            spawnWithProbability(100, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - OBSTACLEHEIGHT);
        }
        
        //first layer spawn
        if (Game.WINDOWSIZE.width - obstacles.get(obstacles.size() - 1).getX() > 50 && Game.WINDOWSIZE.width - obstacles.get(obstacles.size() - 1).getX() < 80) {
            if (obstacles.get(obstacles.size() - 1).getY() == Game.WINDOWSIZE.height - (2 * OBSTACLEHEIGHT)) {
                if (Game.WINDOWSIZE.width - obstacles.get(obstacles.size() - 1).getX() > 50) {
                    spawnWithProbability(10, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - (2 * OBSTACLEHEIGHT));
                }
            }
        }
    }
    
    public void update(int score) {
        runSpawner();
        
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
