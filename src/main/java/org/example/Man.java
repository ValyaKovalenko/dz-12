package org.example;

public class Man extends Person {
    private Woman partner;
    private boolean married;

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age, "male");
        this.partner = null;
        this.married = false;
    }

    // Метод для реєстрації партнерства (дружина приймає прізвище чоловіка)
    public void registerPartnership(Woman woman) {
        this.partner = woman;
        this.married = true;
        if (!woman.hasPartner()) {
            woman.registerPartnership(this);
        }
    }

    // Метод для розірвання партнерства (повернення до попереднього прізвища)
    public void deregisterPartnership(boolean returnToPreviousLastName) {
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