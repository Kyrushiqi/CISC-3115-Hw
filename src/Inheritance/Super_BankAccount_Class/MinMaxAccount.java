package Inheritance.Super_BankAccount_Class;

public class MinMaxAccount extends BankAccount{
    private MonetaryValue min;
    private MonetaryValue max;

    public MinMaxAccount(String accountNum, MonetaryValue balance){
        super(accountNum, balance);
        this.min = balance;
        this.max = balance;
    }

    public MonetaryValue getMin(){
        return this.min;
    }

    public MonetaryValue getMax() {
        return this.max;
    }
    @Override
    public String toString(){
        return super.toString() + " " + "[min=" + min + ", max=" + max + "]";
    }

    @Override
    public boolean deposit(MonetaryValue amount){
        if(super.deposit(amount) == true){
            if(this.getBalance().isGreaterThan(max)){
                max = getBalance();
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(MonetaryValue amount){
        if(super.withdraw(amount) == true){
            if(this.getBalance().isLessThan(min)){
                min = getBalance();
                return true;
            }
        }
        return false;
    }

}
