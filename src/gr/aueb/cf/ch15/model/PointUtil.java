package gr.aueb.cf.ch15.model;

/**
 * Utility class that calculates the distance of a Point
 * instance from origin.
 *
 * @author thodoris
 */
public class PointUtil {
    private PointUtil() {

    }

    /**
     * Returns point's distance from origin.
     *
     * @param point
     *      input Point.
     * @return
     *      point's distance from origin.
     */
    public static double distanceFromOrigin(Point point) {
        return point.getDistanceFromOrigin();
    }
}
