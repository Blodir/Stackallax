/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.entities;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Pyry
 */
public class Obstacle extends Entity {

    public Obstacle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void update() {
        super.setX(super.getX() + super.getMovement().getX());
        super.setY(super.getY() + super.getMovement().getY());
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX(), getY(), super.getWidth(), super.getHeight());
    }
}
