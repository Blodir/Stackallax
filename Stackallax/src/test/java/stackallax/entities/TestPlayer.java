package stackallax.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import stackallax.entities.Player;
import stackallax.maths.Vector2;

/**
 *
 * @author Pyry
 */
public class TestPlayer {
    
    Player player;
    
    public TestPlayer() {
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
    public void testConstructor() {
        player = new Player(10, 10);
        assertTrue(player.getX() == 10);
        assertTrue(player.getY() == 10);
    }
    
    /*@Test
    public void testMovement() {
        player = new Player(10, 10);
        player.setMovement(new Vector2(10, -10));
        for (int i = 0; i < 2; i++) {
            player.update();
        }
        assertTrue(player.getX() == 30);
        assertTrue(player.getY() == -10);
    }*/
    
    @Test
    public void testGetMovement() {
        player = new Player(10, 10);
        Vector2 vector = new Vector2(10, 10);
        player.setMovement(vector);
        assertTrue(player.getMovement().equals(vector));
    }
    
    @Test
    public void testSetXAndSetY() {
        player = new Player(10, 10);
        player.setX(5);
        assertTrue(player.getX() == 5);
        player.setY(15);
        assertTrue(player.getY() == 15);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
