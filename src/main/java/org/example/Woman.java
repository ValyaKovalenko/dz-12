package org.example;
public class Woman extends Person {
    private String defaultLastName;
    private Man partner;
    private boolean married;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age, "female");
        this.defaultLastName = lastName;
        this.partner = null;
        this.married = false;
    }

    public void registerPartnership(Man man) {
        this.partner = man;
        this.married = true;
        setLastName(man.getLastName());
        if (!man.hasPartner()) {
            man.registerPartnership(this);
        }
    }
    // Метод для розірвання партнерства (повернення до попереднього прізвища)
    public void deregisterPartnership(boolean returnToPreviousLastName) {
        if (returnToPreviousLastName) {
            setLastName(defaultLastName);
        }
        if(hasPartner()) {
            this.married = false;
            partner.deregisterPartnership(returnToPreviousLastName);
        }
        this.partner = null;
    }

    public boolean hasPartner() {
        return this.married;
    }
}