package gr.aueb.cf.ch12.pointapp;

import gr.aueb.cf.ch12.pointapp.model.PointXYZ;

/**
 * Creates instances of PointXYZ class and uses its methods.
 */
public class PointXYZApp {

    public static void main(String[] args) {
        PointXYZ p1 = new PointXYZ(2, 2, 4);
        PointXYZ p2 = new PointXYZ(3, 1, 0);

        p1.setX(5);
        p2.setZ(8);

        System.out.println("p1 y: " + p1.getY());
        System.out.println("p2 x: " + p2.getX());
        System.out.println("p1: " + p1.convertToString());
        System.out.println("p2: " + p2.convertToString());
    }
}
