package org.ahmedbe00.qamp.zadaci.zadaca9.task1;

public class Owner {
    private String firstName;
    private String lastName;
    private String address;

    public Owner(String firstName, String secondName, String addres) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.address = addres;
    }

     @Override
    public String toString() {
        return "Owner info: " + this.firstName + " " + this.lastName + ", " + this.address;
    }
}
