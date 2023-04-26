package org.ahmedbe00.qamp.zadaci.zadaca9.task1;

public class SavingsAccount extends Account {
    private double dailyTransactionLimit;
    private double oneTransactionLimit;
    private int numberOfTransactions;

    public SavingsAccount(Owner owner, String serialNumber, int passcode, double balance) {
        super(owner, serialNumber, passcode, balance);
        this.numberOfTransactions = 3;
        this.oneTransactionLimit = 1000;
        this.dailyTransactionLimit = numberOfTransactions * oneTransactionLimit;
    }
    @Override
    public double withdraw(final double amount) {
        if (balance - amount < 0) {
            throw new IllegalStateException("You don't have enough money");
        }
        if (amount > oneTransactionLimit) {
            throw new IllegalStateException("Maximum amount you can withdraw has been reached");
        }
        if (amount > dailyTransactionLimit) {
            throw new IllegalStateException("Maximum amount you can withdraw in one day has been reached");
        }
        if (numberOfTransactions==0) {
            throw new IllegalStateException("you have reached the daily limit of the number of withdrawals from the account");
        }
        super.withdraw(amount);
        numberOfTransactions--;
        this.dailyTransactionLimit -= amount;
        return balance;
    }
    @Override
    public double deposit(final double amount){
        if (numberOfTransactions==0) {
            throw new IllegalStateException("you have reached the daily limit of the number of withdrawals from the account");
        }
        super.deposit(amount);
        this.numberOfTransactions--;
        return balance;
    }
    @Override
    public void reset(){
        this.numberOfTransactions=3;
        this.dailyTransactionLimit=3000;
    }
    public String showAccountState(){
        return super.accountState() +"\nCurrent daily limit :" + this.dailyTransactionLimit + "\nNumber of transactions left :"+ this.numberOfTransactions ;
    }

}
