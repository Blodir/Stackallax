/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import stackallax.entities.Obstacle;
import stackallax.entities.Player;
import stackallax.maths.Vector2;

/**
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
    
    public boolean update() {
        for (Obstacle obstacle : obstacleManager.getObstacles()) {
            if (obstacle.getBounds().intersects(player.getBounds())) {
                //if obstacle intersects player
                if (player.getY() > obstacle.getY() - obstacle.getHeight() + 10) {
                    //if player is lower than obstacle
                    return false; //game over
                } else {
                    //if player is on top of the obstacle
                    player.setMovement(new Vector2(0, 0));
                }
            }
        }
        return true; //game continues
    }
}
