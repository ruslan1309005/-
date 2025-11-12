package org.example;

// Класс Electronics, наследующий абстрактный класс Product
public class Electronics extends Product {
    // Конструктор для инициализации электронного продукта с названием и ценой
    public Electronics(String name, double price) {
        super(name, price); // Вызов конструктора родительского класса
    }

    // Реализация метода displayPrice для электронных продуктов
    @Override
    public String displayPrice() {
        // Возвращает форматированную строку с типом продукта, названием и ценой
        return "Электроника: " + name + " - $" + String.format("%.2f", price);
    }
}
