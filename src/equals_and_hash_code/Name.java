package equals_and_hash_code;

/*second attempt:

 */
import java.util.Objects;
public class Name {
    private String first, last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Name(Name original) {
        this.first = original.first;
        this.last = original.last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    /**
     * Overrides the equals method of the Object class. Two names are equal if they have equal first and equal last names.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Name){ // if reference points to an object of Name class then its true so continue
            Name other = (Name) obj; // downcasting of object to name
            return first.equals(other.first) && last.equals(other.last);
        }
        return false;
    }

    /**
     * When overriding equals method of object class, you must also override the hashCode method too. Java instructions.
     * @return
     */
    @Override
    public int hashCode(){
        return Objects.hash(first, last);
    }
}



/*
import java.util.Objects;

public class Name {
    private String first, last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Name(Name original) {
        this.first = original.first;
        this.last = original.last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name otherName = (Name) obj;
        return Objects.equals(first, otherName.first) && Objects.equals(last, otherName.last);
    }

    public int hashCode(){
        return Objects.hash(first, last);
    }
}
*/
