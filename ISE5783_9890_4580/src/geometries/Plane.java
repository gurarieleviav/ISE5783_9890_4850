/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;


import java.util.LinkedList;
import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane implements Geometry {
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
        this.normal = vector;
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
    /**
     * Gets a point on the plane
     *
     * @return a point
     */
    public Point getP0() {
        return point;
    }

    @Override
    public Vector getNormal(Point point) {
        return this.normal;
    }


    public Vector getNormal() {return this.normal;
    }


    @Override
    public List<Point> findIntersections(Ray ray) {
        Vector rayDir = ray.getDirection();
        Point rayP0 = ray.getStart();
        // if they are parallel
        if (isZero(rayDir.dotProduct(normal)))
            return null;

        //t = n * (Q - Po) / n * v: t>0
        try {
            double t = alignZero(normal.dotProduct(point.subtract(rayP0)) / normal.dotProduct(rayDir));
            if (t <= 0)
                return null;
            //p = P0 + t*v
            Point point = rayP0.add(rayDir.scale(t));
            List<Point> pointList = new LinkedList<>();
            pointList.add(point);
            return pointList;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}