package com.example.domain;

public class CapitalCity extends City {
    private String country;

    public CapitalCity() {}

    public CapitalCity(String name, int population, String country) {
        super(name, population);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", столица страны: " + country;
    }
}


