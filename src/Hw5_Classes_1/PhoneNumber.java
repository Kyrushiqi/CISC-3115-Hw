package Hw5_Classes_1;/*
Immutable class, there are no setter methods here.
 */
import java.util.Scanner;
public class PhoneNumber {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber){
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public PhoneNumber(String fullNumber){
        this.areaCode = Integer.parseInt(fullNumber.substring(0,3));
        this.prefix = Integer.parseInt(fullNumber.substring(4,7));
        this.lineNumber = Integer.parseInt(fullNumber.substring(8,12));
    }

    public int getAreaCode(){
        return areaCode;
    }
    public int getPrefix(){
        return prefix;
    }
    public int getLineNumber(){
        return lineNumber;
    }

    public String toString(){
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNumber);
                //areaCode + "-" + prefix + "-" + lineNumber;  (Wrong: Missing 0s)
    }

    public boolean isEqualTo(PhoneNumber other){
        if((areaCode == other.areaCode) && (prefix == other.prefix) && (lineNumber == other.lineNumber)){
            return true;
        }
        return false;
    }

    public static PhoneNumber read(Scanner scanner){
        String phoneNumber = scanner.next();
        String[] phoneNum = phoneNumber.split("-");
        /* Wrong: PhoneNumber[] phoneNum = new PhoneNumber[3];
                  phoneNum[0] = phoneNumber.split("-");*/

        return new PhoneNumber(Integer.parseInt(phoneNum[0]), Integer.parseInt(phoneNum[1]),
                Integer.parseInt(phoneNum[2]));
    }
}
