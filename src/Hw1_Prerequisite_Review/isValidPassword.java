package Hw1_Prerequisite_Review;/*
Objective:
Write a method that receives a String and determine whether the String is a valid password.
The password should have the following requirements:
1) at least 1 letter
2) at least 1 digit
3) at least 5 characters in total
Examples:
if the password is...
"557s3" --> true, all requirements are met.
"55r17s3" --> true, all requirements are met.
"55753" --> false, doesn't contain at least 1 letter
"eftyh" --> false, doesn't contain at least 1 digit
"57s3" --> false, only has 4 characters in total

Tips:
- Use charAt method (String Class) --> to invoke instance method you need to have a String object
Ex: String s = "Hello"; --> s.charAt(2); --> The result will be the first l.
How to count characters? It's exactly like counting indexes in array...start from 0.

- Use isDigit method (Character Class) --> to invoke static method you use the name of the class (Which is 'Character')
Ex: Character.isDigit('7');

- Use isLetter method (Character Class)

(More info on these methods in my notebook 2/7/24)
 */

public class isValidPassword {
    public static void main(String[]args){
        String phrase = "57s3";
        System.out.println("Valid Password? " + isValidPassword(phrase));
    }

    public static boolean isValidPassword(String phrase){
        boolean b1 = false;
        int digit = 0;
        int letter = 0;
        int characters = 0;

        for(int i = 0; i<phrase.length(); i++){
            if(Character.isDigit(phrase.charAt(i))){
                digit++;
                characters++;
            }else if(Character.isLetter(phrase.charAt(i))){
                letter++;
                characters++;
            }
        }

        if(digit >= 1){
            if(letter >= 1){
                if(phrase.length() >= 5){
                    b1 = true;
                }else{
                    b1 = false;
                }
            }
        }

        return b1;
    }
}
