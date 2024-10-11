package Hw7_Inheritance.Super_BankAccount_Class;

// DO NOT MODIFY THIS FILE.

public class BankAccount {
    private final String accountNumber;
    private MonetaryValue balance;

    public BankAccount(String accountNumber, MonetaryValue balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = MonetaryValue.ZERO;
    }

    public BankAccount(BankAccount original) {
        this.accountNumber = original.accountNumber;
        this.balance = original.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public MonetaryValue getBalance() {
        return balance;
    }

    public boolean deposit(MonetaryValue amount) {
        if (amount.isNegative()) { // if true, returns false indicating no deposit.
            return false;
        } else {
            balance = balance.plus(amount);
            return true;
        }
    }

    public boolean withdraw(MonetaryValue amount) {
        if (withdrawalNotAllowed(amount)) { // if true, return false for withdraw indicating no withdrawal.
            return false;
        } else {
            balance = balance.minus(amount);
            return true;
        }
    }

    protected boolean withdrawalNotAllowed(MonetaryValue amount) {
        return amount.isNegative() || balance.isLessThan(amount);
    }/* If either one of these are true, then the method will return true indicating that
    withdrawal ISN'T allowed. If both are false, then the method returns false indicating
    that withdrawal IS allowed.
    */

    public String toString() {
        return accountNumber + " " + balance.toString();
    }
}