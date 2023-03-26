/** @author Gur Arie Leviav
 *  @author Asaf Basali*/
package primitives;

public class Ray {
    private final Vector direction;
    private final Point start;

    /**
     * Constant to move the point by a small distance
     */
    private static final double DELTA = 0.1;

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
        this.start = head.add(normal.scale(normal.dotProduct(direction) > 0 ? this.DELTA : -this.DELTA));
        this.direction = direction.normalize();
    }
}
