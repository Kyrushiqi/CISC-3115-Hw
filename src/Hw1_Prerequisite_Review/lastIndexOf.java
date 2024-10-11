package Hw1_Prerequisite_Review;

public class lastIndexOf {
    public static void main(String[]args){
        int[]arr = {9, 13, 2, 8, 13, -8, 13, 9};
        int x = 9;

        int index = lastIndexOf(arr,x);
        System.out.println("Final Answer - Index: " + index);
    }

/*Method Objective:
Find last occurrence of x inside the array arr and return its index.
If X isn't found in arr, the method should return -1

 */
    // Parameter reads in the array as well as the integer x we want to find.
    public static int lastIndexOf(int[] arr, int x){
        int index = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) {
                index = i;
            }
        }
        return index;
    }

    /*
    What I learned:
    For context, my original plan was to set up a second array and store the indices of X in it.
    Then return the last non-zero index in that array to get the answer. While this isn't wrong,
    it's much more complicated than it had to be.

    In the new/current version, I only focus on the given array.
    Using a for loop I searched through the array to find any numbers that matched up with the target, x. If it
    did match, then the index variable will store that specific index. And as we move along the array from left to right
    the index variable will continue to update finding the largest index there is of the target x. If none of the elements
    in the array match with x, then it will return the default number -1. We put it as -1 in the beginning to
    make our lives easier if we never find the x element in the array. --> It is -1 because Professor Moshe Lach said so
    in the given prompt.
     */


}

