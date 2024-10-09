package equals_and_hash_code;

// DO NOT MODIFY THIS FILE.

public class NameTest {
    public static void main(String[] args) {
        Object o1 = new Name("Jane", "Doe");
        Object o2 = new Name("Jane", "Doe");
        System.out.println(o1.equals(o2)); // expected: true
        System.out.println(new Name("Jane", "Doe").equals(new Name("John", "Doe"))); // expected: false
        System.out.println(new Name("Jane", "Doe").equals(new Name("Jane", "Smith"))); // expected: false
        System.out.println(new Name("Jane", "Doe").equals(new Name("Doe", "Jane"))); // expected: false
        System.out.println(new Name("Jane", "Doe").equals("a string"));              // expected: false
        System.out.println(new Name("Jane", "Doe").equals(null));                    // expected: false

        System.out.println(new Name("A", "B").hashCode() == new Name("A", "B").hashCode()); // expected: true
    }
}
