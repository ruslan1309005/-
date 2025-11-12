package org.example;

// Абстрактный класс, представляющий общий продукт
public abstract class Product {
    // Переменные экземпляра для хранения данных о продукте
    protected String name;  // Название продукта
    protected double price; // Цена продукта

    // Конструктор для инициализации названия и цены продукта
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Абстрактный метод для отображения цены, реализуется в подклассах
    public abstract String displayPrice();

    public void print() {
        System.out.println("HI");
    }


}
