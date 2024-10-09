/*
Enhanced For loop Syntax:
    for(dataType element : array){
    (body...)
    }

    element = each element of an array/collection is assigned to this variable
    Ex:
    Given an array {2, 1, 3, 3}
    element will be replaced by each of these elements
    Giving: for(int 2: array){}
            for(int 1: array){}
            ... etc.

   (More information can be found on Discord server 2/7/24)
 */

public class enhancedForLoop {
    public static void main(String[]args){
        String[] array = {"aa", "b", "ccc", "d"};
        String result = longest(array);
        System.out.println(result);
        /*//Demo
        for(String i: array){
            System.out.println(i);
        }*/
    }

    public static String longest(String[]arr){
        String longestString = "";

        for(String i: arr){
            if(i.length() > longestString.length()){
                longestString = i;
            }
        }
        return longestString;
    }
}
