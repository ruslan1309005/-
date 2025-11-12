package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product apple = new Food("Яблоко", 50.0);
        Product phone = new Electronics("Смартфон", 20000.0, 10);

        apple.displayPrice();
        phone.displayPrice();
        Electronics.Clothing shirt = new Electronics.Clothing("Футболка", 1500.0, 4);
        shirt.getInfo();
    }
}