/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere extends RadialGeometry{
    protected Point point;

    public Sphere(Point point, int i) {
        this.point = point;
        this.radius = i;
    }


    @Override
    public Vector getNormal(Point p) {
        return p.subtract(point).normalize();
    }

}
