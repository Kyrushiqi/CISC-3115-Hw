package Hw8_Interfaces.Comparable;
import java.util.Objects;

/*
hashCode() vs hash()
- Object.hashCode(): use to get the hashcode of a single, non-null object
- Objects.hashCode(): use to get the hashcode of a single object that might be null

- Objects.hash(): use to get a hashcode for multiple objects
 */

public class Time24 implements Comparable<Time24>{
    private int hour, minute, second;

    public Time24(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }

    /**
     * String timeString is in the form of "hour:minute:second"
     *
     * parse method purpose:
     * The method should create and return a new Time24 object based on the timeString.
     */
    public static Time24 parse(String timeString){
        String ts = timeString;
        String[]arr = timeString.split(":");

        return new Time24(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]) );
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Time24){
            Time24 other = (Time24) obj;
            return this.hour == other.hour && this.minute == other.minute && this.second == other.second;
        } else {
        return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(hour, minute, second);
    }

    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    /** compareTo is part of the generic interface -- Comparable
     *
     * Objective: Time24 objects should be compared chronologically; that is, an earlier time should
     * be considered less than a later time.
     * Earlier time < later time
     *
     * In this method we compare the hours, minutes, then seconds. If the hours are the same we compare the minutes.
     * If the minutes are the same we then compare the seconds.
     * Ex: 22:50:20 vs 23:10:59
     * We first look at the hours. It clearly indicates which of the two has the longer time, 22 or 23, it is 23 hours.
     * Thus ending the program at that since 22 < 23 which means 23:10:59 is greater than 22:50:20.
     *
     * Hour: 0-23 hours
     * Minute: 0-59 minutes
     * Second: 0-59 seconds
     *
     * public static int compare(int x, int y):
     * this < other = negative #
     * this > other = positive #
     * this = other = 0
     */
    @Override
    public int compareTo(Time24 other){
        int hourComparison = Integer.compare(this.hour, other.hour);
        if(hourComparison != 0){
            return hourComparison; // returns a negative or positive number signifying that the hours are different.
        }

        int minuteComparison = Integer.compare(this.minute, other.minute);
        if(minuteComparison != 0){
            return minuteComparison;
        }

        int secondComparison = Integer.compare(this.second, other.second);
        return secondComparison;
    }

}
