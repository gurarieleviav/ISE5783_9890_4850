/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

public class Tube extends RadialGeometry{
    protected Ray ray ;

    public Tube(Ray ray) {
        this.ray = ray;
        this.radius = radius;
    }

    @Override
    public Vector getNormal(Point point) {
        Vector dir = this.ray.getDirection();
        Point p0 = this.ray.getStart();
        double t = dir.dotProduct(point.subtract(p0));
        Point o = isZero(t) ? p0 : p0.add(dir.scale(t));
        return point.subtract(o).normalize();
    }

    @Override
    public List<Point> findIntsersections(Ray ray)
    {
        return null;
    }

    public <E> List<E> findIntersections(Ray ray) {
        return null;
    }
}
