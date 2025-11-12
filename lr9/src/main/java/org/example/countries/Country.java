package org.example.countries;

public class Country {
    public String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Страна: " + name;
    }
}