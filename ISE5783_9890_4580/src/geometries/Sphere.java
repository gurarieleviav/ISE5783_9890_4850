/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Sphere extends RadialGeometry{
    protected Point point;

    public Sphere(Point point, double i) {
        this.point = point;
        this.radius = i;
    }


    @Override
    public Vector getNormal(Point p) {
        return p.subtract(point).normalize();
    }

    @Override
    public List<Point> findIntsersections(Ray ray)
    {
        return null;
    }

    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}
