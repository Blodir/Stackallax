package stackallax.stackallax;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import stackallax.entities.Player;

/**
 *
 * @author Pyry
 */
public class Game extends Component implements Runnable {

    private static final String title = "Stackallax";
    public static final Dimension windowSize = new Dimension(500, 500);
    
    private Player player;
    
    private int FPS;
    
    // How much time should elapse before the screen is updated
    private long targetTime;

    private boolean isRunning;

    public Game() {
        setPreferredSize(windowSize);
        isRunning = false;
        FPS = 60;
        targetTime = 1000 / FPS;
    }

    public void start() {
        isRunning = true;
        new Thread(this).start();
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame(title);
        Game game = new Game();

        frame.add(game);
        frame.pack();

        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
    
    public void update() {
        player.update();
    }

    @Override
    public void run() {
        //MAIN GAME LOOP
        while (isRunning) {

        }
    }

}
