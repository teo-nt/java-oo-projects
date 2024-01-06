package gr.aueb.cf.ch15;

import gr.aueb.cf.ch15.model.*;

/**
 * Calculates the distance of any point ({@link gr.aueb.cf.ch15.model.Point}, {@link gr.aueb.cf.ch15.model.Point2D},
 * {@link gr.aueb.cf.ch15.model.Point3D}) from origin.
 *
 * @see gr.aueb.cf.ch15.model.PointUtil
 * @author thodoris
 */
public class PointApp {

    public static void main(String[] args) {
        Point p1 = new Point(2);
        Point2D p2 = new Point2D(3, 4);
        Point3D p3 = new Point3D(1, 2, 2);

        System.out.println("p1 distance from origin: " + PointUtil.distanceFromOrigin(p1));
        System.out.println("p2 distance from origin: " + PointUtil.distanceFromOrigin(p2));
        System.out.println("p3 distance from origin: " + PointUtil.distanceFromOrigin(p3));
    }
}
