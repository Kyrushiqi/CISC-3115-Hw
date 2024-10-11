package Hw5_Classes_1;

import java.lang.Math;
public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator){
        this.numerator = numerator/gcd(numerator, denominator);
        this.denominator = denominator/gcd(numerator, denominator);
    }
    public Rational(String rationalString){
        String[] fraction = rationalString.split("/");
        this.numerator = Integer.parseInt(fraction[0])/gcd(Integer.parseInt(fraction[0]), Integer.parseInt(fraction[1]));
        this.denominator = Integer.parseInt(fraction[1])/gcd(Integer.parseInt(fraction[0]), Integer.parseInt(fraction[1]));
    }

    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }

    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator); // 4/-1 --> 4
        }else if(denominator == -1){
            return Integer.toString(-1*numerator);
        }else if (denominator == 1 || numerator % denominator == 0) {
            return Integer.toString(Math.abs(numerator)); // 5/-1 = R0 --> 5
        }else if(denominator < 0){
            return -1*numerator + "/" + Math.abs(denominator);
        }else if(numerator < 0 && denominator < 0){
            return Math.abs(numerator) + "/" + Math.abs(denominator);
        }else if(numerator == 0){
            return "0" + "/" + denominator;
        }
        return numerator + "/" + denominator;

    }


    public boolean isEqualTo(Rational other){
        if(numerator * other.denominator == other.numerator * denominator){
            return true;
        }
        return false;

        /*if(numerator == other.numerator && denominator == other.denominator){
            return true;
        }
        return false;*/
    }

    public boolean isPositive(){
        if(numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0){
            return true;
        }
        return false;
    }

    public boolean isNegative(){
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0){
            return true;
        }
        return false;
    }

    public Rational plus(Rational other){
        int rationalSumTop = ((this.numerator*other.denominator) + (this.denominator*other.numerator));
        int rationalSumBottom = (this.denominator*other.denominator);

        return new Rational(rationalSumTop, rationalSumBottom);
    }

    public Rational minus(Rational other){
        int top = ((this.numerator*other.denominator) - (this.denominator*other.numerator));
        int bottom = (this.denominator*other.denominator);

        return new Rational(top, bottom);
    }
    public Rational times(Rational other){
        int top = (this.numerator*other.numerator);
        int bottom = (this.denominator*other.denominator);

        return new Rational(top, bottom);
    }

    public Rational dividedBy(Rational other){
        int top = this.numerator*other.denominator;
        int bottom = this.denominator*other.numerator;

        return new Rational(top, bottom);
    }

    public Rational getNegation(){
        return new Rational(-1*this.numerator, this.denominator);
    }

    public Rational getAbsoluteValue(){
        return new Rational(Math.abs(this.numerator), Math.abs(this.denominator));
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
}

/*public class Rational {
    // instance fields

    // denominator should be 1
    public Rational(int numerator)

    public Rational(int numerator, int denominator)

    // assume rationalString is of the form "numerator/denominator", e.g., "3/12"
    public Rational(String rationalString)

    public int getNumerator()

    public int getDenominator()

    // Usually returns a String of the form "numerator/denominator", e.g., "1/4".
    // But if the denominator is 1, just returns the numerator.
    public String toString()

    public boolean isEqualTo(Rational other)

    public boolean isPositive()

    public boolean isNegative()

    // returns this + other
    public Rational plus(Rational other)

    // returns this - other
    public Rational minus(Rational other)

    // returns this * other
    public Rational times(Rational other)

    // returns this / other
    public Rational dividedBy(Rational other)

    // returns -this.
    // E.g, the negation of 1/2 is -1/2; the negation of -1/2 is 1/2
    public Rational getNegation()

    // returns |this|.
    // E.g., the absolute value of 1/2 is 1/2; the absolute value of -1/2 is 1/2
    public Rational getAbsoluteValue()

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
}*/
