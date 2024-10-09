package Inheritance.Super_BankAccount_Class;

import java.time.LocalDate; // EX: 2022-07-13
import java.time.Period; // EX: 8 months

public class CDAccount extends BankAccount {
    private LocalDate startDate; //When the CD account was created
    private Period term; // time before CD account allow withdrawals

    public CDAccount(String accountNum, MonetaryValue balance, LocalDate startDate, Period term){
        super(accountNum, balance);
        this.startDate = startDate;
        this.term = term;
    }

    /**
     * Returns a LocalDate indicating the end of the term.
     * EX:
     * Start Date = 2022-03-25
     * Term = 6 months long
     * It will return a localDate representing 2022-09-15
     *
     * Uses the public LocalDate plus(TemporalAmount amountToAdd) method. -- Period inherits from TemporalAmount class.
     */
    public LocalDate getTermEnd(){
        return startDate.plus(term);
    }

    /**
     * Overrides withdrawalNotAllowed method in BankAccount class.
     * Withdrawal not allowed if:
     * - superclass does not allow it OR
     * - term has not ended yet
     * Ex:
     * Start Date: 5 months ago
     * Term: 6 months long
     * Conclusion: Withdrawals currently not allowed
     *
     * Note: No need to override deposit or withdraw methods in this class.
     */
    @Override
    protected boolean withdrawalNotAllowed(MonetaryValue amount) {
        if(super.withdrawalNotAllowed(amount) == true || LocalDate.now().isBefore(getTermEnd()) == true ){
            return true;
        }
        return false;
    }
}
