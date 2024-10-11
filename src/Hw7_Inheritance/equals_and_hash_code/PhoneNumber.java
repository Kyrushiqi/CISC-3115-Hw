package Hw7_Inheritance.equals_and_hash_code;

import java.util.Objects;
public class PhoneNumber {
    private int areaCode, prefix, lineNumber;

    public PhoneNumber(String fullNumber) {
        String[] tokens = fullNumber.split("-");
        areaCode = Integer.parseInt(tokens[0]);
        prefix = Integer.parseInt(tokens[1]);
        lineNumber = Integer.parseInt(tokens[2]);
    }

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public PhoneNumber(PhoneNumber original) {
        this.areaCode = original.areaCode;
        this.prefix = original.prefix;
        this.lineNumber = original.lineNumber;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNumber);
    }

    public boolean equals(Object obj){
        if(obj instanceof PhoneNumber){
            PhoneNumber other = (PhoneNumber) obj;
            return this.areaCode == other.areaCode &&
                    this.prefix == other.prefix &&
                    this.lineNumber == other.lineNumber;
        } else{
        return false;}
    }

    public int hashCode(){
        return Objects.hash(areaCode, prefix, lineNumber);
    }
}


