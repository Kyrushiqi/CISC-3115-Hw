// DO NOT MODIFY THIS FILE.

import java.util.Scanner;

public class NameTest {
    public static void main(String[] args) {
        testBasicConstructor();
        testCopyConstructor();
        testToString();
        testGetInitials();
        testIsEqualTo();
        testRead();
    }

    private static void testBasicConstructor() {
        System.out.println("Testing basic constructor");

        Name name1 = new Name("Jane", "Doe");
        Name name2 = new Name("John", "Smith");

        System.out.println(name1.getFirst()); // expected: Jane
        System.out.println(name1.getLast());  // expected: Doe

        System.out.println(name2.getFirst()); // expected: John
        System.out.println(name2.getLast());  // expected: Smith

        System.out.println();
    }

    private static void testCopyConstructor() {
        System.out.println("Testing copy constructor");

        Name name1 = new Name("Jane", "Doe");
        Name name2 = new Name(name1);

        System.out.println(name1.getFirst().equals(name2.getFirst())); // expected: true
        System.out.println(name1.getLast().equals(name2.getLast()));   // expected: true

        name1.setFirst("Janet");
        name2.setLast("Smith");

        System.out.println(name1.getFirst() + " " + name1.getLast());  // expected: Janet Doe
        System.out.println(name2.getFirst() + " " + name2.getLast());  // expected: Jane Smith

        System.out.println();
    }

    private static void testToString() {
        System.out.println("Testing toString");

        Name name = new Name("Jane", "Doe");
        String nameString = name.toString();
        System.out.println("***" + nameString + "***"); // expected: ***Jane Doe***

        name.setFirst("Janet");
        name.setLast("Smith");
        System.out.println(name.toString()); // expected: Janet Smith

        System.out.println();
    }

    private static void testGetInitials() {
        System.out.println("Testing getInitials");

        Name name = new Name("Jane", "Doe");
        String initials = name.getInitials();
        System.out.println("***" + initials + "***"); // expected: ***J.Inheritance.D.***

        name.setFirst("Cynthia");
        name.setLast("Smith");
        System.out.println(name.getInitials()); // expected: Inheritance.C.S.

        System.out.println();
    }

    private static void testIsEqualTo() {
        System.out.println("Testing isEqualTo");

        Name name1 = new Name("Jane", "Doe");
        System.out.println(name1.isEqualTo(name1)); // expected: true

        Name name2 = new Name(new String("Jane"), new String("Doe"));
        System.out.println(name1.isEqualTo(name2)); // expected: true

        Name name3 = new Name("John", "Doe");
        System.out.println(name1.isEqualTo(name3)); // expected: false

        Name name4 = new Name("Jane", "Smith");
        System.out.println(name1.isEqualTo(name4)); // expected: false

        System.out.println();
    }

    private static void testRead() {
        System.out.println("Testing read");

        Scanner scanner = new Scanner("Jane Doe Mike Smith");

        Name name1 = Name.read(scanner); // Name in "Name.read(scanner);" refers to the Name class b/c its calling a static method.
        System.out.println(name1.toString()); // expected: Jane Doe

        Name name2 = Name.read(scanner);
        System.out.println(name2.toString()); // expected: Mike Smith

        System.out.println();
    }
}