package gr.aueb.cf.ch12.pointapp.model;

/**
 * Creates 3D points with coordinates as (x, y, z).
 */
public class PointXYZ {
    private int x;
    private int y;
    private int z;

    public PointXYZ() {}

    public PointXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Returns the state of this point.
     *
     * @return      the x, y, z coordinates transformed into String (x, y, z).
     */
    public String convertToString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
