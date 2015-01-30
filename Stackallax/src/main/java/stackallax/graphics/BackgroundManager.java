/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.graphics;

import java.awt.Graphics2D;
import javax.swing.JFrame;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public class BackgroundManager {

    private Background backOne;
    private Background backTwo;

    private Vector2 scrollingSpeed;

    public BackgroundManager() {
        backOne = new Background(0, 0);
        backTwo = new Background(backOne.getImageWidth(), 0);
        scrollingSpeed = new Vector2(-1, 0);
        backOne.setMovement(scrollingSpeed);
        backTwo.setMovement(scrollingSpeed);
    }

    public void update() {
        backOne.update();
        backTwo.update();

        // Move background if out of screen
        if (backOne.getX() + backOne.getImageWidth() <= 0) {
            backOne.setX(backOne.getImageWidth());
        }
        if (backTwo.getX() + backTwo.getImageWidth() <= 0) {
            backTwo.setX(backTwo.getImageWidth());
        }
    }

    public void paint(Graphics2D g) {
        backOne.draw(g);
        backTwo.draw(g);
        System.out.println("backone" + backOne.getX() + ", " + backOne.getY());
        System.out.println("backtwo" + backTwo.getX() + ", " + backTwo.getY());
    }
}
