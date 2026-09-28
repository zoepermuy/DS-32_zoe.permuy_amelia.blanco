package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void TriangleConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(10, 20, 30);
        });
    }

    @Test
    void TriangleCopy() {
        Triangle t1 = new Triangle(30, 70, 80);
        Triangle t2 = new Triangle(t1);

        assertEquals(t1, t2);
        assertEquals(t1.angle1(), t2.angle1());
        assertEquals(t1.angle2(), t2.angle2());
        assertEquals(t1.angle3(), t2.angle3());
    }

    @Test
    void isRight() {
        Triangle t1 = new Triangle(10, 90, 80); //recto a2
        Triangle t2 = new Triangle(90, 60, 30); //recto a1
        Triangle t3 = new Triangle(40, 50, 90); //recto a3
        Triangle t4 = new Triangle(40, 60, 80); //agudo

        assertTrue(t1.isRight());
        assertTrue(t2.isRight());
        assertTrue(t3.isRight());
        assertFalse(t4.isRight());
    }

    @Test
    void isAcute() {
        Triangle t1 = new Triangle(10, 90, 80); //recto
        Triangle t2 = new Triangle(20, 60, 100); //obtuso
        Triangle t3 = new Triangle(40, 80, 60); //agudo
        Triangle t4 = new Triangle(90, 45, 45); //recto
        Triangle t5 = new Triangle(45, 90, 45); //recto
        Triangle t6 = new Triangle(45, 45, 90); //recto

        assertFalse(t1.isAcute());
        assertFalse(t2.isAcute());
        assertTrue(t3.isAcute());
        assertFalse(t4.isAcute());
        assertFalse(t5.isAcute());
        assertFalse(t6.isAcute());
    }

    @Test
    void isObtuse() {
        Triangle t1 = new Triangle(10, 90, 80); //recto
        Triangle t2 = new Triangle(20, 60, 100); //obtuso
        Triangle t3 = new Triangle(40, 80, 60); //agudo
        Triangle t4 = new Triangle(100, 40, 40); //obtuso
        Triangle t5 = new Triangle(40, 100, 40); //obtuso

        assertFalse(t1.isObtuse());
        assertTrue(t2.isObtuse());
        assertFalse(t3.isObtuse());
        assertTrue(t4.isObtuse());
        assertTrue(t5.isObtuse());
    }

    @Test
    void isEquilateral() {
        Triangle t1 = new Triangle(60, 60, 60); //equilateral agudo
        Triangle t2 = new Triangle(10, 90, 80); //escaleno recto
        Triangle t3 = new Triangle(20, 80, 80); //isosceles agudo
        Triangle t4 = new Triangle(20, 20, 140); //isosceles obtuso

        assertTrue(t1.isEquilateral());
        assertFalse(t2.isEquilateral());
        assertFalse(t3.isEquilateral());
        assertFalse(t4.isEquilateral());
    }

    @Test
    void isIsosceles() {
        Triangle t1 = new Triangle(60, 60, 60); //equilatero agudo
        Triangle t2 = new Triangle(10, 90, 80); //escaleno recto
        Triangle t3 = new Triangle(20, 80, 80); //isosceles agudo
        Triangle t4 = new Triangle(20, 20, 140); // isosceles obtuso
        Triangle t5 = new Triangle(45, 90, 45); //isosceles recto

        assertFalse(t1.isIsosceles());
        assertFalse(t2.isIsosceles());
        assertTrue(t3.isIsosceles());
        assertTrue(t4.isIsosceles());
        assertTrue(t5.isIsosceles());
    }

    @Test
    void isScalene() {
        Triangle t1 = new Triangle(60, 60, 60); //equilatero agudo
        Triangle t2 = new Triangle(10, 90, 80); //escaleno recto
        Triangle t3 = new Triangle(20, 80, 80); //isosceles agudo
        Triangle t4 = new Triangle(30, 30, 120); //isosceles obtuso
        Triangle t5 = new Triangle(45, 90, 45); //isosceles recto

        assertFalse(t1.isScalene());
        assertTrue(t2.isScalene());
        assertFalse(t3.isScalene());
        assertFalse(t4.isScalene());
        assertFalse(t5.isScalene());
    }

    @Test
    void testEquals() {
        Triangle t1 = new Triangle(20, 60, 100);
        Triangle t2 = new Triangle(30, 70, 80);
        Triangle t3 = new Triangle(100, 20, 60);

        assertFalse(t1.equals(t2));
        assertTrue(t1.equals(t3));
        assertFalse(t1.equals(null));
        assertTrue(t2.equals(t2));
        assertFalse(t3.equals("Triangle"));
    }

    @Test
    void testHashCode() {
        Triangle t1 = new Triangle(20, 60, 100);
        Triangle t2 = new Triangle(30, 70, 80);
        Triangle t3 = new Triangle(100, 20, 60);

        assertNotEquals(t1.hashCode(), t2.hashCode());
        assertEquals(t3.hashCode(), t1.hashCode());
    }
}