/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.handlers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import stackallax.graphics.Background;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 * Luokka huolehtii taustojen varastoinnista sekä piirrosta
 * 
 * @author Pyry
 */
public class BackgroundManager {
    
    private String back1 = "background.png";
    private String back2 = "background2.png";
    
    private Background backOne;
    private Background backTwo;
    private Background backThree;
    private Background backFour;
    
    private ArrayList<Background> backgrounds;

    private Vector2 scrollingSpeed;
    private Vector2 scrollingSpeed2;

    public BackgroundManager() {
        backOne = new Background(0, 0, back1);
        backTwo = new Background(backOne.getImageWidth(), 0, back1);
        backThree = new Background(0, 0, back2);
        backFour = new Background(backThree.getImageWidth(), 0, back2);
        
        scrollingSpeed = new Vector2(-1 * (Game.SPEED / 4), 0);
        scrollingSpeed2 = new Vector2(-1 * (Game.SPEED / 2), 0);
        
        backOne.setMovement(scrollingSpeed);
        backTwo.setMovement(scrollingSpeed);
        backThree.setMovement(scrollingSpeed2);
        backFour.setMovement(scrollingSpeed2);
        
        backgrounds = new ArrayList<Background>();
        backgrounds.add(backOne);
        backgrounds.add(backTwo);
        backgrounds.add(backThree);
        backgrounds.add(backFour);
    }
    
    /**
     * Kutsuu taustojen update() metodeita ja varmistaa että taustat ovat näkyvillä ruudulla
     */

    public void update() {
        backOne.update();
        backTwo.update();
        backThree.update();
        backFour.update();

        // Move background if out of screen
        if (backOne.getX() + backOne.getImageWidth() <= 0) {
            backOne.setX(backOne.getImageWidth());
        }
        if (backTwo.getX() + backTwo.getImageWidth() <= 0) {
            backTwo.setX(backTwo.getImageWidth());
        }
        if (backThree.getX() + backThree.getImageWidth() <= 0) {
            backThree.setX(backThree.getImageWidth());
        }
        if (backFour.getX() + backFour.getImageWidth() <= 0) {
            backFour.setX(backFour.getImageWidth());
        }
    }
    
    public ArrayList<Background> getBackgrounds() {
        return backgrounds;
    }
    
    public Background getBackOne() {
        return backOne;
    }
    
    public Background getBackTwo() {
        return backTwo;
    }
}
