package org.ahmedbe00.qamp.zadaci.zadaca9.task1;

public class MainFirst {
    public static void main(String[] args) {
        final Owner owner1=new Owner("Ahmed","Berbic","Kakanj");
        final Owner owner2=new Owner("Tarik","Basic","Sarajevo");

        final Account account1=new SavingsAccount(owner1,"LN123",1234,5000);
        final Account account2=new CurrentAccount(owner2,"LN456",2345,3100);

        final ATM atm = new ATM();
        atm.addAccount(account1);
        atm.addAccount(account2);

        try {
            System.out.println(" Account state: ");
            System.out.println(atm.showAccountState("LN123",1234));
            System.out.println(atm.showAccountState("LN456",2345));

            System.out.println("Account state after withdraw :");
            atm.withdraw(300,"LN123",1234);
            System.out.println(atm.showAccountState( "LN123",1234));

            System.out.println("Account state after deposit :");
            atm.depositMoney(500,"LN123",1234);
            System.out.println(atm.showAccountState( "LN123",1234));

            atm.reset("LN123",1234);
            System.out.println("After reseting balance is :");
            System.out.println(atm.showAccountState( "LN123",1234));

            System.out.println();


            atm.withdraw(8000,"LN123",1234);
           /* atm.withdraw(11000,"123n1",123);
            atm.withdraw(1000,"LN123",123); */


        }catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
