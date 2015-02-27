/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackallax.entities;

import java.awt.Graphics2D;
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
public class TestEntity {
    
    Entity entity;
    
    public TestEntity() {
        
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
    public void testGetMovement() {
        entity = new Entity(10, 10, 50, 50) {
        };
        Vector2 vector = new Vector2(10, 10);
        entity.setMovement(vector);
        assertTrue(entity.getMovement().equals(vector));
    }
    
    @Test
    public void testSetXAndSetY() {
        entity = new Entity(10, 10, 50, 50) {
        };
        entity.setX(5);
        assertTrue(entity.getX() == 5);
        entity.setY(15);
        assertTrue(entity.getY() == 15);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
