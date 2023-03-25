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
    /**
     * Sum two vectors triads into a new triad vector by adding the two points
     * that are constructing the vectors
     *
     * @param other the point of the second vector for adding it to the first vector
     * @return new vector, result of add
     */
    public Vector add(Vector other) {
        return new Vector(this.xyz.add(other.xyz));
    }

    /**
     * Scale (multiply) point of vector by a number into a new vector where each
     * number of the point is multiplied by the number
     *
     * @param scalar the number for scaling
     * @return new vector, result of scale
     */
    public Vector scale(double scalar) {
        return new Vector(this.xyz.scale(scalar));
    }


}
