package org.example;

public class Main {
    public static void main(String[] args) {
        Man brad = new Man("Brad", "Pitt", 65);
        Woman andjelina = new Woman("Andjelina", "Joli", 59);

        brad.registerPartnership(andjelina);

        System.out.println("Brad's last name: " + brad.getLastName()); // Виведе "Brad's last name: Pitt"
        System.out.println("Andjelina's last name: " + andjelina.getLastName()); // Виведе "Andjelina's last name: Pitt"

        brad.deregisterPartnership(true);
        System.out.println("Andjelina's old name: " + andjelina.getLastName());

        System.out.println("Brad is retired: " + brad.isRetired()); // Виведе "Brad is retired: true"
        System.out.println("Andjelina is retired: " + andjelina.isRetired()); // Виведе "Andjelina is retired: false"
    }
}