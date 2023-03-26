/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Vector;

public interface Geometry {
    /**
     * finds the normal of the geometry at the given point
     * on the surface of the geometry
     *
     * @param point on the geometry
     * @return the normal of the geometry
     */
    abstract public Vector getNormal(Point point);

    Vector getNormal();
}
