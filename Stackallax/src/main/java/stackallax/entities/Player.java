/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.entities;

import java.awt.Graphics2D;
import stackallax.maths.Vector2;

/**
 *
 * @author Pyry
 */
public class Player {

    private int x;
    private int y;
    private Vector2 movement;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMovement(Vector2 movement) {
        this.movement = movement;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2 getMovement() {
        return movement;
    }
    
    public void update() {
        
    }
    
    public void draw(Graphics2D g) {
        
    }
}
