package geometries;
import primitives.*;
import java.util.List;
/**
 * basic interface for intersectable geometries.
 *
 * @author Gur Arie Leviav
 * @author Asaf Basali
 */
public interface Intersectable {
    /**
     * Finds all intersection points
     *
     * @param ray the ray
     * @return all intersection points with the ray
     */
    List<Point> findIntersections(Ray ray);
}
