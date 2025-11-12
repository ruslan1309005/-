// Задание 1. Страны и города с Map
import java.util.*;

class Country {
    String name;
    public Country(String name) {
        this.name = name;
    }
}

class City extends Country {
    public City(String name) {
        super(name);
    }
}

class Town extends Country {
    public Town(String name) {
        super(name);
    }
}

public class Z1 {
    public static void main(String[] args) {
        // Map: название -> объект Country
        Map<String, Country> map = new HashMap<>();
        map.put("Беларусь", new Country("Беларусь"));
        map.put("Минск", new City("Минск"));
        map.put("Гродно", new City("Гродно"));
        map.put("Поставы", new Town("Поставы"));
        map.put("Россия", new Country("Россия"));
        map.put("Москва", new City("Москва"));
        map.put("Сочи", new City("Сочи"));
        // Пояснение вывода ключей
        System.out.println("\nНазвания в отображении (ключи, добавленные в Map):");
        for (String k : map.keySet()) {
            System.out.println(" - " + k);
        }
    }
    // Пояснение:
    // В этом примере создано отображение Map, где ключ - название страны или города, а значение - объект класса Country или его наследника.
    // Все добавленные ключи (названия) выводятся в консоль.
}
