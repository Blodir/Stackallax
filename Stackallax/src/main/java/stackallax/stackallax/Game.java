package stackallax.stackallax;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import stackallax.entities.Player;
import stackallax.graphics.BackgroundManager;
import stackallax.maths.Vector2;

/**
 *
 * @author Pyry
 */
public class Game extends JPanel implements Runnable {

    private static final String title = "Stackallax";
    public static final Dimension WINDOWSIZE = new Dimension(500, 500);
    public static final int GRAVITY = 1;
    public static final int SPEED = 5;

    private static JFrame frame;

    private Player player;
    private BackgroundManager backgroundManager;

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

    public void start() {
        player = new Player(50, 450);
        player.setMovement(new Vector2(0, 0));
        backgroundManager = new BackgroundManager();
        getFrame().addKeyListener(new InputListener(player));
        isRunning = true;
        new Thread(this).start();
    }

    public Player getPlayer() {
        return player;
    }

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

    public void update() {
        backgroundManager.update();
        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundManager != null) {
            backgroundManager.paint((Graphics2D) g);
        }
        if (player != null) {
            player.draw((Graphics2D) g);
        }
    }

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
    }

}
