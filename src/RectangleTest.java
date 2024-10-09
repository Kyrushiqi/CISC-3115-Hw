// DO NOT MODIFY THIS FILE.

import java.lang.reflect.Field;
import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) throws IllegalAccessException {
        basicTests();
        advancedTests();
    }

    private static void basicTests() {
        Rectangle rectangle1 = new Rectangle(new MutablePoint(1, 2), 3, 4);
        System.out.println(rectangle1.getLocation().toString()); // (1, 2)
        System.out.println(rectangle1.getLocationX()); // 1
        System.out.println(rectangle1.getLocationY()); // 2
        System.out.println(rectangle1.getWidth()); // 3
        System.out.println(rectangle1.getHeight()); // 4
        System.out.println(rectangle1.toString()); // rectangle at (1, 2) with width 3 and height 4
        System.out.println(rectangle1.getArea()); // 12
        System.out.println(rectangle1.getPerimeter()); // 14
        System.out.println(rectangle1.getDiagonal()); // 5.0

        rectangle1.setLocationX(5);
        rectangle1.setLocationY(6);
        System.out.println(rectangle1.getLocation().toString()); // (5, 6)

        rectangle1.setLocation(new MutablePoint(7, 8));
        rectangle1.setWidth(9);
        rectangle1.setHeight(10);
        System.out.println(rectangle1.toString()); // rectangle at (7, 8) with width 9 and height 10
        System.out.println(rectangle1.getArea()); // 90
        System.out.println(rectangle1.getPerimeter()); // 38
        System.out.println(rectangle1.getDiagonal()); // 13.45362404707371

        Rectangle rectangle2 = new Rectangle(new MutablePoint(7, 8), 9, 10);
        System.out.println(rectangle1.isEqualTo(rectangle2)); // true

        System.out.println(Rectangle.getUnitSquare().toString()); // rectangle at (0, 1) with width 1 and height 1

        Scanner sc = new Scanner("1 2 3 4");
        System.out.println(Rectangle.read(sc).toString()); // rectangle at (1, 2) with width 3 and height 4

        Rectangle rectangle3 = new Rectangle(new MutablePoint(1, 2), -1, -1);
        System.out.println(rectangle3.getWidth()); // 0
        System.out.println(rectangle3.getHeight()); // 0
        rectangle3.setWidth(-1);
        rectangle3.setHeight(-1);
        System.out.println(rectangle3.getWidth()); // 0
        System.out.println(rectangle3.getHeight()); // 0
    }

    // you are not expected to understand the code in this method; it uses "reflection"
    private static void advancedTests() throws IllegalAccessException {
        // make sure that the constructor makes a defensive copy of location.
        MutablePoint point = new MutablePoint(1, 2);
        Rectangle rectangle1 = new Rectangle(point, 3, 4);
        Field[] rectangle1Fields = rectangle1.getClass().getDeclaredFields();
        for (Field field : rectangle1Fields) {
            field.setAccessible(true);
            if (field.getType() == MutablePoint.class && field.get(rectangle1) == point) {
                System.out.println("It appears that the constructor doesn't make a defensive copy of location");
            }
        }

        // make sure that the copy constructor makes a deep copy.
        Rectangle rectangle2 = new Rectangle(rectangle1);
        Field[] rectangle2Fields = rectangle2.getClass().getDeclaredFields();
        for (Field field1 : rectangle1Fields) {
            for (Field field2 : rectangle2Fields) {
                field2.setAccessible(true);
                if (field1.getType() == MutablePoint.class && field2.getType() == MutablePoint.class && field1.get(rectangle1) == field1.get(rectangle2)) {
                    System.out.println("It appears that the copy constructor doesn't make a deep copy");
                }
            }
        }

        // make sure that getLocation makes a defensive copy.
        MutablePoint returnedPoint = rectangle1.getLocation();
        for (Field field : rectangle1Fields) {
            if (field.getType() == MutablePoint.class && field.get(rectangle1) == returnedPoint) {
                System.out.println("It appears that the getLocation method doesn't make a defensive copy");
            }
        }

        // make sure that setLocation makes a defensive copy.
        MutablePoint newPoint = new MutablePoint(5, 6);
        rectangle1.setLocation(newPoint);
        for (Field field : rectangle1Fields) {
            if (field.getType() == MutablePoint.class && field.get(rectangle1) == newPoint) {
                System.out.println("It appears that the setLocation method doesn't make a defensive copy");
            }
        }
    }
}
