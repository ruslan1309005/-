package org.example;

public class Electronics implements Product, Interface {
    private String name;
    private double price;
    private double koll;

    public Electronics(String name, double price, int koll) {
        this.name = name;
        this.price = price;
        this.koll = koll;
    }

    @Override
    public void displayPrice() {
        System.out.println("Электроника: " + name + ", цена: " + price + " руб.");
    }
    public void getInfo(){
        System.out.println("Колличество:"+ koll);
    }


public static class Clothing implements Interface {
    private String name;
    private double price;
    private int quantity; // количество на складе

    public Clothing(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void getInfo() {
        System.out.println("Одежда: " + name);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Количество на складе: " + quantity);
    }
}
}