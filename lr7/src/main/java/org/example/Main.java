package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Главный класс для демонстрации иерархии продуктов
public class Main {
    // Главный метод - точка входа в программу
    public static void main(String[] args) {
        // Создание экземпляра продукта питания
        Product apple = new Food("Яблоко", 1.99);
        // Создание экземпляра электронного продукта
        Product laptop = new Electronics("Ноутбук", 999.99);

        // Вывод цены продукта питания
        System.out.println(apple.displayPrice());
        // Вывод цены электронного продукта
        System.out.println(laptop.displayPrice());
    }
}