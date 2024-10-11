package Hw7_Inheritance.basic;

public class ColorWithAlpha extends Color {
    private int alpha;

    public ColorWithAlpha(){
        super(); //Calls the no-argument constructor of the parent class Inheritance.basic.Color
        this.alpha = 255;
    }

    public ColorWithAlpha(int red, int green, int blue, int alpha){
        super(red, green, blue); // Calls the 3 parameter constructor of the parent class also tells the constructor
        // what to initialize in the parent class constructor
        this.alpha = alpha;
    }

    public int getAlpha(){
        return this.alpha;
    }
    public void increment(){
        super.increment();
        if(alpha < 255){
            alpha ++;
        }
    }
    public void decrement(){
        super.decrement();
        if(alpha > 0){
            alpha --;
        }
    }

    public String toString(){
        return "rgba(" + super.getRed() + ", " + super.getGreen() + ", " + super.getBlue() + ", " +
                this.getAlpha() + ")";
    }


}
