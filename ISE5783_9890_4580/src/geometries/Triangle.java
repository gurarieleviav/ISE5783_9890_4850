/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;

public class Triangle extends Polygon {
    /**
     * Constructor that generates a triangle from 3 given points
     *
     * @param vertices 3 Point
     */
    public Triangle(Point... vertices) {
        super(vertices);
    }



    public List<Point> findIntersections(Ray ray, double maxDistance) {
// First check the intersections with the plane
        Point point0 = vertices.get(0);
        Point point1 = vertices.get(1);
        Point point2 = vertices.get(2);

        Vector normal = (point0.subtract(point1).crossProduct(point1.subtract(point2))).normalize();
        Plane plane = new Plane(point0, normal);
        List<Point> pointList = plane.findIntersections(ray);
        if (pointList == null)
            return null;

        Point rayP0 = ray.getStart();
        Vector rayDir = ray.getDirection();
        // After check if they're in the triangle
        Vector v1 = (rayP0.subtract(point0));
        Vector v2 = (rayP0.subtract(point1));
        double vn1 = alignZero(rayDir.dotProduct((v1.crossProduct(v2)).normalize()));
        if (vn1 == 0) return null;

        Vector v3 = (rayP0.subtract(point2));
        double vn2 = alignZero(rayDir.dotProduct((v2.crossProduct(v3)).normalize()));
        if (vn1 * vn2 <= 0) return null;

        double vn3 = alignZero(rayDir.dotProduct((v3.crossProduct(v1)).normalize()));
        if (vn1 * vn3 <= 0) return null;

        return List.of(pointList.get(0));
    }
}
