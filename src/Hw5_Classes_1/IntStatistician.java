package Hw5_Classes_1;

public class IntStatistician {
    private int count = 0;
    private int sum = 0;
    private int min = 0;
    private int max = 0;

    /**
     * Gives the specified integer to this IntStatistician. The IntStatistician doesn't store the integer;
     * instead, it uses it to update the statistics.
     */
    public void record(int number){
        count ++;
        sum += number;
        if(min == 0){
            min = number;
        }
        /* Since number is always going to be less than min, because min is 0 (number < 0, always false),
        we must give the value of `number` to `min` so that we can compare incoming numbers to other incoming numbers.
        And not compare the developer's initial int min value of 0 to the new incoming numbers. We also must use
        if(min == 0) as a condition because if we just do `min = number;` we will always have `min` referring to a new
        incoming `number`and we won't be able to compare the new incoming numbers to other incoming numbers
        in the method below -- if(number < min){min = number;}
        */
        if(number < min){
            min = number;
        }
        if (number > max){
            max = number;
        }
    }

    /**
     * Returns the number of integers that have been given to this IntStatistician; if nothing has been given
     * yet, returns 0.
     */
    public int count(){
        return count;
    }

    /**
     * Returns the sum of the integers that have been given to this IntStatistician; if nothing has been
     * given yet, returns 0.
     */
    public int sum(){
        return sum;
    }

    /**
     * Returns (as a double) the average of the integers that have been given to this IntStatistician;
     * if nothing has been given yet, returns 0.0
     */
    public double average(){
        if(count == 0){
            return 0.0;
        }else{
            return (double) sum/count;
        }
    }

    /**
     * Returns the minimum of the integers that have been given to this IntStatistician; if nothing has been
     * given yet, returns Integer.MAX_VALUE.
     */
    public int min(){
        if(count == 0) {
            return Integer.MAX_VALUE;
        }else{
            return min;
        }
    }
    /**
     * Returns the maximum of the integers that have been given to this IntStatistician; if nothing has been
     * given yet, returns Integer.MIN_VALUE.
     */
    public int max(){
        if(count == 0) {
            return Integer.MIN_VALUE;
        }else{
            return max;
        }
    }
}
