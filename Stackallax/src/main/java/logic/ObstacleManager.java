/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Graphics2D;
import java.util.ArrayList;
import stackallax.entities.Obstacle;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public class ObstacleManager {
    private final ArrayList<Obstacle> obstacles = new ArrayList<>();
    
    public void spawn() {
        Obstacle o = new Obstacle(Game.WINDOWSIZE.width, 0);
        o.setMovement(new Vector2(-1 * Game.SPEED, 0));
        obstacles.add(o);
    }
    
    public void draw(Graphics2D g) {
        for (Obstacle o : obstacles) {
            o.draw(g);
        }
    }
}
