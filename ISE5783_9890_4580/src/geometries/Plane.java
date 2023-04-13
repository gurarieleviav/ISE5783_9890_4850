/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane {
    private final Point point;
    private final Vector normal;

    /**
     * Constructor to build a Plane object from a point and an orthogonal vector
     *
     * @param point  on the Plane
     * @param vector normal to the plane
     */
    public Plane(Point point, Vector vector) {
        this.point = point;
        this.normal = null;
    }

    /**
     * Constructor to build a Plane from 3 Points
     *
     * @param p1 Point on the Plane
     * @param p2 Point on the Plane
     * @param p3 Point on the Plane
     * @throws IllegalArgumentException when the points are on the same line
     */
    public Plane(Point p1, Point p2, Point p3) {//ax+by+cz +d = 0
        this.point = p1;
        this.normal = p1.subtract(p2).crossProduct(p1.subtract(p3)).normalize();
    }


    public Vector getNormal() {
        return null;
    }


    public Vector getNormal(Point point) {
        return null;
    }

}