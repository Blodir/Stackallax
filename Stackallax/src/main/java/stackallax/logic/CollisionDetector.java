/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.logic;

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
        if (player.getY() >= Game.WINDOWSIZE.height - 50) {
            player.getMovement().setY(0);
            player.setY(Game.WINDOWSIZE.height - 50);
        } else {
            player.getMovement().setY(player.getMovement().getY() + Game.GRAVITY);
        }
        
        for (Obstacle obstacle : obstacleManager.getObstacles()) {
            if (obstacle.getBounds().intersects(player.getBounds())) {
                //if obstacle intersects player
                if (player.getY() > obstacle.getY() - obstacle.getHeight() + 10) {
                    //if player is lower than obstacle
                    return false; //game over
                } else {
                    //if player is on top of the obstacle
                    player.getMovement().setY(0);
                }
            }
        }
        return true; //game continues
    }
}
