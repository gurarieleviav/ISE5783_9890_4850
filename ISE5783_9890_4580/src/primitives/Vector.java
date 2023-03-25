package primitives;

public class Vector extends Point{
    /**
     * Constructor for initializing a vector from 3 double numbers (x,y,z)
     *
     * @param x first number value for x coordinate
     * @param y second number value for y coordinate
     * @param z third number value for z coordinate
     */
    public Vector(double x, double y, double z) {
        this(new Double3(x, y, z));
    }

    /**
     * Constructor for initializing a vector from a point (x,y,z)
     *
     * @param xyz point (x,y,z) for top of the vector
     */
    public Vector(Double3 xyz) {
        super(xyz);
        if (xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException();
    }

}
