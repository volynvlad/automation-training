package by.bsu.vlad;

import by.bsu.vlad.exception.InvalidValueException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void arbitraryTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(7, 8, 9);
        assertTrue(triangle.isAvailable());
    }

    @Test
    public void rightTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(5, 12, 13);
        assertTrue(triangle.isAvailable());
    }

    @Test
    public void isoscelesTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(9, 9, 7);
        assertTrue(triangle.isAvailable());
    }

    @Test
    public void equilateralTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(5,5,5);
        assertTrue(triangle.isAvailable());
    }

    @Test(expected = InvalidValueException.class)
    public void oneNegativeSideTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(4, 3, -4);
        triangle.isAvailable();
    }

    @Test(expected = InvalidValueException.class)
    public void oneZeroSideTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(0, 3, 4);
        triangle.isAvailable();
    }

    @Test(expected = InvalidValueException.class)
    public void oneNaNSideTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(Double.NaN, 2, 3);
        triangle.isAvailable();
    }

    @Test
    public void allSidesArePositiveInfinity() throws InvalidValueException {
        Triangle triangle = new Triangle(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertFalse(triangle.isAvailable());
    }

    @Test
    public void allSidesAreMaxDoubleTriangle() throws InvalidValueException {
        Triangle triangle = new Triangle(Double.MAX_VALUE , Double.MAX_VALUE, Double.MAX_VALUE);
        assertTrue(triangle.isAvailable());
    }

    @Test
    public void oneSideEqualsSumOfTwoSides() throws InvalidValueException {
        Triangle triangle = new Triangle(10, 5, 5);
        assertFalse(triangle.isAvailable());
    }

    @Test
    public void oneSideIsLessThanSumOfTwoSides() throws InvalidValueException {
        Triangle triangle = new Triangle(10, 5, 4);
        assertFalse(triangle.isAvailable());
    }
}