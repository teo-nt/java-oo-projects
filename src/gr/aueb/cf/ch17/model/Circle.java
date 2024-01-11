package gr.aueb.cf.ch17.model;

import java.io.Serializable;

/**
 * Defines a circle.
 */
public class Circle extends AbstractShape implements ITwoDimensional, Serializable, Cloneable {
    private double radius;
    private static final double PI = 3.14159;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    // Copy constructor
    public Circle(Circle circle) {
        this.radius = circle.radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    /**
     * Calculate circle's area.
     *
     * @return  area of the circle.
     */
    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Circle circle = (Circle) o;

        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
