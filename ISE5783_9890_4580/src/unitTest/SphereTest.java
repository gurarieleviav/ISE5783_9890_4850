package unitTest;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for geometries.Plane class
 *
 * @author Asaf Basali
 * @author Gur Arie Leviav
 */
class SphereTest {

    /**
     * Test method for {@link geometries.Plane#getNormal(primitives.Point)}
     */
    @Test
    void getNormal() {
        Sphere sphere = new Sphere(new Point(0,0,0), 1);

        // ============ Equivalence Partitions Tests ==============
        // T01: Test that the getNormal function on Sphere is calculated correctly
        Point p1 = new Point(0, 0, 1);
        assertEquals(sphere.getNormal(p1), new Vector(0, 0, 1),
                "Sphere getNormal function gives wrong normal.");
    }


}