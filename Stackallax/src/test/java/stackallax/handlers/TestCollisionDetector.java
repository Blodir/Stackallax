/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.handlers;

import stackallax.handlers.ObstacleManager;
import stackallax.handlers.CollisionDetector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import stackallax.entities.Player;
import stackallax.maths.Vector2;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public class TestCollisionDetector {
    
    CollisionDetector cd;
    Player p;
    ObstacleManager om;
    
    public TestCollisionDetector() {
        p = new Player(50, 450);
        om = new ObstacleManager();
        cd = new CollisionDetector(p, om);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void playerIsOnGroundLevel() {
        p.setX(0);
        p.setY(Game.WINDOWSIZE.height);
        p.setMovement(new Vector2(0, -10));
        cd.update();
        assertTrue(p.getY() == Game.WINDOWSIZE.height - 50);
        assertTrue(p.getMovement().getY() == 0);
    }
    
    @Test
    public void playerIsFalling() {
        p.setX(0);
        p.setY(100);
        p.setMovement(new Vector2(0, 10));
        cd.update();
        assertTrue(p.getMovement().getY() == 11);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
