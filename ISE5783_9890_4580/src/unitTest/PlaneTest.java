package unitTest;

import geometries.Plane;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for geometries.Plane class
 *
 * @author Gur Arie Leviav
 * @author Asaf Basali
 */
class PlaneTest {

    /**
     * Test method for {@link geometries.Plane#Plane(primitives.Point, primitives.Point, primitives.Point)}
     */
    @Test
    void testConstructor() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 1, 1);

        // EP01: 2 points of the 3 are unifying
        assertThrows(IllegalArgumentException.class, () -> new Plane(p1, p1, p1.add(new Vector(1, 1, 1))),
                "ERROR: does not throw an exception when 2 points are the same");

        // EP02: the points are on the same line
        assertThrows(IllegalArgumentException.class, () -> new Plane(p1, p1.add(new Vector(2, 2, 2)), p1.add(new Vector(1, 1, 1))),
                "ERROR: does not throw an exception when the points are on the same line");
    }

    /**
     * Test method for {@link Plane#getNormal()}
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // EP01: There is a simple single test here
        Point p = new Point(1, 1, 1);
        Plane plane = new Plane(p, new Point(1, 2, 1), new Point(1, 1, 2));
        assertTrue(plane.getNormal().equals(new Vector(1, 0, 0))
                        || plane.getNormal().equals(new Vector(-1, 0, 0)),
                "ERROR: getnormal method in Plane does not work properly");
    }



}