package gr.aueb.cf.ch17.model;

import java.io.Serializable;

/**
 * Defines a line.
 */
public class Line extends AbstractShape implements Serializable, Cloneable {
    private double length;

    public Line() {

    }

    public Line(double length) {
        this.length = length;
    }

    // Copy constructor
    public Line(Line line) {
        this.length = line.length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Line{" +
                "length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Line line = (Line) o;

        return Double.compare(length, line.length) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }
}
