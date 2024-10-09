// DO NOT MODIFY THIS FILE

import java.lang.reflect.Field;
import java.util.Scanner;

public class PhonebookEntryTest {
    public static void main(String[] args) throws IllegalAccessException {
        basicTests();
        isEqualToTests();
        advancedTests();
    }

    private static void basicTests() {
        PhonebookEntry phonebookEntry1 = new PhonebookEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        System.out.println(phonebookEntry1.getName().toString()); // Jane Doe
        System.out.println(phonebookEntry1.getPhoneNumber().toString()); // 123-456-7890

        phonebookEntry1.setName(new Name("Adam", "Smith"));
        phonebookEntry1.setPhoneNumber(new PhoneNumber("098-765-4321"));
        System.out.println(phonebookEntry1.toString()); // Adam Smith 098-765-4321

        PhonebookEntry phonebookEntry2 = new PhonebookEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        System.out.println(phonebookEntry2.toString()); // Jane Doe 123-456-7890

        Scanner scanner = new Scanner("Jane Doe 111-111-1111 Mike Smith 222-222-2222");
        PhonebookEntry phonebookEntry3 = PhonebookEntry.read(scanner); // PhonebookEntry after the = is the class since read is a static method. Only class can call static methods.
        System.out.println(phonebookEntry3.toString()); // Jane Doe 111-111-1111
        PhonebookEntry phonebookEntry4 = PhonebookEntry.read(scanner);
        System.out.println(phonebookEntry4.toString()); // Mike Smith 222-222-2222
    }

    private static void isEqualToTests() {
        PhonebookEntry phonebookEntry1 = new PhonebookEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        PhonebookEntry phonebookEntry2 = new PhonebookEntry(phonebookEntry1);
        System.out.println(phonebookEntry1.isEqualTo(phonebookEntry2)); // true
        PhonebookEntry phonebookEntry3 = new PhonebookEntry(new Name("Jane", "Doe"), new PhoneNumber("111-111-1111"));
        System.out.println(phonebookEntry1.isEqualTo(phonebookEntry3)); // false
        PhonebookEntry phonebookEntry4 = new PhonebookEntry(new Name("Adam", "Doe"), new PhoneNumber("123-456-7890"));
        System.out.println(phonebookEntry1.isEqualTo(phonebookEntry4)); // false
    }

    // you are not expected to understand the code in this method; it uses "reflection"
    private static void advancedTests() throws IllegalAccessException {
        // make sure that the first constructor makes a defensive copy of name.
        Name name = new Name("Jane", "Doe");
        PhoneNumber phoneNumber = new PhoneNumber("123-456-7890");
        PhonebookEntry phonebookEntry1 = new PhonebookEntry(name, phoneNumber);
        Field[] phonebookEntry1Fields = phonebookEntry1.getClass().getDeclaredFields();
        for (Field field : phonebookEntry1Fields) {
            field.setAccessible(true);
            if (field.getType() == Name.class && field.get(phonebookEntry1) == name) {
                System.out.println("It appears that the first constructor doesn't make a defensive copy of name");
            }
        }

        // make sure that the copy constructor makes a deep copy.
        PhonebookEntry phonebookEntry2 = new PhonebookEntry(phonebookEntry1);
        Field[] phonebookEntry2Fields = phonebookEntry2.getClass().getDeclaredFields();
        for (Field field1 : phonebookEntry1Fields) {
            for (Field field2 : phonebookEntry2Fields) {
                field2.setAccessible(true);
                if (field1.getType() == Name.class && field2.getType() == Name.class && field1.get(phonebookEntry1) == field1.get(phonebookEntry2)) {
                    System.out.println("It appears that the copy constructor doesn't make a deep copy");
                }
            }
        }

        // make sure that getName makes a defensive copy.
        Name returnedName = phonebookEntry1.getName();
        for (Field field : phonebookEntry1Fields) {
            if (field.getType() == Name.class && field.get(phonebookEntry1) == returnedName) {
                System.out.println("It appears that the getName method doesn't make a defensive copy");
            }
        }

        // make sure that setName makes a defensive copy.
        Name newName = new Name("Adam", "Smith");
        phonebookEntry1.setName(newName);
        for (Field field : phonebookEntry1Fields) {
            if (field.getType() == Name.class && field.get(phonebookEntry1) == newName) {
                System.out.println("It appears that the setName method doesn't make a defensive copy");
            }
        }
    }
}
