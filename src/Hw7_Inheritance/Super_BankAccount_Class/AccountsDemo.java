package Hw7_Inheritance.Super_BankAccount_Class;

import java.time.LocalDate;
import java.time.Period;

public class AccountsDemo {
    public static void main(String[] args) {
        final MonetaryValue ONE_HUNDRED_DOLLARS = new MonetaryValue("100.00");
        final MonetaryValue TWENTY_FIVE_DOLLARS = new MonetaryValue("25.00");
        final LocalDate FIVE_MONTHS_AGO = LocalDate.now().minusMonths(5);

        BankAccount[] accounts = {
                new BankAccount("111", ONE_HUNDRED_DOLLARS),
                new CheckingAccount("222", ONE_HUNDRED_DOLLARS, TWENTY_FIVE_DOLLARS),
                new CDAccount("333", ONE_HUNDRED_DOLLARS, FIVE_MONTHS_AGO, Period.ofMonths(6)),
                new MinMaxAccount("444", ONE_HUNDRED_DOLLARS),
                new BonusAccount("555", ONE_HUNDRED_DOLLARS, TWENTY_FIVE_DOLLARS)
        };

        for (BankAccount account : accounts) {
            account.withdraw(ONE_HUNDRED_DOLLARS.plus(TWENTY_FIVE_DOLLARS));
            account.deposit(ONE_HUNDRED_DOLLARS.plus(TWENTY_FIVE_DOLLARS));
            System.out.println(account);
        }
    }
}
