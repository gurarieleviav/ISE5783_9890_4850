/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube extends RadialGeometry{
    protected Ray ray ;

    public Tube(Ray ray)
    {
        this.ray = ray;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }

    @Override
    public Vector getNormal() {
        return null;
    }
}
