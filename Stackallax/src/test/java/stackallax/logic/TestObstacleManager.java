/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import stackallax.stackallax.Game;

/**
 *
 * @author Pyry
 */
public class TestObstacleManager {
    
    ObstacleManager obs;
    
    public TestObstacleManager() {
        obs = new ObstacleManager();
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
    public void testSpawn() {
        obs.spawn();
        assertTrue(obs.getObstacles().size() == 1);
        assertTrue(obs.getObstacles().get(0).getMovement().getX() == -1 * Game.SPEED);
    }
    
    @Test
    public void testRemove() {
        obs.spawn();
        for (int i = 0; i < 200; i++) {
            obs.update();
        }
        assertTrue(obs.getObstacles().isEmpty());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}