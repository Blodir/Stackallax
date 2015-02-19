package stackallax.handlers;

/**
 * Luokka huolehtii näppäimistön painallusten toiminnallisuudesta.
 * 
 * @author Pyry
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import stackallax.entities.Player;
import stackallax.stackallax.Game;

public class KeyboardHandler implements KeyListener {

    private Player player;
    private Game game;

    public KeyboardHandler(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.jump();
        }
        if (game.isRunning() == false) {
            game.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
