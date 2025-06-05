package com.cbfacademy.shapes;

/**
 * An abstract class representing a Shape.
 */
public abstract class Shape {
    private String shapeName;

    public Shape() {
        this("Shape");
    }

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }
    /**
     * Abstract method to calculate the area of the shape.
     *
     * @return The area of the shape.
     */
    public abstract double getArea();

    /**
     * Get the name of the shape.
     *
     * @return The name of the shape.
     */
    public String getName() {
        return shapeName;
    }
}
