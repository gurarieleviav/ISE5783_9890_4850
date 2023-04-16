/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Vector;

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

}
