package Hw1_Prerequisite_Review;/*
input file = numbers.txt
Objectives:
1) open numbers.txt ~~
2) read in sequences ~~
3) print to screen average of each sequence
4) Total number of sequences processed?

Restrictions: no arrays
Hint: use while loop, for loop, and nest loop
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class Averages {
    public static void main(String[] args)throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("numbers.txt"));
        int totalSequence = 0;
        while(inFile.hasNextInt()){
            double sum = 0;
            int header = inFile.nextInt();
            System.out.print("The average of the " + header + " integers");

            for(int count = 1; count <= header; count++){
                int num = inFile.nextInt();
                System.out.print(" " + num);
                sum += num;
            }

            double average = sum/header;
            System.out.println(" is " + average);

            totalSequence++;

        }

        System.out.println(totalSequence + " sets of numbers processed");

    }
}

/* Things I've learned:
1) You need to break up the final sentence in order for this to work without arrays
2) You need the double sum = 0; so that the sum renews everytime we go through the sequence.
So that it doesn't add on from the previous numbers
3) .nextLine(); reads until the end of a line.
4) .next(); reads until a space
 */