package Hw3_Command_Line;

/*
Write a program that is given an abitrary amount of numeric command-line arguments and prints their maximum to the screem.
You can assume that the user will only provide numbers (but nt necessarily integers). If no command line arguments are provided
by the user, the program should print the following error message:
usage: java Max n1 [n2 ...]
    n1, n2, etc.: numbers
(There are exactly four spaces at the beginning of the second line.)
 */
public class Max {
    public static void main(String[]args){
        if(args.length == 0){
            System.out.println("usage: java Max n1 [n2 ...]\n    n1, n2, etc.: numbers");
        }else{
            double max = Double.parseDouble(args[0]);

            for(int i = 0; i<args.length; i++){
                max = Math.max(max, Double.parseDouble(args[i]));
            }
            System.out.println(max);
        }
    }
}
/*
What I learned:
Parsing in java means converting a String type to other data types. For example in this program,
parseDouble from the Double class will take the arguments/elements in the array of Strings then
converts them into a Double.
 */
