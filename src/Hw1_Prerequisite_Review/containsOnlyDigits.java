package Hw1_Prerequisite_Review;/*
Objective:
Write a boolean method named containsOnlyDigits. The method receives a String and determine whether the
String contains only digits.
Examples:
- containsOnlyDigits("571") should be true
- containsOnlyDigits("5s1") should be false
- containsOnlyDigits("5") should be true
- containsOnlyDigits("") should be true

Tips:
- Use charAt method (String Class) --> to invoke instance method you need to have a String object
Ex: String s = "Hello"; --> s.charAt(2); --> The result will be the first l.
How to count characters? It's exactly like counting indexes in array...start from 0.

- Use isDigit method (Character Class) --> to invoke static method you use the name of the class (Which is 'Character')
Ex: Character.isDigit('7');

(More info on these methods in my notebook 2/7/24)

- Remember that we can do math on characters. Not that we need it here lol.
 */

public class containsOnlyDigits {
    public static void main(String[]args){
        String phrase = "571";
        System.out.println("The String contains only digits: " + containsOnlyDigits(phrase));
        //System.out.println(Character.isDigit('1'));

        /*Demo vv
        char result = phrase.charAt(1);
        System.out.println(result);

        boolean b1 = Character.isDigit('Inheritance.A');
        System.out.println(b1); */
    }

    public static boolean containsOnlyDigits(String phrase){
        //System.out.println(phrase); // to check if the phrase has been passed
        boolean b1 = true;
        //System.out.println("Phrase length: " + phrase.length());

        for(int i = 0; i<phrase.length(); i++){
            //char ch = phrase.charAt(i);
            //System.out.println("Index: " + i + " " + ch);

            if(Character.isDigit(phrase.charAt(i)) == true){
                b1 = true;
            }else if(Character.isDigit(phrase.charAt(i)) == false){
                b1 = false;
                return b1;
            }
        }

        return b1;
    }

}
/*
What I learned:
I learned the .isDigit(); and .charAt(); methods as written in the Tips section. More comments about this in my notebook
2/7/24
I also learned .length() tells me the length of a String. In this case, phrase.length(); told me the length of
the String phrase in main method.
The lines in // are things I used to test different parts of the method.
 */
