package stackallax.stackallax;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends Component implements Runnable {
    private static final String title = "Stackallax";
    public static final Dimension windowSize = new Dimension(500, 500);
    
    private boolean isRunning;
    
    public Game() {
        setPreferredSize(windowSize);
        isRunning = false;
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

    @Override
    public void run() {
        //MAIN GAME LOOP
        while (isRunning) {
            
        }
    }

}