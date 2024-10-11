package Hw3_Command_Line;/*
Write a program that "echoes" the command line arguments in reverse order, one per line. For example,
if the program is run like this:
java EchoBackwards Hello world "CISC 3115"
then the output should be:
CISC 3115
world
Hello
 */

public class EchoBackwards {
    public static void main(String[]args){

        /*for(String elementArg : args){
            System.out.println(elementArg);
        }*/

        for(int i = args.length - 1; i >= 0; i--){
            System.out.println(args[i]);
        }
    }
}
/*
Explanation for args.length - 1:
The args.length represents the number of elements in the args array. However, array indices in Java are zero-based,
meaning the first element of the array has an index of 0, the second element has an index of 1, and so on.

Therefore, to access the last element of the array, you need to subtract 1 from the length of the array
(args.length - 1) because the last element's index is one less than the length of the array.


0 Hello 1 world 2 "CISC 3115"
args.length = 3
args.length - 1 = 2 // retrieves last index of the array which is 2
 */


        /* First attempt:
        Scanner keybd = new Scanner(System.in);
        int MAX_ARR = 10;
        String[]arr = new String[MAX_ARR];

        for (int i = 0; i < arr.length; i++){
            arr[i] = keybd.nextLine();
            System.out.println("Index: " + i + " " + arr[i]);
        }

        for(int i = arr.length; i == 0; i--){
            System.out.println(arr[i]);
        }*/
