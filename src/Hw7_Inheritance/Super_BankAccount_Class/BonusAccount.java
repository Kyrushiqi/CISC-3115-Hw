package Hw7_Inheritance.Super_BankAccount_Class;

public class BonusAccount extends BankAccount{
    private MonetaryValue bonus;

    public BonusAccount(String accountNum, MonetaryValue balance, MonetaryValue bonus){
        super(accountNum, balance);
        this.bonus = bonus;
    }

    @Override
    public boolean deposit(MonetaryValue amount){
        // Check if the amount to be deposited is greater than $100
        if (amount.isGreaterThan(MonetaryValue.ofDollars(100))) { //Contines down the if statements if the conditions are true.
            // Deposit the original amount
            if (super.deposit(amount)) {
                // Deposit the bonus
                if (super.deposit(bonus)) {
                    return true;
                }
            }
        } else {
            // If the amount is not greater than $100, deposit it normally
            return super.deposit(amount);
        } return false;
        /*if(super.deposit(amount) == true || amount.isGreaterThan(MonetaryValue.ofDollars(100))){
            if(amount.isGreaterThan(MonetaryValue.ofDollars(100)) && super.deposit(bonus) == true && super.deposit(amount) == true){
                super.withdraw(amount);
                return true;
            }
            //getBalance().plus(bonus);
        }
        return false;*/
    }

}
