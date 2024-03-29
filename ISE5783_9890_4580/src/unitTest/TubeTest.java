package unitTest;

import geometries.*;
import primitives.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for geometries.Plane class
 *
 * @author Gur Arie Leviav
 * @author Asaf Basali
 */
class TubeTest {

    /**
     * Test method for {@link geometries.Plane#getNormal(primitives.Point)}
     */
    @Test
    void testGetNormal() {
        Tube t = new Tube(new Ray(new Point(0, 0, 0), new Vector(1, 0, 0)), 3);
        // ============ Equivalence Partitions Tests ==============
        // EP01: Point is on the Tube
        assertEquals(t.getNormal(new Point(1, 0, 3)), new Vector(0, 0, 1),
                "normal for tube is not working properly at random point");

        // ============ Boundary Value Tests ====================
        // BV01: Point is parallel to the starting point of the ray
        assertEquals(t.getNormal(new Point(0, 0, 3)), new Vector(0, 0, 1),
                "normal for tube is not working properly when point is parallel to the starting point");
    }

    /**
     * Test method for {@link geometries.Tube#findIntersections(primitives.Ray)}

    @Test
    void findIntsersections() {
        Tube tube = new Tube(new Ray(new Point(1, 1, 1), new Vector(1, 0, 0)), 1);
        // **** Group: ray is parallel to the tube
        // ============ Equivalence Partitions Tests ==============
        //EP01: the ray is outside the tube all the time( 0 intersections)
        assertNull(tube.findIntersections(new Ray(new Point(1, 0, 0), new Vector(1, 0, 0))),
                "the ray is outside the tube all the time( 0 intersections)");
        //EP02: the ray is congruent to the edge of the tube
        assertNull(tube.findIntersections(new Ray(new Point(1, 1, 0), new Vector(1, 0, 0))),
                "the ray is congruent to the tube");
        //EP03: the ray is inside the tube
        assertNull(tube.findIntersections(new Ray(new Point(1, 1, 1.5), new Vector(1, 0, 0))),
                "the ray is inside the tube");
        //EP04: the ray is congruent to the center of the tube
        assertNull(tube.findIntersections(new Ray(new Point(2, 1, 1), new Vector(1, 0, 0))),
                "the ray is congruent to the center of the tube");
        // ============ Boundary Value Tests ====================
        //BV01: the ray is congruent to the center of the tube and starts at the same point
        assertNull(tube.findIntersections(new Ray(new Point(1, 1, 1), new Vector(1, 0, 0))),
                "the ray is congruent to the center of the tube and starts at the same point");

        //**** Group:the ray is vertical to the tube
        // ============ Equivalence Partitions Tests ==============
        //EP05: the ray starts inside the tube
        assertEquals(List.of(new Point(2,2,1)),tube.findIntersections(new Ray(new Point(2, 1.5, 1), new Vector(0, 1, 0))),
                "the ray starts inside the tube");
        //EP06: the  ray starts outside the tube and transverses it twice
        assertEquals(List.of(new Point(2,0,1.5),new Point(2,2,1.5)),tube.findIntersections(new Ray(new Point(2, -1, 1.5), new Vector(0, 1, 0))),
                "the  ray starts outside the tube and transverses it twice");
        //EP07: the ray starts outside the tube and does not transverse it
        assertNull(tube.findIntersections(new Ray(new Point(2, -1, 1.5), new Vector(0, -1, 0))),
                "the ray starts outside the tube and does not transverse it");
        //EP08: the ray starts outside the tube and does not transverse it but the opposite direction does
        assertNull(tube.findIntersections(new Ray(new Point(1, 1.5, 3), new Vector(0, 0, 1))),
                "the ray starts outside the tube and does not transverse it but the opposite direction does");

        // ============ Boundary Value Tests ====================
        //BV02: the ray starts on the tube towards outside
        assertNull(tube.findIntersections(new Ray(new Point(1, 0, 1), new Vector(0, -1, 0))),
                "the ray starts on the tube towards outside");
        //BV03: the ray starts on the tube towards inside
        assertEquals(List.of(new Point(1,2,1)),tube.findIntersections(new Ray(new Point(1, 0, 1), new Vector(0, 1, 0))),
                "the ray starts on the tube towards inside");
        //BV04: the ray is tangent to the tube
        assertEquals(List.of(new Point(1,0,1)),tube.findIntersections(new Ray(new Point(1, 0, -1), new Vector(0, 0, 1))),
                "the ray is tangent to the tube");
        //BV05: the opposite way of the ray is tangent to the tube
        assertNull(tube.findIntersections(new Ray(new Point(1, 0, -1), new Vector(0, 0, -1))),
                "the opposite way of the ray is tangent to the tube");
        //BV06: the ray is vertical twice to the tube
        assertNull(tube.findIntersections(new Ray(new Point(1, -1, 1), new Vector(0, 0, 1))),
                "the ray is vertical twice to the tube");
        //BV07: the ray starts at the center of the tube
        assertEquals(List.of(new Point(3,1,2)),tube.findIntersections(new Ray(new Point(3, 1, 1), new Vector(0, 0, 1))),
                "the ray starts at the center of the tube");
        //BV08: the ray starts on the tube towards outside and the other direction goes threw the center
        assertNull(tube.findIntersections(new Ray(new Point(3, 0, 1), new Vector(0, -1, 0))),
                "the ray starts on the tube towards outside and the other direction goes threw the center ");
        //BV09: the ray starts outside the tube and the other direction goes threw the center
        assertNull(tube.findIntersections(new Ray(new Point(3, -1, 1), new Vector(0, -1, 0))),
                "the ray starts outside the tube and the other direction goes threw the center ");
        //BV10: the ray starts on the tube towards inside
        assertEquals(List.of(new Point(3,0,1)),tube.findIntersections(new Ray(new Point(3, 2, 1), new Vector(0, -1, 0))),
                "the ray starts on the tube towards inside");
        //BV11: the ray starts inside the tube towards outside,the other side goes threw the center
        assertEquals(List.of(new Point(3,2,1)),tube.findIntersections(new Ray(new Point(3, 1.5, 1), new Vector(0, 1, 0))),
                " the ray starts inside the tube towards outside,the other side goes threw the center ");
        //BV12: the ray starts outside the tube and goes threw the center
        assertEquals(List.of(new Point(3,2,1),new Point(3,0,1)),tube.findIntersections(new Ray(new Point(3, 2.5, 1), new Vector(0, -1, 0))),
                " the ray starts inside the tube towards outside,the other side goes threw the center ");
    }*/
}