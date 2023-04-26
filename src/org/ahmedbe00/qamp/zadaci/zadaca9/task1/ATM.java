package org.ahmedbe00.qamp.zadaci.zadaca9.task1;

import java.util.ArrayList;
import java.util.List;

public class ATM {
    private List<Account>accounts;
    public ATM() {
        this.accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {

        accounts.add(account);
    }
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public double withdraw(double amount, String serialNumber, int passcode){
        Account myAccount = getAccount(serialNumber,passcode);
        return myAccount.withdraw(amount);

    }
   public double depositMoney(double amount, String serialNumber, int passcode){
       Account myAccount = getAccount(serialNumber,passcode);
      return myAccount.deposit(amount);

   }
    public void reset (String serialNumber, int passcode){
        Account myAccount = getAccount(serialNumber,passcode);
        myAccount.reset();

    }
   public String showAccountState(String serialNumber, int passcode){
       Account myAccount = getAccount(serialNumber,passcode);
      return myAccount.accountState();


   }
   private Account getAccount(String serialNumber, int passcode) {
       for (Account account : accounts) {
           if (account.getSerialNumber().contains(serialNumber)) {

               if (passcode < 1000 || passcode > 9999) {
                   throw new IllegalArgumentException("You have entered invalid passcode");
               }
               if (account.getPasscode() != passcode) {
                   throw new IllegalStateException("This passcode is incorrect");
               }
               return account;

           }
       }
       throw new IllegalStateException("Account doesn't exist");
   }

}
