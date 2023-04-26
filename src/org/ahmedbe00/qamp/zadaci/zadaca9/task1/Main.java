package org.ahmedbe00.qamp.zadaci.zadaca9.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Owner owner1=new Owner("Ahmed","Berbic","Kakanj");
        final Owner owner2=new Owner("Tarik","Basic","Sarajevo");

        final Account account1=new CurrentAccount(owner1,"LN123",1234,5000);
        final Account account2=new SavingsAccount(owner2,"LN456",2345,3100);

        Scanner reader=new Scanner(System.in);
        final ATM atm = new ATM();
        atm.addAccount(account1);
        atm.addAccount(account2);

        while (true){
            System.out.println("\nWhait is your option ?");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Reset");
            System.out.println("4 - Show account info");
            System.out.println("Else - Quit the menu");

            String serialNumber = "";
            int passcode = 0;
            int choice = reader.nextInt();

            if (choice==1) {

                try {
                    System.out.print("Enter serial number: ");
                    serialNumber = reader.next();
                    System.out.print("Enter passcode: ");
                    passcode = reader.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double amount =reader.nextDouble();
                    double myNewBalance = atm.depositMoney(amount, serialNumber, passcode);
                    System.out.println("New account balance is: " + myNewBalance);

                }catch (IllegalStateException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                   }
            } else if (choice == 2) {

                try {
                    System.out.print("Enter serial number: ");
                    serialNumber = reader.next();
                    System.out.print("Enter passcode: ");
                    passcode = reader.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double amount =reader.nextDouble();
                    double myNewBalance = atm.withdraw(amount, serialNumber, passcode);
                    System.out.println("New account balance is: " + myNewBalance);

                }catch (IllegalStateException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 3) {

                try {
                    System.out.print("Enter serial number: ");
                    serialNumber = reader.next();
                    System.out.print("Enter passcode: ");
                    passcode = reader.nextInt();
                     atm.reset(serialNumber,passcode);
                    System.out.println("Your account is reset");

                }catch (IllegalStateException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }else if (choice == 4) {

                try {
                    System.out.print("Enter serial number: ");
                    serialNumber = reader.next();
                    System.out.print("Enter passcode: ");
                    passcode = reader.nextInt();
                    String accountState=atm.showAccountState(serialNumber,passcode);
                    System.out.println(accountState);

                }catch (IllegalStateException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }else {
                System.out.println("You have closed the selection menu");
            }

        }
    }
}
