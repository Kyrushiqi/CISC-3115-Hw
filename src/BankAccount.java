//TODO: Redo this entire thing
public class BankAccount {
    private final String accountNumber;
    private MonetaryValue balance;
    private static MonetaryValue totalBalance = MonetaryValue.ZERO;

    public BankAccount(String accountNumber, MonetaryValue balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        updateTotalBalance(balance);
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = MonetaryValue.ZERO;
    }

    public BankAccount(BankAccount original) {
        this.accountNumber = original.accountNumber;
        this.balance = original.balance;
        updateTotalBalance(balance);
    }
    private static void updateTotalBalance(MonetaryValue amount) {
        totalBalance = totalBalance.plus(amount);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public MonetaryValue getBalance() {
        return balance;
    }

    public boolean deposit(MonetaryValue amount) {
        if (amount.isNegative()) {
            return false;
        } else {
            balance = balance.plus(amount);
            updateTotalBalance(amount);
            return true;
        }
    }

    public boolean withdraw(MonetaryValue amount) {
        if (amount.isNegative() || balance.isLessThan(amount)) {
            return false;
        } else {
            balance = balance.minus(amount);
            totalBalance = totalBalance.minus(amount); // Update total balance
            return true;
        }
    }



    public String toString() {
        return accountNumber + " " + balance.toString();
    }

    /**
     * Returns the total of the balances of all BankAccount objects that have been created.
     */
    public static MonetaryValue getTotal(){
        return totalBalance;
    }
}
