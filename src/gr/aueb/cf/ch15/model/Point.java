package gr.aueb.cf.ch15.model;

/**
 * Defines a point in a line with a single coordinate (single dimension).
 */
public class Point {
    private double x;

    public Point() {

    }

    public Point(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void movePlus10() {
        x += 10;
    }

    protected void movePlusOne() {
        x += 1;
    }

    protected void printTypeOf() {
        System.out.println(this.getClass().getSimpleName());
    }

    private void reset() {
        x = 0;
    }

    @Override
    public String toString() {
        return "(" + x + ")";
    }

    /**
     * Returns the point's distance from 0.
     *
     * @return  distance from 0.
     */
    public double getDistanceFromOrigin() {
        return x;
    }
}
