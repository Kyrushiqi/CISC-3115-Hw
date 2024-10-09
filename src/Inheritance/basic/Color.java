package Inheritance.basic;

// Provided by Professor Moshe Lach
public class Color {
    private int red, green, blue;

    public Color() {
        this(255, 255, 255);
    }

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void increment() {
        if (red < 255) {
            red++;
        }

        if (green < 255) {
            green++;
        }

        if (blue < 255) {
            blue++;
        }
    }

    public void decrement() {
        if (red > 0) {
            red--;
        }

        if (green > 0) {
            green--;
        }

        if (blue > 0) {
            blue--;
        }
    }
}