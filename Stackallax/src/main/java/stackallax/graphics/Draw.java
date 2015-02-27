/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import stackallax.entities.Obstacle;
import stackallax.entities.Player;
import stackallax.handlers.BackgroundManager;
import stackallax.handlers.ObstacleManager;
import stackallax.handlers.ScoreManager;
import static stackallax.stackallax.Game.WINDOWSIZE;

/**
 * Hoitaa kaikki piirto-operaatiot
 * 
 * @author Pyry
 */
public class Draw {
    
    /**
     * Piirtää backgroundmanageriin varastoidut taustat
     * 
     * @param g grafiikkamuuttuja jolla piirretään
     * @param bm BackgroundManager josta piirrettävät taustat haetaan
     */

    public void drawAllBackgrounds(Graphics2D g, BackgroundManager bm) {
        for (Background b : bm.getBackgrounds()) {
            drawBackground(g, b);
        }
    }
    
    /**
     * Piirtää pelaajan grafiikkaan g
     * 
     * @param g grafiikkamuuttuja jolla pelaaja piirretään
     * @param p pelaaja joka piirretään
     */
    
    public void drawPlayer(Graphics2D g, Player p) {
        g.setColor(Color.RED);
        g.fillRect(p.getX(), p.getY(), 50, 50);
    }
    
    /**
     * Piirtää esteen grafiikkaan g
     * @param g 
     */
    
    public void drawObstacle(Graphics2D g, Obstacle o) {
        g.setColor(Color.BLUE);
        g.fillRect(o.getX(), o.getY(), o.getWidth(), o.getHeight());
    }
    
    /**
     * Piirtää ObstacleManageriin varastoidut esteet
     * 
     * @param g grafiikkamuuttuja jolla piirretään
     * @param om ObstacleManager josta piirrettävät esteet haetaan
     */
    
    public void drawAllObstacles(Graphics2D g, ObstacleManager om) {
        for (Obstacle o : om.getObstacles()) {
            drawObstacle(g, o);
        }
    }
    
    /**
     * Piirtää taustan
     * @param g grafiikkamuuttuja jolla piirretään
     * @param b tausta joka piirretään
     */
    
    public void drawBackground(Graphics2D g, Background b) {
        g.drawImage(b.getImage(), b.getX(), b.getY(), null);
    }
    
    /**
     * Piirtää nykyisen pistetilanteen
     * @param g Grafiikkaolio jolla pisteet piirretään
     * @param score ScoreManager jonka pisteet piirretään
     */

    public void drawCurrentScore(Graphics2D g, ScoreManager score) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", 0, 32));
        g.drawString("Score: " + score.getScore(), 0, 25);
    }
    
    /**
     * Tulostaa highscore listan näytölle
     * @param g grafiikkamuuttuja jolla piirretään
     * @param score pisteet jotka piirretään
     */

    public void paintScore(Graphics g, ScoreManager score) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", 0, 32));
        g.drawString("GAME OVER", (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 - 150);
        g.drawString("Press any key to continue", (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 - 100);
        g.drawString("Score: " + score.getScore(), (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 - 50);
            
        g.drawString("Highscores: ", (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2);
        g.setFont(new Font("Arial", 0, 16));
        int[] highscores = score.getHighscoreList();
        for (int i = 0; i < highscores.length; i++) {
            g.drawString((i + 1) + ". " + highscores[i], (WINDOWSIZE.width / 2) - 150, WINDOWSIZE.height / 2 + (20 * (i + 1)));
        }
    }
}
