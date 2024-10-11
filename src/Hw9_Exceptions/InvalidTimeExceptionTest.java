package Hw9_Exceptions;

// DO NOT MODIFY THIS FILE.

public class InvalidTimeExceptionTest {
    public static void main(String[] args) {
        try {
            throw new InvalidTimeException("25:45:23");
        } catch (InvalidTimeException e) {
            System.out.println(e.getInvalidTime()); // 25:45:23
            System.out.println(e.getMessage());     // invalid time: 25:45:23

            System.out.println(e.getClass().getSuperclass().getName()); // java.lang.Exception
        }
    }
}
