package Hw6_Classes_2;

import java.util.Scanner;

/** Each object of this class represents a point on the x-y grid. */
public class MutablePoint {
    private int x, y;

    /**
     * Constructs and initializes a new MutablePoint at the specified
     * (x, y) coordinates.
     */
    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MutablePoint(int[] coordinates) {
        x = coordinates[0];
        y = coordinates[1];
    }

    /**
     * Copy constructor.
     * Constructs and initializes a new MutablePoint representing the same
     * (x, y) coordinates as the specified original MutablePoint.
     */
    public MutablePoint(MutablePoint original) {
        this.x = original.x;
        this.y = original.y;
    }

    // In documentation, "this MutablePoint" means the MutablePoint that
    // called the method.

    /**
     * Returns the x coordinate of this MutablePoint.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of this MutablePoint.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x coordinate of this MutablePoint to the specified value.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of this MutablePoint to the specified value.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns a string representation of this MutablePoint in the form
     * (x, y).
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Determines whether this MutablePoint is equal to the specified
     * other MutablePoint;
     * that is, determines whether they represent the same (x, y) coordinates.
     */
    public boolean isEqualTo(MutablePoint other) {
        return this.x == other.x && this.y == other.y;
    }

    /**
     * Returns the distance between this MutablePoint and the specified
     * other MutablePoint. (Distance formula for coordinates)
     */
    public double distanceTo(MutablePoint other) {
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    /**
     * Returns a new MutablePoint that is like this MutablePoint,
     * but reflected across the x-axis.
     * For example, if this MutablePoint is (2, 3), this method returns (2, -3).
     */
    public MutablePoint xReflection() {
        // int newX = this.x;
        // int newY = -this.y;
        // MutablePoint newPoint = new MutablePoint(newX, newY);
        // return newPoint;

        // much more concisely:
        return new MutablePoint(x, -y);
    }

    /**
     * Returns the result of adding this MutablePoint with the specified
     * other MutablePoint.
     * For example, (1, 2) + (-5, 6) = (-4, 8).
     * new MutablePoint(1, 2).plus(new MutablePoint(-5, 6))
     */
    public MutablePoint plus(MutablePoint other) {
        return new MutablePoint(this.x + other.x, this.y + other.y);
    }

    /**
     * Returns a new MutablePoint that is a copy of this MutablePoint.
     */
    public MutablePoint clone() {
        return new MutablePoint(this.x, this.y);
    }

    public int[] toArray() {
        int[] coordinates = {this.x, this.y};
        return coordinates;
    }

    /**
     * Returns a MutablePoint that represents the origin, that is, (0, 0).
     */
    public static MutablePoint getOrigin() {
        return new MutablePoint(0, 0);
    }

    /**
     * Returns a MutablePoint with the specified x and y coordinates.
     */
    public static MutablePoint ofXY(int x, int y) {
        return new MutablePoint(x, y);
    }

    /**
     * Returns a MutablePoint with x and y coordinates read from the
     * specified Scanner.
     */
    public static MutablePoint read(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new MutablePoint(x, y);
    }

    /**
     * Returns the result of adding the two specified MutablePoints
     * together.
     * For example, (1, 2) + (-5, 6) = (-4, 8).
     * MutablePoint.sum(new MutablePoint(1, 2), new MutablePoint(-5, 6))
     */
    public static MutablePoint sum(MutablePoint point1,
                                   MutablePoint point2) {
        return point1.plus(point2);
    }
}
