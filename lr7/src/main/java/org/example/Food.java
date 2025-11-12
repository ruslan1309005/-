package org.example;

// Класс Food, наследующий абстрактный класс Product
public class Food extends Product {
    // Конструктор для инициализации продукта питания с названием и ценой
    public Food(String name, double price) {
        super(name, price); // Вызов конструктора родительского класса
    }

    // Реализация метода displayPrice для продуктов питания
    @Override
    public String displayPrice() {
        // Возвращает форматированную строку с типом продукта, названием и ценой
        return "Продукт питания: " + name + " - $" + String.format("%.2f", price);
    }
}
