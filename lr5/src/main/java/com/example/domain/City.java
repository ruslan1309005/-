package com.example.domain;

public class City {
    private String name;
    private int population;
    private String glava;

    public String getGlava(){
        return glava;
    }
    public void setGlava(String glava){
    this.glava = glava;
    }



    public City() {}

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public City(String name, int population, String glava) {
        this.name = name;
        this.population = population;
        this.glava = glava;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getGlava() {
        return glava;
    }

    public void setGlava(String glava) {
        this.glava = glava;
    }

    public String getInfo() {
        String info = "Город: " + name + ", население: " + population;
        if (glava != null && !glava.isEmpty()) {
            info += ", глава: " + glava;
        }
        return info;
    }
}


