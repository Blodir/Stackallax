/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.handlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Luokka huolehtii pisteiden kirjanpidosta ja piirtämisestä.
 *
 * @author Pyry
 */
public class ScoreManager {

    private int score;

    /**
     * Kasvattaa pisteitä yhdellä
     */
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
        /*if (score > 5000) {
            g.setColor(Color.BLUE);
        } else if (score > 4000) {
            g.setColor(Color.CYAN);
        } else if (score > 3000) {
            g.setColor(Color.WHITE);
        } else if (score > 2000) {
            g.setColor(Color.YELLOW);
        } else if (score > 1000) {
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(Color.RED);
        }
        */
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", 0, 32));
        g.drawString("Score: " + score, 0, 25);
    }
}
