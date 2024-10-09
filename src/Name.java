/*
Mutable class, there are setter methods here.
 */
import java.util.Scanner;
public class Name {
    private String firstName;
    private String lastName;

    //Name name1 = new Name("Jane", "Doe");

    /**
     * Constructor
     */
    public Name(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }
    /**
     * Copy Constructor: it is used to construct a new object that is a copy of an old object.
     */
    public Name(Name original){
        firstName = original.getFirst();
        lastName = original.getLast();
    }

    public String getFirst(){
        return firstName;
    }

    public String getLast(){
        return lastName;
    }

    public void setFirst(String first){
        this.firstName = first;
    }

    public void setLast(String last){
        this.lastName = last;
    }

    public String toString(){
        return firstName + " " + lastName;
    }

    public String getInitials(){
        return firstName.charAt(0) + "." + lastName.charAt(0) + ".";
    }

    public boolean isEqualTo(Name other){
        if(firstName.equals(other.firstName) && lastName.equals(other.lastName)){
            return true;
        }
        return false;
    }

    /*
     * Static methods are part of the class, not part of an object. So you can't access the private String
     * fields firstName or lastName in this method because they are part of a Name object.
     *
     * Static methods need to be called by the class and not by an object.
     */
    public static Name read(Scanner scanner){
        return new Name(scanner.next(), scanner.next());
    }
}
