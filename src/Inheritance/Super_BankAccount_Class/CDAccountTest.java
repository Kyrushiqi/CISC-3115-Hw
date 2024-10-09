package Inheritance.Super_BankAccount_Class;// DO NOT MODIFY THIS FILE.

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Period;

public class CDAccountTest {
    public static void main(String[] args) {
        testExtendsBankAccount();
        testFields();
        testCorrectMethods();
        testConstructorAndGetTermEnd();
        testWithdraw();
    }

    // Makes sure that CheckingAccount.CDAccount directly extends BankAccount.
    private static void testExtendsBankAccount() {
        if (CDAccount.class.getSuperclass() != BankAccount.class) {
            System.out.println("CheckingAccount.CDAccount should extend BankAccount");
        }
    }

    // Makes sure that the CheckingAccount.CDAccount class has at most two declared fields.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testFields() {
        Field[] declaredFields = CDAccount.class.getDeclaredFields();

        if (declaredFields.length > 2) {
            System.out.println("CheckingAccount.CDAccount should declare at most two fields");
        }
    }

    // Makes sure that CheckingAccount.CDAccount doesn't override deposit or withdraw, and that it does override withdrawalNotAllowed.
    // You do not have to understand how this method works. (It uses a Java feature called "reflection.")
    private static void testCorrectMethods() {
        Method[] declaredMethods = CDAccount.class.getDeclaredMethods();

        if (containsMethodWithName(declaredMethods, "deposit")) {
            System.out.println("CheckingAccount.CDAccount should not override deposit");
        }

        if (containsMethodWithName(declaredMethods, "withdraw")) {
            System.out.println("CheckingAccount.CDAccount should not override withdraw");
        }

        if (!containsMethodWithName(declaredMethods, "withdrawalNotAllowed")) {
            System.out.println("CheckingAccount.CDAccount should override withdrawalNotAllowed");
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

    private static void testConstructorAndGetTermEnd() {
        System.out.println("testing constructor and getTermEnd");

        CDAccount account = new CDAccount("123456", new MonetaryValue("150.00"), LocalDate.parse("2022-03-15"), Period.ofMonths(6));
        System.out.println(account.getAccountNumber()); // expected: 123456
        System.out.println(account.getBalance());       // expected: $150.00
        System.out.println(account.getTermEnd());       // expected: 2022-09-15

        account = new CDAccount("987654", new MonetaryValue("150.00"), LocalDate.parse("2022-04-01"), Period.ofMonths(3));
        System.out.println(account.getAccountNumber()); // expected: 987654
        System.out.println(account.getBalance());       // expected: $150.00
        System.out.println(account.getTermEnd());       // expected: 2022-07-01

        System.out.println();
    }

    private static void testWithdraw() {
        System.out.println("testing withdraw");
        CDAccount account = new CDAccount("123456", new MonetaryValue("150.00"), LocalDate.now().minusMonths(5), Period.ofMonths(6));

        // attempt to withdraw from account in middle of term
        boolean result = account.withdraw(new MonetaryValue("50.00"));
        System.out.println(result);               // expected: false
        System.out.println(account.getBalance()); // expected: $150.00

        account = new CDAccount("987654", new MonetaryValue("150.00"), LocalDate.parse("2022-04-01"), Period.ofMonths(3));

        // withdraw from account whose term has completed
        result = account.withdraw(new MonetaryValue("50.00"));
        System.out.println(result);               // expected: true
        System.out.println(account.getBalance()); // expected: $100.00

        // attempt to withdraw a negative amount
        result = account.withdraw(new MonetaryValue("-25.00"));
        System.out.println(result);               // expected: false
        System.out.println(account.getBalance()); // expected: $100.00

        // attempt to make the balance go below $0.00
        result = account.withdraw(new MonetaryValue("150.00"));
        System.out.println(result);               // expected: false
        System.out.println(account.getBalance()); // expected: $100.00
    }
}
