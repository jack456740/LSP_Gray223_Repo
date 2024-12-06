package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ShapeRenderer and ShapeFactory classes.
 */
public class ShapeRendererTest {

    @Test
    void testCircleShapeCreation() {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape("circle");
        assertNotNull(shape);
        assertTrue(shape instanceof Circle);
    }

    @Test
    void testRectangleShapeCreation() {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape("rectangle");
        assertNotNull(shape);
        assertTrue(shape instanceof Rectangle);
    }

    @Test
    void testTriangleShapeCreation() {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape("triangle");
        assertNotNull(shape);
        assertTrue(shape instanceof Triangle);
    }

    @Test
    void testUnknownShapeCreation() {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape("hexagon");
        assertNull(shape);
    }

    @Test
    void testFactorySingleton() {
        ShapeFactory factory1 = ShapeFactory.getInstance();
        ShapeFactory factory2 = ShapeFactory.getInstance();
        assertSame(factory1, factory2); // Both references should point to the same instance
    }
}
