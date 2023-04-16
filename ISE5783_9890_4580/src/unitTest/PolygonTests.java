package unitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static primitives.Util.isZero;

import org.junit.jupiter.api.Test;

import geometries.Polygon;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;

/** Testing Polygons
 * @author Dan */
public class PolygonTests {

   /** Test method for {@link Polygon#Polygon(Point...)}. */
   @Test
   public void testConstructor() {
      // ============ Equivalence Partitions Tests ==============

      // TC01: Correct concave quadrangular with vertices in correct order
      try {
         new Polygon(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(-1, 1, 1));
      } catch (IllegalArgumentException e) {
         fail("Failed constructing a correct polygon");
      }

      // TC02: Wrong vertices order
      assertThrows(IllegalArgumentException.class, //
                   () -> new Polygon(new Point(0, 0, 1), new Point(0, 1, 0), new Point(1, 0, 0), new Point(-1, 1, 1)), //
                   "Constructed a polygon with wrong order of vertices");

      // TC03: Not in the same plane
      assertThrows(IllegalArgumentException.class, //
                   () -> new Polygon(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 2, 2)), //
                   "Constructed a polygon with vertices that are not in the same plane");

      // TC04: Concave quadrangular
      assertThrows(IllegalArgumentException.class, //
                   () -> new Polygon(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0),
                                     new Point(0.5, 0.25, 0.5)), //
                   "Constructed a concave polygon");

      // =============== Boundary Values Tests ==================

      // TC10: Vertex on a side of a quadrangular
      assertThrows(IllegalArgumentException.class, //
                   () -> new Polygon(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0),
                                     new Point(0, 0.5, 0.5)),
                   "Constructed a polygon with vertix on a side");

      // TC11: Last point = first point
      assertThrows(IllegalArgumentException.class, //
                   () -> new Polygon(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1)),
                   "Constructed a polygon with vertice on a side");

      // TC12: Co-located points
      assertThrows(IllegalArgumentException.class, //
                   () -> new Polygon(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 1, 0)),
                   "Constructed a polygon with vertice on a side");

   }

   /** Test method for {@link Polygon#getNormal(Point)}. */
   @Test
   public void testGetNormal() {
      // ============ Equivalence Partitions Tests ==============
      // TC01: There is a simple single test here - using a quad
      Point[] pts =
         { new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0), new Point(-1, 1, 1) };
      Polygon pol = new Polygon(pts);
      // ensure there are no exceptions
      assertDoesNotThrow(() -> pol.getNormal(new Point(0, 0, 1)), "");
      // generate the test result
      Vector result = pol.getNormal(new Point(0, 0, 1));
      // ensure |result| = 1
      assertEquals(1, result.length(), 0.00000001, "Polygon's normal is not a unit vector");
      // ensure the result is orthogonal to all the edges
      for (int i = 0; i < 3; ++i)
         assertTrue(isZero(result.dotProduct(pts[i].subtract(pts[i == 0 ? 3 : i - 1]))),
                    "Polygon's normal is not orthogonal to one of the edges");
   }

   /**
    * Test method for {@link geometries.Polygon#findIntersections(primitives.Ray)}
    */
   @Test
   void findIntersections() {
      Polygon polygon = new Polygon(new Point(2, 2, 0),
              new Point(-2, 2, 0),
              new Point(-2, -2, 0),
              new Point(2, -2, 0));

      List<Point> intersections = new LinkedList<>();
      // ================== Equivalence Partition Tests ======================
      // EP01: Ray intersects with polygon (1 point)
      List<Point> result = polygon.findIntersections(new Ray(new Point(0.75, 0.75, 0.75),
              new Vector(0, 0, -1)));
      assertEquals(1, result.size(), "EP01: Wrong number of points");
      intersections.add(result.get(0));
      assertEquals(List.of(new Point(0.75, 0.75, 0)), intersections, "EP01: Ray crosses polygon");
      intersections.clear();

      // EP02: Ray intersects with the plane against the edge of polygon (0 points)
      result = polygon.findIntersections(new Ray(new Point(3, 1.5, 0.75),
              new Vector(0, 0, -1)));
      assertNull(result, "EP02: Wrong number of points");
      intersections.clear();

      // EP03: Ray intersects with the plane against the vertex of polygon (0 points)
      result = polygon.findIntersections(new Ray(new Point(3, 3, 0.75),
              new Vector(0, 0, -1)));
      assertNull(result, "EP03: Wrong number of points");
      intersections.clear();

      // =============== Boundary Values Tests ==================
      // BV01: Ray intersects with edge (0 points)
      result = polygon.findIntersections(new Ray(new Point(2, 1, 0.75),
              new Vector(0, 0, -1)));
      assertNull( result, "BV01: Wrong number of points");
      intersections.clear();

      // BV02: Ray intersects with vertex (0 points)
      result = polygon.findIntersections(new Ray(new Point(2, 2, 0.75),
              new Vector(0, 0, -1)));
      assertNull(result, "BV02: Wrong number of points");
      intersections.clear();

      // BV03: Ray intersects with edge's continuation (0 points)
      result = polygon.findIntersections(new Ray(new Point(2, 3, 0.75),
              new Vector(0, 0, -1)));
      assertNull(result, "BV03: Wrong number of points");
      assertEquals(List.of(), intersections, "BV03: Ray crosses polygon");
      intersections.clear();
   }
}
