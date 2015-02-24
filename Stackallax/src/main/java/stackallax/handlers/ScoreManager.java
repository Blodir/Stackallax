/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.handlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka huolehtii pisteiden kirjanpidosta ja piirtämisestä.
 *
 * @author Pyry
 */
public class ScoreManager {

    private int score;
    FileWriter fw;
    File file;

    public ScoreManager() {
        file = new File("Highscores.txt");
    }

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

    public int[] getHighscoreList() {
        ArrayList<Integer> allHighscores = new ArrayList<>();
        allHighscores.add(score);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int sc = Integer.parseInt(scanner.nextLine());
                allHighscores.add(sc);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.sort(allHighscores);
        Collections.reverse(allHighscores);

        int[] top10 = new int[10];
        for (int i = 0; i < 10; i++) {
            top10[i] = allHighscores.get(i);
        }

        return top10;
    }

    public void writeHighscores() {

        int[] top10 = getHighscoreList();
        try {
            fw = new FileWriter(file);
        } catch (IOException ex) {
            Logger.getLogger(ScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int u : top10) {
                System.out.println(u);
                fw.write(u + "\n");
            }
            fw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
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
