package Inheritance.Super_BankAccount_Class;

public class CheckingAccount extends BankAccount{
    private MonetaryValue overdraftLimit;

    public CheckingAccount(String accountNum, MonetaryValue balance, MonetaryValue overdraftLimit){
        super(accountNum, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public MonetaryValue getOverdraftLimit(){
        return this.overdraftLimit;
    }

    /**
     * Objective: Overrides the withdrawalNotAllowed in BankAccount class.
     *
     * Not allowed to withdraw if it meets either one of these conditions:
     * - withdrawal amount is negative OR
     * - withdrawal amount is greater than balance + overdraft limit.
     *
     * Note: no need to override the withdraw method in this class
     */
    @Override
    protected boolean withdrawalNotAllowed(MonetaryValue amount) {
        if(amount.isNegative() || amount.isGreaterThan(super.getBalance().plus(overdraftLimit))){
            return true;
        }
        return false;
    }
}
