/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;

public class Cylinder extends Tube{
   private final double height;

    public Cylinder(double height, Ray ray) {
        super(ray);
        if(height<0){throw new IllegalArgumentException("A Cylinder cant have negative height");}
        else {this.height = height;}
    }

    @Override
    public Vector getNormal(Point point) {return null;}
}
