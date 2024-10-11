package Hw6_Classes_2;// DO NOT MODIFY THIS FILE.

public class Room {
    private final double length, width;

    public Room(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return length + " x " + width + " room";
    }
}
