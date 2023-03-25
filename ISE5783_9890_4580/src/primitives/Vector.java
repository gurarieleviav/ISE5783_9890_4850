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

    public double dotProduct(Vector other) {
        return this.xyz.d1 * other.xyz.d1 + this.xyz.d2 * other.xyz.d2 + this.xyz.d3 * other.xyz.d3;
    }

    /**
     * Product two vectors into a new vector, witch is a vector that is perpendicular to both vectors
     * and thus normal to the plane containing them.
     *
     * @param other the second vector for cross-product
     * @return vector, result of cross-product
     */
    public Vector crossProduct(Vector other) {
        return new Vector(this.xyz.d2 * other.xyz.d3 - this.xyz.d3 * other.xyz.d2,
                this.xyz.d3 * other.xyz.d1 - this.xyz.d1 * other.xyz.d3,
                this.xyz.d1 * other.xyz.d2 - this.xyz.d2 * other.xyz.d1);
    }

    /**
     * calculates the length squared of the vector.
     *
     * @return number, the length squared of the vector.
     */
    public double lengthSquared() {
        return dotProduct(this);
    }

}
