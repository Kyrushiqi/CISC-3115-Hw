package Comparable;

// DO NOT MODIFY THIS FILE.

public class TestRational {
    public static void main(String[] args) {
        System.out.println(new Rational("1/2") instanceof Comparable); // expected: true

        System.out.println(new Rational("1/3").compareTo(new Rational("1/2")) < 0);    // expected: true
        System.out.println(new Rational("1/2").compareTo(new Rational("1/3")) > 0);    // expected: true
        System.out.println(new Rational("1/3").compareTo(new Rational("1/3")) == 0);   // expected: true
        System.out.println(new Rational("-1/3").compareTo(new Rational("1/2")) < 0);   // expected: true
        System.out.println(new Rational("-1/2").compareTo(new Rational("1/3")) < 0);   // expected: true
        System.out.println(new Rational("-1/3").compareTo(new Rational("-1/3")) == 0); // expected: true
    }
}
