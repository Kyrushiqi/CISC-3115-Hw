package Hw7_Inheritance.Super_BankAccount_Class;

public class MonetaryValue {
    private final int totalCents;
    public static final MonetaryValue ZERO = ofCents(0),
            ONE_CENT = ofCents(1),
            ONE_DOLLAR = ofDollars(1);

    private MonetaryValue(int totalCents) {
        this.totalCents = totalCents;
    }

    public static MonetaryValue ofCents(int cents) {
        return new MonetaryValue(cents);
    }

    public static MonetaryValue ofDollars(int dollars) {
        return new MonetaryValue(dollars * 100);
    }

    public static MonetaryValue ofDollarsAndCents(int dollars, int cents) {
        return new MonetaryValue(dollars * 100 + cents);
    }

    // examples of monetaryString:
    // 10, 10.34, -10, -10.34, $10, $10.34, $-10, $-10.34
    public MonetaryValue(String monetaryString) {
        if (monetaryString.startsWith("$")) {
            monetaryString = monetaryString.substring(1); // disregard first character
        }

        boolean isNegative = false;
        if (monetaryString.startsWith("-")) {
            isNegative = true;
            monetaryString = monetaryString.substring(1); // disregard the - character
        }

        int indexOfPoint = monetaryString.indexOf('.');
        if (indexOfPoint == -1) { // there is no decimal point
            totalCents = (isNegative ? -1 : 1) * Integer.parseInt(monetaryString) * 100;
        } else {
            String dollarsString = monetaryString.substring(0, indexOfPoint);
            String centsString = monetaryString.substring(indexOfPoint + 1);
            totalCents = (isNegative ? -1 : 1)
                    * (Integer.parseInt(dollarsString) * 100 + Integer.parseInt(centsString));
        }
    }

    public int getTotalCents() {
        return totalCents;
    }

    // totalCents: 1023 --> 10.23
    public double toDouble() {
        return totalCents / 100.0;
    }

    public String toString() {
        return String.format("$%.2f", toDouble());
    }

    public boolean isNegative() {
        return totalCents < 0; // or: this.isLessThan(ZERO)
    }

    public boolean isPositive() {
        return totalCents > 0;
    }

    public boolean isGreaterThan(MonetaryValue other) {
        return this.totalCents > other.totalCents;
    }

    public boolean isLessThan(MonetaryValue other) {
        return this.totalCents < other.totalCents;
    }

    public boolean isEqualTo(MonetaryValue other) {
        return this.totalCents == other.totalCents;
    }

    public MonetaryValue plus(MonetaryValue other) {
        return new MonetaryValue(this.totalCents + other.totalCents);
    }

    public MonetaryValue minus(MonetaryValue other) {
        return new MonetaryValue(this.totalCents - other.totalCents);
    }
}