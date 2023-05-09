/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * Geometry interface represents three-dimensional objects system
 *
 * @author Gur arie Leviav
 * @author Asaf Basali
 */
public interface Geometry extends Intersectable {
    /**
     * finds the normal of the geometry at the given point
     * on the surface of the geometry
     *
     * @param point on the geometry
     * @return the normal of the geometry
     */
    Vector getNormal(Point point);

    /**
     * Finds all intersection points
     *
     * @param ray the ray
     * @return all intersection points with the ray
     */
    @Override
    default List<Point> findIntersections(Ray ray) {
        return null;
    }
}
