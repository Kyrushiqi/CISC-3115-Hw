/*
Standard Deviation calculator objective:
1) if user provides fewer than 2 command line arguments, the program should print the error message
2) if user inputs are good, then the program should calculate and print out the standard deviation
(Assume that the user will only provide numbers (but not necessarily integers)
 */
public class StandardDeviation {
    public static void main(String[]args){
        int n = args.length;
        double meanSum = 0;
        double sumOfParenthesis = 0;
        double standardDeviation = 0;

        if(args.length < 2){
            System.out.println("usage: java StandardDeviation n1 n2 [n3 ...]\n    n1, n2, etc.: numbers");
        }else {

            for (int i = 0; i < args.length; i++) {
                meanSum += Double.parseDouble(args[i]);
            }
            double mean = meanSum / n;

            for (int i = 0; i < args.length; i++) {
                sumOfParenthesis += (Math.pow((Double.parseDouble(args[i]) - mean), 2));
            }

            standardDeviation = Math.sqrt(sumOfParenthesis / n);
            System.out.println(standardDeviation);
        }
    }
}
