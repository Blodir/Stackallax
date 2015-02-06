package stackallax.stackallax;

/**
 * Luokka huolehtii näppäimistön painallusten toiminnallisuudesta.
 * 
 * @author Pyry
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import stackallax.entities.Player;

public class InputListener implements KeyListener {

    private Player player;

    public InputListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
