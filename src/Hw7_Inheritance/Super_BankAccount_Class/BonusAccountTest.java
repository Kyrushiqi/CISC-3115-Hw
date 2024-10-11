package Hw7_Inheritance.Super_BankAccount_Class;

// DO NOT MODIFY THIS FILE.

import java.lang.reflect.Field;

public class BonusAccountTest {
    public static void main(String[] args) {
        testExtendsBankAccount();
        testFields();
        testConstructor();
        testDeposit();
    }

    // Makes sure that BonusAccount directly extends BankAccount.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testExtendsBankAccount() {
        if (BonusAccount.class.getSuperclass() != BankAccount.class) {
            System.out.println("BonusAccount should extend BankAccount");
        }
    }

    // Makes sure that the BonusAccount class has at most two declared fields.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testFields() {
        Field[] declaredFields = BonusAccount.class.getDeclaredFields();

        if (declaredFields.length > 2) {
            System.out.println("BonusAccount should declare at most two fields");
        }
    }

    private static void testConstructor() {
        System.out.println("testing constructor");
        BonusAccount account = new BonusAccount("123", new MonetaryValue("100.00"), new MonetaryValue("50.00"));
        System.out.println(account.getAccountNumber()); // expected: 123
        System.out.println(account.getBalance());       // expected: $100.00
        System.out.println();
    }

    private static void testDeposit() {
        System.out.println("testing deposit");

        BonusAccount account = new BonusAccount("123", new MonetaryValue("50.00"), new MonetaryValue("25.00"));
        System.out.println(account.getBalance()); // expected: $50.00

        boolean result = account.deposit(new MonetaryValue("-25.00")); // deposit unsuccessful
        System.out.println(result); // expected: false
        System.out.println(account.getBalance()); // expected: $50.00

        result = account.deposit(new MonetaryValue("75.00")); // deposit successful, but no bonus
        System.out.println(result); // expected: true
        System.out.println(account.getBalance()); // expected: $125.00

        result = account.deposit(new MonetaryValue("100.00")); // deposit successful, but no bonus
        System.out.println(result); // expected: true
        System.out.println(account.getBalance()); // expected: $225.00

        result = account.deposit(new MonetaryValue("125.00")); // deposit successful, and bonus added
        System.out.println(result); // expected: true
        System.out.println(account.getBalance()); // expected: $375.00

        System.out.println();
    }
}

