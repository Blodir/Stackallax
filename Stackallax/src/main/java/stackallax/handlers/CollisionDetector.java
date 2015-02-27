/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.handlers;

import stackallax.entities.Obstacle;
import stackallax.entities.Player;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 * Luokka tarkistaa osuuko pelaaja muihin peliobjekteihin ja valitsee asianmukaisen toimenpiteen.
 *
 * @author Pyry
 */
public class CollisionDetector {
    private Player player;
    private ObstacleManager obstacleManager;
    
    public CollisionDetector(Player p, ObstacleManager om) {
        player = p;
        obstacleManager = om;
    }
    /**
     * Tarkistaa että pelaaja ei ole osunut esteeseen sivusuunnassa sekä korjaa pelaajan liikkumisvektorin jos osuu maahan tai jonkin esteen päälle.
     * 
     * @return Palauttaa false jos pelaaja teki laittoman osuman, muuten true.
     */
    
    public boolean update() {
        //ground collision
        if (player.getY() >= Game.WINDOWSIZE.height - player.getHeight()) {
            player.getMovement().setY(0);
            player.setY(Game.WINDOWSIZE.height - player.getHeight());
            player.setCanJump(true);
        } else {
            player.getMovement().setY(player.getMovement().getY() + Game.GRAVITY);
            player.setCanJump(false);
        }
        
        for (Obstacle obstacle : obstacleManager.getObstacles()) {
            if (obstacle.getBounds().intersects(player.getBounds())) {
                player.setCanJump(true);
                //if obstacle intersects player
                /*if (player.getY() > obstacle.getY() - obstacle.getHeight() + 10) {
                    //if player is lower than obstacle
                    return false; //game over
                } else {
                    //if player is on top of the obstacle
                    player.getMovement().setY(0);
                }
                */
                if (player.getMovement().getY() > 0) { //if player has positive vertical velocity (is going towards the ground)
                    
                    if ((player.getX() + player.getWidth() - obstacle.getX())/((-1) * obstacle.getMovement().getX()) >
                    (player.getY() + player.getHeight() - obstacle.getY())/((2 * player.getY()) - player.getMovement().getY())) {
                        player.setY(obstacle.getY() - obstacle.getHeight());
                        player.getMovement().setY(0);
                    }
                } else {
                    return false;
                }
            }
            
            if (player.getY() == obstacle.getY() - obstacle.getHeight()) {
                player.setCanJump(true);
            }
        }
        return true; //game continues
    }
}
