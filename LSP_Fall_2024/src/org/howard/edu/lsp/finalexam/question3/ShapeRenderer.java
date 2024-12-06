package org.howard.edu.lsp.finalexam.question3;

/**
 * ShapeRenderer class that uses ShapeFactory to render shapes.
 */
public class ShapeRenderer {
    public void renderShape(String shapeType) {
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape = factory.createShape(shapeType);

        if (shape != null) {
            shape.draw();
        } else {
            System.out.println("Unknown shape type: " + shapeType);
        }
    }

    public static void main(String[] args) {
        ShapeRenderer renderer = new ShapeRenderer();

        // Render different shapes
        renderer.renderShape("circle");    // Output: Drawing a Circle
        renderer.renderShape("rectangle"); // Output: Drawing a Rectangle
        renderer.renderShape("triangle");  // Output: Drawing a Triangle
        renderer.renderShape("hexagon");   // Output: Unknown shape type: hexagon
    }
}

//Refrences: https://refactoring.guru/design-patterns/factory-method 
//https://www.baeldung.com/java-factory-pattern
//https://www.geeksforgeeks.org/singleton-design-pattern/
//https://www.geeksforgeeks.org/singleton-design-pattern-in-java/
//https://junit.org/junit5/docs/current/user-guide/
//https://google.github.io/styleguide/javaguide.html
//https://docs.oracle.com/javase/tutorial/
//https://www.geeksforgeeks.org/solid-principle-in-programming-understand-with-real-life-examples/