/**
Hw 4 (using objects) Objective:
1) Read in from file 'rectangles.txt' and place Rectangle objects into an array. Inheritance.A rectangle object
has the following attributes in this order: x-coordinate, y-coordinate, width, height of a rectangle.
The header number in the file tells us how many rectangle object information there is.
2) Print using toString() method from Rectangle class.
3) Print whether there are any consecutive Rectangles in the array that intersect each other.
4) Print whether any of the Rectangles in the array intersect each other.

Note: For 3 and 4, use the intersects boolean method from the Rectangle class.
 */

import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ArrayOfRectangles {
    public static void main(String[]args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("rectangles.txt"));
        int rectangleHeader = inFile.nextInt();
        //System.out.println(rectangleHeader);
        Rectangle[]array = readRectangles(inFile, rectangleHeader);
        System.out.println("Array length: " + array.length);

        toString(array);

        boolean consecutiveIntersections = checkConsecutiveIntersections(array);
        System.out.println("contains consecutive intersecting rectangles: " + consecutiveIntersections);

        boolean anyIntersections = checkAnyIntersections(array);
        System.out.println("contains intersecting rectangles: " + anyIntersections);

        inFile.close();

    }

    public static void toString(Rectangle[]array){
        for (Rectangle rectangle : array) {
            System.out.println("java.awt.Rectangle[x=" + rectangle.x + ",y=" + rectangle.y + ",width=" + rectangle.width
                    + ",height=" + rectangle.height + "]");
            /* You can also replace the sout stuff with just "rectangle."
               It does the same thing as that long sentence
               because it's built into the Rectangle class that way.
                    System.out.println(rectangle);*/
        }

        /*for(int i=0; i<array.length;i++){
            System.out.println("java.awt.Rectangle[x=" + array[i].x + ",y=" + array[i].y + ",width=" + array[i].width
            + ",height=" + array[i].height + "]");
        }*/

    }
    public static Rectangle[] readRectangles(Scanner inFile, int rectangleHeader){
        Rectangle[]array = new Rectangle[rectangleHeader];
        int x;
        int y;
        int width;
        int height;

        for(int i = 0; i < array.length; i++){
            x = inFile.nextInt();
            y = inFile.nextInt();
            width = inFile.nextInt();
            height = inFile.nextInt();
            /*System.out.println("Index: " + i + " [x=" + array[i].x + ",y=" + array[i].y + "width=" + array[i].width
                    + "height=" + array[i].height);*/
            array[i] = new Rectangle(x, y, width, height);
        }
        return array;
    }

    public static boolean checkConsecutiveIntersections(Rectangle[] rectangles){
        for(int i = 0; i < rectangles.length - 1; i++){
            if(rectangles[i].intersects(rectangles[i+1])){
                return true;
            }
        }
        return false;
    }

    public static boolean checkAnyIntersections(Rectangle[] rectangles) {
        for (int i = 0; i < rectangles.length - 1; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (rectangles[i].intersects(rectangles[j])) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    (Single vs Nested For Loops)
    https://chat.openai.com/share/38087bfb-4555-41bb-a4d3-674f2e5b1396
    Summarized notes in NB 3/3/24

    Key Points:
    - In nested for loops, the inner for loop needs to finish iterating before the outer loop
    can continue iterating.
    - Inheritance.A return statement means the method terminates or stops and returns the return value.
    Even nested for loops stop what they are doing regardless of if they haven't reached their stopping
    condition (Ex: j < rectangles.length). All operations are discontinued within the method
    */
}

