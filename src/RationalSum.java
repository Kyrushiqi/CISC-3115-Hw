public class RationalSum {
    public static void main(String[]args){
        Rational sum = new Rational (0);

        for(String i : args){
            sum = sum.plus(new Rational(i));
        }
        System.out.println(sum.toString());
    }
}
