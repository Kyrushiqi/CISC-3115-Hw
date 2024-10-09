import java.util.Scanner;

public class ThreeNumbers {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);

        System.out.print("first number? second number? third number? ");
        int a = keybd.nextInt();
        int b = keybd.nextInt();
        int c = keybd.nextInt();


        System.out.println("allAreEqual: " + allAreEqual(a, b, c));
        System.out.println("exactlyTwoAreEqual: " + exactlyTwoAreEqual(a, b, c));
        System.out.println("noneAreEqual: " + noneAreEqual(a, b, c));
        System.out.println("areAscending: " + areAscending(a, b, c));
        System.out.println("areDescending: " + areDescending(a, b, c));
        System.out.println("areStrictlyAscending: " + areStrictlyAscending(a, b, c));
        System.out.println("areStrictlyDescending: " + areStrictlyDescending(a, b, c));

    }

    public static boolean allAreEqual(int a, int b, int c){
        return a==b && b==c;
    }

    public static boolean exactlyTwoAreEqual(int a, int b, int c){
        return (a == b && b != c) || (a == c && a != b) || (b == c && b != a);
    } // but returns false when all three are equal

    public static boolean noneAreEqual(int a, int b, int c){
        return a != b && b != c && c != a;
    }

    public static boolean areAscending(int a, int b, int c){
        return a <= b && b <= c;
    } // returns true when a <= b <= c, false otherwise

    public static boolean areDescending(int a, int b, int c){
        return a >= b && b>=c;
    } // returns true when a >= b >= c, false otherwise

    public static boolean areStrictlyAscending(int a, int b, int c){
        return a < b && b < c;
    } // returns true when a < b < c, false otherwise

    public static boolean areStrictlyDescending(int a, int b, int c){
        return a > b && b > c;
    } // returns true when a > b > c, false otherwise

}
