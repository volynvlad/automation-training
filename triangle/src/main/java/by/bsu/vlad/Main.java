package by.bsu.vlad;

import by.bsu.vlad.exception.InvalidValueException;
import by.bsu.vlad.exception.NegativeSideException;

public class Main {
    public static void main(String[] args) throws NegativeSideException, InvalidValueException {
        Triangle triangle = new Triangle(Double.MAX_VALUE + 2, 1, 5);
        System.out.println(triangle.isAvailable());

        triangle.setSides(9, Double.MAX_VALUE + 3, 10);
        System.out.println(triangle.isAvailable());
    }
}
