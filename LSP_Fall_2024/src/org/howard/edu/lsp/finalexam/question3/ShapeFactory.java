package org.howard.edu.lsp.finalexam.question3;

/**
 * Factory class to create Shape objects.
 */
public class ShapeFactory {
    private static ShapeFactory instance;

    // Private constructor to enforce singleton
    private ShapeFactory() {}

    /**
     * Returns the singleton instance of the ShapeFactory.
     *
     * @return the singleton instance.
     */
    public static synchronized ShapeFactory getInstance() {
        if (instance == null) {
            instance = new ShapeFactory();
        }
        return instance;
    }

    /**
     * Creates a Shape object based on the provided shape type.
     *
     * @param shapeType the type of shape to create.
     * @return a Shape object, or null if the type is unknown.
     */
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("triangle")) {
            return new Triangle();
        }
        return null; // Unknown shape type
    }
}
