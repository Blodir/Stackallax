package stackallax.maths;

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
import stackallax.maths.Vector2;

/**
 *
 * @author Pyry
 */
public class TestVector2 {
    
    Vector2 vector;
    
    public TestVector2() {
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
        vector = new Vector2(10, 20);
        assertTrue(vector.getX() == 10);
        assertTrue(vector.getY() == 20);
    }

    @Test
    public void testAdd() {
        vector = new Vector2(10, 20);
        vector.add(new Vector2(10, 10));
        assertTrue(vector.getX() == 20);
        assertTrue(vector.getY() == 30);
    }
    
    @Test
    public void testMultiply() {
        vector = new Vector2(10, 20);
        vector.multiply(5);
        assertTrue(vector.getX() == 50);
        assertTrue(vector.getY() == 100);
    }
    
    @Test
    public void testSetXAndSetY() {
        vector = new Vector2(10, 10);
        vector.setX(5);
        assertTrue(vector.getX() == 5);
        vector.setY(15);
        assertTrue(vector.getY() == 15);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
