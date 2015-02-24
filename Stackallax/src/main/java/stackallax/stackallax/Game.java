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
        getFrame().addKeyListener(new KeyboardHandler(player, this));
        isRunning = true;
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
        System.out.println("GAME OVER");
        finalScore = score.getScore();
        isRunning = false;
    }

    public void paintScore(Graphics g) {
        g.drawString("Highscores: ", (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 + 50);
        g.setFont(new Font("Arial", 0, 16));
        int[] highscores = score.getHighscoreList();
        for (int i = 0; i < highscores.length; i++) {
            g.drawString((i + 1) + ". " + highscores[i], (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 + 50 + (20 * (i + 1)));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isRunning == false) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", 0, 32));
            g.drawString("GAME OVER", (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 - 100);
            g.drawString("Press any key to continue", (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 - 50);
            g.drawString("Score: " + finalScore, (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2);
            
            if(finalScore > 0) {
                paintScore(g);
            }            
            return;
        }
        if (backgroundManager != null) {
            backgroundManager.paint((Graphics2D) g);
        }
        if (player != null) {
            player.draw((Graphics2D) g);
        }
        if (obstacleManager != null) {
            obstacleManager.draw((Graphics2D) g);
        }
        if (score != null) {
            score.draw((Graphics2D) g);
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
