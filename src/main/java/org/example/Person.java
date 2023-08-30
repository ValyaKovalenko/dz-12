package org.example;
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private int pensionAge;

    public Person(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        // Задаємо пенсійний вік в залежності від статі
        if (gender.equals("male")) {
            this.pensionAge = 65;
        } else if (gender.equals("female")) {
            this.pensionAge = 60;
        } else {
            this.pensionAge = 0;
        }
    }

    // Геттери та сеттери для всіх полів
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Метод для перевірки, чи особа на пенсії
    public boolean isRetired() {
        return age >= pensionAge;
    }
}
