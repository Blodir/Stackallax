/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.graphics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pyry
 */
public class TestBackground {
    
    Background back;
    
    public TestBackground() {
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
    public void testSetX() {
        back = new Background(0, 0, "");
        back.setX(27);
        assertTrue(back.getX() == 27);
    }
    
    @Test
    public void testSetY() {
        back = new Background(0, 0, "");
        back.setY(32);
        assertTrue(back.getY() == 32);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
