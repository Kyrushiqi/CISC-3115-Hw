package Hw6_Classes_2;

public class BankAccountTest {
    public static void main(String[] args) {
        testGetTotal();
    }

    private static void testGetTotal() {
        System.out.println("testing getTotal");
        System.out.println(BankAccount.getTotal().toString()); // expected: $0.00
        BankAccount account1 = new BankAccount("111", new MonetaryValue("100.00"));
        System.out.println(BankAccount.getTotal().toString()); // expected: $100.00
        BankAccount account2 = new BankAccount("222", new MonetaryValue("50.00"));
        System.out.println(BankAccount.getTotal().toString()); // expected: $150.00
        BankAccount account3 = new BankAccount("333");
        System.out.println(BankAccount.getTotal().toString()); // expected: $150.00
        BankAccount account4 = new BankAccount(account2);
        System.out.println(BankAccount.getTotal().toString()); // expected: $200.00
        account1.deposit(new MonetaryValue("40.00"));
        System.out.println(BankAccount.getTotal().toString()); // expected: $240.00
        account2.deposit(new MonetaryValue("60.00"));
        System.out.println(BankAccount.getTotal().toString()); // expected: $300.00
        account1.withdraw(new MonetaryValue("20.00"));
        System.out.println(BankAccount.getTotal().toString()); // expected: $280.00
        account2.withdraw(new MonetaryValue("30.00"));
        System.out.println(BankAccount.getTotal().toString()); // expected: $250.00
        System.out.println();
    }
}
