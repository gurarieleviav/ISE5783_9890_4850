package geometries;

import primitives.Point;
import primitives.Vector;

public class Cylinder extends Tube{
    private final Point point;

    public Cylinder(Point point) {
        this.point = point;
    }

    @Override
    public Vector getNormal(Point point) {return null;}
}
