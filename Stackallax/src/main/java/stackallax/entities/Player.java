package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 * Luokka huolehtii pelihahmon tiedoista, liikkumisesta ja piirrosta
 * 
 * @author Pyry
 */
public class Player extends Entity {

    public static final int PLAYERWIDTH = 50;
    public static final int PLAYERHEIGHT = 50;
    
    private boolean canJump = true;

    public boolean isCanJump() {
        return canJump;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }
    
    public Player(int x, int y) {
        super(x, y, PLAYERWIDTH, PLAYERHEIGHT);
    }
    
    /**
     * Lisää pelaajalle vertikaalista vauhtia
     */

    public void jump() {
        if (canJump) {
            super.getMovement().setY(-15);
        }
    }
}
