package stackallax.stackallax;

import java.awt.Color;
import stackallax.handlers.KeyboardHandler;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import stackallax.handlers.CollisionDetector;
import stackallax.handlers.ObstacleManager;
import stackallax.handlers.ScoreManager;
import stackallax.entities.Player;
import stackallax.graphics.Draw;
import stackallax.handlers.BackgroundManager;
import stackallax.maths.Vector2;

/**
 * Pääluokka joka sisältää mainin, käyttöliittymän sekä gameloopin.
 *
 * @author Pyry
 */
public class Game extends JPanel implements Runnable {

    private static final String title = "Stackallax";
    public static final Dimension WINDOWSIZE = new Dimension(800, 500);
    public static final int GRAVITY = 1;

    public static int SPEED = 5;

    private static JFrame frame;

    private int finalScore = 0;

    private Player player;
    private BackgroundManager backgroundManager;
    private ObstacleManager obstacleManager;
    private CollisionDetector collisionDetector;
    private ScoreManager score;
    private Draw draw;

    private int FPS;

    // How much time should elapse before the screen is updated
    private long targetTime;

    private boolean isRunning;

    public Game() {
        setPreferredSize(WINDOWSIZE);
        isRunning = false;
        FPS = 60;
        targetTime = 1000 / FPS;
    }

    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Alustaa uuden pelin ja aloittaa sen
     */
    public void start() {
        finalScore = 0;
        player = new Player(50, 450);
        player.setMovement(new Vector2(0, 0));
        backgroundManager = new BackgroundManager();
        obstacleManager = new ObstacleManager();
        collisionDetector = new CollisionDetector(player, obstacleManager);
        score = new ScoreManager();
        draw = new Draw();
        getFrame().addKeyListener(new KeyboardHandler(player, this));
        isRunning = true;
        SPEED = 5;
        new Thread(this).start();
    }

    public Player getPlayer() {
        return player;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * Määrittelee framen ja siirtyy pelin alustukseen
     *
     * @param args
     */
    public static void main(String args[]) {
        frame = new JFrame(title);
        Game game = new Game();

        frame.add(game);
        frame.pack();

        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }

    public static JFrame getFrame() {
        return frame;
    }

    /**
     * Päivittää pelin logiikan
     *
     * Kutsuu update() metodeja ja kasvattaa pelin nopeutta
     */
    public void update() {
        /*if (new Random().nextInt(50) == 1) {
         obstacleManager.spawn();
         }*/
        backgroundManager.update();
        player.update();
        obstacleManager.update(score.getScore());
        if (!collisionDetector.update()) {
            gameOver();
        }
        score.increase();
        if (score.getScore() % 1000 == 0) {
            SPEED++;
        }
    }

    /**
     * Lopettaa pelin
     */
    private void gameOver() {
        finalScore = score.getScore();
        isRunning = false;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (draw == null) {
            return;
        }
        
        if (isRunning == false && finalScore > 0) {
            draw.paintScore(g, score);
            
            return;
        }
        if (backgroundManager != null) {
            draw.drawAllBackgrounds((Graphics2D) g, backgroundManager);
        }
        if (player != null) {
            draw.drawPlayer((Graphics2D) g, player);
        }
        if (obstacleManager != null) {
            draw.drawAllObstacles((Graphics2D) g, obstacleManager);
        }
        if (score != null) {
            draw.drawCurrentScore((Graphics2D) g, score);
        }
    }

    /**
     * Game-loop
     */
    @Override
    public void run() {
        //MAIN GAME LOOP
        long start;
        long elapsed;
        long wait;
        while (isRunning) {
            start = System.nanoTime();
            update();
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if (wait < 0) {
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
        }

        repaint();
        score.writeHighscores();
    }
}
