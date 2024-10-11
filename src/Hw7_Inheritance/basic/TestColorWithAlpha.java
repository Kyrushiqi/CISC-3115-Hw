package Hw7_Inheritance.basic;// DO NOT MODIFY THIS FILE.

public class TestColorWithAlpha {
    public static void main(String[] args) {
        testExtendsColor();
        testNumFields();
        testNoArgConstructor();
        testParameterizedConstructor();
        testToString();
        testIncrement();
        testDecrement();
    }

    private static void testExtendsColor() {
        System.out.println("testing extends Inheritance.basic.Color");

        ColorWithAlpha c = new ColorWithAlpha();
        System.out.println(c instanceof Color); // expected: true

        System.out.println();
    }

    // Makes sure that the Inheritance.basic.ColorWithAlpha class only declares a single field and that the field is an int.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testNumFields() {
        System.out.println("testing num fields");

        java.lang.reflect.Field[] fields = ColorWithAlpha.class.getDeclaredFields();
        System.out.println(fields.length); // expected: 1
        System.out.println(fields[0].getType()); // expected: int

        System.out.println();
    }

    private static void testNoArgConstructor() {
        System.out.println("testing no-arg constructor");

        ColorWithAlpha c = new ColorWithAlpha();
        System.out.println(c.getRed());   // expected: 255
        System.out.println(c.getGreen()); // expected: 255
        System.out.println(c.getBlue());  // expected: 255
        System.out.println(c.getAlpha()); // expected: 255

        System.out.println();
    }

    private static void testParameterizedConstructor() {
        System.out.println("testing parameterized constructor");

        ColorWithAlpha c = new ColorWithAlpha(44, 125, 66, 7);
        System.out.println(c.getRed());   // expected: 44
        System.out.println(c.getGreen()); // expected: 125
        System.out.println(c.getBlue());  // expected: 66
        System.out.println(c.getAlpha()); // expected: 7

        System.out.println();
    }

    private static void testToString() {
        System.out.println("testing toString");

        ColorWithAlpha c = new ColorWithAlpha();
        System.out.println(c); // expected: rgba(255, 255, 255, 255)

        c = new ColorWithAlpha(44, 125, 66, 7);
        System.out.println(c); // expected: rgba(44, 125, 66, 7)

        System.out.println();
    }

    private static void testIncrement() {
        System.out.println("testing increment");

        ColorWithAlpha c = new ColorWithAlpha(44, 125, 66, 7);
        c.increment();
        System.out.println(c); // expected: rgba(45, 126, 67, 8)

        c = new ColorWithAlpha(255, 125, 66, 7);
        c.increment();
        System.out.println(c); // expected: rgba(255, 126, 67, 8)

        c = new ColorWithAlpha(44, 255, 66, 7);
        c.increment();
        System.out.println(c); // expected: rgba(45, 255, 67, 8)

        c = new ColorWithAlpha(44, 125, 255, 7);
        c.increment();
        System.out.println(c); // expected: rgba(45, 126, 255, 8)

        c = new ColorWithAlpha(44, 125, 66, 255);
        c.increment();
        System.out.println(c); // expected: rgba(45, 126, 67, 255)

        System.out.println();
    }

    private static void testDecrement() {
        System.out.println("testing decrement");

        ColorWithAlpha c = new ColorWithAlpha(44, 125, 66, 7);
        c.decrement();
        System.out.println(c); // expected: rgba(43, 124, 65, 6)

        c = new ColorWithAlpha(0, 125, 66, 7);
        c.decrement();
        System.out.println(c); // expected: rgba(0, 124, 65, 6)

        c = new ColorWithAlpha(44, 0, 66, 7);
        c.decrement();
        System.out.println(c); // rgba(43, 0, 65, 6)

        c = new ColorWithAlpha(44, 125, 0, 7);
        c.decrement();
        System.out.println(c); // expected: rgba(43, 124, 0, 6)

        c = new ColorWithAlpha(44, 125, 66, 0);
        c.decrement();
        System.out.println(c); // expected: rgba(43, 124, 65, 0)

        System.out.println();
    }
}