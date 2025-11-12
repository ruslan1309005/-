package org.example;

public class Tester {
    private String name;
    private String surname;
    private int expirienceInYears;
    private String englishLevel;
    private double salary;

    public Tester() {
        this("Сеня", "Илюкевич");
    }

    public Tester(String name, String surname) {
        this(name, surname, 0, "A1", 0.0);
    }

    public Tester(String name, String surname, int expirienceInYears, String englishLevel, double salary) {
        this.name = name;
        this.surname = surname;
        this.expirienceInYears = expirienceInYears;
        this.englishLevel = englishLevel;
        this.salary = salary;
    }

    public String describe() {
        return name + " " + surname + ", опыт: " + expirienceInYears + " г., англ.: " + englishLevel + ", зарплата: " + salary;
    }

    public String describe(boolean withCurrency) {
        if (withCurrency) {
            return name + " " + surname + ", опыт: " + expirienceInYears + " г., англ.: " + englishLevel + ", зарплата: $" + String.format("%.2f", salary);
        }
        return describe();
    }

    public String describe(String prefix) {
        return prefix + ": " + describe();
    }

    public static Tester junior(String name, String surname) {
        return new Tester(name, surname, 0, "A2", 500.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExpirienceInYears() {
        return expirienceInYears;
    }

    public void setExpirienceInYears(int expirienceInYears) {
        this.expirienceInYears = expirienceInYears;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}




