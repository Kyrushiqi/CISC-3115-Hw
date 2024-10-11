package Hw2_Prerequisite_Review;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class PhonebookApp {
    public static void main(String[]args) throws FileNotFoundException {
        final int MAX_ENTRIES = 10;
        String[] firstName = new String[MAX_ENTRIES];
        String[] lastName = new String[MAX_ENTRIES];
        String[] phoneNumber = new String[MAX_ENTRIES];

        Scanner keybd = new Scanner(System.in);
        System.out.print("Hw5_Classes_1.Name of input file: "); // entries_input.txt
        String fileName = keybd.next();
        Scanner fileSc = new Scanner(new File(fileName));
        System.out.println();

        int numEntries = readFile(firstName, lastName, phoneNumber, fileSc);

        /*System.out.println("Number of Entries: " + numEntries);
        for(int i = 0; i<10; i++){
            System.out.println("Index: " + i + " " + firstName[i]+ " " + lastName[i]+ " " + phoneNumber[i]);
        }*/

        char choice;
        do{
            printMenu();
            choice = keybd.next().charAt(0);

            switch(choice){
                case 'l':
                    lookUp(firstName, lastName, phoneNumber, keybd, numEntries);
                    System.out.println();
                    break;
                case 'r':
                    reverseLookUp(firstName, lastName, phoneNumber, keybd, numEntries);
                    System.out.println();
                    break;
                case 'c':
                    changeNumber(firstName, lastName, phoneNumber, keybd, numEntries);
                    System.out.println();
                    break;
                case 'a':
                    boolean added = addEntry(firstName, lastName, phoneNumber, keybd, numEntries, MAX_ENTRIES);
                    if(added){
                        numEntries++;
                    }
                    System.out.println();
                    break;
                case 'q':
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.out.println();
            }
        }while(choice != 'q');

        System.out.print("Hw5_Classes_1.Name of output file: "); // entries_output.txt
        fileName = keybd.next();
        printEntries(firstName, lastName, phoneNumber, fileName, numEntries);

        /*System.out.println("Number of Entries: " + numEntries);
        for(int i = 0; i<10; i++){
            System.out.println("Index: " + i + " " + firstName[i]+ " " + lastName[i]+ " " + phoneNumber[i]);
        }*/
    }

    /*
    indexOfStrings method objective:
    To find the index of a first and last name as requested by the user.
    To find the index of a phone number as requested by the user.
     */
    public static int indexOfStrings(String[] firstName, String[] lastName, int numEntries, String inputFirstName, String inputLastName){
        for(int i = 0; i < numEntries; i++){
            if(firstName[i].equals(inputFirstName) && lastName[i].equals(inputLastName)){
                return i;
            }
        }
        return -1;
    }

    public static int indexOfStrings(String[]phoneNumber, int numEntries, String inputPhoneNum){
        for(int i = 0; i < numEntries; i++){
            if(phoneNumber[i].equals(inputPhoneNum)){
                return i;
            }
        }
        return -1;
    }
    /*
    Add Entry objective:
    Allows the user to add a new entry.
    1) If there's no room in arrays for a new entry, print error message.
    2) Else ask for first and last name. If name is found, print error message.
    3) Else ask for phone number and add new entry to arrays.
     */
    public static boolean addEntry(String[] firstName, String[] lastName, String[]phoneNumber, Scanner keybd, int numEntries, int MAX_ENTRIES){
        if(numEntries >= MAX_ENTRIES){
            System.out.println("Database is full");
            return false;
        }
        System.out.print("First name: ");
        String inputFN = keybd.next();
        System.out.print("Last name: ");
        String inputLN = keybd.next();

        int i = indexOfStrings(firstName, lastName, numEntries, inputFN, inputLN);
        if(i != -1){
            System.out.println("That name already exists");
            return false;
        }else{
            System.out.print("Phone number: ");
            String inputPhoneNum = keybd.next();

            firstName[numEntries] = inputFN;
            lastName[numEntries] = inputLN;
            phoneNumber[numEntries] = inputPhoneNum;
            System.out.println("Entry added");
            return true;
        }
    }
    /*
    Change Number method objective:
    Allows user to update an entry's phone number.
    1) Ask for first and last name
    2) If first and last name found, ask for new phone number and update the old entry's phone number
    3) Else print error message
     */
    public static void changeNumber(String[] firstName, String[] lastName, String[]phoneNumber, Scanner keybd, int numEntries){
        System.out.print("First name: ");
        String inputFN = keybd.next();
        System.out.print("Last name: ");
        String inputLN = keybd.next();

        int nameIndex = indexOfStrings(firstName, lastName, numEntries, inputFN, inputLN);

        if(nameIndex == -1){
            System.out.println("Hw5_Classes_1.Name not found");
        }else{
            System.out.print("New phone number: ");
            String newPhoneNum = keybd.next();

            phoneNumber[nameIndex] = newPhoneNum;
            System.out.println("Phone number updated");
            //System.out.println(phoneNumber[nameIndex]);
        }
    }
    public static void reverseLookUp(String[] firstName, String[] lastName, String[]phoneNumber, Scanner keybd, int numEntries){
        System.out.print("Phone number: ");
        String inputPhoneNum = keybd.next();

        int index = indexOfStrings(phoneNumber, numEntries, inputPhoneNum);
        if(index == -1){
            System.out.println("Phone number not found");
        }else{
            System.out.println(phoneNumber[index] + " is " + firstName[index] + " " + lastName[index] + "'s phone number");
        }
    }
    /*
    LookUp method:
    1) Ask for first name and last name
    2) If valid first and last name then print info about that entry
    3) Else print error message
     */
    public static void lookUp(String[] firstName, String[] lastName, String[]phoneNumber, Scanner keybd, int numEntries){
        System.out.print("First name: ");
        String inputFirstName = keybd.next();
        System.out.print("Last name: ");
        String inputlastName = keybd.next();

        //System.out.println(inputFirstName + " " + inputlastName);


        int i = indexOfStrings(firstName, lastName, numEntries, inputFirstName, inputlastName);
        if(i == -1){
            System.out.println("Hw5_Classes_1.Name not found");
        }else{
            System.out.println(firstName[i] + " " + lastName[i] + "'s phone number is " +  phoneNumber[i]);
        }


        //return firstName[i] + " " + lastName[i] + " " +  phoneNumber[i];
    }
    public static int readFile(String[] firstName, String[] lastName, String[]phoneNumber, Scanner fileSc){
        int numEntries = 0;
        while(fileSc.hasNext()){
            firstName[numEntries] = fileSc.next();
            lastName[numEntries] = fileSc.next();
            phoneNumber[numEntries] = fileSc.next();
            numEntries++;
        }
        return numEntries;
    }

    public static void printMenu(){
        System.out.println("Choices:");
        System.out.println("l: lookup, r: reverse lookup, c: change number, a: add entry, q: quit");
    }

    public static void printEntries(String[]firstName, String[]lastName, String[]phoneNumber, String fileName, int numEntries)
    throws FileNotFoundException{
        PrintStream ps = new PrintStream(fileName);
        for(int i = 0; i<numEntries; i++){
            ps.println(firstName[i] + " " + lastName[i] + " " + phoneNumber[i]);
        }
        ps.close();
    }
}
