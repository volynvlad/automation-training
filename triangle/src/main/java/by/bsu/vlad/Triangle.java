package by.bsu.vlad;

import by.bsu.vlad.exception.InvalidValueException;
import by.bsu.vlad.exception.NegativeSideException;

public class Triangle {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle() {
        this.firstSide = 1;
        this.secondSide = 1;
        this.thirdSide = 1;
    }

    public Triangle(double size) {
        this.firstSide = size;
        this.secondSide = size;
        this.thirdSide = size;
    }

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(double firstSide) {
        this.firstSide = firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(double secondSide) {
        this.secondSide = secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public void setThirdSide(double thirdSide) {
        this.thirdSide = thirdSide;
    }

    public void setSides(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    private boolean verifyTriangleInequality(double a, double b, double c) {
        return a + b > c;
    }

    public boolean isAvailable() throws InvalidValueException {

        if (Double.isNaN(this.firstSide) || Double.isNaN(this.secondSide) || Double.isNaN(this.thirdSide)) {
            throw new InvalidValueException();
        }

        if (this.firstSide <= 0 || this.secondSide <= 0 || this.thirdSide <= 0) {
            throw new InvalidValueException();
        }

        return this.verifyTriangleInequality(this.firstSide, this.secondSide, this.thirdSide) &&
                this.verifyTriangleInequality(this.thirdSide, this.firstSide, this.secondSide) &&
                this.verifyTriangleInequality(this.secondSide, this.thirdSide, this.firstSide);
    }

}
