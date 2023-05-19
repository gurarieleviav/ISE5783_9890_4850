/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Vector;

public abstract class RadialGeometry extends Geometry {
    protected double radius;

    public abstract Vector getNormal(Point point);
}
