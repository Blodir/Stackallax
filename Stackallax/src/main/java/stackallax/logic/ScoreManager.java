/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.logic;

import java.awt.Graphics2D;

/**
 * Luokka huolehtii pisteiden kirjanpidosta ja piirtämisestä.
 *
 * @author Pyry
 */
public class ScoreManager {

    private int score;
    
    public void increase() {
        score++;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void draw(Graphics2D g) {
        if (score % 10 == 0) {
            System.out.println(score);
        }
    }
}
