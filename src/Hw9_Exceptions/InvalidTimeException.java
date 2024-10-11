package Hw9_Exceptions;

/*Objective:
- Custom exception class should extend Exception class
- Its constructor should accept a String representing the invalid time.
- Message for InvalidTimeException is "invalid time: " + invalidTime. EX: "invalid time: 24:45:59"
(In order to assign this message, the constructor must call the superclass constructor)
- getInvalidTime() method, no parameters, returns the invalid time (as a String)
 */

public class InvalidTimeException extends Exception{
    private String invalidTime;

    //Constructor
    public InvalidTimeException(String invalidTime){
        super("invalid time: " + invalidTime); // calls the
        this.invalidTime = invalidTime;
    }

    public String getInvalidTime(){
        return invalidTime;
    }

}
