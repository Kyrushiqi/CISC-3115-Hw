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
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.awt.Rectangle;


public class Redo_ArrayOfRectangles {
    public static void main(String[]args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("rectangles.txt"));
        int numRectangles = inFile.nextInt();
        //System.out.println("Number of Rectangles: " + numRectangles);

        Rectangle[]array = readRectangles(inFile,numRectangles);
        toString(array);
        //System.out.println("Array length " + array.length);

        System.out.println("contains consecutive intersecting rectangles: " + consecutiveRectangles(array));
        System.out.println("contains intersecting rectangles: " + intersectingRectangles(array));

    }

    /**
     * 4) Print whether any of the Rectangles in the array intersect each other.
     * I may want to review this part again. Test to see if I know how to design this later on.
     */
    public static boolean intersectingRectangles(Rectangle[]array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i].intersects(array[j])){
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

    /**3) Print whether there are any consecutive Rectangles in the array that intersect each other.
     */
    public static boolean consecutiveRectangles(Rectangle[]array){
        boolean answer = true;
        for(int i = 0; i < array.length-1; i++){
            if(array[i].intersects(array[i+1])){
                answer = true;
            }else{
                answer = false;
            }
        }
        return answer;
    }

    /**
     * 2) Print using toString() method from Rectangle class.
     */
    public static void toString(Rectangle[]array){
        for(Rectangle i : array){
            System.out.println( i );
        }
    }
    /**1) Read in from file 'rectangles.txt' and place Rectangle objects into an array. Inheritance.A rectangle object
     has the following attributes in this order: x-coordinate, y-coordinate, width, height of a rectangle.
     The header number in the file tells us how many rectangle object information there is.
     */
     public static Rectangle[] readRectangles(Scanner inFile, int numRectangles){
        Rectangle[]array = new Rectangle[numRectangles];
        int x;
        int y;
        int width;
        int height;

        for(int i = 0; i< numRectangles; i++){
            x = inFile.nextInt();
            y = inFile.nextInt();
            width = inFile.nextInt();
            height = inFile.nextInt();

            array[i] = new Rectangle(x, y, width, height);
            /*System.out.println("Index: " + i + " " + array[i].x + " " + array[i].y + " "+ array[i].width + " "
                    + array[i].height + " " );*/
        }

        /*for(int i = 0; i<numRectangles; i++){
            array[i].x = inFile.nextInt();
            array[i].y = inFile.nextInt();
            array[i].width = inFile.nextInt();
            array[i].height = inFile.nextInt();

            System.out.println(array[i].x + " " + array[i].y + " " + array[i].width + " " + array[i].height);

        }
        Error: Exception in thread "main" java.lang.NullPointerException: Cannot assign field "x" because "array[i]" is null
	    at Redo_ArrayOfRectangles.readRectangles(Redo_ArrayOfRectangles.java:33)
	    at Redo_ArrayOfRectangles.main(Redo_ArrayOfRectangles.java:22)
            The error you're encountering, NullPointerException, occurs because you're trying to access fields
        (x, y, width, height) of the Rectangle objects in your array without first initializing those objects.
        In Java, when you create an array of objects, each element in the array is initially null. You need to
        instantiate a Rectangle object for each element in the array before you can access its fields.
        My own Words:
        There are no fields/objects named x,y, width, or height, in the array...only an object with the field "null." So,
        you have to create a new Rectangle object and fields for each of the indexes in the array so they can be referenced
        to a value (aka fields). Visualized in NB 2/29/24.
        */
        return array;
    }
}
