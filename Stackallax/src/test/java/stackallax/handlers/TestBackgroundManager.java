/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.handlers;

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
public class TestBackgroundManager {
    
    BackgroundManager bm;
    
    public TestBackgroundManager() {
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
    public void testInit() {
        bm = new BackgroundManager();
        assertTrue(bm.getBackOne().getX() == 0);
        assertTrue(bm.getBackTwo().getX() == bm.getBackOne().getImageWidth());
    }
    
    @Test
    public void testMovement() {
        bm = new BackgroundManager();
        bm.update();
        assertTrue(bm.getBackOne().getX() == bm.getBackOne().getMovement().getX());
        assertTrue(bm.getBackTwo().getX() == bm.getBackOne().getImageWidth() + bm.getBackTwo().getMovement().getX());
    }
    
    @Test
    public void testMovementOutOfScreen() {
        bm = new BackgroundManager();
        for (int i = 0; i < bm.getBackOne().getImageWidth()/((-1) * Game.SPEED / 2) + 1; i++) {
            bm.update();
        }
        assertTrue(bm.getBackTwo().getX() == bm.getBackOne().getImageWidth());
    }
    
    @Test
    public void testScrollingSpeed() {
        bm = new BackgroundManager();
        assertTrue(bm.getBackOne().getMovement().getX() == (-1) * Game.SPEED / 2);
        assertTrue(bm.getBackTwo().getMovement().getX() == (-1) * Game.SPEED / 2);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
