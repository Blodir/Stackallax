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
        if (rand.nextInt(1000) <= probability) {
            Obstacle o = new Obstacle(x, y, OBSTACLEWIDTH, OBSTACLEHEIGHT);
            o.setMovement(new Vector2(-1 * Game.SPEED, 0));
            obstacles.add(o);
        }
    }
    
    /**
     * Generoi esteet niin monen framen ajaksi kunnes nopeus muuttuu
     * (ei käytetty)
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
     * Luo uusia esteitä, kutsutaan joka frame
     */
    
    public void runSpawner() {
        int minimumSpawnDistance = Game.SPEED * 21; //jump lasts for 21 frames
        
        if (!obstacles.isEmpty()) {
            //if there are obstacles in field
            if (Game.WINDOWSIZE.width - obstacles.get(obstacles.size() - 1).getX() > minimumSpawnDistance) {
                //if the last obstacle is far enough that we should start spawning again
                
                //spawn on ground level
                spawnWithProbability(5 * Game.SPEED, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - OBSTACLEHEIGHT);
                //spawn an obstacle in 1st layer with small probability
                spawnWithProbability(1 * Game.SPEED, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - (2 * OBSTACLEHEIGHT));
                //have a chance of spawning an obstacle in 2nd layer if the last spawned obstacle was in 1st layer
                if (obstacles.get(obstacles.size() - 1).getY() == Game.WINDOWSIZE.height - (2 * OBSTACLEHEIGHT)) {
                    spawnWithProbability(1 * Game.SPEED, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - (3 * OBSTACLEHEIGHT));
                }
            }
        } else {
            //if there is no obstacles, spawn one on ground level
            spawnWithProbability(1000, Game.WINDOWSIZE.width, Game.WINDOWSIZE.height - OBSTACLEHEIGHT);
        }
    }
    
    
    /**
     * Päivittää jokaisen obstaclen sijainnin, huolehtii että ruudulta pois olevat poistetaan sekä kutsuu generateLevel()
     * @param score
     */
    
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
}
