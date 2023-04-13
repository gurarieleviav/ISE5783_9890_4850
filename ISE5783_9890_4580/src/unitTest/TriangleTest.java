package unitTest;

import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for geometries.Plane class
 *
 * @author Gur Arie Leviav
 * @author Asaf Basali
 */
class TriangleTest {

    /**
     * Test method for {@link geometries.Triangle#getNormal(primitives.Point)}
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // EP01: There is a simple single test here
        Point p = new Point(1, 1, 1);
        Triangle triangle = new Triangle(p, new Point(1, 2, 1), new Point(1, 1, 2));
        assertTrue(triangle.getNormal(p).equals(new Vector(1, 0, 0))
                        || triangle.getNormal(p).equals(new Vector(-1, 0, 0)),
                "ERROR: getnormal method in Triangle does not work properly");
    }


}