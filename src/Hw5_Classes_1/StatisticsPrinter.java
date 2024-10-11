package Hw5_Classes_1;/*
This class goes with IntStatistician and IntStatisticianTest
 */

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class StatisticsPrinter {
    public static void main(String[]args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("integers.txt"));
        IntStatistician stats = new IntStatistician();
        while(sc.hasNextInt()){
            stats.record(sc.nextInt());
        }
        /*for(int i = 0; i < ???; i++ ) {
            stats.record(sc.nextInt());
        } Doesn't work because we don't know where i should stop at. We want to read until the end of
        file, so we should use a `while` loop with the condition sc.hasNextInt().
        .hasNextInt() means if the file still has more integers continue doing the body.
        */

        System.out.println("count: " + stats.count());
        System.out.println("sum: " + stats.sum());
        System.out.println("average: " + stats.average());
        System.out.println("min: " + stats.min());
        System.out.println("max: " + stats.max());
    }
}
