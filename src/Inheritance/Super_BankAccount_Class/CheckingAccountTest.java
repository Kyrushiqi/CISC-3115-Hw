package Inheritance.Super_BankAccount_Class;

// DO NOT MODIFY THIS FILE.

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CheckingAccountTest {
    public static void main(String[] args) {
        testBankAccountFieldsArePrivate();
        testExtendsBankAccount();
        testField();
        testCorrectMethods();
        testConstructor();
        testWithdraw();
    }

    // Makes sure that the fields of BankAccount are private.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testBankAccountFieldsArePrivate() {
        Field[] declaredFields = BankAccount.class.getDeclaredFields();
        if (!containsOnlyPrivateFields(declaredFields)) {
            System.out.println("All fields of BankAccount should be private");
        }
    }

    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static boolean containsOnlyPrivateFields(Field[] fields) {
        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                return false;
            }
        }

        return true;
    }

    // Makes sure that CheckingAccount.CheckingAccount directly extends BankAccount.
    private static void testExtendsBankAccount() {
        if (CheckingAccount.class.getSuperclass() != BankAccount.class) {
            System.out.println("CheckingAccount.CheckingAccount should extend BankAccount");
        }
    }

    // Makes sure that the CheckingAccount.CheckingAccount class has only one declared field, and that the field is a MonetaryValue.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testField() {
        Field[] declaredFields = CheckingAccount.class.getDeclaredFields();

        if (declaredFields.length != 1) {
            System.out.println("CheckingAccount.CheckingAccount should declare exactly one field");
        }

        if (declaredFields[0].getType() != MonetaryValue.class) {
            System.out.println("CheckingAccount.CheckingAccount's declared field should be of type MonetaryValue");
        }
    }

    // Makes sure that CheckingAccount.CheckingAccount doesn't override deposit or withdraw, and that it does override withdrawalNotAllowed.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testCorrectMethods() {
        Method[] declaredMethods = CheckingAccount.class.getDeclaredMethods();

        if (containsMethodWithName(declaredMethods, "deposit")) {
            System.out.println("CheckingAccount.CheckingAccount should not override deposit");
        }

        if (containsMethodWithName(declaredMethods, "withdraw")) {
            System.out.println("CheckingAccount.CheckingAccount should not override withdraw");
        }

        if (!containsMethodWithName(declaredMethods, "withdrawalNotAllowed")) {
            System.out.println("CheckingAccount.CheckingAccount should override withdrawalNotAllowed");
        }
    }

    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static boolean containsMethodWithName(Method[] methods, String name) {
        for (Method method : methods) {
            if (method.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    private static void testConstructor() {
        System.out.println("testing constructor");

        CheckingAccount ca = new CheckingAccount("123456", new MonetaryValue("100.00"), new MonetaryValue("50.00"));
        System.out.println(ca.getAccountNumber());  // expected: 123456
        System.out.println(ca.getBalance());        // expected: $100.00
        System.out.println(ca.getOverdraftLimit()); // expected: $50.00

        System.out.println();
    }

    private static void testWithdraw() {
        System.out.println("testing withdraw");

        CheckingAccount account = new CheckingAccount("123456", new MonetaryValue("100.00"), new MonetaryValue("100.00"));

        boolean result = account.withdraw(new MonetaryValue("-0.50"));
        System.out.println(result);                 // expected: false
        System.out.println(account.getBalance());   // expected: $100.00

        result = account.withdraw(new MonetaryValue("150.00"));
        System.out.println("Error Here: ");
        System.out.println(result);                 // expected: true
        System.out.println("Error Here: ");
        System.out.println(account.getBalance());   // expected: $-50.00

        result = account.withdraw(new MonetaryValue("100.00"));
        System.out.println(result);                 // expected: false
        System.out.println(account.getBalance());   // expected: $-50.00

        result = account.withdraw(new MonetaryValue("50.00"));
        System.out.println(result);                 // expected: true
        System.out.println(account.getBalance());   // expected: $-100.00

        result = account.withdraw(new MonetaryValue("50.00"));
        System.out.println(result);                 // expected: false
        System.out.println(account.getBalance());   // expected: $-100.00

        account.deposit(new MonetaryValue("200.00"));
        System.out.println(account.getBalance());   // expected: $100.00

        result = account.withdraw(new MonetaryValue("150.00"));
        System.out.println(result);                 // expected: true
        System.out.println(account.getBalance());   // expected: $-50.00

        System.out.println();
    }
}
