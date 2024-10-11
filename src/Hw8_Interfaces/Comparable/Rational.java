package Hw8_Interfaces.Comparable;

import java.util.Objects;

public class Rational extends Number implements Comparable<Rational>{
    private int numerator, denominator;

    public Rational(int numerator) {
        this(numerator, 1);
    }

    public Rational(int numerator, int denominator) {
        initialize(numerator, denominator);
    }

    public Rational(String rationalString) {
        String[] tokens = rationalString.split("/");
        int numerator = Integer.parseInt(tokens[0]);
        int denominator = Integer.parseInt(tokens[1]);
        initialize(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + (denominator == 1 ? "" : ("/" + denominator));
    }

    public boolean isEqualTo(Rational other) {
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    public boolean isPositive() {
        return numerator > 0;
    }

    public boolean isNegative() {
        return numerator < 0;
    }

    public Rational plus(Rational other) {
        int numerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int denominator = this.denominator * other.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational minus(Rational other) {
        int numerator = this.numerator * other.denominator - this.denominator * other.numerator;
        int denominator = this.denominator * other.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational times(Rational other) {
        int numerator = this.numerator * other.numerator;
        int denominator = this.denominator * other.denominator;
        return new Rational(numerator, denominator);
    }

    public Rational dividedBy(Rational other) {
        int numerator = this.numerator * other.denominator;
        int denominator = this.denominator * other.numerator;
        return new Rational(numerator, denominator);
    }

    public Rational getNegation() {
        return new Rational(-numerator, denominator);
    }

    public Rational getAbsoluteValue() {
        return new Rational(Math.abs(numerator), denominator);
    }

    private void initialize(int numerator, int denominator) {
        // for this homework assignment, we assume that denominator != 0

        // put fraction into reduced form
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        // If denominator is negative, convert the fraction to an equivalent fraction in which the denominator is positive:
        // - If both numerator and denominator are negative, make both be positive.
        // - If denominator is negative and numerator is non-negative, make numerator negative and denominator positive.
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        // if the numerator is 0, make the denominator 1
        if (numerator == 0) {
            denominator = 1;
        }

        // assign the corrected numerator and denominator to the fields
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        // perform the Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Rational) {
            Rational other = (Rational) o;
            return this.numerator == other.numerator && this.denominator == other.denominator;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    /**
     * My code here:
     * Objective: Implement the Comparable interface (it comes with the compareTo method that needs to be overriden.)
     * Rational objects should be ordered in the obvious way. For example:
     * 1/3 < 1/2
     * 1/2 > 1/3
     * 1/3 = 1/3
     *
     * Additional Notes, Object's compare method:
     * public static int compare(int x, int y):
     *      * this < other = negative #
     *      * this > other = positive #
     *      * this = other = 0
     *
     * Tip: Rational has a doubleValue() method. Returns a double of the quotient of numerator and denominator. vv
     * @Override
     *     public double doubleValue() {
     *         return (double) numerator / denominator;
     *     }
     **/
    @Override
    public int compareTo(Rational other){
        return Double.compare(this.doubleValue(), other.doubleValue()); // 0.333 vs 0.5;
    }
}