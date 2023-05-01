package primitives;


import java.util.List;

import static primitives.Util.isZero;

/**@author Gur Arie Leviav
 * @author Asaf Basali
 */
public class Ray {
    private final Vector direction;
    private final Point start;


    /**
     * Constructor to create a Ray from a Point to direction of dir
     *
     * @param start Point: start of the Ray
     * @param dir   Vector: direction of Ray
     */
    public Ray(Point start, Vector dir) {
        this.start = start;
        this.direction = dir.normalize();
    }

    /**
     * Constructs a ray, the head is moved by DELTA
     *
     * @param head      The head of the ray
     * @param direction The direction of the ray
     * @param normal    The normal to the geometry, on this vector's line the point will move
     */
    public Ray(Point head, Vector direction, Vector normal) {
        this.start = head;
        this.direction = direction.normalize();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ray other)) return false;
        return this.direction.equals(other.direction) && this.start.equals(other.start);
    }

    /**
     * Getter for the ray's direction Vector
     *
     * @return the direction vector
     */
    public Vector getDirection() {
        return this.direction;
    }

    /**
     * Getter for the ray's starting Point
     *
     * @return the start Point
     */
    public Point getStart() {
        return this.start;
    }

    /**
     * Calculates a point on the line of the ray at a given distance from the starting point
     *
     * @param t the distance from the starting point
     * @return the point on the line of the ray
     */
    public Point getPoint(double t) {
        return isZero(t) ? this.start : this.start.add(this.direction.scale(t));
    }

    @Override
    public String toString() {
        return "Ray{" +
                "direction=" + direction +
                ", start=" + start +
                '}';
    }
}