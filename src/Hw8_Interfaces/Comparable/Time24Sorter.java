package Hw8_Interfaces.Comparable;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

/*
Time24 class' comparable -- array of Time24 objects can be sorted using the Arrays.sort method.
Additionally, the parse and toString methods of Time24 may come in handy.

CompareTo method purpose: Time24 objects should be compared chronologically; that is, an earlier time should
     * be considered less than a later time.
     * Earlier time < later time

parse method purpose:
     * The method should create and return a new Time24 object based on the timeString.
 */
public class Time24Sorter {

    public static void main(String[] args) throws FileNotFoundException{
        print(read());
    }

    /**
     * Read method:
     * Read in from times.txt file. Using a for loop reads in times and inputs into parse to divide the numbers into
     * hours, minutes, and seconds. The parse method returns new Time24 objects that can then be put into an array of
     * Time24 objects.
     *
     */
    public static Time24[] read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("times.txt"));
        int header = sc.nextInt();
        Time24[] arr = new Time24[header];

        for(int i = 0; i < header; i++){
            arr[i] = Time24.parse(sc.next());
        }
        return arr;
    }

    /**
     * Print method:
     * 1) Sorts the times using Arrays.sort method. Array.sort(arr) works only if the elements of arr come from a class
     * that implements Comparable interface.
     *
     * 2) Then prints the sorted array using the toString method.
     */
    public static void print(Time24[] arr) throws FileNotFoundException {
        Arrays.sort(arr); // uses Time24's compareTo method to compare the elements with each other.
        PrintStream ps = new PrintStream("sortedtimes.txt");
        for(Time24 time : arr){
            ps.println(time.toString());
        }
        ps.close();
    }


}
