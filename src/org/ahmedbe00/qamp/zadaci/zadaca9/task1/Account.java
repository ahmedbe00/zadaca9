package org.ahmedbe00.qamp.zadaci.zadaca9.task1;

public class Account {
    private String serialNumber;
    private int passcode;
    protected double balance;
    private Owner owner;
    public Account( Owner owner,  String serialNumber,  int passcode,  double balance) {
        this.owner = owner;
        this.serialNumber = serialNumber;
        this.passcode = passcode;
        this.balance = balance;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }
    public int getPasscode() {
        return this.passcode;
    }
    public Owner getOwner() {
        return owner;
    }
    public double withdraw(double amount) {
        this.balance -= amount;
        return balance;
    }
    public double deposit(double amount) {
       this.balance += amount;
        return balance;
    }
    public void reset() {
    }

    public String accountState() {
        return "Owner : " + getOwner().toString() + "\nBalance: " + this.balance;
    }



}
