package Hw1_Prerequisite_Review;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
Objective:
1) Read from numbers.txt file. This file contains Header int value and double numbers. Not multiple sequences. ~~
2) Create an array of the appropriate size. Fill it with doubles. Print out info about array.
3) Info about array:
    - What are the elements of the array and How many elements does it contain?
    - First element?
    - Last element? @ what position?
    - Middle element? @ what position?
    - Largest element? @ what position?
    - Smallest element @ what position?

Tip: Divide up the tasks among a few methods.

 */
public class ArrayInformation {
    public static void main(String[]args) throws FileNotFoundException{
        Scanner inFile = new Scanner(new File("arrayInformationNumbers.txt"));
        int header = inFile.nextInt();
        double[] array = new double[header];


        System.out.print("The array {");
        for(int i = 0; i < header; i++) {
            array[i] = inFile.nextDouble();
            if(i < header-1) {
                System.out.print(array[i] + ", ");
            }else{
                System.out.print(array[i]);
            }
        }

        System.out.print("} contains " + header + " elements\n");
        System.out.println("The first element of the array is " + array[0]);
        System.out.println("The last element of the array is " + array[array.length-1]+ " and is at position " + (array.length-1));

        if(header%2 != 0) {
            System.out.println("The middle element of the array is " + middle(array,header) + " and is at position " + ((header - 1) / 2));
        }else{
            System.out.println("There is no middle of the array since the array's length is even");
        }

        System.out.println("The largest element of the array is " + largest(array,header) + " and is at position " + largestIndex(array,header));
        System.out.println("The smallest element of the array is " + smallest(array,header) + " and is at position " + smallestIndex(array,header));
    }

    public static int smallestIndex(double[]arr, int header){
        int index = 0;
        double smallest = arr[0];
        for(int i=1; i<header; i++){
            if(arr[i] <= smallest){
                smallest = arr[i];
                index = i;
            }
        }
        return index;
    }
    public static double smallest(double[]arr, int header){
        double smallest = arr[0];
        for(int i=1; i<header; i++){
            if(arr[i] <= smallest){
                smallest = arr[i];
            }
        }
        return smallest;
    }
    public static int largestIndex(double[]arr, int header){
        int index = 0;
        double largest = arr[0];
        for(int i = 1; i<header; i++){
            if(arr[i] >= largest){
                largest = arr[i];
                index = i;
            }
        }
        return index;
    }
    public static double largest(double[]arr, int header){
        double largest = arr[0];
        for(int i = 1; i<header; i++){
            if(arr[i] >= largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static double middle(double[]arr, int header){
            int midIndex = (header - 1) / 2;
            return arr[midIndex];
    }

}
/*
What I learned:
I learned how to format a statement correctly from unknown numbers. In this program, there was an error where I had this
{7.3, -6.5, 0.5, 40.0, 5.2, } instead of {7.3, -6.5, 0.5, 40.0, 5.2}. I needed to remove the comma and space at the end.
I fixed this by adding an if else statement. --> If the counter i is less than (header-1) aka the amount of commas and spaces
we need, then we print the statement with comma and space. If the counter i is greater than the amount of commas and spaces
we need, then we print without the comma and space. To reiterate, the (header-1) signifies the amount of commas and spaces we need.
For example, the correct example output of {7.3, -6.5, 0.5, 40.0, 5.2} has 4 commas and spaces and since the numbers are unknown
in the arrayInformationNumbers.txt file we can use the header to guide us and tell us how many commas and spaces we need
each time. In the example, we need 4 commas and spaces as well as 5 numbers(given by the header in the example
5 7.3 -6.5 0.5 40 5.2

New Code:
for(int i = 0; i < header; i++) {
            array[i] = inFile.nextDouble();
            if(i < header -1) {
                System.out.print(array[i] + ", ");
            }else{
                System.out.print(array[i]);
            }
        }

Old Code:
for(int i = 0; i < header; i++) {
            array[i] = inFile.nextDouble();
            System.out.print(array[i] + ", ");
        }
 */