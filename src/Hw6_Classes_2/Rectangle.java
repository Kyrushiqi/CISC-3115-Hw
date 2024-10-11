package Hw6_Classes_2;/*
Notes:
1) First constructor should use the origin as the location. (Inheritance.A MutablePoint representing the origin
can be obtained via MutablePoint.getOrigin().
2) The getDiagonal() method should return the length of the rectangle's diagonal, that is the distance
between the upper-left corner and the lower-right corner. (Equivalently, this is the distance
between the lower-left corner and the upper-right corner.)
3) The toString() method should return a String representation of the Rectangle object.
EX: rectangle at (1,2) with width 3 and height 4
4) For the getUnitSquare() method, note that a unit square is a square whose sides have length 1 and whose
corners are at (0,0), (1,0), (0,1), and (1,1). In other words, the length and width are both 1, and the
upper-left corner is at (0,1).
5) The read() method should use the provided Scanner to read a MutablePoint, a width, and a height.
(To read the MutablePoint, use the read() method of MutablePoint.) The method should then create and
return a new Rectangle based on those pieces of data.

Additional Notes:
1) The width and height of a rectangle are not allowed to be negative. If client code attempts to set the
width or height to be negative, the class should set it to 0 instead.
2) The class should make defensive copies whenever appropriate.
3) The copy constructor should make a deep copy of the original object.

Optional:
Add a method with the following header:
    public boolean contains(Mutable point)
The method should determine whether this Rectangle contains the specified point.

MutablePoint and Rectangle are mutable classes
 */
import java.util.Scanner;
public class Rectangle {
    private MutablePoint location;
    private int width;
    private int height;

    /**
     * First constructor should use the origin as the location. (Inheritance.A MutablePoint representing the origin
     * can be obtained via MutablePoint.getOrigin().
     */
    public Rectangle(int width, int height){
        this.location = MutablePoint.getOrigin();
        if(width < 0){
            width = 0;
        }
        if(height < 0){
            height = 0;
        }
        this.width = width;
        this.height = height;
    }
    public Rectangle(MutablePoint location, int width, int height){
        this.location = new MutablePoint(location);
        if(width < 0){
            width = 0;
        }
        if(height < 0){
            height = 0;
        }
        this.width = width;
        this.height = height;
    }
    public Rectangle(Rectangle original){
        this.location = new MutablePoint(original.location);
        this.width = original.width;
        this.height = original.height;
    }

    public MutablePoint getLocation(){
        return new MutablePoint(this.location);
    }
    public int getLocationX(){
        return this.location.getX();
    }
    public int getLocationY(){
        return this.location.getY();
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    public void setLocation(MutablePoint location) {
        this.location = new MutablePoint(location);
    }
    public void setLocationX(int x){
        this.location.setX(x);
    }
    public void setLocationY(int y){
        this.location.setY(y);
    }
    public void setWidth(int width){
        if(width < 0){
            width = 0;
        }
        this.width = width;
    }
    public void setHeight(int height){
        if(height < 0){
            height = 0;
        }
        this.height = height;
    }
    public int getArea(){
        return width*height;
    }
    public int getPerimeter(){
        return ((width*2) + (height*2));
    }

    /**
     * The getDiagonal() method should return the length of the rectangle's diagonal, that is the distance
     * between the upper-left corner and the lower-right corner. (Equivalently, this is the distance
     * between the lower-left corner and the upper-right corner.)
     *
     * 1) Find the 2 coordinates of the corners. (x1,y1) (x2,y2)
     * 2) Use the distance formula from MutablePoint class, public double distanceTo(MutablePoint other)
     * Compares two MutablePoint objects
     *
     * Rectangle rectangle1 = new Rectangle(new MutablePoint(1, 2), 3, 4);
     * System.out.println(rectangle1.getDiagonal()); // 5.0
     */
    public double getDiagonal(){
        MutablePoint point = new MutablePoint(this.location);
        /* point refers to a new MutablePoint with
           the calling object's X and Y Coordinates.
         */
        MutablePoint otherPoint = new MutablePoint(getLocationX() + getWidth(), getLocationY() + getHeight());
        /* otherPoint refers to a new MutablePoint object that has x as the calling object's X plus the
         calling object's width. It has y as the calling object's Y plus the calling object's height.
         This will give us the point of other rectangle corner.
         */
        return point.distanceTo(otherPoint);
    }

    public boolean isSquare(){
        if(width == height){
            return true;
        }
        return false;
    }

    /**
     * The toString() method should return a String representation of the Rectangle object.
     * EX: rectangle at (1,2) with width 3 and height 4
     *
     * Rectangle rectangle1 = new Rectangle(new MutablePoint(1, 2), 3, 4);
     * System.out.println(rectangle1.toString()); // rectangle at (1, 2) with width 3 and height 4
     */
    public String toString(){
        return "rectangle at " + location.toString() + " with width " + getWidth() + " and height " + getHeight();
    }

    /**
     * Are two rectangle objects equal to each other?
     *
     * Rectangle rectangle1 = new Rectangle(new MutablePoint(7, 8), 9, 10);
     * Rectangle rectangle2 = new Rectangle(new MutablePoint(7, 8), 9, 10);
     * System.out.println(rectangle1.isEqualTo(rectangle2)); // true
     */
    public boolean isEqualTo(Rectangle other){
        if(location.getX() == other.getLocationX() && location.getY() == other.getLocationY() &&
                width == other.width && height == other.height){
            return true;
        }
        return false;
    }

    /**
     * For the getUnitSquare() method, note that a unit square is a square whose sides have length 1 and whose
     * corners are at (0,0), (1,0), (0,1), and (1,1). In other words, the length and width are both 1, and the
     * upper-left corner is at (0,1).
     *
     * System.out.println(Rectangle.getUnitSquare().toString());
     * // rectangle at (0, 1) with width 1 and height 1
     */
    public static Rectangle getUnitSquare(){
        return new Rectangle(new MutablePoint(0,1), 1,1);
    }

    /**
     * The read() method should use the provided Scanner to read a MutablePoint, a width, and a height.
     * (To read the MutablePoint, use the read() method of MutablePoint.) The method should then create and
     * return a new Rectangle based on those pieces of data.
     *
     * Scanner sc = new Scanner("1 2 3 4");
     * System.out.println(Rectangle.read(sc).toString());
     * // rectangle at (1, 2) with width 3 and height 4
     */
    public static Rectangle read(Scanner sc){
        return new Rectangle(MutablePoint.read(sc), sc.nextInt(), sc.nextInt());
    }
}
