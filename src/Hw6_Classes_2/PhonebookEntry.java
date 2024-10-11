package Hw6_Classes_2;/*
Notes:
Name class is mutable -- use defensive copies
PhoneNumber class is immutable

The copy constructor should make a deep copy of the original object.
 */
import Hw5_Classes_1.Name;
import Hw5_Classes_1.PhoneNumber;

import java.util.Scanner;
public class PhonebookEntry {
    private Name name;
    private PhoneNumber phoneNumber;

    public PhonebookEntry(Name name, PhoneNumber phoneNumber){
        this.name = new Name(name);
        this.phoneNumber = phoneNumber;
    }

    public PhonebookEntry(PhonebookEntry original){
        this.name = new Name(original.name);
        this.phoneNumber = original.phoneNumber;
    }

    public Name getName(){
        return new Name(name);
    }

    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }

    public void setName(Name name){
        this.name = new Name(name);
    }

    public void setPhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return name.toString() + " " + phoneNumber.toString();
    }

    /*TODO: complete this method using the PhonebookEntryTest.java
        Is the PhonebookEntry object that is calling the isEqualTo method equal to
        the "other" PhonebookEntry object

        PhonebookEntry phonebookEntry1 = new PhonebookEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        PhonebookEntry phonebookEntry2 = new PhonebookEntry(phonebookEntry1);
        System.out.println(phonebookEntry1.isEqualTo(phonebookEntry2)); // true
     */
    public boolean isEqualTo(PhonebookEntry other){
        /*
        Below doesn't work because you are determining if the name object is equivalent to one another, the default fields.
        You aren't determining if the name object's first name and last name within these name objects are
        equivalent to one another. I think at least-
        if(name.equals(other.name) && phoneNumber.equals(other.phoneNumber)){
            return true;
        }
        return false;
        */
        return (name.getFirst().equals(other.name.getFirst()) && name.getLast().equals(other.name.getLast()) &&
                phoneNumber.equals(other.phoneNumber));
    }

    /*TODO: complete this, return type is PhonebookEntry object
        The PhonebookEntry class calls this method.
     */
    public static PhonebookEntry read(Scanner scanner){
        Name name1 = Name.read(scanner);
        PhoneNumber phoneNumber1 = PhoneNumber.read(scanner);
        return new PhonebookEntry(name1, phoneNumber1);
    }


}
