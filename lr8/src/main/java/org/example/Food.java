package org.example;

public class Food implements Product {
    private String name;
    private double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void displayPrice() {
        System.out.println("Food: " + name + ", цена: " + price + " руб.");
    }
}
