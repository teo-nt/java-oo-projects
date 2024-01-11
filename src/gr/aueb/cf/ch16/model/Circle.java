package gr.aueb.cf.ch16.model;

public class Circle extends AbstractShape implements ITwoDimensional {
    private double radius;
    private static final double PI = 3.14159;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
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

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}
